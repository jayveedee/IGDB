import Data.UserDTO.UserDTO;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("User")
public class UserService {

    @POST
    @Path("form/createUser")
    public String tagImodFormParametre(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password ){
        UserDTO user = new UserDTO();

        user.setUserEMAIL(email);
        user.setUserNAME(username);
        user.setUserPASS(password);
        user.setUserROLEs();
        //return ("de indtastede data er følgende: <br>\nname: "+ name + "\nid: " + id + "\namount: " + amount);
        return "hey";
    }

}
