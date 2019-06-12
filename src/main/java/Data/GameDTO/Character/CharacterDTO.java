package Data.GameDTO.Character;

public class CharacterDTO {

    private int                     chID;
    private String                  chNAME;
    private int                     chGAME;

    private String                  chPFP;

    public CharacterDTO(int chID, String chNAME, String chPFP, int chGAME) {
        this.chID = chID;
        this.chNAME = chNAME;
        this.chPFP = chPFP;
        this.chGAME = chGAME;
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

    public String getChPFP() {
        return chPFP;
    }

    public void setChPFP(String chPFP) {
        this.chPFP = chPFP;
    }

    public int getChGAME() {
        return chGAME;
    }

    public void setChGAME(int chGAME) {
        this.chGAME = chGAME;
    }
}
