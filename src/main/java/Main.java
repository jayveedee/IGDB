import Data.GameDTO.GameDTO;
import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDAL.IUserDAO;
import Data.UserDAL.UserDAO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        IMysqlConnection mysqlConnection = new MysqlConnection();
        try {
            mysqlConnection.setConnection(mysqlConnection.createConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        IUserDAO userDAO = new UserDAO(mysqlConnection);
        UserDTO userDTO = new UserDTO();

        ArrayList<RoleDTO> roleList = new ArrayList<>();
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRoleNAME("user");
        roleDTO.setRoleID(1);
        roleList.add(roleDTO);

        ArrayList<Integer> gameList = new ArrayList<>();

        userDTO.setUserROLEs(roleList);
        userDTO.setUserGAMEs(gameList);
        userDTO.setUserPASS("hejsa");
        userDTO.setUserNAME("Asama");
        userDTO.setUserEMAIL("asama@yahoo.dk");
        userDTO.setUserPFP("skerder.dk");

        userDAO.createUser(userDTO);

    }
}
