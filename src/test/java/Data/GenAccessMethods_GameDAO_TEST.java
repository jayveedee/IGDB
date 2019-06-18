package Data;

import Data.GameDAL.GameDAO;
import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.ParentCompanyDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.MusicArtistDTO;
import Data.GameDTO.Development.WriterDTO;
import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.*;
import Data.UserDTO.RatingDTO;

import java.util.ArrayList;
import java.util.List;

public class GenAccessMethods_GameDAO_TEST {

    private IMysqlConnection            mySql       = new MysqlConnection();
    private GameDAO                     gdao        = new GameDAO(mySql);

    // Create Game Object til tests
    public GameDTO createGameDB(int gameID, String userNAME) {
        GameDTO game = new GameDTO();
        String date = "2019-12-12";
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
    // Update Game Object til tests
    public GameDTO createGameDB1(int gameID, String userNAME) {
        GameDTO game = new GameDTO();
        String date = "2001-01-01";
        DeveloperDTO dev = GAME_createDeveloper1(51,gameID);
        PublisherDTO pub = GAME_createPublisher1(54,gameID);
        ComposerDTO comp = GAME_createComposer1(54,gameID,51);
        List<Integer> maList = new ArrayList<>();
        maList.add(gameID);
        SoundtrackDTO ost = GAME_createSoundtrack1(50,gameID,maList);

        List<CharacterDTO>  gameCHARs       = GAME_createCharacterList1(gameID);
        List<PlatformDTO>   plat            = GAME_createPlatformList1(gameID);
        List<GenreDTO>      gameGENREs      = GAME_createGenreList1(gameID);
        List<ActorDTO>      gameACTOR       = GAME_createActorList1(gameID,gameCHARs);
        List<WriterDTO>     gameWRI         = GAME_createWriterList1(gameID);
        List<RatingDTO>     gameRATING      = new ArrayList<>();
        List<GameModeDTO>   gameGAMEMODE    = GAME_createGameModeList1(gameID);
        List<TrailerDTO>    gameTRAILER     = GAME_createTrailerList1(gameID);
        List<PictureDTO>    gamePics        = GAME_createPictureList1(gameID);

        game.setGameID(gameID);
        game.setGameBG("INSERT BACKGROUND URL1");       game.setGameBIO("INSERT DESCRIPTION HERE1");        game.setGameNAME(userNAME);
        game.setGameCover("INSERT COVER HERE1");        game.setGameCOMP(comp);                             game.setGameDEV(dev);
        game.setGameOST(ost);                           game.setGamePUB(pub);                               game.setGameRELEASEDATE(date);
        game.setGameWRI(gameWRI);                       game.setGameACs(gameACTOR);                         game.setGamePICs(gamePics);
        game.setGameCHs(gameCHARs);                     game.setGameGENREs(gameGENREs);                     game.setGameGMs(gameGAMEMODE);
        game.setGameRATINGs(gameRATING);                game.setGameTRAILERs(gameTRAILER);                  game.setGamePLAT(plat);
        //gdao.createGame(game);
        return game;
    }

    // Character X Actor insert ( CREATE )
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
        String DOB = "2002-01-02";
        actor.setAcBDAY(DOB);
        List<Integer> charList = new ArrayList<>();
        for (int i = 0; i < gameCHARs.size(); i++) {
            charList.add(gameCHARs.get(i).getChID());
        }
        actor.setAcCHs(charList);
        actor.setAcGAME(gameID);
        return actor;
    }

