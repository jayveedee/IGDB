package Data.GameDTO.Character;

import Data.GameDTO.Info.DateDTO;

import java.util.List;

public class CharacterDTO {

    private int                     chID;
    private String                  chNAME;
    private DateDTO                 chBDAY;
    private List<Integer>           chVAs;
    private List<Integer>           chGAMEs;

    private String                  chBIO;

    public CharacterDTO(int chID, String chNAME, String chBIO, DateDTO chBDAY, List<Integer> chVAs, List<Integer> chGAMEs) {
        this.chID = chID;
        this.chNAME = chNAME;
        this.chBIO = chBIO;
        this.chBDAY = chBDAY;
        this.chVAs = chVAs;
        this.chGAMEs = chGAMEs;
    }

    public CharacterDTO() {
    }

    public int getChID() {
        return chID;
    }

    public void setChID(int chID) {
        this.chID = chID;
    }

    public String getChNAME() {
        return chNAME;
    }

    public void setChNAME(String firstName) {
        this.chNAME = firstName;
    }

    public String getChBIO() {
        return chBIO;
    }

    public void setChBIO(String chBIO) {
        this.chBIO = chBIO;
    }

    public DateDTO getChBDAY() {
        return chBDAY;
    }

    public void setChBDAY(DateDTO chBDAY) {
        this.chBDAY = chBDAY;
    }

    public List<Integer> getChVAs() {
        return chVAs;
    }

    public void setChVAs(List<Integer> chVAs) {
        this.chVAs = chVAs;
    }

    public List<Integer> getChGAMEs() {
        return chGAMEs;
    }

    public void setChGAMEs(List<Integer> chGAMEs) {
        this.chGAMEs = chGAMEs;
    }
}
