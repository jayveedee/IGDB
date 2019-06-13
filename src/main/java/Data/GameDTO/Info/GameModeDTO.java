package Data.GameDTO.Info;

import java.util.List;

public class GameModeDTO {

    private int                 gmID;
    private String              gmTITLE;
    private int                 gmGAME;

    public GameModeDTO(int gmID, String gmTITLE, int gmGAME) {
        this.gmID = gmID;
        this.gmTITLE = gmTITLE;
        this.gmGAME = gmGAME;
    }

    public GameModeDTO() {
    }

    public int getGmID() {
        return gmID;
    }

    public void setGmID(int gmID) {
        this.gmID = gmID;
    }

    public String getGmTITLE() {
        return gmTITLE;
    }

    public void setGmTITLE(String gmTITLE) {
        this.gmTITLE = gmTITLE;
    }

    public int getGmGAME() {
        return gmGAME;
    }

    public void setGmGAME(int gmGAME) {
        this.gmGAME = gmGAME;
    }
}
