package Data.GameDTO.Info;

import java.util.List;

public class GameModeDTO {

    private int                 gmID;
    private String              gmTITLE;
    private List<Integer>       gmGAMEs;

    public GameModeDTO(int gmID, String gmTITLE, List<Integer> gmGAMEs) {
        this.gmID = gmID;
        this.gmTITLE = gmTITLE;
        this.gmGAMEs = gmGAMEs;
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

    public List<Integer> getGmGAMEs() {
        return gmGAMEs;
    }

    public void setGmGAMEs(List<Integer> gmGAMEs) {
        this.gmGAMEs = gmGAMEs;
    }
}
