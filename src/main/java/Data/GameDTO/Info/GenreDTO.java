package Data.GameDTO.Info;


import java.util.List;

public class GenreDTO {

    private int                 genID;
    private String              genNAME;
    private List<Integer>       genGAMEs;

    public GenreDTO(int genID, String genNAME, List<Integer> genGAMEs) {
        this.genID = genID;
        this.genNAME = genNAME;
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

    public String getGenNAME() {
        return genNAME;
    }

    public void setGenNAME(String genNAME) {
        this.genNAME = genNAME;
    }

    public List<Integer> getGenGAMEs() {
        return genGAMEs;
    }

    public void setGenGAMEs(List<Integer> genGAMEs) {
        this.genGAMEs = genGAMEs;
    }
}
