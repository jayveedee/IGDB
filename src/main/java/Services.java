import Data.IMysqlConnection;
import Data.MysqlConnection;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.SQLException;

@Path("services")
public class Services {

    @POST
    @Path("user/createUser")
    public boolean createUser(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password) {
        IMysqlConnection mySQL = new MysqlConnection();
        boolean answer = true;
        try {
            mySQL.setConnection(mySQL.createConnection());
            UserService service = new UserService(mySQL);
            answer=service.tagImodFormParametre(username, email, password);
            mySQL.closeConnection(mySQL.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @POST
    @Path("test")
    public String test(){
        return "hej med dig din kashmir";
    }




}
