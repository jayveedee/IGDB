package Data.GameDTO.Character;

import java.util.List;

public class CharacterDTO {

    private int                     chID;
    private String                  chNAME;
    private List<Integer>           chVAs;
    private List<Integer>           chGAMEs;

    private String                  chPFP;
    private String                  chBIO;

    public CharacterDTO(int chID, String chNAME, String chBIO, List<Integer> chVAs, String chPFP, List<Integer> chGAMEs) {
        this.chID = chID;
        this.chNAME = chNAME;
        this.chBIO = chBIO;
        this.chVAs = chVAs;
        this.chPFP = chPFP;
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

    public List<Integer> getChVAs() {
        return chVAs;
    }

    public void setChVAs(List<Integer> chVAs) {
        this.chVAs = chVAs;
    }

    public String getChPFP() {
        return chPFP;
    }

    public void setChPFP(String chPFP) {
        this.chPFP = chPFP;
    }

    public List<Integer> getChGAMEs() {
        return chGAMEs;
    }

    public void setChGAMEs(List<Integer> chGAMEs) {
        this.chGAMEs = chGAMEs;
    }
}
