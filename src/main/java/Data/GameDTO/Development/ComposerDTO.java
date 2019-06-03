package Data.GameDTO.Development;

import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.SoundtrackDTO;

import java.util.List;

public class ComposerDTO {

    private int                     compID;
    private String                  compFN;
    private String                  compLN;
    private List<Integer>           compOSTs;
    private List<Integer>           compGAMEs;

    public ComposerDTO(int compID, String compFN, String compLN, List<Integer> compOSTs, List<Integer> compGAMEs) {
        this.compID = compID;
        this.compFN = compFN;
        this.compLN = compLN;
        this.compOSTs = compOSTs;
        this.compGAMEs = compGAMEs;
    }

    public ComposerDTO() {
    }

    public int getCompID() {
        return compID;
    }

    public void setCompID(int compID) {
        this.compID = compID;
    }

    public String getCompFN() {
        return compFN;
    }

    public void setCompFN(String compFN) {
        this.compFN = compFN;
    }

    public String getCompLN() {
        return compLN;
    }

    public void setCompLN(String compLN) {
        this.compLN = compLN;
    }

    public List<Integer> getCompOSTs() {
        return compOSTs;
    }

    public void setCompOSTs(List<Integer> compOSTs) {
        this.compOSTs = compOSTs;
    }

    public List<Integer> getCompGAMEs() {
        return compGAMEs;
    }

    public void setCompGAMEs(List<Integer> compGAMEs) {
        this.compGAMEs = compGAMEs;
    }
}
