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
        String query1 = "INSERT INTO Game (gameID, gameTITLE, gameRD, gameDESC, gameCOVER, gameBACKGROUND) VALUES (?, ?, ?, ?, ?, ?)";
        int gameID = game.getGameID();                          String gameTitle = game.getGameNAME();
        String gameDESC = game.getGameBIO();                    DateDTO gameRD = game.getGameRELEASEDATE();
        String gameReleaseString = gameRD.getDay() + "/" + gameRD.getMonth() + "/" + gameRD.getYaer();
        String gameCOV = game.getGameCover();                   String gameBG = game.getGameBG();

        List<ActorDTO> gameACTOR = game.getGameACs();            List<CharacterDTO> gameCHAR = game.getGameCHs();
        List<GenreDTO> gameGENRE = game.getGameGENREs();         List<GameModeDTO> gameGM = game.getGameGMs();
        List<PictureDTO> gamePIC = game.getGamePICs();           List<RatingDTO> gameRATING = game.getGameRATINGs();
        List<TrailerDTO> gameTRAILER = game.getGameTRAILERs();
        DeveloperDTO gameDEV = game.getGameDEV();                PublisherDTO gamePUB = game.getGamePUB();
        WriterDTO gameWTI = game.getGameWRI();
        ComposerDTO gameCOMP = game.getGameCOMP();               SoundtrackDTO gameOST = game.getGameOST();

        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query1));
            mySql.getPrepStatement().setInt(1,gameID);
            mySql.getPrepStatement().setString(2,gameTitle);
            mySql.getPrepStatement().setString(3,gameReleaseString);
            mySql.getPrepStatement().setString(4,gameDESC);
            mySql.getPrepStatement().setString(5,gameCOV);
            mySql.getPrepStatement().setString(6,gameBG);
        } catch (SQLException e) {
            e.printStackTrace();
            boolean gameInsert = false;
            return gameInsert;
        }
        handleINSERTCharacters(gameID, gameCHAR);
        handleINSERTActors(gameID, gameACTOR, gameCHAR);

        return true;
    }

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
