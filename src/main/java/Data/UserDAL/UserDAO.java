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
        String query1 = "INSERT INTO Users (userid, username, email, password) VALUES (?, ?, ?, ?)";
        String query2 = "INSERT INTO UserRoles (roleid, userid) VALUES (?, ?)";
        String query3 = "INSERT INTO GameList (gameid, userid) VALUES (?, ?)";

        int userid              = user.getUserID();
        String username         = user.getUserNAME();
        String password         = user.getUserPASS();
        String email            = user.getUserEMAIL();
        List<GameDTO> gameList  = user.getUserGAMEs();
        List<RoleDTO> roleList = user.getUserROLEs();

        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.getConnection().prepareStatement(query1);
            mySql.getPrepStatement().setInt(1,userid);
            mySql.getPrepStatement().setString(2,username);
            mySql.getPrepStatement().setString(3,email);
            mySql.getPrepStatement().setString(4,password);
            mySql.getPrepStatement().executeUpdate();

            mySql.getConnection().prepareStatement(query2);
            for (int i = 0; i < roleList.size(); i++) {
                mySql.getPrepStatement().setInt(1,roleList.get(i).getRoleID());
                mySql.getPrepStatement().setInt(2,userid);
                mySql.getPrepStatement().addBatch();
            }
            mySql.getPrepStatement().executeBatch();

            mySql.getConnection().prepareStatement(query3);
            for (int i = 0; i < gameList.size(); i++) {
                mySql.getPrepStatement().setInt(1,gameList.get(i).getGameid());
                mySql.getPrepStatement().setInt(2,userid);
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
