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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GameDAO implements IGameDAO {

    private IMysqlConnection mySql;

    public GameDAO(IMysqlConnection mySql) {
        this.mySql = mySql;
    }

    @Override
    public boolean createGame(GameDTO game) {
        String query = "INSERT INTO Game (gameID, gameTITLE, gameRD, gameDESC, gameCOVER, gameBACKGROUND) VALUES (?, ?, ?, ?, ?, ?)";
        int         gameID          = game.getGameID();
        String      gameTitle       = game.getGameNAME();
        String      gameDESC        = game.getGameBIO();
        String      gameCOV         = game.getGameCover();
        String      gameBG          = game.getGameBG();
        DateDTO     gameRD          = game.getGameRELEASEDATE();
        String      gameRDstring    = gameRD.getDay() + "/" + gameRD.getMonth() + "/" + gameRD.getYear();

        List<ActorDTO>      gameACTOR   = game.getGameACs();        List<CharacterDTO>  gameCHAR    = game.getGameCHs();
        List<GenreDTO>      gameGENRE   = game.getGameGENREs();     List<GameModeDTO>   gameGM      = game.getGameGMs();
        List<PictureDTO>    gamePIC     = game.getGamePICs();       List<TrailerDTO>    gameTRAILER = game.getGameTRAILERs();
        DeveloperDTO        gameDEV     = game.getGameDEV();        PublisherDTO        gamePUB     = game.getGamePUB();
        List<WriterDTO>     gameWRI     = game.getGameWRI();        List<PlatformDTO>   gamePLAT    = game.getGamePLAT();
        SoundtrackDTO       gameOST     = game.getGameOST();

        handleINSERTGame                        (query, gameID, gameTitle, gameDESC, gameRDstring, gameCOV, gameBG);
        handleINSERTCharacters                  (gameID, gameCHAR);
        handleINSERTActors                      (gameID, gameACTOR, gameCHAR);
        handleINSERTGenres                      (gameID, gameGENRE);
        handleINSERTGameModes                   (gameID, gameGM);
        handleINSERTPictures                    (gameID, gamePIC);
        handleINSERTTrailers                    (gameID, gameTRAILER);
        handleINSERTDeveloperXParentCompany     (gameID, gameDEV);
        handleINSERTPublisher                   (gameID, gamePUB);
        handleINSERTWriter                      (gameID, gameWRI);
        handleINSERTPlatform(gameID, gamePLAT);
        if (gameOST != null){
            handleINSERTComposer                    (gameID, gameOST.getOstCOMP());
            handleINSERTSoundtrackxMusicalArtists   (gameID, gameOST);
        }
        return true;
    }

    private void handleINSERTPlatform(int gameID, List<PlatformDTO> gamePLAT) {
        if (gamePLAT != null){
            String queryPLAT =
                "INSERT INTO PlatformList (platID, platTITLE, platCREATED, platGameID) " +
                "VALUES (?, ?, ?, ?)";
            try {
                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryPLAT));
                for (int i = 0; i < gamePLAT.size(); i++) {
                    mySql.getPrepStatement().setInt(1,gamePLAT.get(i).getPlatID());
                    mySql.getPrepStatement().setString(2,gamePLAT.get(i).getPlatTITLE());
                        String day      = gamePLAT.get(i).getPlatCREATED().getDay();
                        String month    = gamePLAT.get(i).getPlatCREATED().getMonth();
                        String year     = gamePLAT.get(i).getPlatCREATED().getYear();
                    mySql.getPrepStatement().setString(3,day + "/" + month + "/" + year);
                    mySql.getPrepStatement().setInt(4,gameID);
                    mySql.getPrepStatement().addBatch();
                }
                mySql.getPrepStatement().executeBatch();
                mySql.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleINSERTSoundtrackxMusicalArtists(int gameID, SoundtrackDTO gameOST) {
        if (gameOST != null){
            String queryARTIST =
                "INSERT INTO MusicalArtistList (artistID, artistNAME, artistPFP) " +
                "VALUES (?, ?, ?)";
            String queryOST =
                    "INSERT INTO SoundtrackList (ostID, ostTITLE, ostPFP, ostComposerID, ostArtistID, ostGameID) " +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            int                         ostID           = gameOST.getOstID();
            String                      ostTITLE        = gameOST.getOstTITLE();
            String                      ostPFP          = gameOST.getOstPFP();
            List<MusicArtistDTO>        malist          = gameOST.getOstMA();
            try {
                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryARTIST));
                for (int i = 0; i < malist.size(); i++) {
                    mySql.getPrepStatement().setInt(1,malist.get(i).getArtID());
                    mySql.getPrepStatement().setString(2,malist.get(i).getArtNAME());
                    mySql.getPrepStatement().setString(3,malist.get(i).getArtPFP());
                    mySql.getPrepStatement().addBatch();
                }
                mySql.getPrepStatement().executeBatch();
                mySql.getConnection().commit();

                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryOST));
                for (int i = 0; i < malist.size(); i++) {
                    mySql.getPrepStatement().setInt(1,ostID);
                    mySql.getPrepStatement().setString(2,ostTITLE);
                    mySql.getPrepStatement().setString(3,ostPFP);
                    mySql.getPrepStatement().setInt(4,gameOST.getOstCOMP().getCompID());
                    mySql.getPrepStatement().setInt(5,malist.get(i).getArtID());
                    mySql.getPrepStatement().setInt(6,gameID);
                    mySql.getPrepStatement().addBatch();
                }
                mySql.getPrepStatement().executeBatch();
                mySql.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleINSERTComposer(int gameID, ComposerDTO gameCOMP) {
        if (gameCOMP != null){
            String queryCOMP =
                "INSERT INTO ComposerList (compID, compFN, compLN, compGameID) " +
                "VALUES (?, ?, ?, ?)";
            int             compID              = gameCOMP.getCompID();
            String          compFN              = gameCOMP.getCompFN();
            String          compLN              = gameCOMP.getCompLN();
            handleINSERT_fn_ln_gameid(gameID, queryCOMP, compID, compFN, compLN);
        }
    }
    private void handleINSERTWriter(int gameID, List<WriterDTO> gameWRI) {
        if (gameWRI != null) {
            String queryWRI =
                "INSERT INTO WriterList (writerID, writerFN, writerLN, writerGameID) " +
                "VALUES (?, ?, ?, ?)";
            try {
                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryWRI));
                PreparedStatement prepStatement = mySql.getPrepStatement();
                for (int i = 0; i < gameWRI.size(); i++) {
                    prepStatement.setInt(1,gameWRI.get(i).getWriterID());
                    prepStatement.setString(2,gameWRI.get(i).getWriterFN());
                    prepStatement.setString(3,gameWRI.get(i).getWriterLN());
                    prepStatement.setInt(4,gameID);
                    prepStatement.addBatch();
                }
                prepStatement.executeBatch();
                mySql.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleINSERT_fn_ln_gameid(int gameID, String query, int ID, String FN, String LN) {
        try {
            handleINSERTDuplicateCode2(query, ID, FN, LN);
            mySql.getPrepStatement().setInt(4,gameID);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void handleINSERTDuplicateCode2(String query, int ID, String FN_or_NAME, String LN_or_CREATEDstring) throws SQLException {
        mySql.getConnection().setAutoCommit(false);
        mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
        mySql.getPrepStatement().setInt(1, ID);
        mySql.getPrepStatement().setString(2, FN_or_NAME);
        mySql.getPrepStatement().setString(3, LN_or_CREATEDstring);
    }
    private void handleINSERTPublisher(int gameID, PublisherDTO gamePUB) {
        if (gamePUB != null) {
            String queryPUB =
                "INSERT INTO PublisherList (pubID, pubNAME, pubCREATED, pubCOUNTRY, pubSTATUS, pubGameID) " +
                "VALUES (?, ?, ?, ?, ?, ?)";
            int             pubID               = gamePUB.getPubID();
            String          pubNAME             = gamePUB.getPubNAME();
            DateDTO pubCREATED          = gamePUB.getPubCREATED();
                String      pubCREATEDstring    = pubCREATED.getDay() + "/" + pubCREATED.getMonth() + "/" +pubCREATED.getYear();
            String          pubCOUNTRY          = gamePUB.getPubCOUNTRY();
            boolean         pubSTATUS           = gamePUB.isPubSTATUS();

            try {
                handleINSERTCompanyDuplicateCode1(queryPUB,pubID,pubNAME,pubCREATEDstring,pubCOUNTRY,pubSTATUS);
                mySql.getPrepStatement().setInt(6,gameID);
                mySql.getPrepStatement().executeUpdate();
                mySql.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleINSERTDeveloperXParentCompany(int gameID, DeveloperDTO gameDEV) {
        if (gameDEV != null) {
            String queryParent =
                "INSERT INTO ParentCompany (parentID, parentNAME, parentCREATED, parentCOUNTRY, parentSTATUS) " +
                "VALUES (?, ?, ?, ?, ?)";
            int         parentID                    = gameDEV.getDevPCOMPANY().getParentID();
            String      parentNAME                  = gameDEV.getDevPCOMPANY().getParentNAME();
            DateDTO parentCREATED               = gameDEV.getDevPCOMPANY().getParentCREATED();
                String  parentCREATEDstring         = parentCREATED.getDay() + "/" + parentCREATED.getMonth() + "/" + parentCREATED.getYear();
            String      parentCOUNTRY               = gameDEV.getDevPCOMPANY().getParentCOUNTRY();
            boolean     parentSTATUS                = gameDEV.getDevPCOMPANY().isParentSTATUS();

            String queryDEV =
                "INSERT INTO DeveloperList (devID, devNAME, devCREATED, devCOUNTRY, devSTATUS, devParentID, devGameID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
            int         devID               = gameDEV.getDevID();
            String      devNAME             = gameDEV.getDevNAME();
            DateDTO     devCREATED          = gameDEV.getDevCREATED();
                String  devCREATEDstring    = devCREATED.getDay() + "/" + devCREATED.getMonth() + "/" + devCREATED.getYear();
            String      devCOUNTRY          = gameDEV.getDevCOUNTRY();
            boolean     devSTATUS           = gameDEV.isDevSTATUS();
            try {
                handleINSERTCompanyDuplicateCode1(queryParent, parentID, parentNAME, parentCREATEDstring, parentCOUNTRY, parentSTATUS);
                mySql.getPrepStatement().executeUpdate();
                mySql.getConnection().commit();

                handleINSERTCompanyDuplicateCode1(queryDEV, devID, devNAME, devCREATEDstring, devCOUNTRY, devSTATUS);
                mySql.getPrepStatement().setInt(6,parentID);
                mySql.getPrepStatement().setInt(7,gameID);
                mySql.getPrepStatement().executeUpdate();
                mySql.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleINSERTCompanyDuplicateCode1(String query, int companyID, String companyNAME, String companyCREATED, String companyCOUNTRY, boolean companySTATUS) throws SQLException {
        handleINSERTDuplicateCode(query, companyID, companyNAME, companyCREATED, companyCOUNTRY);
        mySql.getPrepStatement().setBoolean(5, companySTATUS);
    }
    private void handleINSERTDuplicateCode(String query, int ID, String NAME, String CREATED, String COUNTRY_or_DESC) throws SQLException {
        handleINSERTDuplicateCode2(query, ID, NAME, CREATED);
        mySql.getPrepStatement().setString(4, COUNTRY_or_DESC);
    }
    private void handleINSERTTrailers(int gameID, List<TrailerDTO> gameTRAILER) {
        if (!gameTRAILER.isEmpty()){
            String queryTRAILER =
                "INSERT INTO TrailerList (trailerID, trailerURL, trailerGameID) " +
                "VALUES (?, ?, ?)";
            try {
                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryTRAILER));
                for (int i = 0; i < gameTRAILER.size(); i++) {
                    mySql.getPrepStatement().setInt(1,gameTRAILER.get(i).getTrailerID());
                    mySql.getPrepStatement().setString(2,gameTRAILER.get(i).getTrailerURL());
                    mySql.getPrepStatement().setInt(3,gameID);
                    mySql.getPrepStatement().addBatch();
                }
                mySql.getPrepStatement().executeBatch();
                mySql.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleINSERTPictures(int gameID, List<PictureDTO> gamePIC) {
        if (!gamePIC.isEmpty()){
            String queryPICTURES =
                "INSERT INTO PictureList (pictureID, pictureURL, pictureGameID) " +
                "VALUES (?, ?, ?)";
            try {
                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryPICTURES));
                for (int i = 0; i < gamePIC.size(); i++) {
                    mySql.getPrepStatement().setInt(1,gamePIC.get(i).getPicID());
                    mySql.getPrepStatement().setString(2,gamePIC.get(i).getPicURL());
                    mySql.getPrepStatement().setInt(3,gameID);
                    mySql.getPrepStatement().addBatch();
                }
                mySql.getPrepStatement().executeBatch();
                mySql.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleINSERTGameModes(int gameID, List<GameModeDTO> gameGM) {
        if (!gameGM.isEmpty()) {
            String queryGameGM =
                "INSERT INTO GameModeList (gmID, gmTITLE, gmGameID) " +
                "VALUES (?, ?, ?)";
            try {
                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryGameGM));
                for (int i = 0; i < gameGM.size(); i++) {
                    mySql.getPrepStatement().setInt(1,gameGM.get(i).getGmID());
                    mySql.getPrepStatement().setString(2,gameGM.get(i).getGmTITLE());
                    mySql.getPrepStatement().setInt(3,gameID);
                    mySql.getPrepStatement().addBatch();
                }
                mySql.getPrepStatement().executeBatch();
                mySql.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleINSERTGenres(int gameID, List<GenreDTO> gameGENRE) {
        if (!gameGENRE.isEmpty()) {
            String queryGENRE =
                "INSERT INTO GenreList (genreID, genreTITLE, genreGameID) " +
                "VALUES (?, ?, ?)";
            try {
                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryGENRE));
                for (int i = 0; i < gameGENRE.size(); i++) {
                    mySql.getPrepStatement().setInt(1,gameGENRE.get(i).getGenID());
                    mySql.getPrepStatement().setString(2,gameGENRE.get(i).getGenTITLE());
                    mySql.getPrepStatement().setInt(3,gameID);
                    mySql.getPrepStatement().addBatch();
                }
                mySql.getPrepStatement().executeBatch();
                mySql.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleINSERTGame(String query1, int gameID, String gameTitle, String gameDESC, String gameReleaseString, String gameCOV, String gameBG) {
        try {
            handleINSERTDuplicateCode(query1, gameID, gameTitle, gameReleaseString, gameDESC);
            mySql.getPrepStatement().setString(5,gameCOV);
            mySql.getPrepStatement().setString(6,gameBG);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void handleINSERTActors(int gameID, List<ActorDTO> gameACTOR, List<CharacterDTO> gameCHAR) {
        if (!gameACTOR.isEmpty() && !gameCHAR.isEmpty()) {
            String queryACTOR =
                "INSERT INTO ActorList (actorID, actorFN, actorLN, actorDOB, actorPFP, actorCHARID, actorGameID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
            try {
                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryACTOR));
                for (int i = 0; i < gameACTOR.size(); i++) {
                    for (int j = 0; j < gameACTOR.get(i).getAcCHs().size(); j++) {
                        mySql.getPrepStatement().setInt(1,gameACTOR.get(i).getAcID());
                        mySql.getPrepStatement().setString(2,gameACTOR.get(i).getAcFN());
                        mySql.getPrepStatement().setString(3,gameACTOR.get(i).getAcLN());
                        String actorDOBstring =
                                gameACTOR.get(i).getAcBDAY().getDay() + "/" +
                                gameACTOR.get(i).getAcBDAY().getMonth() + "/" + gameACTOR.get(i).getAcBDAY().getYear();
                        mySql.getPrepStatement().setString(4,actorDOBstring);
                        mySql.getPrepStatement().setString(5,gameACTOR.get(i).getAcPFP());
                        mySql.getPrepStatement().setInt(6,gameACTOR.get(i).getAcCHs().get(j));
                        mySql.getPrepStatement().setInt(7,gameID);
                        mySql.getPrepStatement().addBatch();
                    }
                    mySql.getPrepStatement().executeBatch();
                }
                mySql.getConnection().commit();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    private void handleINSERTCharacters(int gameID, List<CharacterDTO> gameCHAR) {
        if (!gameCHAR.isEmpty()) {
            String queryCHAR =
                "INSERT INTO CharacterList (charID, charNAME, charPFP, charGameID) " +
                "VALUES (?, ?, ?, ?)";
            try {
                mySql.getConnection().setAutoCommit(false);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryCHAR));
                for (int i = 0; i < gameCHAR.size(); i++) {
                    mySql.getPrepStatement().setInt(1,gameCHAR.get(i).getChID());
                    mySql.getPrepStatement().setString(2,gameCHAR.get(i).getChNAME());
                    mySql.getPrepStatement().setString(3,gameCHAR.get(i).getChPFP());
                    mySql.getPrepStatement().setInt(4,gameID);
                    mySql.getPrepStatement().addBatch();
                }
                mySql.getPrepStatement().executeBatch();
                mySql.getConnection().commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public GameDTO getGame(int gameID) {
        String queryGAME            = "SELECT * FROM Game           WHERE gameID            = ?";
        String queryPIC             = "SELECT * FROM PictureList    WHERE pictureGameID     = ?";
        String queryPLAT            = "SELECT * FROM PlatformList   WHERE platGameID        = ?";
        String queryTRAILER         = "SELECT * FROM TrailerList    WHERE trailerGameID     = ?";
        String queryGM              = "SELECT * FROM GameModeList   WHERE gmGameID          = ?";
        String queryGENRE           = "SELECT * FROM GenreList      WHERE genreGameID       = ?";
        String queryCHAR            = "SELECT * FROM CharacterList  WHERE charGameID        = ?";
        String queryACTOR           = "SELECT actorID, ANY_VALUE(actorFN), ANY_VALUE(actorLN), ANY_VALUE(actorDOB), ANY_VALUE(actorPFP), ANY_VALUE(actorCharID), actorGameID FROM ActorList      WHERE actorGameID       = ?     GROUP BY actorID";
        String queryCOMP            = "SELECT * FROM ComposerList   WHERE compGameID        = ?";
        String queryOST             = "SELECT * FROM SoundtrackList WHERE ostGameID         = ?";
        String queryWRI             = "SELECT * FROM WriterList     WHERE writerGameID      = ?";
        String queryPUB             = "SELECT * FROM PublisherList  WHERE pubGameID         = ?";
        String queryDEV             = "SELECT * FROM DeveloperList  WHERE devGameID         = ?";
        GameDTO game = new GameDTO();
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryGAME));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs1 = mySql.getPrepStatement().executeQuery();
            while (rs1.next()){
                game.setGameCover(rs1.getString("gameCOVER"));
                game.setGameNAME(rs1.getString("gameTITLE"));
                game.setGameBIO(rs1.getString("gameDESC"));
                String gameRDstring = rs1.getString("gameRD");
                String [] stringSplit = gameRDstring.split("/");
                DateDTO date = new DateDTO(stringSplit[0],stringSplit[1],stringSplit[2]);
                game.setGameRELEASEDATE(date);
                game.setGameBG(rs1.getString("gameBACKGROUND"));
                game.setGameID(rs1.getInt("gameID"));
            }

            List<PictureDTO> picList = new ArrayList<>();
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryPIC));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs2 = mySql.getPrepStatement().executeQuery();
            while (rs2.next()){
                PictureDTO pic = new PictureDTO();
                pic.setPicURL(rs2.getString("pictureURL"));
                pic.setPicID(rs2.getInt("pictureID"));
                pic.setPicGameID(rs2.getInt("pictureGameID"));
                picList.add(pic);
            }
            game.setGamePICs(picList);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryPLAT));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs3 = mySql.getPrepStatement().executeQuery();
            List <PlatformDTO> platformList = new ArrayList<>();
            while (rs3.next()){
                PlatformDTO plat = new PlatformDTO();
                plat.setPlatID(rs3.getInt("platID"));
                plat.setPlatTITLE(rs3.getString("platTITLE"));
                    String platCreatedstring = rs3.getString("platCREATED");
                    String[] platStringSplit = platCreatedstring.split("/");
                    DateDTO date = new DateDTO(platStringSplit[0], platStringSplit[1], platStringSplit[2]);
                plat.setPlatCREATED(date);
                plat.setPlatGAMEs(rs3.getInt("platGameID"));
                platformList.add(plat);
            }
            game.setGamePLAT(platformList);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryTRAILER));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs4 = mySql.getPrepStatement().executeQuery();
            List<TrailerDTO> trailerList = new ArrayList<>();
            while (rs4.next()){
                TrailerDTO trailer = new TrailerDTO();
                trailer.setTrailerID(rs4.getInt("trailerID"));
                trailer.setTrailerGameID(rs4.getInt("trailerGameID"));
                trailer.setTrailerURL(rs4.getString("trailerURL"));
                trailerList.add(trailer);
            }
            game.setGameTRAILERs(trailerList);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryGM));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs5 = mySql.getPrepStatement().executeQuery();
            List<GameModeDTO> gmList = new ArrayList<>();
            while (rs5.next()){
                GameModeDTO gm = new GameModeDTO();
                gm.setGmID(rs5.getInt("gmID"));
                gm.setGmTITLE(rs5.getString("gmTITLE"));
                gm.setGmGAME(rs5.getInt("gmGameID"));
                gmList.add(gm);
            }
            game.setGameGMs(gmList);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryGENRE));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs6 = mySql.getPrepStatement().executeQuery();
            List<GenreDTO> genreList = new ArrayList<>();
            while (rs6.next()){
                GenreDTO genre = new GenreDTO();
                genre.setGenID(rs6.getInt("genreID"));
                genre.setGenTITLE(rs6.getString("genreTITLE"));
                genre.setGenGAME(rs6.getInt("genreGameID"));
                genreList.add(genre);
            }
            game.setGameGENREs(genreList);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryCHAR));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs7 = mySql.getPrepStatement().executeQuery();
            List<CharacterDTO> charList = new ArrayList<>();
            while (rs7.next()){
                CharacterDTO ch = new CharacterDTO();
                ch.setChID(rs7.getInt("charID"));
                ch.setChNAME(rs7.getString("charNAME"));
                ch.setChPFP(rs7.getString("charPFP"));
                ch.setChGAME(rs7.getInt("charGameID"));
                charList.add(ch);
            }
            game.setGameCHs(charList);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryACTOR));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs8 = mySql.getPrepStatement().executeQuery();
            List<ActorDTO> actList = new ArrayList<>();
            String actCharList = "SELECT * FROM CharacterList WHERE charID = ? AND charGameID = ?";
            String actCharList1 = "" +
                    "SELECT ANY_VALUE(actorID), ANY_VALUE(actorFN), ANY_VALUE(actorLN), ANY_VALUE(actorDOB), ANY_VALUE(actorPFP), actorCharID, actorGameID " +
                    "FROM ActorList " +
                    "WHERE actorGameID = ? " +
                    "GROUP BY actorCharID";
            while (rs8.next()){
                ActorDTO act = new ActorDTO();
                act.setAcID(rs8.getInt("actorID"));
                act.setAcFN(rs8.getString("ANY_VALUE(actorFN)"));
                act.setAcLN(rs8.getString("ANY_VALUE(actorLN)"));
                act.setAcPFP(rs8.getString("ANY_VALUE(actorPFP)"));
                act.setAcGAME(rs8.getInt("actorGameID"));
                    String actDOB           = rs8.getString("ANY_VALUE(actorDOB)");
                    String[] actDOBsplit    = actDOB.split("/");
                    DateDTO actDate         = new DateDTO(actDOBsplit[0],actDOBsplit[1],actDOBsplit[2]);
                act.setAcBDAY(actDate);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(actCharList1));
                mySql.getPrepStatement().setInt(1,gameID);
                ResultSet rs0 = mySql.getPrepStatement().executeQuery();
                List<Integer> actCharLIST = new ArrayList<>();
                while (rs0.next()){
                    mySql.setPrepStatment(mySql.getConnection().prepareStatement(actCharList));
                    mySql.getPrepStatement().setInt(1,rs0.getInt("actorCharID"));
                    mySql.getPrepStatement().setInt(2,gameID);
                    ResultSet rs9 = mySql.getPrepStatement().executeQuery();
                    while (rs9.next()){
                        actCharLIST.add(rs9.getInt("charID"));
                    }
                    act.setAcCHs(actCharLIST);
                }
                actList.add(act);
            }
            game.setGameACs(actList);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryCOMP));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs10 = mySql.getPrepStatement().executeQuery();
            ComposerDTO comp = new ComposerDTO();
            String compOstList = "SELECT * FROM SoundtrackList WHERE ostComposerID = ?";
            while (rs10.next()){
                comp.setCompID(rs10.getInt("compID"));
                comp.setCompFN(rs10.getString("compFN"));
                comp.setCompLN(rs10.getString("compLN"));
                comp.setCompGAME(rs10.getInt("compGameID"));
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(compOstList));
                mySql.getPrepStatement().setInt(1,rs10.getInt("compID"));
                ResultSet rs11 = mySql.getPrepStatement().executeQuery();
                List<Integer> ostCompLIST = new ArrayList<>();
                while (rs11.next()){
                    ostCompLIST.add(rs11.getInt("ostID"));
                }
                comp.setCompOSTs(ostCompLIST);
            }
            game.setGameCOMP(comp);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryOST));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs12 = mySql.getPrepStatement().executeQuery();
            SoundtrackDTO ost = new SoundtrackDTO();
            String ostMa   = "SELECT * FROM MusicalArtistList WHERE artistID = ?";
            while (rs12.next()){
                ost.setOstID(rs12.getInt("ostID"));
                ost.setOstTITLE(rs12.getString("ostTITLE"));
                ost.setOstPFP(rs12.getString("ostPFP"));
                ost.setOstGAME(rs12.getInt("ostGameID"));
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(ostMa));
                mySql.getPrepStatement().setInt(1,rs12.getInt("ostArtistID"));
                ResultSet rs13 = mySql.getPrepStatement().executeQuery();
                List<MusicArtistDTO> maList = new ArrayList<>();
                while (rs13.next()){
                    MusicArtistDTO ma = new MusicArtistDTO();
                    ma.setArtID(rs13.getInt("artistID"));
                    ma.setArtNAME(rs13.getString("artistNAME"));
                    ma.setArtPFP(rs13.getString("artistPFP"));
                    maList.add(ma);
                }
                ost.setOstMA(maList);
                ost.setOstCOMP(comp);
            }
            game.setGameOST(ost);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryWRI));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs15 = mySql.getPrepStatement().executeQuery();
            List<WriterDTO> writerList = new ArrayList<>();
            while (rs15.next()){
                WriterDTO writer = new WriterDTO();
                writer.setWriterID(rs15.getInt("writerID"));
                writer.setWriterFN(rs15.getString("writerFN"));
                writer.setWriterLN(rs15.getString("writerLN"));
                writer.setWriterGAME(rs15.getInt("writerGameID"));
                writerList.add(writer);
            }
            game.setGameWRI(writerList);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryPUB));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs16 = mySql.getPrepStatement().executeQuery();
            PublisherDTO pub = new PublisherDTO();
            while (rs16.next()){
                pub.setPubID(rs16.getInt("pubID"));
                pub.setPubNAME(rs16.getString("pubNAME"));
                pub.setPubCOUNTRY(rs16.getString("pubCOUNTRY"));
                    String pubDate      = rs16.getString("pubCREATED");
                    String[] pubDATE    = pubDate.split("/");
                    DateDTO pubDaTe     = new DateDTO(pubDATE[0],pubDATE[1],pubDATE[2]);
                pub.setPubCREATED(pubDaTe);
                pub.setPubSTATUS(rs16.getBoolean("pubSTATUS"));
                pub.setPubGAME(rs16.getInt("pubGameID"));
            }
            game.setGamePUB(pub);

            mySql.setPrepStatment(mySql.getConnection().prepareStatement(queryDEV));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs17 = mySql.getPrepStatement().executeQuery();
            DeveloperDTO dev = new DeveloperDTO();
            String devPcompanyQuery = "SELECT * FROM ParentCompany WHERE parentID = ?";
            while (rs17.next()){
                dev.setDevID(rs17.getInt("devID"));
                dev.setDevNAME(rs17.getString("devNAME"));
                dev.setDevCOUNTRY(rs17.getString("devCOUNTRY"));
                dev.setDevGAME(rs17.getInt("devGameID"));
                    String devDate          = rs17.getString("devCREATED");
                    String[] devDateSplit   = devDate.split("/");
                    DateDTO devDATE = new DateDTO(devDateSplit[0],devDateSplit[1],devDateSplit[2]);
                dev.setDevCREATED(devDATE);
                mySql.setPrepStatment(mySql.getConnection().prepareStatement(devPcompanyQuery));
                mySql.getPrepStatement().setInt(1,rs17.getInt("devParentID"));
                ResultSet rs18 = mySql.getPrepStatement().executeQuery();
                ParentCompanyDTO parent = new ParentCompanyDTO();
                while (rs18.next()){
                    parent.setParentID(rs18.getInt("parentID"));
                    parent.setParentNAME(rs18.getString("parentNAME"));
                    parent.setParentCOUNTRY(rs18.getString("parentCOUNTRY"));
                    parent.setParentSTATUS(rs18.getBoolean("parentSTATUS"));
                        String parentDate           = rs18.getString("parentCREATED");
                        String[] parentDateSplit    = parentDate.split("/");
                        DateDTO parentDATE          = new DateDTO(parentDateSplit[0],parentDateSplit[1],parentDateSplit[2]);
                    parent.setParentCREATED(parentDATE);
                }
                dev.setDevPCOMPANY(parent);
            }
            game.setGameDEV(dev);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return game;
    }

    @Override
    public List<GameDTO> getGameList() {
        return null;
    }

    @Override
    public ArrayList<String> getGameNames(String characters){
        String query = "SELECT gameTITLE FROM Game WHERE gameTITLE LIKE ? LIMIT 10";
        ArrayList<String> list = new ArrayList<>();
        try {
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setString(1,characters);
            ResultSet resultset = mySql.getPrepStatement().executeQuery();
            while (resultset.next()){
                list.add(resultset.getString("gameTITLE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean updateGame(int gameID, GameDTO updatedGame) {
        String query = "UPDATE Game SET gameTITLE = ?, gameRD = ?, gameDESC = ?, gameCOVER = ?, gameBACKGROUND = ? WHERE gameID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            PreparedStatement prepStatement = mySql.getPrepStatement();
            prepStatement.setString(1,updatedGame.getGameNAME());
            prepStatement.setString(2,updatedGame.getGameRELEASEDATE().getDateString());
            prepStatement.setString(3,updatedGame.getGameBIO());
            prepStatement.setString(4,updatedGame.getGameCover());
            prepStatement.setString(5,updatedGame.getGameBG());
            prepStatement.setInt(6,gameID);
            prepStatement.executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGameGenre(int gameID, int oldGenreID, int updatedGenreID) {
        String query = "UPDATE GenreList SET genreID = ? WHERE genreID = ? AND genreGameID = ?";
        return handleStaticTablesDuplicateCode(gameID, oldGenreID, updatedGenreID, query);
    }

    @Override
    public boolean updateGameGM(int gameID, int oldGMID, int updatedGMID) {
        String query = "UPDATE GameModeList SET gmID = ? WHERE gmID = ? AND gmGameID = ?";
        return handleStaticTablesDuplicateCode(gameID, oldGMID, updatedGMID, query);
    }

    @Override
    public boolean updateGamePlatform(int gameID, int oldPlatformID, int updatedPlatformID) {
        String query = "UPDATE PlatformList SET platID = ? WHERE platID = ? AND gameID = ?";
        return handleStaticTablesDuplicateCode(gameID, oldPlatformID, updatedPlatformID, query);
    }

    private boolean handleStaticTablesDuplicateCode(int gameID, int oldPlatformID, int updatedPlatformID, String query) {
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            PreparedStatement prepStatement = mySql.getPrepStatement();
            prepStatement.setInt(1,updatedPlatformID);
            prepStatement.setInt(2,oldPlatformID);
            prepStatement.setInt(3,gameID);
            prepStatement.executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGamePicture(int gameID, int oldPicID, PictureDTO updatedPicture) {
        String query = "UPDATE PictureList SET pictureURL = ? WHERE pictureID = ? AND pictureGameID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            PreparedStatement prepStatement = mySql.getPrepStatement();
            prepStatement.setString(1,updatedPicture.getPicURL());
            prepStatement.setInt(2,oldPicID);
            prepStatement.setInt(2,gameID);
            prepStatement.executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updatedGameTrailer(int gameID, int oldTrailerID, TrailerDTO updatedTrailer) {
        String query = "UPDATE TrailerList SET trailerURL = ? WHERE trailerID = ? AND trailerGameID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            PreparedStatement prepStatement = mySql.getPrepStatement();
            prepStatement.setString(1,updatedTrailer.getTrailerURL());
            prepStatement.setInt(2,oldTrailerID);
            prepStatement.setInt(3,gameID);
            prepStatement.executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGamePublisher(int gameID, int oldPublisherID, PublisherDTO updatedPublisher) {
        String query = "UPDATE PublisherList SET pubNAME = ?, pubCREATED = ?, pubCOUNTRY = ?, pubSTATUS = ? WHERE pubID = ? AND pubGameID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            PreparedStatement prepStatement = mySql.getPrepStatement();
            prepStatement.setString(1,updatedPublisher.getPubNAME());
            prepStatement.setString(2,updatedPublisher.getPubCREATED().getDateString());
            prepStatement.setString(3,updatedPublisher.getPubCOUNTRY());
            prepStatement.setBoolean(4,updatedPublisher.isPubSTATUS());
            prepStatement.setInt(5,oldPublisherID);
            prepStatement.setInt(6,gameID);
            prepStatement.executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGameDeveloper(int gameID, int oldDeveloperID, int oldPCompanyID, DeveloperDTO updatedDeveloper) {
        String query1 = "UPDATE DeveloperList SET devNAME = ?, devCREATED = ?, devCOUNTRY = ?, devSTATUS = ?, devParentID = ? WHERE devID = ? AND devGameID = ?";
        String query2 = "UPDATE ParentCompany SET parentNAME = ?, parentCREATED = ?, parentCOUNTRY = ?, parentSTATUS = ? WHERE parentID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query1));
            PreparedStatement prepStatement1 = mySql.getPrepStatement();
            prepStatement1.setString(1,updatedDeveloper.getDevNAME());
            prepStatement1.setString(2,updatedDeveloper.getDevCREATED().getDateString());
            prepStatement1.setString(3,updatedDeveloper.getDevCOUNTRY());
            prepStatement1.setBoolean(4,updatedDeveloper.isDevSTATUS());
            prepStatement1.setInt(5,updatedDeveloper.getDevPCOMPANY().getParentID());
            prepStatement1.setInt(6,oldDeveloperID);
            prepStatement1.setInt(7,gameID);
            prepStatement1.executeUpdate();
            mySql.getConnection().commit();

            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query2));
            PreparedStatement prepStatement2 = mySql.getPrepStatement();
            prepStatement2.setString(1,updatedDeveloper.getDevPCOMPANY().getParentNAME());
            prepStatement2.setString(2,updatedDeveloper.getDevPCOMPANY().getParentCREATED().getDateString());
            prepStatement2.setString(3,updatedDeveloper.getDevPCOMPANY().getParentCOUNTRY());
            prepStatement2.setBoolean(4,updatedDeveloper.getDevPCOMPANY().isParentSTATUS());
            prepStatement2.setInt(5,oldPCompanyID);
            prepStatement2.executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGameWriter(int gameID, int oldWriterID, WriterDTO updatedWriter) {
        String query = "UPDATE WriterList SET writerFN = ?, writerLN = ? WHERE writerID = ? AND writerGameID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            PreparedStatement prepStatement = mySql.getPrepStatement();
            prepStatement.setString(1,updatedWriter.getWriterFN());
            prepStatement.setString(2,updatedWriter.getWriterLN());
            prepStatement.setInt(3,oldWriterID);
            prepStatement.setInt(4,gameID);
            prepStatement.executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGameCharacter(int gameID, int oldCharID, CharacterDTO updatedCharacter) {
        String query = "UPDATE CharacterList SET charNAME = ?, charPFP = ? WHERE charID = ? AND charGameID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            PreparedStatement prepStatement = mySql.getPrepStatement();
            prepStatement.setString(1,updatedCharacter.getChNAME());
            prepStatement.setString(2,updatedCharacter.getChPFP());
            prepStatement.setInt(3,oldCharID);
            prepStatement.setInt(4,gameID);
            prepStatement.executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGameActor(int gameID, int oldActorID, ActorDTO updatedActor) {
        String query = "UPDATE ActorList SET actorFN = ?, actorLN = ?, actorDOB = ?, actorPFP = ? WHERE actorID = ? AND actorGameID = ? AND actorCharID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            PreparedStatement prepStatement = mySql.getPrepStatement();
            for (int i = 0; i < updatedActor.getAcCHs().size(); i++) {
                prepStatement.setString(1,updatedActor.getAcFN());
                prepStatement.setString(2,updatedActor.getAcLN());
                prepStatement.setString(3,updatedActor.getAcBDAY().getDateString());
                prepStatement.setString(4,updatedActor.getAcPFP());
                prepStatement.setInt(5,oldActorID);
                prepStatement.setInt(6,gameID);
                prepStatement.setInt(7,updatedActor.getAcCHs().get(i));
                prepStatement.addBatch();
            }
            prepStatement.executeBatch();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGameOST(int gameID, int oldOstID, int oldComposerID, int oldArtistID, SoundtrackDTO updatedOST) {
        String query1 = "UPDATE ComposerList SET compFN = ?, compLN = ? WHERE compID = ? AND compGameID = ?";
        String query2 = "UPDATE MusicalArtistList SET artistNAME = ?, artistPFP WHERE artistID = ?";
        String query3 = "UPDATE SoundtrackList SET ostTITLE = ?, ostPFP = ? WHERE ostID = ? AND ostGameID = ? AND ostComposerID = ? and ostArtistID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query1));
            PreparedStatement prepStatement1 = mySql.getPrepStatement();
            prepStatement1.setString(1,updatedOST.getOstCOMP().getCompFN());
            prepStatement1.setString(2,updatedOST.getOstCOMP().getCompLN());
            prepStatement1.setInt(3,oldComposerID);
            prepStatement1.setInt(4,gameID);
            prepStatement1.executeUpdate();
            mySql.getConnection().commit();

            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query2));
            PreparedStatement prepStatement2 = mySql.getPrepStatement();
            for (int i = 0; i < updatedOST.getOstMA().size(); i++) {
                prepStatement2.setString(1,updatedOST.getOstMA().get(i).getArtNAME());
                prepStatement2.setString(2,updatedOST.getOstMA().get(i).getArtPFP());
                prepStatement2.setInt(3,oldArtistID);
                prepStatement2.addBatch();
            }
            prepStatement2.executeBatch();
            mySql.getConnection().commit();
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query3));
            PreparedStatement prepStatement3 = mySql.getPrepStatement();
            prepStatement3.setString(1,updatedOST.getOstTITLE());
            prepStatement3.setString(2,updatedOST.getOstPFP());
            prepStatement3.setInt(3,oldOstID);
            prepStatement3.setInt(4,gameID);
            prepStatement3.setInt(5,oldComposerID);
            prepStatement3.setInt(6,oldArtistID);
            prepStatement3.executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateGameComposer(int gameID, int oldCompID, ComposerDTO updatedComposer) {
        String query = "UPDATE ComposerList SET compFN = ?, compLN = ? WHERE compID = ? AND compGameID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            PreparedStatement prepStatement = mySql.getPrepStatement();
            prepStatement.setString(1,updatedComposer.getCompFN());
            prepStatement.setString(2,updatedComposer.getCompLN());
            prepStatement.setInt(3,oldCompID);
            prepStatement.setInt(4,gameID);
            prepStatement.executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteGame (int gameID) {
        String query1 = "DELETE From Game WHERE gameID = ?";
        String query2 = "DELETE FROM TrailerList WHERE trailerGameID = ?";
        String query3 = "DELETE FROM ";






        return true;
    }

    private boolean handleDeleteGame(String gameTITLE, String query) {
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setString(1,gameTITLE);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}

