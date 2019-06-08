package Data.GameDTO.Info;

import java.util.List;

public class GenreDTO {

    private int                 genID;
    private String              genTITLE;
    private List<Integer>       genGAMEs;

    public GenreDTO(int genID, String genTITLE, List<Integer> genGAMEs) {
        this.genID = genID;
        this.genTITLE = genTITLE;
        this.genGAMEs = genGAMEs;
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

    public List<Integer> getGenGAMEs() {
        return genGAMEs;
    }

    public void setGenGAMEs(List<Integer> genGAMEs) {
        this.genGAMEs = genGAMEs;
    }
}
