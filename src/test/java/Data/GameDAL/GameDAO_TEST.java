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

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO_TEST {

    IMysqlConnection mysql = new MysqlConnection();
    IUserDAO udao = new UserDAO(mysql);
    IRoleDAO rdao = new RoleDAO(mysql);
    IGameDAO gdao = new GameDAO(mysql);

    public GameDTO createGameDB(int gameID, String userNAME) {
        GameDTO game = new GameDTO();
        DateDTO date = new DateDTO("1","12","2019");
        DeveloperDTO dev = GAME_createDeveloper(1,gameID);
        PublisherDTO pub = GAME_createPublisher(14,gameID);
        ComposerDTO comp = GAME_createComposer(4,gameID,50);
            List<Integer> maList = new ArrayList<>();
            maList.add(gameID);
        SoundtrackDTO ost = GAME_createSoundtrack(50,gameID,maList);

        List<CharacterDTO>  gameCHARs       = GAME_createCharacterList(gameID);
        List<PlatformDTO>   plat            = GAME_createPlatformList(gameID);
        List<GenreDTO>      gameGENREs      = GAME_createGenreList(gameID);
        List<ActorDTO>      gameACTOR       = GAME_createActorList(gameID,gameCHARs);
        List<WriterDTO>     gameWRI         = GAME_createWriterList(gameID);
        List<RatingDTO>     gameRATING      = new ArrayList<>();
        List<GameModeDTO>   gameGAMEMODE    = GAME_createGameModeList(gameID);
        List<TrailerDTO>    gameTRAILER     = GAME_createTrailerList(gameID);
        List<PictureDTO>    gamePics        = GAME_createPictureList(gameID);

        game.setGameID(gameID);
        game.setGameBG("INSERT BACKGROUND URL");        game.setGameBIO("INSERT DESCRIPTION HERE");         game.setGameNAME(userNAME);
        game.setGameCover("INSERT COVER HERE");         game.setGameCOMP(comp);                             game.setGameDEV(dev);
        game.setGameOST(ost);                           game.setGamePUB(pub);                               game.setGameRELEASEDATE(date);
        game.setGameWRI(gameWRI);                       game.setGameACs(gameACTOR);                         game.setGamePICs(gamePics);
        game.setGameCHs(gameCHARs);                     game.setGameGENREs(gameGENREs);                     game.setGameGMs(gameGAMEMODE);
        game.setGameRATINGs(gameRATING);                game.setGameTRAILERs(gameTRAILER);                  game.setGamePLAT(plat);
        //gdao.createGame(game);
        return game;
    }

    // Character X Actor insert
    private List<CharacterDTO> GAME_createCharacterList(int gameID) {
        List<CharacterDTO> charList = new ArrayList<>();
        charList.add(GAME_createCharacter(60,gameID,"test1","PFP1"));
        charList.add(GAME_createCharacter(61,gameID,"test2","PFP2"));
        charList.add(GAME_createCharacter(62,gameID,"test3","PFP3"));
        return charList;
    }
    private CharacterDTO GAME_createCharacter(int charID, int gameID, String name, String PFP) {
        CharacterDTO character = new CharacterDTO();
        character.setChID(charID);
        character.setChNAME(name);
        character.setChPFP(PFP);
        character.setChGAME(gameID);
        return character;
    }
    private List<ActorDTO> GAME_createActorList (int gameID, List<CharacterDTO> gameCHARs) {
        List<ActorDTO> actorList = new ArrayList<>();
        actorList.add(GAME_createActor(60,gameID,"TEST1","TEST1","TEST1",gameCHARs));
        actorList.add(GAME_createActor(61,gameID,"TEST2","TEST2","TEST2",gameCHARs));
        actorList.add(GAME_createActor(62,gameID,"TEST3","TEST3","TEST3",gameCHARs));
        return actorList;
    }
    private ActorDTO GAME_createActor(int actorID, int gameID, String FN, String LN, String PFP, List<CharacterDTO> gameCHARs){
        ActorDTO actor = new ActorDTO();
        actor.setAcID(actorID);
        actor.setAcFN(FN);
        actor.setAcLN(LN);
        actor.setAcPFP(PFP);
        DateDTO DOB = new DateDTO("1","1","2001");
        actor.setAcBDAY(DOB);
        List<Integer> charList = new ArrayList<>();
        for (int i = 0; i < gameCHARs.size(); i++) {
            charList.add(gameCHARs.get(i).getChID());
        }
        actor.setAcCHs(charList);
        actor.setAcGAME(gameID);
        return actor;
    }

    // Genre, GameMode & Platform Insert
    private List<GenreDTO> GAME_createGenreList(int gameID){
        List<GenreDTO> genreList = new ArrayList<>();
        genreList.add(GAME_createGenre(60,gameID,"test1"));
        genreList.add(GAME_createGenre(61,gameID,"test2"));
        genreList.add(GAME_createGenre(62,gameID,"test3"));
        return genreList;
    }
    private GenreDTO GAME_createGenre(int genreID, int gameID, String title){
        GenreDTO genre = new GenreDTO();
        genre.setGenID(genreID);
        genre.setGenTITLE(title);
        genre.setGenGAME(gameID);
        return genre;
    }
    private List<GameModeDTO> GAME_createGameModeList(int gameID){
        List<GameModeDTO> gameModeList = new ArrayList<>();
        gameModeList.add(GAME_createGameMode(60,gameID,"test1"));
        gameModeList.add(GAME_createGameMode(61,gameID,"test2"));
        gameModeList.add(GAME_createGameMode(62,gameID,"test3"));
        return gameModeList;
    }
    private GameModeDTO GAME_createGameMode(int gmID, int gameID, String title){
        GameModeDTO gameMode = new GameModeDTO();
        gameMode.setGmID(gmID);
        gameMode.setGmTITLE(title);
        gameMode.setGmGAME(gameID);
        return gameMode;
    }
    private List<PlatformDTO> GAME_createPlatformList(int gameID) {
        List<PlatformDTO> platList = new ArrayList<>();
        platList.add(GAME_createPlatform(60,gameID));
        platList.add(GAME_createPlatform(61,gameID));
        platList.add(GAME_createPlatform(62,gameID));
        return platList;
    }
    private PlatformDTO GAME_createPlatform(int platID, int gameID) {
        PlatformDTO plat = new PlatformDTO();
        plat.setPlatID(platID);
        plat.setPlatTITLE("FILLER");
        DateDTO date = new DateDTO("1","1","2001");
        plat.setPlatCREATED(date);
        plat.setPlatGAMEs(gameID);
        return plat;
    }

    // Trailer & pics Insert
    private List<TrailerDTO> GAME_createTrailerList(int gameID){
        List<TrailerDTO> trailerList = new ArrayList<>();
        trailerList.add(GAME_createTrailer(60,gameID,"TEST1"));
        trailerList.add(GAME_createTrailer(61,gameID,"TEST2"));
        trailerList.add(GAME_createTrailer(62,gameID,"TEST3"));
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
        picList.add(GAME_createPicture(60,gameID));
        picList.add(GAME_createPicture(61,gameID));
        picList.add(GAME_createPicture(62,gameID));
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
        DateDTO date = new DateDTO("1","1","2001");
        dev.setDevCREATED(date);
        dev.setDevSTATUS(true);
        dev.setDevGAME(gameID);
        dev.setDevPCOMPANY(GAME_createPCompany(gameID));
        return dev;
    }
    private ParentCompanyDTO GAME_createPCompany(int pcompID){
        ParentCompanyDTO pcomp = new ParentCompanyDTO();
        pcomp.setParentID(pcompID);
        pcomp.setParentNAME("FILLER");
        pcomp.setParentCOUNTRY("ASD");
        pcomp.setParentSTATUS(true);
        DateDTO date = new DateDTO("1","1","2001");
        pcomp.setParentCREATED(date);
        return pcomp;
    }
    private PublisherDTO GAME_createPublisher(int pubID, int gameID){
        PublisherDTO pub = new PublisherDTO();
        pub.setPubID(pubID);
        pub.setPubNAME("FILLER TEXT");
        pub.setPubCOUNTRY("FILLER TEXT");
        DateDTO date = new DateDTO("1","1","2001");
        pub.setPubCREATED(date);
        pub.setPubGAME(gameID);
        return pub;
    }

    //Writer Insert
    private List<WriterDTO> GAME_createWriterList(int gameID){
        List<WriterDTO> wriList = new ArrayList<>();
        wriList.add(GAME_createWriter(4,gameID));
        wriList.add(GAME_createWriter(7,gameID));
        wriList.add(GAME_createWriter(9,gameID));
        return wriList;
    }
    private WriterDTO GAME_createWriter(int wriID, int gameID){
        WriterDTO writer = new WriterDTO();
        writer.setWriterID(wriID);
        writer.setWriterFN("FILLER");
        writer.setWriterLN("FILLER");
        writer.setWriterGAME(gameID);
        return writer;
    }

    // Composer & Soundtrack Insert
    private SoundtrackDTO GAME_createSoundtrack(int ostID, int gameID, List<Integer> maIDs){
        SoundtrackDTO ost = new SoundtrackDTO();
        ost.setOstID(ostID);
        ost.setOstTITLE("FILLER");
        ost.setOstPFP("FILLER");
        ost.setOstCOMP(GAME_createComposer(4,gameID,ostID));
        List<MusicArtistDTO> maList = new ArrayList<>();
        for (int i = 0; i < maIDs.size(); i++) {
            maList.add(GAME_createMusicalArtist(maIDs.get(i),ostID));
        }
        ost.setOstMA(maList);
        ost.setOstGAME(gameID);
        return ost;
    }
    private ComposerDTO GAME_createComposer(int compID, int gameID, int ostID){
        ComposerDTO comp = new ComposerDTO();
        comp.setCompID(compID);
        comp.setCompFN("FILLER");
        comp.setCompLN("FILLER");
        comp.setCompGAME(gameID);
        List<Integer> ostList = new ArrayList<>();
        ostList.add(ostID);
        comp.setCompOSTs(ostList);
        return comp;
    }
    private MusicArtistDTO GAME_createMusicalArtist(int maID, int ostID){
        MusicArtistDTO ma = new MusicArtistDTO();
        ma.setArtID(maID);
        ma.setArtNAME("FILLER");
        ma.setArtPFP("FILLER");
        return ma;
    }

    @Test
    public void createGame() throws SQLException {
        mysql.createConnection();
        GameDTO testGame1 = createGameDB(70,"COD1");
        GameDTO testGame2 = createGameDB(71,"COD2");
        GameDTO testGame3 = createGameDB(72,"COD3");
        GameDTO testGame4 = createGameDB(99,"COD4");
        assertTrue(gdao.createGame(testGame4));
        mysql.closeConnection(mysql.getConnection());
    }

    @Test
    public void getGame() throws SQLException {
        mysql.createConnection();
        GameDTO testGame1       = createGameDB(70,"COD1");
        GameDTO testGame1DB     = gdao.getGame(70);

        assertEquals(testGame1.getGameID(),testGame1DB.getGameID());
        assertEquals(testGame1.getGameBG(),testGame1DB.getGameBG());
        assertEquals(testGame1.getGameBIO(),testGame1DB.getGameBIO());
        assertEquals(testGame1.getGameCover(),testGame1DB.getGameCover());
        assertEquals(testGame1.getGameNAME(),testGame1DB.getGameNAME());
        assertEquals(testGame1.getGameRELEASEDATE().getDay(),testGame1DB.getGameRELEASEDATE().getDay());
        assertEquals(testGame1.getGameRELEASEDATE().getMonth(),testGame1DB.getGameRELEASEDATE().getMonth());
        assertEquals(testGame1.getGameRELEASEDATE().getYear(),testGame1DB.getGameRELEASEDATE().getYear());
        assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentID(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentID());
        assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentCOUNTRY(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentCOUNTRY());
        assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentNAME(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentNAME());
        assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentCREATED().getDay(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentCREATED().getDay());
        assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentCREATED().getMonth(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentCREATED().getMonth());
        assertEquals(testGame1.getGameDEV().getDevPCOMPANY().getParentCREATED().getYear(),testGame1DB.getGameDEV().getDevPCOMPANY().getParentCREATED().getYear());
        assertEquals(testGame1.getGameOST().getOstCOMP().getCompID(),testGame1DB.getGameOST().getOstCOMP().getCompID());
        assertEquals(testGame1.getGameOST().getOstCOMP().getCompFN(),testGame1DB.getGameOST().getOstCOMP().getCompFN());
        assertEquals(testGame1.getGameOST().getOstCOMP().getCompLN(),testGame1DB.getGameOST().getOstCOMP().getCompLN());
        assertEquals(testGame1.getGameOST().getOstCOMP().getCompGAME(),testGame1DB.getGameOST().getOstCOMP().getCompGAME());
        List<Integer> compOstList1      = testGame1.getGameOST().getOstCOMP().getCompOSTs();
        List<Integer> compOstList1DB    = testGame1DB.getGameOST().getOstCOMP().getCompOSTs();
        for (int i = 0; i < testGame1.getGameOST().getOstCOMP().getCompOSTs().size(); i++) {
            assertEquals(compOstList1.get(i),compOstList1DB.get(i));
        }
        assertEquals(testGame1.getGameOST().getOstID(),testGame1DB.getGameOST().getOstID());
        assertEquals(testGame1.getGameOST().getOstPFP(),testGame1DB.getGameOST().getOstPFP());
        assertEquals(testGame1.getGameOST().getOstGAME(),testGame1DB.getGameOST().getOstGAME());
        assertEquals(testGame1.getGameOST().getOstTITLE(),testGame1DB.getGameOST().getOstTITLE());
        List<MusicArtistDTO> ostMaList1     = testGame1.getGameOST().getOstMA();
        List<MusicArtistDTO> ostMaList1DB   = testGame1DB.getGameOST().getOstMA();
        for (int i = 0; i < testGame1.getGameOST().getOstMA().size(); i++) {
            assertEquals(ostMaList1.get(i).getArtID(),ostMaList1DB.get(i).getArtID());
            assertEquals(ostMaList1.get(i).getArtNAME(),ostMaList1DB.get(i).getArtNAME());
            assertEquals(ostMaList1.get(i).getArtPFP(),ostMaList1DB.get(i).getArtPFP());
        }
        assertEquals(testGame1.getGamePUB().getPubCREATED().getDay(),testGame1DB.getGamePUB().getPubCREATED().getDay());
        assertEquals(testGame1.getGamePUB().getPubCREATED().getMonth(),testGame1DB.getGamePUB().getPubCREATED().getMonth());
        assertEquals(testGame1.getGamePUB().getPubCREATED().getYear(),testGame1DB.getGamePUB().getPubCREATED().getYear());
        assertEquals(testGame1.getGamePUB().getPubCOUNTRY(),testGame1DB.getGamePUB().getPubCOUNTRY());
        assertEquals(testGame1.getGamePUB().getPubID(),testGame1DB.getGamePUB().getPubID());
        assertEquals(testGame1.getGamePUB().getPubNAME(),testGame1DB.getGamePUB().getPubNAME());
        assertEquals(testGame1.getGamePUB().getPubGAME(),testGame1DB.getGamePUB().getPubGAME());
        assertEquals(testGame1.getGameWRI().size(),testGame1DB.getGameWRI().size());
        for (int i = 0; i < testGame1.getGameWRI().size(); i++) {
            assertEquals(testGame1.getGameWRI().get(i).getWriterID(),testGame1DB.getGameWRI().get(i).getWriterID());
            assertEquals(testGame1.getGameWRI().get(i).getWriterGAME(),testGame1DB.getGameWRI().get(i).getWriterGAME());
            assertEquals(testGame1.getGameWRI().get(i).getWriterFN(),testGame1DB.getGameWRI().get(i).getWriterFN());
            assertEquals(testGame1.getGameWRI().get(i).getWriterLN(),testGame1DB.getGameWRI().get(i).getWriterLN());
        }
        List<ActorDTO> actTest1     = testGame1.getGameACs();
        List<ActorDTO> actTest1DB   = testGame1DB.getGameACs();
        for (int i = 0; i < testGame1.getGameACs().size(); i++) {
            assertEquals(actTest1.get(i).getAcBDAY().getDay(),actTest1DB.get(i).getAcBDAY().getDay());
            assertEquals(actTest1.get(i).getAcBDAY().getMonth(),actTest1DB.get(i).getAcBDAY().getMonth());
            assertEquals(actTest1.get(i).getAcBDAY().getYear(),actTest1DB.get(i).getAcBDAY().getYear());
            assertEquals(actTest1.get(i).getAcFN(),actTest1DB.get(i).getAcFN());
            assertEquals(actTest1.get(i).getAcLN(),actTest1DB.get(i).getAcLN());
            assertEquals(actTest1.get(i).getAcID(),actTest1DB.get(i).getAcID());
            assertEquals(actTest1.get(i).getAcGAME(),actTest1DB.get(i).getAcGAME());
            assertEquals(actTest1.get(i).getAcPFP(),actTest1DB.get(i).getAcPFP());
            List<Integer> actTest1Ch        = actTest1.get(i).getAcCHs();
            List<Integer> actTest1ChDB      = actTest1DB.get(i).getAcCHs();
            assertEquals(actTest1Ch.size(),actTest1ChDB.size());
            for (int j = 0; j < actTest1.get(i).getAcCHs().size(); j++) {
                assertEquals(actTest1Ch.get(j),actTest1ChDB.get(j));
            }
        }
        assertEquals(testGame1.getGameGENREs().size(),testGame1DB.getGameGENREs().size());
        for (int i = 0; i < testGame1.getGameGENREs().size(); i++) {
            assertEquals(testGame1.getGameGENREs().get(i).getGenID(),testGame1DB.getGameGENREs().get(i).getGenID());
            assertEquals(testGame1.getGameGENREs().get(i).getGenTITLE(),testGame1DB.getGameGENREs().get(i).getGenTITLE());
            assertEquals(testGame1.getGameGENREs().get(i).getGenGAME(),testGame1DB.getGameGENREs().get(i).getGenGAME());
        }
        assertEquals(testGame1.getGameCHs().size(),testGame1DB.getGameCHs().size());
        for (int i = 0; i < testGame1.getGameCHs().size(); i++) {
            assertEquals(testGame1.getGameCHs().get(i).getChID(),testGame1DB.getGameCHs().get(i).getChID());
            assertEquals(testGame1.getGameCHs().get(i).getChNAME(),testGame1DB.getGameCHs().get(i).getChNAME());
            assertEquals(testGame1.getGameCHs().get(i).getChPFP(),testGame1DB.getGameCHs().get(i).getChPFP());
            assertEquals(testGame1.getGameCHs().get(i).getChGAME(),testGame1DB.getGameCHs().get(i).getChGAME());
        }
        assertEquals(testGame1.getGameGMs().size(),testGame1DB.getGameGMs().size());
        for (int i = 0; i < testGame1.getGameGMs().size(); i++) {
            assertEquals(testGame1.getGameGMs().get(i).getGmID(),testGame1DB.getGameGMs().get(i).getGmID());
            assertEquals(testGame1.getGameGMs().get(i).getGmTITLE(),testGame1DB.getGameGMs().get(i).getGmTITLE());
            assertEquals(testGame1.getGameGMs().get(i).getGmGAME(),testGame1DB.getGameGMs().get(i).getGmGAME());
        }
        assertEquals(testGame1.getGameTRAILERs().size(),testGame1DB.getGameTRAILERs().size());
        for (int i = 0; i < testGame1.getGameTRAILERs().size(); i++) {
            assertEquals(testGame1.getGameTRAILERs().get(i).getTrailerID(),testGame1DB.getGameTRAILERs().get(i).getTrailerID());
            assertEquals(testGame1.getGameTRAILERs().get(i).getTrailerURL(),testGame1DB.getGameTRAILERs().get(i).getTrailerURL());
            assertEquals(testGame1.getGameTRAILERs().get(i).getTrailerGameID(),testGame1DB.getGameTRAILERs().get(i).getTrailerGameID());
        }
        assertEquals(testGame1.getGamePICs().size(),testGame1DB.getGamePICs().size());
        for (int i = 0; i < testGame1.getGamePICs().size(); i++) {
            assertEquals(testGame1.getGamePICs().get(i).getPicID(),testGame1DB.getGamePICs().get(i).getPicID());
            assertEquals(testGame1.getGamePICs().get(i).getPicURL(),testGame1DB.getGamePICs().get(i).getPicURL());
            assertEquals(testGame1.getGamePICs().get(i).getPicGameID(),testGame1DB.getGamePICs().get(i).getPicGameID());
        }
        assertEquals(testGame1.getGamePLAT().size(),testGame1DB.getGamePLAT().size());
        for (int i = 0; i < testGame1.getGamePLAT().size(); i++) {
            assertEquals(testGame1.getGamePLAT().get(i).getPlatID(),testGame1DB.getGamePLAT().get(i).getPlatID());
            assertEquals(testGame1.getGamePLAT().get(i).getPlatTITLE(),testGame1DB.getGamePLAT().get(i).getPlatTITLE());
            assertEquals(testGame1.getGamePLAT().get(i).getPlatGAMEs(),testGame1DB.getGamePLAT().get(i).getPlatGAMEs());
            assertEquals(testGame1.getGamePLAT().get(i).getPlatCREATED().getDay(),testGame1DB.getGamePLAT().get(i).getPlatCREATED().getDay());
            assertEquals(testGame1.getGamePLAT().get(i).getPlatCREATED().getMonth(),testGame1DB.getGamePLAT().get(i).getPlatCREATED().getMonth());
            assertEquals(testGame1.getGamePLAT().get(i).getPlatCREATED().getYear(),testGame1DB.getGamePLAT().get(i).getPlatCREATED().getYear());
        }
        mysql.closeConnection(mysql.getConnection());
    }

    @Test
    public void getGameList() {

    }

    @Test
    public void updateGame() {
        try {
            mysql.createConnection();
           GameDTO G1 =  createGameDB(88,"Pubg");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteGame() {
    }
}