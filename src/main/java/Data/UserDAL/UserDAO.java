package Data.UserDAL;

import Data.GameDTO.Info.RatingDTO;
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
        String query1 = "INSERT INTO Users (userNAME, userPASS, userEMAIL, userPFP) VALUES (?, ?, ?, ?)";
        String query2 = "INSERT INTO UserRoleList (userNAME, roleID) VALUES (?, ?)";

        String firstParam         = user.getUserNAME();
        String secondParam         = user.getUserPASS();
        String thirdParam            = user.getUserEMAIL();
        List<RoleDTO> roleList  = user.getUserROLEs();
        String fourthParam              = user.getUserPFP();
        try {
            handleUpdateUserXcreateUser(query1, firstParam, secondParam, thirdParam, fourthParam);

            if (roleList != null) {
                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(query2));
                for (RoleDTO roleDTO : roleList) {
                    mySql.getPrepStatement().setString(1, firstParam);
                    mySql.getPrepStatement().setInt(2, roleDTO.getRoleID());
                    mySql.getPrepStatement().addBatch();
                }
                mySql.getPrepStatement().executeBatch();
                mySql.getConnection().commit();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addToUserGameList(String userName, int gameID) {
        String query = "INSERT INTO UserGameList (userNAME, gameID) VALUES (?, ?)";

        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setString(1,userName);
            mySql.getPrepStatement().setInt(2,gameID);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addRatingToGame(RatingDTO rating, int gameID) {
        String query =
            "INSERT INTO RatingList (ratingID, ratingGIVEN, ratingUSER, ratingGameID) " +
            "VALUES (?, ?, ?, ?)";
        int         ratingID        = rating.getRatingID();
        int         ratingGIVEN     = rating.getRatingGIVEN();
        String      ratingUSER      = rating.getRatingUSER().getUserNAME();

        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setInt(1,ratingID);
            mySql.getPrepStatement().setInt(2,ratingGIVEN);
            mySql.getPrepStatement().setString(3,ratingUSER);
            mySql.getPrepStatement().setInt(4,gameID);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private boolean handleUpdateUserXcreateUser(String query, String fisrtParam, String secondParan, String thirdParam, String fourthParam) {
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setString(1,fisrtParam);
            mySql.getPrepStatement().setString(2,secondParan);
            mySql.getPrepStatement().setString(3,thirdParam);
            mySql.getPrepStatement().setString(4,fourthParam);
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
        String query = "SELECT * FROM Users WHERE userNAME = ?";
        UserDTO user = new UserDTO();
        List<RoleDTO> rlist;
        List<Integer> gmlist;
        try {
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setString(1,userNAME);
            ResultSet rs = mySql.getPrepStatement().executeQuery();
            if (rs.next()){
                handleGetUser(rs, user);
            }
            rlist = getUserRoleList(userNAME);
            user.setUserROLEs(rlist);

            gmlist = getUserGameList(userNAME);
            user.setUserGAMEs(gmlist);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<UserDTO> getUserList() {
        String query = "SELECT * FROM Users ORDER BY userNAME ASC";
        List<UserDTO> ulist = new ArrayList<>();
        try {
            mySql.setStatement(mySql.getConnection().createStatement());
            ResultSet rs = mySql.getStatement().executeQuery(query);
            while (rs.next()){
                UserDTO user = new UserDTO();
                handleGetUser(rs, user);

                List<RoleDTO> rlist = getUserRoleList(user.getUserNAME());
                List<Integer> gmlist = getUserGameList(user.getUserNAME());
                user.setUserROLEs(rlist);
                user.setUserGAMEs(gmlist);
                ulist.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ulist;
    }

    private void handleGetUser(ResultSet rs, UserDTO user) throws SQLException {
        user.setUserNAME(rs.getString("userNAME"));
        user.setUserPASS(rs.getString("userPASS"));
        user.setUserEMAIL(rs.getString("userEMAIL"));
        user.setUserPFP(rs.getString("userPFP"));
    }

    @Override
    public List<RoleDTO> getUserRoleList(String userName) {
        String query =
                        "SELECT Users.userNAME, UserRoleList.roleID, Roles.roleNAME FROM Users " +
                        "INNER JOIN UserRoleList ON Users.userNAME = UserRoleList.userNAME " +
                        "INNER JOIN Roles ON UserRoleList.roleID = Roles.roleID " +
                        "WHERE Users.userNAME = ? " +
                        "ORDER BY roleID ASC";
        List<RoleDTO> rlist = new ArrayList<>();
        RoleDAO rdao = new RoleDAO(mySql);
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setString(1,userName);
            ResultSet rs = mySql.getPrepStatement().executeQuery();
            rlist = rdao.handleGetRoleList(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rlist;
    }

    @Override
    public List<Integer> getUserGameList(String userNAME) {
        String query = "SELECT * FROM UserGameList WHERE userNAME = ? ORDER BY gameID ASC";
        List<Integer> gmlist = new ArrayList<>();
        try {
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setString(1,userNAME);
            ResultSet rs = mySql.getPrepStatement().executeQuery();
            while (rs.next()) {
                gmlist.add(rs.getInt("gameID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gmlist;
    }

    @Override
    public boolean updateUserInfo(UserDTO newUser) {
        String query            = "UPDATE Users SET userPASS = ?, userEMAIL = ?, userPFP = ? WHERE userNAME = ?";
        String fourthParan      = newUser.getUserNAME();
        String secondParam      = newUser.getUserEMAIL();
        String firstParam       = newUser.getUserPASS();
        String thirdParam       = newUser.getUserPFP();
        return handleUpdateUserXcreateUser(query, firstParam, secondParam, thirdParam, fourthParan);
    }

    @Override
    public boolean updateSpecificUserRole(String userNAME, RoleDTO newRole) {
        String query = "UPDATE UserRoleList SET roleID = ? WHERE userNAME = ?";
        RoleDAO rdao = new RoleDAO(mySql);
        return rdao.handleUpdateUserRolesXCreateRole(query,newRole.getRoleID(),userNAME);
    }

    @Override
    public boolean deleteUser(String userNAME) {
        String query1 = "DELETE FROM UserRoleList WHERE userNAME = ?";
        String query2 = "DELETE FROM Users WHERE userNAME = ?";
        return handleDeleteByID(userNAME, query1) && handleDeleteByID(userNAME, query2);
    }

    @Override
    public boolean deleteAllUserRoles(String userNAME) {
        String query = "DELETE FROM UserRoleList WHERE userNAME = ?";
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

    @Override
    public boolean deleteAllUserGameLists(String userNAME) {
        String query = "DELETE FROM UserGameList WHERE userNAME = ?";
        return handleDeleteByID(userNAME,query);
    }
}
