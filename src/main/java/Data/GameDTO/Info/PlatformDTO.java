package Data.GameDTO.Info;

import Data.GameDTO.DateDTO;

public class PlatformDTO {

    private int                 platID;
    private String              platTITLE;
    private int                 platGAME;
    private String              platCREATED;

    public PlatformDTO(int platID, String platTITLE, int platGAME, String platCREATED) {
        this.platID = platID;
        this.platTITLE = platTITLE;
        this.platGAME = platGAME;
        this.platCREATED = platCREATED;
    }

    public PlatformDTO() {

    }

    public int getPlatID() {
        return platID;
    }

    public void setPlatID(int platID) {
        this.platID = platID;
    }

    public String getPlatTITLE() {
        return platTITLE;
    }

    public void setPlatTITLE(String platTITLE) {
        this.platTITLE = platTITLE;
    }

    public int getPlatGAME() {
        return platGAME;
    }

    public void setPlatGAME(int platGAME) {
        this.platGAME = platGAME;
    }

    public String getPlatCREATED() {
        return platCREATED;
    }

    public void setPlatCREATED(String platCREATED) {
        this.platCREATED = platCREATED;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)