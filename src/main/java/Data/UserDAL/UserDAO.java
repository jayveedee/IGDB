package Data.UserDAL;

import Data.GameDTO.GameDTO;
import Data.IMysqlConnection;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUserDAO {

    private IMysqlConnection mySql;

    public UserDAO(IMysqlConnection mySql) {
        this.mySql = mySql;
    }

    @Override
    public void createUser(UserDTO user) {
        String query1 = "INSERT INTO Users (userNAME, userPASS, userEMAIL) VALUES (?, ?, ?)";
        String query2 = "INSERT INTO UserRoles (userNAME, roleID) VALUES (?, ?)";

        String username         = user.getUserNAME();
        String password         = user.getUserPASS();
        String email            = user.getUserEMAIL();
        List<Integer> gameList  = user.getUserGAMEs();
        List<RoleDTO> roleList  = user.getUserROLEs();

        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query1));
            mySql.getPrepStatement().setString(1,username);
            mySql.getPrepStatement().setString(2,password);
            mySql.getPrepStatement().setString(3,email);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();

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
        }
    }

    @Override
    public UserDTO getUser(int userid) {
        return null;
    }

    @Override
    public List<UserDTO> getUserList() {
        return null;
    }

    @Override
    public void updateUser(int userid) {

    }

    @Override
    public void deleteUser(int userid) {

    }
}
