package Data.UserDAL;

import Data.GameDTO.GameDTO;
import Data.IMysqlConnection;
import Data.UserDTO.RolesDTO;
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
        String query1 = "INSERT INTO Users (userid, username, password) VALUES (?, ?, ?)";
        String query2 = "INSERT INTO UserRoles (roleid, userid) VALUES (?, ?)";
        String query3 = "INSERT INTO GameList (gameid, userid) VALUES (?, ?)";

        int userid              = user.getUserid();
        String username         = user.getUsername();
        String password         = user.getPassword();
        List<GameDTO> gameList  = user.getGamelist();
        List<RolesDTO> roleList = user.getRoleList();

        try {
            mySql.getConnection().prepareStatement(query1);

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
