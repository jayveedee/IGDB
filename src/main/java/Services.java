import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDAL.IUserDAO;
import Data.UserDAL.UserDAO;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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
            answer=service.createUser(username, email, password);
            mySQL.closeConnection(mySQL.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @POST
    @Path("user/logIn")
    public String logIn(@FormParam("username") String username, @FormParam("password") String password){
        IMysqlConnection mysqlConnection = new MysqlConnection();
        String answer = "placeHolder";
        try {
            mysqlConnection.setConnection(mysqlConnection.createConnection());
            UserService service = new UserService(mysqlConnection);
            answer = service.logIn(username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }




}
