package Data.GameDTO.Info;

import java.util.List;

public class GenreDTO {

    private int                 genID;
    private String              genTITLE;
    private int                 genGAME;

    public GenreDTO(int genID, String genTITLE, int genGAME) {
        this.genID = genID;
        this.genTITLE = genTITLE;
        this.genGAME = genGAME;
    }

    public GenreDTO() {
    }

    public int getGenID() {
        return genID;
    }

    public void setGenID(int genID) {
        this.genID = genID;
    }

    public String getGenTITLE() {
        return genTITLE;
    }

    public void setGenTITLE(String genTITLE) {
        this.genTITLE = genTITLE;
    }

    public int getGenGAME() {
        return genGAME;
    }

    public void setGenGAME(int genGAME) {
        this.genGAME = genGAME;
    }
}
