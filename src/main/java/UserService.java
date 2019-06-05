import Data.UserDAL.UserDAO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.ArrayList;

@Path("user")
public class UserService {

    @POST
    @Path("form/createUser")
    public String tagImodFormParametre(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password ){
        UserDAO userDAO = new UserDAO();
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


        //return ("de indtastede data er følgende: <br>\nname: "+ name + "\nid: " + id + "\namount: " + amount);
        return "hey";
    }

}
