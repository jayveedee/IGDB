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

        List<CharacterDTO>  gameCHARs       = GAME_createCharacterList(gameID);
        List<GenreDTO>      gameGENREs      = GAME_createGenreList(gameID);
        List<ActorDTO>      gameACTOR       = new ArrayList<>();
        List<RatingDTO>     gameRATING      = new ArrayList<>();
        List<GameModeDTO>   gameGAMEMODE    = GAME_createGameModeList(gameID);
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

    // Character X Actor insert
    private List<CharacterDTO> GAME_createCharacterList(int gameID) {
        List<CharacterDTO> charList = new ArrayList<>();
        charList.add(GAME_createCharacter(1,gameID,"test1","PFP1"));
        charList.add(GAME_createCharacter(2,gameID,"test2","PFP2"));
        charList.add(GAME_createCharacter(3,gameID,"test3","PFP3"));
        return charList;
    }
    private CharacterDTO GAME_createCharacter(int charID, int gameID, String name, String PFP) {
        CharacterDTO character = new CharacterDTO();
        character.setChID(charID);
        character.setChBIO("test");
        character.setChNAME(name);
        character.setChPFP(PFP);
        List<Integer> gmlist = new ArrayList<>();
        gmlist.add(gameID);
        List<Integer> aclist = new ArrayList<>();
        character.setChVAs(aclist);
        return character;
    }

    // Genre X GameMode Insert
    private List<GenreDTO> GAME_createGenreList(int gameID){
        List<GenreDTO> genreList = new ArrayList<>();
        genreList.add(GAME_createGenre(1,gameID,"test1"));
        genreList.add(GAME_createGenre(2,gameID,"test2"));
        genreList.add(GAME_createGenre(3,gameID,"test3"));
        return genreList;
    }
    private GenreDTO GAME_createGenre(int genreID, int gameID, String title){
        GenreDTO genre = new GenreDTO();
        genre.setGenID(genreID);
        genre.setGenTITLE(title);
        List<Integer> genreList = new ArrayList<>();
        genreList.add(gameID);
        genre.setGenGAMEs(genreList);
        return genre;
    }
    private List<GameModeDTO> GAME_createGameModeList(int gameID){
        List<GameModeDTO> gameModeList = new ArrayList<>();
        gameModeList.add(GAME_createGameMode(1,gameID,"test1"));
        gameModeList.add(GAME_createGameMode(2,gameID,"test2"));
        gameModeList.add(GAME_createGameMode(3,gameID,"test3"));
        return gameModeList;
    }
    private GameModeDTO GAME_createGameMode(int gmID, int gameID, String title){
        GameModeDTO gameMode = new GameModeDTO();
        gameMode.setGmID(gmID);
        gameMode.setGmTITLE(title);
        List<Integer> gmlist = new ArrayList<>();
        gmlist.add(gameID);
        gameMode.setGmGAMEs(gmlist);
        return gameMode;
    }

    @Test
    public void createGame() throws SQLException {
        mysql.createConnection();
        //GameDTO testGame1 = createGameDB(20);
        GameDTO testGame2 = createGameDB(70);
    }

    @Test
    public void getGame() throws SQLException {
        mysql.createConnection();



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