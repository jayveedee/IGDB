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

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)