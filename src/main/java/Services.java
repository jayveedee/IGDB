import Data.IMysqlConnection;
import Data.MysqlConnection;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.sql.Connection;
import java.sql.SQLException;

@Path("services")
public class Services{

    private Connection connection;

    public Services() {
        IMysqlConnection mySQL = new MysqlConnection();
        try {
            connection = mySQL.createConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @POST
    @Path("user/createUser")
    public String createUser(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password) {
        UserService service = new UserService(connection);
        String answer;
        answer=service.tagImodFormParametre(username, email, password);
        return answer;
    }




}
