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

import java.sql.SQLException;
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

        List<ActorDTO>      gameACTOR = game.getGameACs();              List<CharacterDTO>  gameCHAR = game.getGameCHs();
        List<GenreDTO>      gameGENRE = game.getGameGENREs();           List<GameModeDTO>   gameGM = game.getGameGMs();
        List<PictureDTO>    gamePIC = game.getGamePICs();               List<RatingDTO>     gameRATING = game.getGameRATINGs();
        List<TrailerDTO>    gameTRAILER = game.getGameTRAILERs();
        DeveloperDTO        gameDEV = game.getGameDEV();                PublisherDTO        gamePUB = game.getGamePUB();
        WriterDTO           gameWTI = game.getGameWRI();
        ComposerDTO         gameCOMP = game.getGameCOMP();              SoundtrackDTO       gameOST = game.getGameOST();

        handleINSERTGame                        (query, gameID, gameTitle, gameDESC, gameRDstring, gameCOV, gameBG);
        handleINSERTCharacters                  (gameID, gameCHAR);
        handleINSERTActors                      (gameID, gameACTOR, gameCHAR);
        handleINSERTGenres                      (gameID, gameGENRE);
        handleINSERTGameModes                   (gameID, gameGM);
        handleINSERTPictures                    (gameID, gamePIC);
        handleINSERTTrailers                    (gameID, gameTRAILER);
        handleINSERTDeveloperXParentCompany     (gameID, gameDEV);

        return true;
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
                "INSERT INTO DeveloperList (devID, devNAME, devCREATED, devCOUNTRY, devSTATUS, decParentID, devGameID) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?)";
            int         devID               = gameDEV.getDevID();
            String      devNAME             = gameDEV.getDevNAME();
            DateDTO     devCREATED          = gameDEV.getDevCREATED();
                String  devCREATEDstring    = devCREATED.getDay() + "/" + devCREATED.getMonth() + "/" + devCREATED.getYaer();
            String      devCOUNTRY          = gameDEV.getDevCOUNTRY();
            boolean     devSTATUS           = gameDEV.isDevSTATUS();
            try {
                handleINSERTCompanyDuplicateCode(queryParent, parentID, parentNAME, parentCREATEDstring, parentCOUNTRY, parentSTATUS);
                mySql.getPrepStatement().executeUpdate();
                mySql.getConnection().commit();

                handleINSERTCompanyDuplicateCode(queryDEV, devID, devNAME, devCREATEDstring, devCOUNTRY, devSTATUS);
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

    private void handleINSERTCompanyDuplicateCode(String query, int companyID, String companyNAME, String companyCREATED, String companyCOUNTRY, boolean companySTATUS) throws SQLException {
        handleINSERTDuplicateCode(query, companyID, companyNAME, companyCREATED, companyCOUNTRY);
        mySql.getPrepStatement().setBoolean(5, companySTATUS);
    }

    private void handleINSERTDuplicateCode(String query, int ID, String NAME, String CREATED, String COUNTRY_or_DESC) throws SQLException {
        mySql.getConnection().setAutoCommit(false);
        mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
        mySql.getPrepStatement().setInt(1, ID);
        mySql.getPrepStatement().setString(2, NAME);
        mySql.getPrepStatement().setString(3, CREATED);
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
                        mySql.getPrepStatement().setInt(5,gameACTOR.get(i).getAcCHs().get(j));
                        mySql.getPrepStatement().setInt(6,gameID);
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
    public boolean updateGame(GameDTO newGame) {
        return false;
    }

    @Override
    public boolean deleteGame(int gameID) {
        return false;
    }
}
