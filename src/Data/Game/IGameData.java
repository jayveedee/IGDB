package Data.Game;

import java.util.List;

public interface IGameData {

    /**
     * Finds specific game by gameID
     * @param gameID
     * @return the game specified by ID.
     */
    Game getGame(int gameID);

    /**
     * Lists every game on database and adds it to an arraylist
     * @return list of gmaes
     */
    List<Game> getGameList();

    /**
     * Creates a new game object
     * @param game
     * @return new game created
     */
    boolean createGame(Game game);

    /**
     * updates specified game object
     * @param game
     * @return updated game object
     */
    boolean updateGame (Game game);

    /**
     * Deletes game with specified gameID
     * @param gameID
     */
    void deleteGame(int gameID);

    /**
     * Creates an MySQL connection
     */
    void createConnection();

    /**
     * Closes the My
     */
    void closeConnection();
}