    // Genre, GameMode & Platform Insert ( CREATE )
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
        String date = "2003-09-11";
        plat.setPlatCREATED(date);
        plat.setPlatGAME(gameID);
        return plat;
    }

    // Trailer & pics Insert ( CREATE )
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

    //Developer, Publisher & ParentCompany Insert ( CREATE )
    private DeveloperDTO GAME_createDeveloper (int devID, int gameID){
        DeveloperDTO dev = new DeveloperDTO();
        dev.setDevID(devID);
        dev.setDevNAME("FILLER");
        dev.setDevCOUNTRY("FILLER");
        String date = "2005-12-24";
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
        String date = "2100-11-31";
        pcomp.setParentCREATED(date);
        return pcomp;
    }
    private PublisherDTO GAME_createPublisher(int pubID, int gameID){
        PublisherDTO pub = new PublisherDTO();
        pub.setPubID(pubID);
        pub.setPubNAME("FILLER TEXT");
        pub.setPubCOUNTRY("FILLER TEXT");
        String date = "1996-10-05";
        pub.setPubCREATED(date);
        pub.setPubGAME(gameID);
        return pub;
    }

    //Writer Insert ( CREATE )
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

    // Composer & Soundtrack Insert ( CREATE )
    private SoundtrackDTO GAME_createSoundtrack(int ostID, int gameID, List<Integer> maIDs){
        SoundtrackDTO ost = new SoundtrackDTO();
        ost.setOstID(ostID);
        ost.setOstTITLE("FILLER");
        ost.setOstURL("FILLER");
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

    // Character X Actor insert ( UPDATE )
    private List<CharacterDTO> GAME_createCharacterList1(int gameID) {
        List<CharacterDTO> charList = new ArrayList<>();
        charList.add(GAME_createCharacter1(30,gameID,"test30","PFP31"));
        charList.add(GAME_createCharacter1(31,gameID,"test31","PFP32"));
        charList.add(GAME_createCharacter1(32,gameID,"test32","PFP33"));
        return charList;
    }
    private CharacterDTO GAME_createCharacter1 (int charID, int gameID, String name, String PFP) {
        CharacterDTO character = new CharacterDTO();
        character.setChID(charID);
        character.setChNAME(name);
        character.setChPFP(PFP);
        character.setChGAME(gameID);
        return character;
    }
    private List<ActorDTO> GAME_createActorList1 (int gameID, List<CharacterDTO> gameCHARs) {
        List<ActorDTO> actorList = new ArrayList<>();
        actorList.add(GAME_createActor1(30,gameID,"TEST31","TEST31","TEST31",gameCHARs));
        actorList.add(GAME_createActor1(31,gameID,"TEST32","TEST32","TEST32",gameCHARs));
        actorList.add(GAME_createActor1(32,gameID,"TEST33","TEST33","TEST33",gameCHARs));
        return actorList;
    }
    private ActorDTO GAME_createActor1(int actorID, int gameID, String FN, String LN, String PFP, List<CharacterDTO> gameCHARs){
        ActorDTO actor = new ActorDTO();
        actor.setAcID(actorID);
        actor.setAcFN(FN);
        actor.setAcLN(LN);
        actor.setAcPFP(PFP);
        String DOB = "2009-11-27";
        actor.setAcBDAY(DOB);
        List<Integer> charList = new ArrayList<>();
        for (int i = 0; i < gameCHARs.size(); i++) {
            charList.add(gameCHARs.get(i).getChID());
        }
        actor.setAcCHs(charList);
        actor.setAcGAME(gameID);
        return actor;
    }

    // Genre, GameMode & Platform Insert ( UPDATE )
    private List<GenreDTO> GAME_createGenreList1(int gameID){
        List<GenreDTO> genreList = new ArrayList<>();
        genreList.add(GAME_createGenre1(30,gameID,"test31"));
        genreList.add(GAME_createGenre1(31,gameID,"test32"));
        genreList.add(GAME_createGenre1(32,gameID,"test33"));
        return genreList;
    }
    private GenreDTO GAME_createGenre1(int genreID, int gameID, String title){
        GenreDTO genre = new GenreDTO();
        genre.setGenID(genreID);
        genre.setGenTITLE(title);
        genre.setGenGAME(gameID);
        return genre;
    }
    private List<GameModeDTO> GAME_createGameModeList1(int gameID){
        List<GameModeDTO> gameModeList = new ArrayList<>();
        gameModeList.add(GAME_createGameMode1(30,gameID,"test31"));
        gameModeList.add(GAME_createGameMode1(31,gameID,"test32"));
        gameModeList.add(GAME_createGameMode1(32,gameID,"test33"));
        return gameModeList;
    }
    private GameModeDTO GAME_createGameMode1(int gmID, int gameID, String title){
        GameModeDTO gameMode = new GameModeDTO();
        gameMode.setGmID(gmID);
        gameMode.setGmTITLE(title);
        gameMode.setGmGAME(gameID);
        return gameMode;
    }
    private List<PlatformDTO> GAME_createPlatformList1(int gameID) {
        List<PlatformDTO> platList = new ArrayList<>();
        platList.add(GAME_createPlatform1(30,gameID));
        platList.add(GAME_createPlatform1(31,gameID));
        platList.add(GAME_createPlatform1(32,gameID));
        return platList;
    }
    private PlatformDTO GAME_createPlatform1(int platID, int gameID) {
        PlatformDTO plat = new PlatformDTO();
        plat.setPlatID(platID);
        plat.setPlatTITLE("FILLER");
        String date = "2003-07-6";
        plat.setPlatCREATED(date);
        plat.setPlatGAME(gameID);
        return plat;
    }

    // Trailer & pics Insert ( UPDATE )
    private List<TrailerDTO> GAME_createTrailerList1(int gameID){
        List<TrailerDTO> trailerList = new ArrayList<>();
        trailerList.add(GAME_createTrailer1(30,gameID,"TEST31"));
        trailerList.add(GAME_createTrailer1(31,gameID,"TEST32"));
        trailerList.add(GAME_createTrailer1(32,gameID,"TEST33"));
        return trailerList;
    }
    private TrailerDTO GAME_createTrailer1(int trailerID, int gameID, String trailerURL){
        TrailerDTO trailer = new TrailerDTO();
        trailer.setTrailerID(trailerID);
        trailer.setTrailerURL(trailerURL);
        trailer.setTrailerGameID(gameID);
        return trailer;
    }
    private List<PictureDTO> GAME_createPictureList1(int gameID){
        List<PictureDTO> picList = new ArrayList<>();
        picList.add(GAME_createPicture1(30,gameID));
        picList.add(GAME_createPicture1(31,gameID));
        picList.add(GAME_createPicture1(32,gameID));
        return picList;
    }
    private PictureDTO GAME_createPicture1(int picID, int gmaeID){
        PictureDTO picture = new PictureDTO();
        picture.setPicGameID(gmaeID);
        picture.setPicID(picID);
        picture.setPicURL("fillerTEXT1");
        return picture;
    }

    //Developer, Publisher & ParentCompany Insert ( UPDATE )
    private DeveloperDTO GAME_createDeveloper1 (int devID, int gameID){
        DeveloperDTO dev = new DeveloperDTO();
        dev.setDevID(devID);
        dev.setDevNAME("FILLER1");
        dev.setDevCOUNTRY("FILLER1");
        String date = "2008-03-13";
        dev.setDevCREATED(date);
        dev.setDevSTATUS(true);
        dev.setDevGAME(gameID);
        dev.setDevPCOMPANY(GAME_createPCompany1(gameID));
        return dev;
    }
    private ParentCompanyDTO GAME_createPCompany1(int pcompID){
        ParentCompanyDTO pcomp = new ParentCompanyDTO();
        pcomp.setParentID(pcompID);
        pcomp.setParentNAME("FILLER1");
        pcomp.setParentCOUNTRY("ASD1");
        pcomp.setParentSTATUS(true);
        String date = "1939-05-25";
        pcomp.setParentCREATED(date);
        return pcomp;
    }
    private PublisherDTO GAME_createPublisher1(int pubID, int gameID){
        PublisherDTO pub = new PublisherDTO();
        pub.setPubID(pubID);
        pub.setPubNAME("FILLER TEXT1");
        pub.setPubCOUNTRY("FILLER TEXT1");
        String date = "2002-02-11";
        pub.setPubCREATED(date);
        pub.setPubGAME(gameID);
        return pub;
    }

    //Writer Insert ( UPDATE )
    private List<WriterDTO> GAME_createWriterList1(int gameID){
        List<WriterDTO> wriList = new ArrayList<>();
        wriList.add(GAME_createWriter1(41,gameID));
        wriList.add(GAME_createWriter1(71,gameID));
        wriList.add(GAME_createWriter1(91,gameID));
        return wriList;
    }
    private WriterDTO GAME_createWriter1(int wriID, int gameID){
        WriterDTO writer = new WriterDTO();
        writer.setWriterID(wriID);
        writer.setWriterFN("FILLER1");
        writer.setWriterLN("FILLER1");
        writer.setWriterGAME(gameID);
        return writer;
    }

    // Composer & Soundtrack Insert ( UPDATE )
    private SoundtrackDTO GAME_createSoundtrack1(int ostID, int gameID, List<Integer> maIDs){
        SoundtrackDTO ost = new SoundtrackDTO();
        ost.setOstID(ostID);
        ost.setOstTITLE("FILLER1");
        ost.setOstURL("FILLER1");
        ost.setOstCOMP(GAME_createComposer1(42,gameID,ostID));
        List<MusicArtistDTO> maList = new ArrayList<>();
        for (int i = 0; i < maIDs.size(); i++) {
            maList.add(GAME_createMusicalArtist1(maIDs.get(i),ostID));
        }
        ost.setOstMA(maList);
        ost.setOstGAME(gameID);
        return ost;
    }
    private ComposerDTO GAME_createComposer1(int compID, int gameID, int ostID){
        ComposerDTO comp = new ComposerDTO();
        comp.setCompID(compID);
        comp.setCompFN("FILLER1");
        comp.setCompLN("FILLER1");
        comp.setCompGAME(gameID);
        List<Integer> ostList = new ArrayList<>();
        ostList.add(ostID);
        comp.setCompOSTs(ostList);
        return comp;
    }
    private MusicArtistDTO GAME_createMusicalArtist1(int maID, int ostID){
        MusicArtistDTO ma = new MusicArtistDTO();
        ma.setArtID(maID);
        ma.setArtNAME("FILLER1");
        ma.setArtPFP("FILLER1");
        return ma;
    }
}
