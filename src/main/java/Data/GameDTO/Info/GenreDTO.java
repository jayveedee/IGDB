package Data.GameDTO.Info;

import Data.GameDTO.GameDTO;

import java.util.List;

public class GenreDTO {

    private int                 genID;
    private String              genNAME;
    private List<GameDTO>       genGAMEs;

    public GenreDTO(int genID, String genNAME, List<GameDTO> genGAMEs) {
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

    public List<GameDTO> getGenGAMEs() {
        return genGAMEs;
    }

    public void setGenGAMEs(List<GameDTO> genGAMEs) {
        this.genGAMEs = genGAMEs;
    }
}
