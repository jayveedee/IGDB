package Data.GameDTO;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.WriterDTO;
import Data.GameDTO.Info.*;
import Data.UserDTO.RatingDTO;

import java.util.List;

public class GameDTO {

    private int                     gameID;         private String                  gameNAME;
    private List<CharacterDTO>      gameCHs;        private List<ActorDTO>          gameACs;
    private List<GenreDTO>          gameGENREs;     private List<GameModeDTO>       gameGMs;
    private List<RatingDTO>         gameRATINGs;    private DateDTO                 gameRELEASEDATE;
    private WriterDTO               gameWRI;
    private DeveloperDTO            gameDEV;        private PublisherDTO            gamePUB;
    private ComposerDTO             gameCOMP;       private SoundtrackDTO           gameOST;
    private PlatformDTO             gamePLAT;

    private String                  gameCover;      private String                  gameBG;
    private String                  gameBIO;        private List<TrailerDTO>        gameTRAILERs;
    private List<PictureDTO>        gamePICs;

    public GameDTO(int gameID, String gameNAME, List<CharacterDTO> gameCHs, List<ActorDTO> gameACs, List<GenreDTO> gameGENREs, List<GameModeDTO> gameGMs, List<RatingDTO> gameRATINGs, DateDTO gameRELEASEDATE, WriterDTO gameWRI, DeveloperDTO gameDEV, PublisherDTO gamePUB, ComposerDTO gameCOMP, SoundtrackDTO gameOST, String gameCover, String gameBG, String gameBIO, List<TrailerDTO> gameTRAILERs, List<PictureDTO> gamePICs, PlatformDTO gamePLAT) {
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
        this.gamePLAT = gamePLAT;
        this.gameCover = gameCover;
        this.gameBG = gameBG;
        this.gameBIO = gameBIO;
        this.gameTRAILERs = gameTRAILERs;
        this.gamePICs = gamePICs;
    }

    public GameDTO() {
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

    public List<CharacterDTO> getGameCHs() {
        return gameCHs;
    }

    public void setGameCHs(List<CharacterDTO> gameCHs) {
        this.gameCHs = gameCHs;
    }

    public List<ActorDTO> getGameACs() {
        return gameACs;
    }

    public void setGameACs(List<ActorDTO> gameACs) {
        this.gameACs = gameACs;
    }

    public List<GenreDTO> getGameGENREs() {
        return gameGENREs;
    }

    public void setGameGENREs(List<GenreDTO> gameGENREs) {
        this.gameGENREs = gameGENREs;
    }

    public List<GameModeDTO> getGameGMs() {
        return gameGMs;
    }

    public void setGameGMs(List<GameModeDTO> gameGMs) {
        this.gameGMs = gameGMs;
    }

    public List<RatingDTO> getGameRATINGs() {
        return gameRATINGs;
    }

    public void setGameRATINGs(List<RatingDTO> gameRATINGs) {
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

    public PlatformDTO getGamePLAT() {
        return gamePLAT;
    }

    public void setGamePLAT(PlatformDTO gamePLAT) {
        this.gamePLAT = gamePLAT;
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

    public List<TrailerDTO> getGameTRAILERs() {
        return gameTRAILERs;
    }

    public void setGameTRAILERs(List<TrailerDTO> gameTRAILERs) {
        this.gameTRAILERs = gameTRAILERs;
    }

    public List<PictureDTO> getGamePICs() {
        return gamePICs;
    }

    public void setGamePICs(List<PictureDTO> gamePICs) {
        this.gamePICs = gamePICs;
    }
}
