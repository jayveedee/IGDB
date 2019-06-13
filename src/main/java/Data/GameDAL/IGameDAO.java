package Data.GameDAL;

import Data.GameDTO.GameDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface IGameDAO {

    boolean createGame(GameDTO game);
    GameDTO getGame(int gameID);
    List<GameDTO> getGameList();
    ArrayList<String> getGameNames(String characters);
    boolean updateGame(GameDTO newGame);
    boolean deleteGame(int gameID) throws SQLException;
}
