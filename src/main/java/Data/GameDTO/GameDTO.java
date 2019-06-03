package Data.GameDTO;

import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.WriterDTO;
import Data.GameDTO.Info.*;

import java.util.List;

public class GameDTO {

    private int                     gameID;
    private int                     gameAGERATING;
    private String                  gameNAME;
    private DateDTO                 gameRELEASEDATE;
    private List<Integer>           gameRATINGs;
    private DeveloperDTO            gameDEV;
    private PublisherDTO            gamePUB;
    private SoundtrackDTO           gameOST;
    private ComposerDTO             gameCOMP;
    private WriterDTO               gameWRI;
    private List<Integer>           gameCHs;
    private List<Integer>           gameACs;
    private List<Integer>           gameGENREs;
    private List<Integer>           gameGMs;

    private String                  gameBIO;

    public GameDTO(int gameID, int gameAGERATING, String gameNAME, String gameBIO, DateDTO gameRELEASEDATE, List<Integer> gameRATINGs, DeveloperDTO gameDEV, PublisherDTO gamePUB, SoundtrackDTO gameOST, ComposerDTO gameCOMP, WriterDTO gameWRI, List<Integer> gameCHs, List<Integer> gameACs, List<Integer> gameGENREs, List<Integer> gameGMs) {
        this.gameID = gameID;
        this.gameAGERATING = gameAGERATING;
        this.gameNAME = gameNAME;
        this.gameBIO = gameBIO;
        this.gameRELEASEDATE = gameRELEASEDATE;
        this.gameRATINGs = gameRATINGs;
        this.gameDEV = gameDEV;
        this.gamePUB = gamePUB;
        this.gameOST = gameOST;
        this.gameCOMP = gameCOMP;
        this.gameWRI = gameWRI;
        this.gameCHs = gameCHs;
        this.gameACs = gameACs;
        this.gameGENREs = gameGENREs;
        this.gameGMs = gameGMs;
    }

    public GameDTO() {
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getGameAGERATING() {
        return gameAGERATING;
    }

    public void setGameAGERATING(int gameAGERATING) {
        this.gameAGERATING = gameAGERATING;
    }

    public String getGameNAME() {
        return gameNAME;
    }

    public void setGameNAME(String gameNAME) {
        this.gameNAME = gameNAME;
    }

    public String getGameBIO() {
        return gameBIO;
    }

    public void setGameBIO(String gameBIO) {
        this.gameBIO = gameBIO;
    }

    public DateDTO getGameRELEASEDATE() {
        return gameRELEASEDATE;
    }

    public void setGameRELEASEDATE(DateDTO gameRELEASEDATE) {
        this.gameRELEASEDATE = gameRELEASEDATE;
    }

    public List<Integer> getGameRATINGs() {
        return gameRATINGs;
    }

    public void setGameRATINGs(List<Integer> gameRATINGs) {
        this.gameRATINGs = gameRATINGs;
    }

    public DeveloperDTO getGameDEV() {
        return gameDEV;
    }

    public void setGameDEV(DeveloperDTO gameDEV) {
        this.gameDEV = gameDEV;
    }

    public PublisherDTO getGamePUB() {
        return gamePUB;
    }

    public void setGamePUB(PublisherDTO gamePUB) {
        this.gamePUB = gamePUB;
    }

    public SoundtrackDTO getGameOST() {
        return gameOST;
    }

    public void setGameOST(SoundtrackDTO gameOST) {
        this.gameOST = gameOST;
    }

    public ComposerDTO getGameCOMP() {
        return gameCOMP;
    }

    public void setGameCOMP(ComposerDTO gameCOMP) {
        this.gameCOMP = gameCOMP;
    }

    public WriterDTO getGameWRI() {
        return gameWRI;
    }

    public void setGameWRI(WriterDTO gameWRI) {
        this.gameWRI = gameWRI;
    }

    public List<Integer> getGameCHs() {
        return gameCHs;
    }

    public void setGameCHs(List<Integer> gameCHs) {
        this.gameCHs = gameCHs;
    }

    public List<Integer> getGameACs() {
        return gameACs;
    }

    public void setGameACs(List<Integer> gameACs) {
        this.gameACs = gameACs;
    }

    public List<Integer> getGameGENREs() {
        return gameGENREs;
    }

    public void setGameGENREs(List<Integer> gameGENREs) {
        this.gameGENREs = gameGENREs;
    }

    public List<Integer> getGameGMs() {
        return gameGMs;
    }

    public void setGameGMs(List<Integer> gameGMs) {
        this.gameGMs = gameGMs;
    }
}
