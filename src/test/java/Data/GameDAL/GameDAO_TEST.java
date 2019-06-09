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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GameDAO_TEST {

    IMysqlConnection mysql = new MysqlConnection();
    IUserDAO udao = new UserDAO(mysql);
    IRoleDAO rdao = new RoleDAO(mysql);
    IGameDAO gdao = new GameDAO(mysql);

    public GameDTO createGameDB(int gameID) {
        GameDTO game = new GameDTO();
        DateDTO date = new DateDTO(1,12,2019);
        WriterDTO writer = null;
        DeveloperDTO dev = null;
        PublisherDTO pub = null;
        ComposerDTO comp = null;
        SoundtrackDTO ost = null;

        List<CharacterDTO>  gameCHARs       = GAME_createCharacterList();
        List<GenreDTO>      gameGENREs      = new ArrayList<>();
        List<ActorDTO>      gameACTOR       = new ArrayList<>();
        List<RatingDTO>     gameRATING      = new ArrayList<>();
        List<GameModeDTO>   gameGAMEMODE    = new ArrayList<>();
        List<TrailerDTO>    gameTRAILER     = new ArrayList<>();
        List<PictureDTO>    gamePics        = new ArrayList<>();

        game.setGameID(gameID);
        game.setGameBG("INSERT BACKGROUND URL");        game.setGameBIO("INSERT DESCRIPTION HERE");         game.setGameNAME("INSERT GAME TITLE HERE");
        game.setGameCover("INSERT COVER HERE");         game.setGameCOMP(comp);                             game.setGameDEV(dev);
        game.setGameOST(ost);                           game.setGamePUB(pub);                               game.setGameRELEASEDATE(date);
        game.setGameWRI(writer);                        game.setGameACs(gameACTOR);                         game.setGamePICs(gamePics);
        game.setGameCHs(gameCHARs);                     game.setGameGENREs(gameGENREs);                     game.setGameGMs(gameGAMEMODE);
        game.setGameRATINGs(gameRATING);                game.setGameTRAILERs(gameTRAILER);
        gdao.createGame(game);
        return game;
    }

    private List<CharacterDTO> GAME_createCharacterList() {
        List<CharacterDTO> charList = new ArrayList<>();
        charList.add(GAME_createCharacter(1));
        GAME_createCharacter(2);
        GAME_createCharacter(3);

        return null;
    }

    private CharacterDTO GAME_createCharacter(int charID) {
        CharacterDTO character = new CharacterDTO();
        return null;
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