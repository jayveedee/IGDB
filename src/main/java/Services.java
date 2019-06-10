import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDAL.IUserDAO;
import Data.UserDAL.UserDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("services")
public class Services {

    IMysqlConnection mysqlConnection = new MysqlConnection();

    @POST
    @Path("createConnection")
    public String createConnection(){
        String answer;
        try {
            if (mysqlConnection.getConnection() == null || mysqlConnection.getConnection().isClosed()){
                mysqlConnection.setConnection(mysqlConnection.createConnection());
            }
            answer = "true";
        } catch (SQLException e) {
            e.printStackTrace();
            answer = "false";
        }
        return answer;
    }

    @POST
    @Path("closeConnection")
    public String closeConnection(){
        String answer;
        try {
            mysqlConnection.closeConnection(mysqlConnection.getConnection());
            answer = "true";
        } catch (SQLException e) {
            e.printStackTrace();
            answer = "false";
        } catch (NullPointerException u){
            u.printStackTrace();
            answer = "true";
        }
        return answer;
    }

    @POST
    @Path("user/createUser")
    public boolean createUser(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password) {
        //IMysqlConnection mySQL = new MysqlConnection();
        boolean answer = true;
        //try {
           // mySQL.setConnection(mySQL.createConnection());
            UserService service = new UserService(mysqlConnection);
            answer=service.createUser(username, email, password);
            //mySQL.closeConnection(mySQL.getConnection());
        //} catch (SQLException e) {
          //  e.printStackTrace();
        //}
        return answer;
    }

    @POST
    @Path("user/logIn")
    public String logIn(@FormParam("username") String username, @FormParam("password") String password){
        //IMysqlConnection mysqlConnection = new MysqlConnection();
        String answer = "placeHolder";
        //try {
            //mysqlConnection.setConnection(mysqlConnection.createConnection());
            UserService service = new UserService(mysqlConnection);
            answer = service.logIn(username, password);
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
        //} catch (SQLException e) {
          //  e.printStackTrace();
        //}
        return answer;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("game/getGameNames/{input}")
    public ArrayList<String> GameNamesService(@PathParam("input") String characters){
        if (characters.equals("empty")){
            System.out.println("der er ikke nogen characters");
            //return null;
            //bruges til ikke at sende alle games når der ikke står noget i søgefeltet. (fordi man bruger % i querien)
            //lige nu er denne if-statement skyld i at søgefeltet ikke kan gennemføre data transferen.
        }

        ArrayList<String> answer = null;
        System.out.println(characters);
        //GameService service = new GameService(mysqlConnection);
        //answer = service.getGameNames(characters);

        return answer;
    }
}
