package Data.GameDAL;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.MusicArtistDTO;
import Data.GameDTO.Development.WriterDTO;
import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.*;
import Data.IMysqlConnection;

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
        String      gameRDstring    = gameRD.getDay() + "/" + gameRD.getMonth() + "/" + gameRD.getYaer();

        List<ActorDTO>      gameACTOR   = game.getGameACs();        List<CharacterDTO>  gameCHAR    = game.getGameCHs();
        List<GenreDTO>      gameGENRE   = game.getGameGENREs();     List<GameModeDTO>   gameGM      = game.getGameGMs();
        List<PictureDTO>    gamePIC     = game.getGamePICs();       List<TrailerDTO>    gameTRAILER = game.getGameTRAILERs();
        DeveloperDTO        gameDEV     = game.getGameDEV();        PublisherDTO        gamePUB     = game.getGamePUB();
        WriterDTO           gameWRI     = game.getGameWRI();
        ComposerDTO         gameCOMP    = game.getGameCOMP();       SoundtrackDTO       gameOST     = game.getGameOST();

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
        handleINSERTComposer                    (gameID, gameCOMP);
        handleINSERTSoundtrackxMusicalArtists   (gameID, gameOST);
        return true;
    }

    private boolean handleINSERTSoundtrackxMusicalArtists(int gameID, SoundtrackDTO gameOST) {
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
                return false;
            }
        }
        return true;
    }
    private boolean handleINSERTComposer(int gameID, ComposerDTO gameCOMP) {
        if (gameCOMP != null){
            String queryCOMP =
                "INSERT INTO ComposerList (compID, compFN, compLN, compGameID) " +
                "VALUES (?, ?, ?, ?)";
            int             compID              = gameCOMP.getCompID();
            String          compFN              = gameCOMP.getCompFN();
            String          compLN              = gameCOMP.getCompLN();
            return (handleINSERT_fn_ln_gameid(gameID, queryCOMP, compID, compFN, compLN));
        }
        return false;
    }
    private boolean handleINSERTWriter(int gameID, WriterDTO gameWRI) {
        if (gameWRI != null) {
            String queryWRI =
                "INSERT INTO WriterList (writerID, writerFN, writerLN, writerGameID) " +
                "VALUES (?, ?, ?, ?)";
            int                 writerID            = gameWRI.getWriterID();
            String              writerFN            = gameWRI.getWriterFN();
            String              writerLN            = gameWRI.getWriterLN();
            return handleINSERT_fn_ln_gameid(gameID, queryWRI, writerID, writerFN, writerLN);
        }
        return false;
    }
    private boolean handleINSERT_fn_ln_gameid(int gameID, String query, int ID, String FN, String LN) {
        try {
            handleINSERTDuplicateCode2(query, ID, FN, LN);
            mySql.getPrepStatement().setInt(4,gameID);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
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
                String      pubCREATEDstring    = pubCREATED.getDay() + "/" + pubCREATED.getMonth() + "/" +pubCREATED.getYaer();
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
    private boolean handleINSERTDeveloperXParentCompany(int gameID, DeveloperDTO gameDEV) {
        if (gameDEV != null) {
            String queryParent =
                "INSERT INTO ParentCompany (parentID, parentNAME, parentCREATED, parentCOUNTRY, parentSTATUS) " +
                "VALUES (?, ?, ?, ?, ?)";
            int         parentID                    = gameDEV.getDevPCOMPANY().getParentID();
            String      parentNAME                  = gameDEV.getDevPCOMPANY().getParentNAME();
            DateDTO parentCREATED               = gameDEV.getDevPCOMPANY().getParentCREATED();
                String  parentCREATEDstring         = parentCREATED.getDay() + "/" + parentCREATED.getMonth() + "/" + parentCREATED.getYaer();
            String      parentCOUNTRY               = gameDEV.getDevPCOMPANY().getParentCOUNTRY();
            boolean     parentSTATUS                = gameDEV.getDevPCOMPANY().isParentSTATUS();

            String queryDEV =
                "INSERT INTO DeveloperList (devID, devNAME, devCREATED, devCOUNTRY, devSTATUS, devParentID, devGameID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
            int         devID               = gameDEV.getDevID();
            String      devNAME             = gameDEV.getDevNAME();
            DateDTO     devCREATED          = gameDEV.getDevCREATED();
                String  devCREATEDstring    = devCREATED.getDay() + "/" + devCREATED.getMonth() + "/" + devCREATED.getYaer();
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
                return false;
            }
        }
        return true;
    }
    private void handleINSERTCompanyDuplicateCode1(String query, int companyID, String companyNAME, String companyCREATED, String companyCOUNTRY, boolean companySTATUS) throws SQLException {
        handleINSERTDuplicateCode(query, companyID, companyNAME, companyCREATED, companyCOUNTRY);
        mySql.getPrepStatement().setBoolean(5, companySTATUS);
    }
    private void handleINSERTDuplicateCode(String query, int ID, String NAME, String CREATED, String COUNTRY_or_DESC) throws SQLException {
        handleINSERTDuplicateCode2(query, ID, NAME, CREATED);
        mySql.getPrepStatement().setString(4, COUNTRY_or_DESC);
    }
    private boolean handleINSERTTrailers(int gameID, List<TrailerDTO> gameTRAILER) {
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
                return false;
            }
        }
        return true;
    }
    private boolean handleINSERTPictures(int gameID, List<PictureDTO> gamePIC) {
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
                return false;
            }
        }
        return true;
    }
    private boolean handleINSERTGameModes(int gameID, List<GameModeDTO> gameGM) {
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
                return false;
            }
        }
        return true;
    }
    private boolean handleINSERTGenres(int gameID, List<GenreDTO> gameGENRE) {
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
                return false;
            }
        }
        return true;
    }
    private boolean handleINSERTGame(String query1, int gameID, String gameTitle, String gameDESC, String gameReleaseString, String gameCOV, String gameBG) {
        try {
            handleINSERTDuplicateCode(query1, gameID, gameTitle, gameReleaseString, gameDESC);
            mySql.getPrepStatement().setString(5,gameCOV);
            mySql.getPrepStatement().setString(6,gameBG);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    //FIXME måske kan opstå en fejl ved indsætning af flere spil til denne actor, ikke helt sikker (TEST SENERE)
    private boolean handleINSERTActors(int gameID, List<ActorDTO> gameACTOR, List<CharacterDTO> gameCHAR) {
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
                                gameACTOR.get(i).getAcBDAY().getMonth() + "/" + gameACTOR.get(i).getAcBDAY().getYaer();
                        mySql.getPrepStatement().setString(4,actorDOBstring);
                        mySql.getPrepStatement().setString(5,gameCHAR.get(i).getChPFP());
                        mySql.getPrepStatement().setInt(6,gameACTOR.get(i).getAcCHs().get(j));
                        mySql.getPrepStatement().setInt(7,gameID);
                        mySql.getPrepStatement().addBatch();
                    }
                    mySql.getPrepStatement().executeBatch();
                }
                mySql.getConnection().commit();

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }
    private boolean handleINSERTCharacters(int gameID, List<CharacterDTO> gameCHAR) {
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
                return false;
            }
        }
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
    public boolean updateGame(GameDTO newGame) {
        return false;
    }

    @Override
    public boolean deleteGame(int gameID) {
        return false;
    }
}
