package Data.GameDAL;

import Data.GameDTO.GameDTO;

import java.util.List;

public interface IGameDAO {

    boolean createGame(GameDTO game);
    GameDTO getGame(int gameID);
    List<GameDTO> getGameList();
    boolean updateGame(GameDTO newGame);
    boolean deleteGame(int gameID);
}
