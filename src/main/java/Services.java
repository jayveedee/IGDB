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
        System.out.println("TUSSE");
        System.out.println(gameDTO.getGamePUB());
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

    /*@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("game/createGame/test")
    public boolean createGameTest(GameDTO gameDTO){
        boolean answer = true;
        System.out.println(" ");
        System.out.println("#### the game data received is the following ####");
        System.out.println("gameID: " + gameDTO.getGameID());
        System.out.println("gameNAME: " + gameDTO.getGameNAME());
        System.out.println("game releasedate is: " + gameDTO.getGameRELEASEDATE());
        System.out.println(" ");

        System.out.println("### MEDIA ###");
        System.out.println("cover: " + gameDTO.getGameCover());
        System.out.println("background: " + gameDTO.getGameBG());
        System.out.println("trailer 1: " + gameDTO.getGameTRAILERs().get(0).getTrailerURL());
        System.out.println("trailer 2: " + gameDTO.getGameTRAILERs().get(1).getTrailerURL());
        System.out.println("picture 1: " + gameDTO.getGamePICs().get(0).getPicURL());
        System.out.println("picture 2: " + gameDTO.getGamePICs().get(1).getPicURL());
        System.out.println(" ");

        System.out.println("### ART ###");
        System.out.println("game OST name: " + gameDTO.getGameOST().getOstTITLE());
        System.out.println("game OST URL: " + gameDTO.getGameOST().getOstURL());
        System.out.println("music artist 1 name: " + gameDTO.getGameOST().getOstMA().get(0).getArtNAME());
        System.out.println("music artist 1 url: " + gameDTO.getGameOST().getOstMA().get(0).getArtPFP());
        System.out.println("music artist 2 name: " + gameDTO.getGameOST().getOstMA().get(1).getArtNAME());
        System.out.println("music artist 1 url: " + gameDTO.getGameOST().getOstMA().get(1).getArtPFP());
        System.out.println("Composer: " + gameDTO.getGameCOMP().getCompFN());
        System.out.println("writer 1 name: " + gameDTO.getGameWRI().get(0).getWriterFN());
        System.out.println("writer 2 name: " + gameDTO.getGameWRI().get(1).getWriterFN());
        System.out.println(" ");

        System.out.println("### Company Details ###");
        System.out.println("parent name" + gameDTO.getGameDEV().getDevPCOMPANY().getParentNAME());
        System.out.println("parent country"+gameDTO.getGameDEV().getDevPCOMPANY().getParentCOUNTRY());
        System.out.println("parent creation"+gameDTO.getGameDEV().getDevPCOMPANY().getParentCREATED());
        System.out.println("parent status"+gameDTO.getGameDEV().getDevPCOMPANY().isParentSTATUS());
        System.out.println("parentid"+gameDTO.getGameDEV().getDevPCOMPANY().getParentID());
        System.out.println(" ");

        System.out.println("### Developer ###");
        System.out.println("Developer name: " + gameDTO.getGameDEV().getDevNAME());
        System.out.println("Developer creation: " + gameDTO.getGameDEV().getDevCREATED());
        System.out.println("Developer country: " + gameDTO.getGameDEV().getDevCOUNTRY());
        System.out.println("Developer status: " + gameDTO.getGameDEV().isDevSTATUS());
        System.out.println("Developer id: " + gameDTO.getGameDEV().getDevID());
        System.out.println("Developer gameID: " + gameDTO.getGameDEV().getDevGAME());
        System.out.println(" ");

        System.out.println("### Publisher Details ###");
        System.out.println("publisher name: " + gameDTO.getGamePUB().getPubNAME());
        System.out.println("publisher creation: " + gameDTO.getGamePUB().getPubCREATED());
        System.out.println("publisher country: " + gameDTO.getGamePUB().getPubCOUNTRY());
        System.out.println("publisher status: " + gameDTO.getGamePUB().isPubSTATUS());
        System.out.println("publisher id: " + gameDTO.getGamePUB().getPubID());
        System.out.println("publisher gameid: " + gameDTO.getGamePUB().getPubGAME());
        System.out.println(" ");

        System.out.println("### Actors ###");
        System.out.println("actor 1 name: " + gameDTO.getGameACs().get(0).getAcFN());
        System.out.println("actor 1 url: " + gameDTO.getGameACs().get(0).getAcPFP());
        System.out.println("actor 1 birthday: " + gameDTO.getGameACs().get(0).getAcBDAY());
        System.out.println("actor 1 ID: " + gameDTO.getGameACs().get(0).getAcID());
        System.out.println("actor 1 gameID: " + gameDTO.getGameACs().get(0).getAcGAME());
        System.out.println("actor 2 name: " + gameDTO.getGameACs().get(1).getAcFN());
        System.out.println("actor 2 url: " + gameDTO.getGameACs().get(1).getAcPFP());
        System.out.println("actor 2 birthday: " + gameDTO.getGameACs().get(1).getAcBDAY());
        System.out.println("actor 2 ID: " + gameDTO.getGameACs().get(1).getAcID());
        System.out.println("actor 2 gameID: " + gameDTO.getGameACs().get(1).getAcGAME());
        System.out.println(" ");

        System.out.println("### Ingame Characters ###");
        System.out.println("character 1 name: " + gameDTO.getGameCHs().get(0).getChNAME());
        System.out.println("character 1 url: " + gameDTO.getGameCHs().get(0).getChPFP());
        System.out.println("character 1 ID: " + gameDTO.getGameCHs().get(0).getChID());
        System.out.println("character 1 gameID: " + gameDTO.getGameCHs().get(0).getChGAME());
        System.out.println("character 2 name: " + gameDTO.getGameCHs().get(1).getChNAME());
        System.out.println("character 2 url: " + gameDTO.getGameCHs().get(1).getChPFP());
        System.out.println("character 2 ID: " + gameDTO.getGameCHs().get(1).getChID());
        System.out.println("character 2 gameID: " + gameDTO.getGameCHs().get(1).getChGAME());
        System.out.println(" ");

        System.out.println("### Eligible Game Platforms ###");
        System.out.println("platform 1 title: " + gameDTO.getGamePLAT().get(0).getPlatTITLE());
        System.out.println("platform 1 created: " + gameDTO.getGamePLAT().get(0).getPlatCREATED());
        System.out.println("platform 1 ID: " + gameDTO.getGamePLAT().get(0).getPlatID());
        System.out.println("platform 1 game: " + gameDTO.getGamePLAT().get(0).getPlatGAME());
        System.out.println("platform 2 Title: " + gameDTO.getGamePLAT().get(1).getPlatTITLE());
        System.out.println("platform 2 created: " + gameDTO.getGamePLAT().get(1).getPlatCREATED());
        System.out.println("platform 2 ID: " + gameDTO.getGamePLAT().get(1).getPlatID());
        System.out.println("platform 2 game:" + gameDTO.getGamePLAT().get(1).getPlatGAME());
        System.out.println(" ");

        System.out.println("### Game genre ###");
        System.out.println("genre 1 title: " + gameDTO.getGameGENREs().get(0).getGenTITLE());
        System.out.println("genre 1 ID: " + gameDTO.getGameGENREs().get(0).getGenID());
        System.out.println("genre 1 gameID: " + gameDTO.getGameGENREs().get(0).getGenGAME());
        System.out.println("genre 2 title: " + gameDTO.getGameGENREs().get(1).getGenTITLE());
        System.out.println("genre 2 ID: " + gameDTO.getGameGENREs().get(1).getGenID());
        System.out.println("genre 2 gameID: " + gameDTO.getGameGENREs().get(1).getGenGAME());
        System.out.println(" ");

        System.out.println("### game desc ###");
        System.out.println("gameBIO: " + gameDTO.getGameBIO());

        return answer;
    }*/


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
