package Data.GameDAL;

import Data.GameDTO.GameDTO;
import Data.IMysqlConnection;

import java.util.List;

public class GameDAO implements IGameDAO {

    private IMysqlConnection mySql;

    public GameDAO(IMysqlConnection mySql) {
        this.mySql = mySql;
    }

    @Override
    public boolean createGame(GameDTO gmae) {
        String query = "";

        return true;
    }

    @Override
    public GameDTO getGame(int gameID) {
        return null;
    }

    @Override
    public List<GameDTO> getGameList() {
        return null;
    }

    @Override
    public boolean updateGame(GameDTO newGame) {
        return false;
    }

    @Override
    public boolean deleteGame(int gameID) {
        return false;
    }
}
