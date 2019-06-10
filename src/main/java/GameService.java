import Data.GameDAL.GameDAO;
import Data.GameDAL.IGameDAO;
import Data.IMysqlConnection;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    IMysqlConnection mysqlConnection;

    public GameService(IMysqlConnection mysqlConnection) {
        this.mysqlConnection = mysqlConnection;

    }

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