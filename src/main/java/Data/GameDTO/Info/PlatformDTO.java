package Data.GameDTO.Info;

import java.util.List;

public class PlatformDTO {

    private int                 platID;
    private String              platTITLE;
    private List<Integer>       platGAMEs;

    public PlatformDTO(int platID, String platTITLE, List<Integer> platGAMEs) {
        this.platID = platID;
        this.platTITLE = platTITLE;
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

    public String getPlatTITLE() {
        return platTITLE;
    }

    public void setPlatTITLE(String platTITLE) {
        this.platTITLE = platTITLE;
    }

    public List<Integer> getPlatGAMEs() {
        return platGAMEs;
    }

    public void setPlatGAMEs(List<Integer> platGAMEs) {
        this.platGAMEs = platGAMEs;
    }
}
