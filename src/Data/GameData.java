package Data;

import java.util.List;

public class GameData implements IGameData {
    @Override
    public Game getGame(int gameID) {
        return null;
    }

    @Override
    public List<Game> getGameList() {
        return null;
    }

    @Override
    public boolean createGame(Game game) {
        return false;
    }

    @Override
    public boolean updateGame(Game game) {
        return false;
    }

    @Override
    public void deleteGame(int gameID) {

    }

    @Override
    public void createConnection() {

    }

    @Override
    public void closeConnection() {

    }
}
