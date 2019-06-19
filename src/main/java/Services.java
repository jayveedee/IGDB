import Data.GameDAL.GameDAO;
import Data.GameDAL.IGameDAO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.PlatformDTO;
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
import javax.ws.rs.core.StreamingOutput;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @POST
    @Path("user/getUserList")
    public String getUserList(){
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            List<UserDTO> userList = service.getUserList();
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());

            class JSONObject{
                List<UserDTO> userList;

                public JSONObject() {
                }

                public List<UserDTO> getUserList() {
                    return userList;
                }

                public void setUserList(List<UserDTO> userList) {
                    this.userList = userList;
                }
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.setUserList(userList);

            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(jsonObject);
            return jsonString;
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return "true";
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
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("user/removeUserPermissions")
    public boolean removeUserPermissions(UserDTO userDTO){
        boolean answer = false;
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            answer = service.removeUserPermissions(userDTO);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("user/promoteUserPermissions")
    public boolean promoteUserPermissions(UserDTO userDTO){
        boolean answer = false;
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            answer = service.promoteUserPermissions(userDTO);
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
    @Path("game/getGame/{gameID}")
    public String getGame (@PathParam("gameID") int gameID){
        GameDTO gameDTO = new GameDTO();
        try {
            //mysqlConnection.setConnection(mysqlConnection.createConnection());
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            gameDTO = service.getGame(gameID);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "placeHolder";

        try {
            jsonString = objectMapper.writeValueAsString(gameDTO);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return jsonString;
    }

    @POST
    @Path("game/getGameID/{gameName}")
    public String getGameID(@PathParam("gameName") String gameName){
        System.out.println("###############33denne metode bliver kørt##3############");
            String gameID = "placeholder";
        try {
            //mysqlConnection.setConnection(mysqlConnection.createConnection());
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            gameID = service.getGameId(gameName);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gameID;
    }

    //dette er literally en ligegyldig kommentar som bruges til at pushe noget, lol
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("game/updateGame")
    public boolean updateGame(GameDTO gameDTO){
        boolean answer = true;
        try {
            //mysqlConnection.setConnection(mysqlConnection.createConnection());
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            System.out.println("########################" + gameDTO.getGameCOMP().getCompID() + "##################");
            answer = service.updateGame(gameDTO);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
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

    @POST
    @Path("game/deleteGame/{gameID}")
    public boolean deleteGame(@PathParam("gameID") int gameID){
        boolean answer = false;
        try {
            //mysqlConnection.setConnection(mysqlConnection.createConnection());
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            answer = service.deleteGame(gameID);
            MysqlConnection.getInstance().closeConnection(MysqlConnection.getInstance().getConnection());
            //mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
}
