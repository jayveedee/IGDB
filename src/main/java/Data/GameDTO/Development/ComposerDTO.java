package Data.GameDTO.Development;

import java.util.List;

public class ComposerDTO {

    private int                     compID;
    private String                  compFN;
    private String                  compLN;
    private List<Integer>           compOSTs;
    private int                     compGAME;

    public ComposerDTO(int compID, String compFN, String compLN, List<Integer> compOSTs, int compGAME) {
        this.compID = compID;
        this.compFN = compFN;
        this.compLN = compLN;
        this.compOSTs = compOSTs;
        this.compGAME = compGAME;
    }

    public ComposerDTO() {
    }

    public int getCompID() {
        return compID;
    }

    public void setCompID(int compID) {
        this.compID = compID;
    }

    public String getCompFN() {
        return compFN;
    }

    public void setCompFN(String compFN) {
        this.compFN = compFN;
    }

    public String getCompLN() {
        return compLN;
    }

    public void setCompLN(String compLN) {
        this.compLN = compLN;
    }

    public List<Integer> getCompOSTs() {
        return compOSTs;
    }

    public void setCompOSTs(List<Integer> compOSTs) {
        this.compOSTs = compOSTs;
    }

    public int getCompGAME() {
        return compGAME;
    }

    public void setCompGAME(int compGAME) {
        this.compGAME = compGAME;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)