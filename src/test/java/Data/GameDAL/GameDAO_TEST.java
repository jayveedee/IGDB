package Data.GameDAL;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.WriterDTO;
import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.*;
import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDAL.IRoleDAO;
import Data.UserDAL.IUserDAO;
import Data.UserDAL.RoleDAO;
import Data.UserDAL.UserDAO;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class GameDAO_TEST {

    IMysqlConnection mysql = new MysqlConnection();
    IUserDAO udao = new UserDAO(mysql);
    IRoleDAO rdao = new RoleDAO(mysql);
    IGameDAO gdao = new GameDAO(mysql);

    public GameDTO createGameDB(int gameID) {
        GameDTO game = new GameDTO();
        DateDTO date = null;
        WriterDTO writer = null;
        DeveloperDTO dev = null;
        PublisherDTO pub = null;
        ComposerDTO comp = null;
        SoundtrackDTO ost = null;

        List<CharacterDTO> gameCHARs        = null;
        List<GenreDTO>      gameGENREs      = null;
        List<ActorDTO>      gameACTOR       = null;
        List<RatingDTO>     gameRATING      = null;
        List<GameModeDTO>   gameGAMEMODE    = null;
        List<TrailerDTO>    gameTRAILER     = null;
        List<PictureDTO>    gamePics        = null;

        game.setGameID(gameID);
        game.setGameBG("INSERT BACKGROUND URL");
        game.setGameBIO("INSERT DESCRIPTION HERE");
        game.setGameNAME("INSERT GAME TITLE HERE");
        game.setGameCover("INSERT COVER HERE");
        game.setGameCOMP(comp);
        game.setGameDEV(dev);
        game.setGameOST(ost);
        game.setGamePUB(pub);
        game.setGameRELEASEDATE(date);
        game.setGameWRI(writer);
        game.setGameACs(gameACTOR);
        game.setGameCHs(gameCHARs);
        game.setGameGENREs(gameGENREs);
        game.setGameGMs(gameGAMEMODE);
        game.setGamePICs(gamePics);
        game.setGameRATINGs(gameRATING);
        game.setGameTRAILERs(gameTRAILER);
        gdao.createGame(game);
        return game;
    }

    @Test
    public void createGame() throws SQLException {
        mysql.createConnection();
        GameDTO testGame = createGameDB(20);
    }

    @Test
    public void getGame() {
    }

    @Test
    public void getGameList() {
    }

    @Test
    public void updateGame() {
    }

    @Test
    public void deleteGame() {
    }
}