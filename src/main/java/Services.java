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
        boolean answer = true;
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
                System.out.println("created at createUSer");
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            answer=service.createUser(username, email, password);
            //DONT CLOSE THE CONNECTION, KEEP IT OPEN
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @POST
    @Path("user/getUser/{username}")
    public String getUser(@PathParam("username") String username){
        UserDTO user = null;
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
                System.out.println("created at getUser");
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            user = service.getUser(username);
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
                System.out.println("created at getUserList");
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            List<UserDTO> userList = service.getUserList();

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
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return "true";
    }

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
                System.out.println("created at updateUser");
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            answer = service.updateUser(user);
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
                System.out.println("created at removeUserPermissions");
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            answer = service.removeUserPermissions(userDTO);
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
                System.out.println("created at promoteUserPermissions");
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            answer = service.promoteUserPermissions(userDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }

    @POST
    @Path("user/logIn")
    public String logIn(@FormParam("username") String username, @FormParam("password") String password){
        UserDTO user = new UserDTO();
        String answer = "placeholder";
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
                System.out.println("created at Login");
            }
            UserService service = new UserService(MysqlConnection.getInstance());
            user = service.logIn(username, password);

            ObjectMapper objectMapper = new ObjectMapper();
            answer = objectMapper.writeValueAsString(user);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e){
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
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
                System.out.println("created at createGame");
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            answer = service.createGame(gameDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answer;
    }

    //FIXME getGame og getGameID slukker ikke deres connections lige nu. De er udkommenteret for at teste
    @POST
    @Path("game/getGame/{gameID}")
    public String getGame (@PathParam("gameID") int gameID){
        GameDTO gameDTO = new GameDTO();
        try {
            System.out.println("connection : " + MysqlConnection.getInstance().getConnection());
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
                System.out.println("created at getGame");
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            gameDTO = service.getGame(gameID);
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


    //FIXME not done
    @POST
    @Path("game/getGameList")
    public String getGameList(){
        List<GameDTO> answer = null;
        String json = "placeholder";
        try {
            System.out.println("connection : " + MysqlConnection.getInstance().getConnection());

            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
                System.out.println("created at getGameID");
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            answer = service.getGameList();

            class JSONObject{
                List<GameDTO> gameList;

                public JSONObject() {
                }

                public List<GameDTO> getGameList() {
                    return gameList;
                }

                public void setGameList(List<GameDTO> gameList) {
                    this.gameList = gameList;
                }
            }

            JSONObject jsonObject = new JSONObject();
            jsonObject.setGameList(answer);

            ObjectMapper objectMapper = new ObjectMapper();
            json = objectMapper.writeValueAsString(jsonObject);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return json;
    }

    @POST
    @Path("game/getGameID/{gameName}")
    public String getGameID(@PathParam("gameName") String gameName){
            String gameID = "placeholder";
        try {
            System.out.println("connection : " + MysqlConnection.getInstance().getConnection());
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
                System.out.println("created at getGameID");
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            gameID = service.getGameId(gameName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gameID;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("game/updateGame")
    public boolean updateGame(GameDTO gameDTO){
        boolean answer = true;
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
                System.out.println("created at updateGame");
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            System.out.println("########################" + gameDTO.getGameCOMP().getCompID() + "##################");
            answer = service.updateGame(gameDTO);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answer;
    }

    //FIXME connectionbliver printet ud her
    @POST
    @Path("game/getGameNames/{input}")
    public String GameNamesService(@PathParam("input") String characters){
        if (characters.equals("empty")){
            return null;
            //Used to not send all games when there is typed nothing in the search bar (Because there is used "%" in the query)
        }

        ArrayList<String> answer = null;

        try {
            System.out.println("connection : " + MysqlConnection.getInstance().getConnection());
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
                System.out.println("created at GameNamesService");
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            answer = service.getGameNames(characters);
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
        System.out.println("##########DELETE GAME BLIVER KØRT##############");
        boolean answer = false;
        try {
            if(MysqlConnection.getInstance().getConnection() == null || MysqlConnection.getInstance().getConnection().isClosed()) {
                MysqlConnection.getInstance().createConnection();
                System.out.println("created at deleteGame");
            }
            GameService service = new GameService(MysqlConnection.getInstance());
            answer = service.deleteGame(gameID);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answer;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)