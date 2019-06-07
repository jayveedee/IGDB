import Data.IMysqlConnection;
import Data.UserDAL.IUserDAO;
import Data.UserDAL.UserDAO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.sql.Connection;
import java.util.ArrayList;

public class UserService {
    IMysqlConnection mySQL;

    public UserService(IMysqlConnection mySQL) {
        this.mySQL=mySQL;
    }

    public String tagImodFormParametre(String username, String email, String password ){
        IUserDAO userDAO = new UserDAO(mySQL);
        UserDTO user = new UserDTO();
        RoleDTO role = new RoleDTO();

        role.setRoleID(2);
        role.setRoleNAME("User");

        ArrayList<RoleDTO> roleList = null;
        roleList.add(role);

        user.setUserEMAIL(email);
        user.setUserNAME(username);
        user.setUserPASS(password);
        user.setUserGAMEs(null);
        user.setUserROLEs(roleList);

        String answer = userDAO.createUser(user);

        return answer;
    }

}
