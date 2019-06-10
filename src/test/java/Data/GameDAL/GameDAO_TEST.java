package Data.GameDAL;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.DateDTO;
import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.ParentCompanyDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.MusicArtistDTO;
import Data.GameDTO.Development.WriterDTO;
import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.*;
import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDAL.IRoleDAO;
import Data.UserDAL.IUserDAO;
import Data.UserDAL.RoleDAO;
import Data.UserDAL.UserDAO;
import Data.UserDTO.RatingDTO;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO_TEST {

    IMysqlConnection mysql = new MysqlConnection();
    IUserDAO udao = new UserDAO(mysql);
    IRoleDAO rdao = new RoleDAO(mysql);
    IGameDAO gdao = new GameDAO(mysql);

    public GameDTO createGameDB(int gameID) {
        GameDTO game = new GameDTO();
        DateDTO date = new DateDTO(1,12,2019);
        WriterDTO writer = GAME_createWriter(23,gameID);
        DeveloperDTO dev = GAME_createDeveloper(1,gameID);
        PublisherDTO pub = GAME_createPublisher(14,gameID);
        ComposerDTO comp = GAME_createComposer(4,gameID,50);
        PlatformDTO plat = GAME_createPlatform(55,gameID);
            List<Integer> maList = new ArrayList<>();
            maList.add(gameID);
        SoundtrackDTO ost = GAME_createSoundtrack(50,gameID,maList);

        List<CharacterDTO>  gameCHARs       = GAME_createCharacterList(gameID);
        List<GenreDTO>      gameGENREs      = GAME_createGenreList(gameID);
        List<ActorDTO>      gameACTOR       = GAME_createActorList(gameID,gameCHARs);
        List<RatingDTO>     gameRATING      = new ArrayList<>();
        List<GameModeDTO>   gameGAMEMODE    = GAME_createGameModeList(gameID);
        List<TrailerDTO>    gameTRAILER     = GAME_createTrailerList(gameID);
        List<PictureDTO>    gamePics        = GAME_createPictureList(gameID);

        game.setGameID(gameID);
        game.setGameBG("INSERT BACKGROUND URL");        game.setGameBIO("INSERT DESCRIPTION HERE");         game.setGameNAME("INSERT GAME TITLE HERE");
        game.setGameCover("INSERT COVER HERE");         game.setGameCOMP(comp);                             game.setGameDEV(dev);
        game.setGameOST(ost);                           game.setGamePUB(pub);                               game.setGameRELEASEDATE(date);
        game.setGameWRI(writer);                        game.setGameACs(gameACTOR);                         game.setGamePICs(gamePics);
        game.setGameCHs(gameCHARs);                     game.setGameGENREs(gameGENREs);                     game.setGameGMs(gameGAMEMODE);
        game.setGameRATINGs(gameRATING);                game.setGameTRAILERs(gameTRAILER);                  game.setGamePLAT(plat);
        gdao.createGame(game);
        return game;
    }

    // Character X Actor insert
    private List<CharacterDTO> GAME_createCharacterList(int gameID) {
        List<CharacterDTO> charList = new ArrayList<>();
        charList.add(GAME_createCharacter(100,gameID,"test1","PFP1"));
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
    private List<ActorDTO> GAME_createActorList (int gameID, List<CharacterDTO> gameCHARs) {
        List<ActorDTO> actorList = new ArrayList<>();
        actorList.add(GAME_createActor(110,gameID,"TEST1","TEST1","TEST1",gameCHARs));
        actorList.add(GAME_createActor(2,gameID,"TEST2","TEST2","TEST2",gameCHARs));
        actorList.add(GAME_createActor(3,gameID,"TEST3","TEST3","TEST3",gameCHARs));
        return actorList;
    }
    private ActorDTO GAME_createActor(int actorID, int gameID, String FN, String LN, String PFP, List<CharacterDTO> gameCHARs){
        ActorDTO actor = new ActorDTO();
        actor.setAcID(actorID);
        actor.setAcFN(FN);
        actor.setAcLN(LN);
        actor.setAcPFP(PFP);
        DateDTO DOB = new DateDTO(1,1,2001);
        actor.setAcBDAY(DOB);
        List<Integer> charList = new ArrayList<>();
        for (int i = 0; i < gameCHARs.size(); i++) {
            charList.add(gameCHARs.get(i).getChID());
        }
        actor.setAcCHs(charList);
        List<Integer> gmlist = new ArrayList<>();
        gmlist.add(gameID);
        actor.setAcGAMEs(gmlist);
        return actor;
    }

    // Genre, GameMode & Platform Insert
    private List<GenreDTO> GAME_createGenreList(int gameID){
        List<GenreDTO> genreList = new ArrayList<>();
        genreList.add(GAME_createGenre(120,gameID,"test1"));
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
        gameModeList.add(GAME_createGameMode(130,gameID,"test1"));
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
    private PlatformDTO GAME_createPlatform(int platID, int gameID) {
        PlatformDTO plat = new PlatformDTO();
        plat.setPlatID(platID);
        plat.setPlatTITLE("FILLER");
        DateDTO date = new DateDTO(1,1,2001);
        plat.setPlatCREATED(date);
        List<Integer> gmlist = new ArrayList<>();
        gmlist.add(gameID);
        plat.setPlatGAMEs(gmlist);
        return plat;
    }

    // Trailer & pics Insert
    private List<TrailerDTO> GAME_createTrailerList(int gameID){
        List<TrailerDTO> trailerList = new ArrayList<>();
        trailerList.add(GAME_createTrailer(3,gameID,"TEST1"));
        trailerList.add(GAME_createTrailer(5,gameID,"TEST2"));
        trailerList.add(GAME_createTrailer(9,gameID,"TEST3"));
        return trailerList;
    }
    private TrailerDTO GAME_createTrailer(int trailerID, int gameID, String trailerURL){
        TrailerDTO trailer = new TrailerDTO();
        trailer.setTrailerID(trailerID);
        trailer.setTrailerURL(trailerURL);
        trailer.setTrailerGameID(gameID);
        return trailer;
    }
    private List<PictureDTO> GAME_createPictureList(int gameID){
        List<PictureDTO> picList = new ArrayList<>();
        picList.add(GAME_createPicture(140,gameID));
        picList.add(GAME_createPicture(2,gameID));
        picList.add(GAME_createPicture(3,gameID));
        return picList;
    }
    private PictureDTO GAME_createPicture(int picID, int gmaeID){
        PictureDTO picture = new PictureDTO();
        picture.setPicGameID(gmaeID);
        picture.setPicID(picID);
        picture.setPicURL("fillerTEXT");
        return picture;
    }

    //Developer, Publisher & ParentCompany Insert
    private DeveloperDTO GAME_createDeveloper (int devID, int gameID){
        DeveloperDTO dev = new DeveloperDTO();
        dev.setDevID(devID);
        dev.setDevNAME("FILLER");
        dev.setDevCOUNTRY("FILLER");
        DateDTO date = new DateDTO(1,1,2001);
        dev.setDevCREATED(date);
        dev.setDevSTATUS(true);
        List<Integer> gmlist = new ArrayList<>();
        gmlist.add(gameID);
        dev.setDevGAMEs(gmlist);
        dev.setDevPCOMPANY(GAME_createPCompany(gameID));
        return dev;
    }
    private ParentCompanyDTO GAME_createPCompany(int pcompID){
        ParentCompanyDTO pcomp = new ParentCompanyDTO();
        pcomp.setParentID(pcompID);
        pcomp.setParentNAME("FILLER");
        pcomp.setParentSTATUS(true);
        DateDTO date = new DateDTO(1,1,2001);
        pcomp.setParentCREATED(date);
        return pcomp;
    }
    private PublisherDTO GAME_createPublisher(int pubID, int gameID){
        PublisherDTO pub = new PublisherDTO();
        pub.setPubID(pubID);
        pub.setBiography("FILLER TEXT");
        pub.setPubNAME("FILLER TEXT");
        pub.setPubCOUNTRY("FILLER TEXT");
        DateDTO date = new DateDTO(1,1,2001);
        pub.setPubCREATED(date);
        List<Integer> gmlist = new ArrayList<>();
        gmlist.add(gameID);
        pub.setPubGAMEs(gmlist);
        return pub;
    }

    //Writer Insert
    private WriterDTO GAME_createWriter(int wriID, int gameID){
        WriterDTO writer = new WriterDTO();
        writer.setWriterID(wriID);
        writer.setWriterFN("FILLER");
        writer.setWriterLN("FILLER");
        List<Integer> gmlist = new ArrayList<>();
        gmlist.add(gameID);
        writer.setWriterGAMEs(gmlist);
        return writer;
    }

    // Composer & Soundtrack Insert
    private SoundtrackDTO GAME_createSoundtrack(int ostID, int gameID, List<Integer> maIDs){
        SoundtrackDTO ost = new SoundtrackDTO();
        ost.setOstID(ostID);
        ost.setOstTITLE("FILLER");
        ost.setOstPFP("FILLER");
        ost.setOstCOMP(GAME_createComposer(4,ostID,gameID));
        List<MusicArtistDTO> maList = new ArrayList<>();
        for (int i = 0; i < maIDs.size(); i++) {
            maList.add(GAME_createMusicalArtist(maIDs.get(i),ostID));
        }
        ost.setOstMA(maList);
        List<Integer> gmlist = new ArrayList<>();
        gmlist.add(gameID);
        ost.setOstGAMEs(gmlist);
        return ost;
    }
    private ComposerDTO GAME_createComposer(int compID, int gameID, int ostID){
        ComposerDTO comp = new ComposerDTO();
        comp.setCompID(compID);
        comp.setCompFN("FILLER");
        comp.setCompLN("FILLER");
        List<Integer> gmlist = new ArrayList<>();
        gmlist.add(gameID);
        comp.setCompGAMEs(gmlist);
        List<Integer> ostList = new ArrayList<>();
        ostList.add(ostID);
        comp.setCompOSTs(ostList);
        return comp;
    }
    private MusicArtistDTO GAME_createMusicalArtist(int maID, int ostID){
        MusicArtistDTO ma = new MusicArtistDTO();
        ma.setArtID(maID);
        ma.setArtNAME("FILLER");
        List<Integer> ostList = new ArrayList<>();
        ostList.add(ostID);
        ma.setArtOSTs(ostList);
        ma.setArtPFP("FILLER");
        return ma;
    }

    @Test
    public void createGame() throws SQLException {
        mysql.createConnection();
        GameDTO testGame1 = createGameDB(70);
        GameDTO testGame2 = createGameDB(71);
        GameDTO testGame3 = createGameDB(72);
        GameDTO testGame4 = createGameDB(75);
        mysql.closeConnection(mysql.getConnection());
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