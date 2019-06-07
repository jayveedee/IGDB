package Data.UserDAL;

import Data.IMysqlConnection;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {

    private IMysqlConnection mySql;

    public UserDAO(IMysqlConnection mySql) {
        this.mySql = mySql;
    }

    @Override
    public boolean createUser(UserDTO user) {
        String query1 = "INSERT INTO Users (userNAME, userPASS, userEMAIL) VALUES (?, ?, ?)";
        String query2 = "INSERT INTO UserRoles (userNAME, roleID) VALUES (?, ?)";

        String username         = user.getUserNAME();
        String password         = user.getUserPASS();
        String email            = user.getUserEMAIL();
        List<RoleDTO> roleList  = user.getUserROLEs();
        try {
            handleUpdateUserXcreateUser(query1, username, password, email);

            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query2));
            for (int i = 0; i < roleList.size(); i++) {
                mySql.getPrepStatement().setString(1,username);
                mySql.getPrepStatement().setInt(2,roleList.get(i).getRoleID());
                mySql.getPrepStatement().addBatch();
            }
            mySql.getPrepStatement().executeBatch();
            mySql.getConnection().commit();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean handleUpdateUserXcreateUser(String query1, String username, String password, String email) {
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query1));
            mySql.getPrepStatement().setString(1,username);
            mySql.getPrepStatement().setString(2,password);
            mySql.getPrepStatement().setString(3,email);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public UserDTO getUser(String userNAME) {
        String query1 = "SELECT * FROM Users WHERE userNAME = ?";
        String query2 = "SELECT * FROM UserRoles INNER JOIN Roles ON UserRoles.roleID = Roles.roleID WHERE userNAME = ?";
        String query3 = "SELECT * FROM UGameLIST WHERE userNAME = ?";
        UserDTO user = new UserDTO();
        List<RoleDTO> rlist;
        List<Integer> gmlist;
        try {
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query1));
            mySql.getPrepStatement().setString(1,userNAME);

            ResultSet rs1 = mySql.getPrepStatement().executeQuery();
            if (rs1.next()){
                user.setUserNAME(rs1.getString("userNAME"));
                user.setUserPASS(rs1.getString("userPASS"));
                user.setUserEMAIL(rs1.getString("userEMAIL"));
            }

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query2));
            mySql.getPrepStatement().setString(1,userNAME);

            ResultSet rs2 = mySql.getPrepStatement().executeQuery();
            rlist = RoleDAO.handleGetRoleList(rs2);
            user.setUserROLEs(rlist);

            gmlist = handleGetUGameList(userNAME, query3);
            user.setUserGAMEs(gmlist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<UserDTO> getUserList() {
        String query1 = "SELECT * FROM Users";
        String query2 = "SELECT * FROM UserRoles INNER JOIN Roles ON UserRoles.roleID = Roles.roleID WHERE userNAME = ?";
        String query3 = "SELECT * FROM UGameLIST WHERE userNAME = ?";
        List<UserDTO> ulist = new ArrayList<>();
        try {
            mySql.setStatement(mySql.getConnection().createStatement());

            ResultSet rs1 = mySql.getStatement().executeQuery(query1);
            while (rs1.next()){
                UserDTO user = new UserDTO();
                user.setUserNAME(rs1.getString("userNAME"));
                user.setUserPASS(rs1.getString("userPASS"));
                user.setUserEMAIL(rs1.getString("userEMAIL"));

                mySql.setPrepStatment(mySql.getConnection().prepareStatement(query2));
                mySql.getPrepStatement().setString(1,rs1.getString("userNAME"));
                ResultSet rs2 = mySql.getPrepStatement().executeQuery();
                List<RoleDTO> rlist = RoleDAO.handleGetRoleList(rs2);
                user.setUserROLEs(rlist);

                List<Integer> gmlist = new ArrayList<>();
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(query3));
                mySql.getPrepStatement().setString(1,rs1.getString("userNAME"));
                ResultSet rs3 = mySql.getPrepStatement().executeQuery();
                while (rs3.next()) {
                    gmlist.add(rs3.getInt("gameID"));
                }
                user.setUserGAMEs(gmlist);
                ulist.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ulist;
    }

    private List<Integer> handleGetUGameList(String userNAME, String query) throws SQLException {
        List<Integer> gmlist = new ArrayList<>();
        mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
        mySql.getPrepStatement().setString(1,userNAME);
        ResultSet rs = mySql.getPrepStatement().executeQuery();
        while (rs.next()){
            gmlist.add(rs.getInt("gameID"));
        }
        return gmlist;
    }

    @Override
    public boolean updateUserInfo(UserDTO newUser) {
        String query1 = "UPDATE Users SET userPASS = ?, userEMAIL = ? WHERE userNAME = ?";
        String userNAME = newUser.getUserNAME();
        String userEMAIL = newUser.getUserEMAIL();
        String userPASS = newUser.getUserPASS();
        return handleUpdateUserXcreateUser(query1, userPASS, userEMAIL, userNAME);
    }

    @Override
    public boolean updateSpecificUserRole(String userNAME, RoleDTO newRole) {
        String query = "UPDATE UserRoles SET roleID = ? WHERE userNAME = ?";
        IRoleDAO rdao = new RoleDAO(mySql);
        return rdao.handleUpdateUserRolesXCreateRole(query,newRole.getRoleID(),userNAME);
    }

    @Override
    public boolean deleteUser(String userNAME) {
        String query1 = "DELETE FROM UserRoles WHERE userNAME = ?";
        String query2 = "DELETE FROM Users WHERE userNAME = ?";
        return handleDeleteByID(userNAME, query1) && handleDeleteByID(userNAME, query2);
    }

    @Override
    public boolean deleteAllUserRoles(String userNAME) {
        String query = "DELETE FROM UserRoles WHERE userNAME = ?";
        return handleDeleteByID(userNAME, query);
    }

    private boolean handleDeleteByID(String userNAME, String query) {
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setString(1,userNAME);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
