import Data.GameDAL.GameDAO;
import Data.GameDAL.IGameDAO;
import Data.IMysqlConnection;
import Data.MysqlConnection;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Path("game")
public class GameService {

    IMysqlConnection mysqlConnection;

    public GameService(IMysqlConnection mysqlConnection) {
        this.mysqlConnection = mysqlConnection;

    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("game/getGameNames")
    public ArrayList<String> GameNamesService(@FormParam("input") String characters){
        mysqlConnection = new MysqlConnection();
        //GameService service = new GameService(mysqlConnection);
        ArrayList<String> answer = null;

        try {
            mysqlConnection.setConnection(mysqlConnection.createConnection());
            answer = getGameNames(characters);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answer;
    }*/

    public ArrayList<String> getGameNames(String characters){
        IGameDAO gameDAO = new GameDAO(mysqlConnection);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(characters);
        stringBuilder.append("%");
        String search = stringBuilder.toString();
        ArrayList<String> gameNames = gameDAO.getGameNames(search);
        return gameNames;
    }
}