import Data.GameDAL.GameDAO;
import Data.GameDAL.IGameDAO;
import Data.GameDTO.GameDTO;
import Data.IMysqlConnection;

import java.util.ArrayList;

public class GameService {

    IMysqlConnection mysqlConnection;

    public GameService(IMysqlConnection mysqlConnection) {
        this.mysqlConnection = mysqlConnection;

    }

    public ArrayList<String> getGameNames(String characters){
        IGameDAO gameDAO = new GameDAO(mysqlConnection);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(characters);
        stringBuilder.append("%");
        String search = stringBuilder.toString();
        ArrayList<String> gameNames = gameDAO.getGameNames(search);
        return gameNames;
    }

    public boolean createGame (GameDTO gameDTO){
        IGameDAO gameDAO = new GameDAO(mysqlConnection);
        testObject(gameDTO);
        boolean answer = gameDAO.createGame(gameDTO);
        return answer;
    }

    public void testObject (GameDTO gameDTO){
        System.out.println(" ");
        System.out.println("#### the game data received is the following ####");
        System.out.println("gameID: " + gameDTO.getGameID());
        System.out.println("gameNAME: " + gameDTO.getGameNAME());
        System.out.println("game releasedate is: " + gameDTO.getGameRELEASEDATE());
        System.out.println(" ");

        System.out.println("### MEDIA ###");
        System.out.println("cover: " + gameDTO.getGameCover());
        System.out.println("background: " + gameDTO.getGameBG());
        System.out.println("trailer 1: " + gameDTO.getGameTRAILERs().get(0).getTrailerURL());
        System.out.println("trailer 2: " + gameDTO.getGameTRAILERs().get(1).getTrailerURL());
        System.out.println("picture 1: " + gameDTO.getGamePICs().get(0).getPicURL());
        System.out.println("picture 2: " + gameDTO.getGamePICs().get(1).getPicURL());
        System.out.println(" ");

        System.out.println("### ART ###");
        System.out.println("game OST name: " + gameDTO.getGameOST().getOstTITLE());
        System.out.println("game OST URL: " + gameDTO.getGameOST().getOstURL());
        System.out.println("music artist 1 name: " + gameDTO.getGameOST().getOstMA().get(0).getArtNAME());
        System.out.println("music artist 1 url: " + gameDTO.getGameOST().getOstMA().get(0).getArtPFP());
        System.out.println("music artist 2 name: " + gameDTO.getGameOST().getOstMA().get(1).getArtNAME());
        System.out.println("music artist 1 url: " + gameDTO.getGameOST().getOstMA().get(1).getArtPFP());
        System.out.println("Composer: " + gameDTO.getGameCOMP().getCompFN());
        System.out.println("writer 1 name: " + gameDTO.getGameWRI().get(0).getWriterFN());
        System.out.println("writer 2 name: " + gameDTO.getGameWRI().get(1).getWriterFN());
        System.out.println(" ");

        System.out.println("### Company Details ###");
        System.out.println("parent name" + gameDTO.getGameDEV().getDevPCOMPANY().getParentNAME());
        System.out.println("parent country"+gameDTO.getGameDEV().getDevPCOMPANY().getParentCOUNTRY());
        System.out.println("parent creation"+gameDTO.getGameDEV().getDevPCOMPANY().getParentCREATED());
        System.out.println("parent status"+gameDTO.getGameDEV().getDevPCOMPANY().isParentSTATUS());
        System.out.println("parentid"+gameDTO.getGameDEV().getDevPCOMPANY().getParentID());
        System.out.println(" ");

        System.out.println("### Developer ###");
        System.out.println("Developer name: " + gameDTO.getGameDEV().getDevNAME());
        System.out.println("Developer creation: " + gameDTO.getGameDEV().getDevCREATED());
        System.out.println("Developer country: " + gameDTO.getGameDEV().getDevCOUNTRY());
        System.out.println("Developer status: " + gameDTO.getGameDEV().isDevSTATUS());
        System.out.println("Developer id: " + gameDTO.getGameDEV().getDevID());
        System.out.println("Developer gameID: " + gameDTO.getGameDEV().getDevGAME());
        System.out.println(" ");

        System.out.println("### Publisher Details ###");
        System.out.println("publisher name: " + gameDTO.getGamePUB().getPubNAME());
        System.out.println("publisher creation: " + gameDTO.getGamePUB().getPubCREATED());
        System.out.println("publisher country: " + gameDTO.getGamePUB().getPubCOUNTRY());
        System.out.println("publisher status: " + gameDTO.getGamePUB().isPubSTATUS());
        System.out.println("publisher id: " + gameDTO.getGamePUB().getPubID());
        System.out.println("publisher gameid: " + gameDTO.getGamePUB().getPubGAME());
        System.out.println(" ");
        //asdasdasd

        System.out.println("### Actors ###");
        System.out.println("actor 1 name: " + gameDTO.getGameACs().get(0).getAcFN());
        System.out.println("actor 1 url: " + gameDTO.getGameACs().get(0).getAcPFP());
        System.out.println("actor 1 birthday: " + gameDTO.getGameACs().get(0).getAcBDAY());
        System.out.println("actor 1 ID: " + gameDTO.getGameACs().get(0).getAcID());
        System.out.println("actor 1 gameID: " + gameDTO.getGameACs().get(0).getAcGAME());
        System.out.println("actor 2 name: " + gameDTO.getGameACs().get(1).getAcFN());
        System.out.println("actor 2 url: " + gameDTO.getGameACs().get(1).getAcPFP());
        System.out.println("actor 2 birthday: " + gameDTO.getGameACs().get(1).getAcBDAY());
        System.out.println("actor 2 ID: " + gameDTO.getGameACs().get(1).getAcID());
        System.out.println("actor 2 gameID: " + gameDTO.getGameACs().get(1).getAcGAME());
        System.out.println(" ");

        System.out.println("### Ingame Characters ###");
        System.out.println("character 1 name: " + gameDTO.getGameCHs().get(0).getChNAME());
        System.out.println("character 1 url: " + gameDTO.getGameCHs().get(0).getChPFP());
        System.out.println("character 1 ID: " + gameDTO.getGameCHs().get(0).getChID());
        System.out.println("character 1 gameID: " + gameDTO.getGameCHs().get(0).getChGAME());
        System.out.println("character 2 name: " + gameDTO.getGameCHs().get(1).getChNAME());
        System.out.println("character 2 url: " + gameDTO.getGameCHs().get(1).getChPFP());
        System.out.println("character 2 ID: " + gameDTO.getGameCHs().get(1).getChID());
        System.out.println("character 2 gameID: " + gameDTO.getGameCHs().get(1).getChGAME());
        System.out.println(" ");

        System.out.println("### Eligible Game Platforms ###");
        System.out.println("platform 1 title: " + gameDTO.getGamePLAT().get(0).getPlatTITLE());
        System.out.println("platform 1 created: " + gameDTO.getGamePLAT().get(0).getPlatCREATED());
        System.out.println("platform 1 ID: " + gameDTO.getGamePLAT().get(0).getPlatID());
        System.out.println("platform 1 game: " + gameDTO.getGamePLAT().get(0).getPlatGAME());
        System.out.println("platform 2 Title: " + gameDTO.getGamePLAT().get(1).getPlatTITLE());
        System.out.println("platform 2 created: " + gameDTO.getGamePLAT().get(1).getPlatCREATED());
        System.out.println("platform 2 ID: " + gameDTO.getGamePLAT().get(1).getPlatID());
        System.out.println("platform 2 game:" + gameDTO.getGamePLAT().get(1).getPlatGAME());
        System.out.println(" ");

        System.out.println("### Game genre ###");
        System.out.println("genre 1 title: " + gameDTO.getGameGENREs().get(0).getGenTITLE());
        System.out.println("genre 1 ID: " + gameDTO.getGameGENREs().get(0).getGenID());
        System.out.println("genre 1 gameID: " + gameDTO.getGameGENREs().get(0).getGenGAME());
        System.out.println("genre 2 title: " + gameDTO.getGameGENREs().get(1).getGenTITLE());
        System.out.println("genre 2 ID: " + gameDTO.getGameGENREs().get(1).getGenID());
        System.out.println("genre 2 gameID: " + gameDTO.getGameGENREs().get(1).getGenGAME());
        System.out.println(" ");

        System.out.println("### game desc ###");
        System.out.println("gameBIO: " + gameDTO.getGameBIO());
    }
}