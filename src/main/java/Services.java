import Data.GameDTO.GameDTO;
import Data.MysqlConnection;
import Data.UserDTO.UserDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import javax.inject.Singleton;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;

@Singleton
@Path("services")
public class Services {

    @POST
    @Path("user/createUser")
    public boolean createUser(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password) {
//        IMysqlConnection mySQL = new MysqlConnection();
        boolean answer = true;
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            answer=service.createUser(username, email, password);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //IKKE LUK FORBINDELSEN, BARE HOLD DEN ÅBEN
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @POST
    @Path("user/getUser/{username}")
    public String getUser(@PathParam("username") String username){
        //IMysqlConnection mysqlConnection = new MysqlConnection();
        UserDTO user = null;
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            user = service.getUser(username);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "placeHolder";

        try {
            jsonString = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    //FIXME useren mangler at kunne se sine roller på user-hjemmesiden. Man kan også gøre så man kan ændre sit billede igennem user-siden, men dette er ikke nødvendigt. Desuden mangler userGames også.
    @POST
    @Path("user/updateUser")
    public boolean updateUser(@FormParam("username") String username, @FormParam("email") String email, @FormParam("password") String password){
        boolean answer = false;
        UserDTO user = new UserDTO();
        user.setUserEMAIL(email);
        user.setUserPASS(password);
        user.setUserNAME(username);

        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            answer = service.updateUser(user);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answer;
    }

    @POST
    @Path("user/logIn")
    public String logIn(@FormParam("username") String username, @FormParam("password") String password){
        //IMysqlConnection mysqlConnection = new MysqlConnection();
        String answer = "placeHolder";
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            answer = service.logIn(username, password);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("game/createGame")
    public boolean createGame(GameDTO gameDTO){
        boolean answer = true;
        try {
            //mysqlConnection.setConnection(mysqlConnection.createConnection());
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            answer = service.createGame(gameDTO);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answer;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("game/createGame/test")
    public boolean createGameTest(TestJSONObjekt testJSONObjekt){
        boolean answer = true;

        System.out.println("#### the game data received is the following ####");
        System.out.println("gameID: " + testJSONObjekt.getGameID());
        System.out.println("gameNAME: " + testJSONObjekt.getGameNAME());
        System.out.println("gameBIO: " + testJSONObjekt.getGameBIO());
        System.out.println("game releasedate is: " + testJSONObjekt.getGameRELEASEDATE());
        System.out.println("publisher name: " + testJSONObjekt.getGamePUB().getPubNAME());
        System.out.println("writer 1 name: " + testJSONObjekt.getGameWRI().get(0).getWriterFN());
        System.out.println("writer 2 name: " + testJSONObjekt.getGameWRI().get(1).getWriterFN());
        System.out.println("status is: " + testJSONObjekt.isStatus());
        //System.out.println("gameBIO: " + gameDTO.getGameRELEASEDATE());
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

        //IMysqlConnection mysqlConnection = new MysqlConnection();
        try {
            //mysqlConnection.setConnection(mysqlConnection.createConnection());
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            answer = service.getGameNames(characters);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
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




    //FØRSTE VERSION AF CREATEGAME FUNKTIONALITETEN. SAT PÅ PAUSE FORDI DET BLEV FOR KOMPLICERET
    /*@POST
    @Path("game/createGame")
    public String createGame(@FormParam("titleField") String title, @FormParam("gameCover") String gameCover, @FormParam("gameDescription") String gameDescription, @FormParam("releaseDate") String releaseDate, @FormParam("newValue") String newValue){
        System.out.println(title);
        System.out.println(gameCover);
        System.out.println(gameDescription);
        System.out.println(releaseDate);
        System.out.println(newValue);
        /*for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        return "hey";
    }*/
}
