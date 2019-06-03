package Data.GameDTO.Development;

import Data.GameDTO.Info.DateDTO;

import java.util.List;

public class ActorDTO {

    private int                     acID;
    private String                  acFN;
    private String                  acLN;
    private DateDTO                 acBDAY;
    private List<Integer>           acCHs;
    private List<Integer>           acGAMEs;

    public ActorDTO(int acID, String firstName, String acLN, DateDTO acBDAY, List<Integer> acCHs, List<Integer> acGAMEs) {
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

    public List<Integer> getAcCHs() {
        return acCHs;
    }

    public void setAcCHs(List<Integer> acCHs) {
        this.acCHs = acCHs;
    }

    public List<Integer> getAcGAMEs() {
        return acGAMEs;
    }

    public void setAcGAMEs(List<Integer> acGAMEs) {
        this.acGAMEs = acGAMEs;
    }
}
