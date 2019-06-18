package Data.GameDTO.Info;

public class PlatformDTO {

    private int                 platID;
    private String              platTITLE;
    private int                 platGAME;
    private String              platCREATED;

    public PlatformDTO(int platID, String platTITLE, int platGAME, String platCREATED) {
        this.platID = platID;
        this.platTITLE = platTITLE;
        this.platGAME = platGAME;
        this.platCREATED = platCREATED;
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

    public int getPlatGAME() {
        return platGAME;
    }

    public void setPlatGAME(int platGAME) {
        this.platGAME = platGAME;
    }

    public String getPlatCREATED() {
        return platCREATED;
    }

    public void setPlatCREATED(String platCREATED) {
        this.platCREATED = platCREATED;
    }
}
