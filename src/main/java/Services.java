import Data.IMysqlConnection;
import Data.MysqlConnection;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.SQLException;

@Path("services")
public class Services{

    @POST
    @Path("user/createUser")
    public boolean createUser(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password) {
        IMysqlConnection mySQL = new MysqlConnection();
        try {
            mySQL.setConnection(mySQL.createConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        UserService service = new UserService(mySQL);
        boolean answer;
        answer=service.tagImodFormParametre(username, email, password);
        return answer;
    }

    @POST
    @Path("test")
    public String test(){
        return "hej med dig";
    }




}