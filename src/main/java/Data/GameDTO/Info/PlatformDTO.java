package Data.GameDTO.Info;

import java.util.List;

public class PlatformDTO {

    private int                 platID;
    private String              platNAME;
    private List<Integer>       platGAMEs;

    public PlatformDTO(int platID, String platNAME, List<Integer> platGAMEs) {
        this.platID = platID;
        this.platNAME = platNAME;
        this.platGAMEs = platGAMEs;
    }

    public PlatformDTO() {
    }

    public int getPlatID() {
        return platID;
    }

    public void setPlatID(int platID) {
        this.platID = platID;
    }

    public String getPlatNAME() {
        return platNAME;
    }

    public void setPlatNAME(String platNAME) {
        this.platNAME = platNAME;
    }

    public List<Integer> getPlatGAMEs() {
        return platGAMEs;
    }

    public void setPlatGAMEs(List<Integer> platGAMEs) {
        this.platGAMEs = platGAMEs;
    }
}
