package Data.GameDTO;

import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.WriterDTO;
import Data.GameDTO.Info.*;

import java.util.List;

public class GameDTO {

    private int                     gameID;         private String                  gameNAME;
    private List<Integer>           gameCHs;        private List<Integer>           gameACs;
    private List<Integer>           gameGENREs;     private List<Integer>           gameGMs;
    private List<Integer>           gameRATINGs;    private DateDTO                 gameRELEASEDATE;
    private WriterDTO               gameWRI;
    private DeveloperDTO            gameDEV;        private PublisherDTO            gamePUB;
    private ComposerDTO             gameCOMP;       private SoundtrackDTO           gameOST;

    private String                  gameCover;      private String                  gameBG;
    private String                  gameBIO;        private List<Integer>           gameTRAILERs;       private List<Integer>           gamePICs;

    public GameDTO() {
    }

    public GameDTO
        (
            int gameID, String gameNAME, List<Integer> gameCHs, List<Integer> gameACs, List<Integer> gameGENREs,
            List<Integer> gameGMs, List<Integer> gameRATINGs, DateDTO gameRELEASEDATE, WriterDTO gameWRI,
            DeveloperDTO gameDEV, PublisherDTO gamePUB, ComposerDTO gameCOMP, SoundtrackDTO gameOST, String gameCover,
            String gameBG, String gameBIO, List<Integer> gameTRAILERs, List<Integer> gamePICs
        ) {
        this.gameID = gameID;
        this.gameNAME = gameNAME;
        this.gameCHs = gameCHs;
        this.gameACs = gameACs;
        this.gameGENREs = gameGENREs;
        this.gameGMs = gameGMs;
        this.gameRATINGs = gameRATINGs;
        this.gameRELEASEDATE = gameRELEASEDATE;
        this.gameWRI = gameWRI;
        this.gameDEV = gameDEV;
        this.gamePUB = gamePUB;
        this.gameCOMP = gameCOMP;
        this.gameOST = gameOST;
        this.gameCover = gameCover;
        this.gameBG = gameBG;
        this.gameBIO = gameBIO;
        this.gameTRAILERs = gameTRAILERs;
        this.gamePICs = gamePICs;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameNAME() {
        return gameNAME;
    }

    public void setGameNAME(String gameNAME) {
        this.gameNAME = gameNAME;
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

    public List<Integer> getGameRATINGs() {
        return gameRATINGs;
    }

    public void setGameRATINGs(List<Integer> gameRATINGs) {
        this.gameRATINGs = gameRATINGs;
    }

    public DateDTO getGameRELEASEDATE() {
        return gameRELEASEDATE;
    }

    public void setGameRELEASEDATE(DateDTO gameRELEASEDATE) {
        this.gameRELEASEDATE = gameRELEASEDATE;
    }

    public WriterDTO getGameWRI() {
        return gameWRI;
    }

    public void setGameWRI(WriterDTO gameWRI) {
        this.gameWRI = gameWRI;
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

    public ComposerDTO getGameCOMP() {
        return gameCOMP;
    }

    public void setGameCOMP(ComposerDTO gameCOMP) {
        this.gameCOMP = gameCOMP;
    }

    public SoundtrackDTO getGameOST() {
        return gameOST;
    }

    public void setGameOST(SoundtrackDTO gameOST) {
        this.gameOST = gameOST;
    }

    public String getGameCover() {
        return gameCover;
    }

    public void setGameCover(String gameCover) {
        this.gameCover = gameCover;
    }

    public String getGameBG() {
        return gameBG;
    }

    public void setGameBG(String gameBG) {
        this.gameBG = gameBG;
    }

    public String getGameBIO() {
        return gameBIO;
    }

    public void setGameBIO(String gameBIO) {
        this.gameBIO = gameBIO;
    }

    public List<Integer> getGameTRAILERs() {
        return gameTRAILERs;
    }

    public void setGameTRAILERs(List<Integer> gameTRAILERs) {
        this.gameTRAILERs = gameTRAILERs;
    }

    public List<Integer> getGamePICs() {
        return gamePICs;
    }

    public void setGamePICs(List<Integer> gamePICs) {
        this.gamePICs = gamePICs;
    }
}
