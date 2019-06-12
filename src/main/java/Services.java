import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDAL.IUserDAO;
import Data.UserDAL.UserDAO;
import Data.UserDTO.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.inject.Singleton;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
@Singleton
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
    @Path("user/getUser/{username}")
    public String getUser(@PathParam("username") String username){
        IMysqlConnection mysqlConnection = new MysqlConnection();
        UserDTO user = null;
        try {
            mysqlConnection.setConnection(mysqlConnection.createConnection());
            UserService service = new UserService(mysqlConnection);
            user = service.getUser(username);
            mysqlConnection.closeConnection(mysqlConnection.getConnection());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "placeHolder";

        try {
            objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //return jsonString;
        return "hola!";
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
            mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @POST
    @Path("game/getGameNames/{input}")
    public String GameNamesService(@PathParam("input") String characters){
        if (characters.equals("empty")){
            return null;
            //bruges til ikke at sende alle games når der ikke står noget i søgefeltet. (fordi man bruger % i querien)
        }

        ArrayList<String> answer = null;
        System.out.println(characters);

        IMysqlConnection mysqlConnection = new MysqlConnection();
        try {
            mysqlConnection.setConnection(mysqlConnection.createConnection());
            GameService service = new GameService(mysqlConnection);
            answer = service.getGameNames(characters);
            mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }


        class JSONObject{
            private ArrayList<String> gameNames;

            public JSONObject() {

            }

            public ArrayList<String> getGameNames() {
                return gameNames;
            }

            public void setGameNames(ArrayList<String> gameNames) {
                this.gameNames = gameNames;
            }
        }

        JSONObject jsonObject = new JSONObject();
        jsonObject.setGameNames(answer);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "placeHolder";
        try {
            jsonString = objectMapper.writeValueAsString(jsonObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
