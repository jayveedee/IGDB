package Data.GameDTO.Development;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Info.DateDTO;
import Data.GameDTO.GameDTO;

import java.util.List;

public class ActorDTO {

    private int                     acID;
    private String                  acFN;
    private String                  acLN;
    private DateDTO                 acBDAY;
    private List<CharacterDTO>      acCHs;
    private List<GameDTO>           acGAMEs;

    public ActorDTO(int acID, String firstName, String acLN, DateDTO acBDAY, List<CharacterDTO> acCHs, List<GameDTO> acGAMEs) {
        this.acID = acID;
        this.acFN = firstName;
        this.acLN = acLN;
        this.acBDAY = acBDAY;
        this.acCHs = acCHs;
        this.acGAMEs = acGAMEs;
    }

    public ActorDTO() {
    }

    public int getAcID() {
        return acID;
    }

    public void setAcID(int acID) {
        this.acID = acID;
    }

    public String getfisrtName() {
        return acFN;
    }

    public void setfisrtName(String fisrtName) {
        this.acFN = fisrtName;
    }

    public String getAcFN() {
        return acFN;
    }

    public void setAcFN(String acFN) {
        this.acFN = acFN;
    }

    public String getAcLN() {
        return acLN;
    }

    public void setAcLN(String acLN) {
        this.acLN = acLN;
    }

    public DateDTO getAcBDAY() {
        return acBDAY;
    }

    public void setAcBDAY(DateDTO acBDAY) {
        this.acBDAY = acBDAY;
    }

    public List<CharacterDTO> getAcCHs() {
        return acCHs;
    }

    public void setAcCHs(List<CharacterDTO> acCHs) {
        this.acCHs = acCHs;
    }

    public List<GameDTO> getAcGAMEs() {
        return acGAMEs;
    }

    public void setAcGAMEs(List<GameDTO> acGAMEs) {
        this.acGAMEs = acGAMEs;
    }
}
