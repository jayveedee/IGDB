package Data.GameDTO.Development;

import java.util.List;

public class ActorDTO {

    private int                     acID;
    private String                  acFN;
    private String                  acLN;
    private String                 acBDAY;
    private List<Integer>           acCHs;
    private int                     acGAME;
    private String                  acPFP;

    public ActorDTO(int acID, String acFN, String acLN, String acBDAY, List<Integer> acCHs, int acGAME, String acPFP) {
        this.acID = acID;
        this.acFN = acFN;
        this.acLN = acLN;
        this.acBDAY = acBDAY;
        this.acCHs = acCHs;
        this.acGAME = acGAME;
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

    public String getAcBDAY() {
        return acBDAY;
    }

    public void setAcBDAY(String acBDAY) {
        this.acBDAY = acBDAY;
    }

    public List<Integer> getAcCHs() {
        return acCHs;
    }

    public void setAcCHs(List<Integer> acCHs) {
        this.acCHs = acCHs;
    }

    public int getAcGAME() {
        return acGAME;
    }

    public void setAcGAME(int acGAME) {
        this.acGAME = acGAME;
    }

    public String getAcPFP() {
        return acPFP;
    }

    public void setAcPFP(String acPFP) {
        this.acPFP = acPFP;
    }
}
