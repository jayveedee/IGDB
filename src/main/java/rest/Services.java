package rest;

import Data.IMysqlConnection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.inject.Singleton;
import javax.ws.rs.*;
import java.util.ArrayList;
@Singleton
@Path("services")
public class Services {

    IMysqlConnection mysqlConnection;


    @POST
    @Path("createConnection")
    public String createConnection(){
        String answer;
        ConnectionService connection = ConnectionService.getInstance();
        answer = connection.createConnection();
        mysqlConnection = connection.getMysqlConnection();
        return answer;
    }

    @POST
    @Path("closeConnection")
    public String closeConnection(){
        String answer;
        ConnectionService connection = ConnectionService.getInstance();
        answer = connection.closeConnection();
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
    //@Produces(MediaType.APPLICATION_JSON)
    @Path("game/getGameNames/{input}")
    public String GameNamesService(@PathParam("input") String characters){
        if (characters.equals("empty")){
            return null;
            //bruges til ikke at sende alle games når der ikke står noget i søgefeltet. (fordi man bruger % i querien)
        }

        ArrayList<String> answer = null;
        System.out.println(characters);

        GameService service = new GameService(mysqlConnection);

        answer = service.getGameNames(characters);

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
