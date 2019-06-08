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
    private String                  acPFP;

    public ActorDTO(int acID, String acFN, String acLN, DateDTO acBDAY, List<Integer> acCHs, List<Integer> acGAMEs, String acPFP) {
        this.acID = acID;
        this.acFN = acFN;
        this.acLN = acLN;
        this.acBDAY = acBDAY;
        this.acCHs = acCHs;
        this.acGAMEs = acGAMEs;
        this.acPFP = acPFP;
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

    public String getAcPFP() {
        return acPFP;
    }

    public void setAcPFP(String acPFP) {
        this.acPFP = acPFP;
    }
}
