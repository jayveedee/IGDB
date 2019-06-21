package Data.GameDTO.Development.Company;

import Data.GameDTO.DateDTO;

import java.util.List;

public class PublisherDTO {

    private int                 pubID;
    private String              pubNAME;
    private String             pubCREATED;
    private String              pubCOUNTRY;
    private boolean             pubSTATUS;
    private int                 pubGAME;

    public PublisherDTO(int pubID, String pubNAME, String pubCREATED, String pubCOUNTRY, boolean pubSTATUS, int pubGAME) {
        this.pubID = pubID;
        this.pubNAME = pubNAME;
        this.pubCREATED = pubCREATED;
        this.pubCOUNTRY = pubCOUNTRY;
        this.pubSTATUS = pubSTATUS;
        this.pubGAME = pubGAME;
    }

    public PublisherDTO() {
    }

    public int getPubID() {
        return pubID;
    }

    public void setPubID(int pubID) {
        this.pubID = pubID;
    }

    public String getPubNAME() {
        return pubNAME;
    }

    public void setPubNAME(String pubNAME) {
        this.pubNAME = pubNAME;
    }

    public String getPubCREATED() {
        return pubCREATED;
    }

    public void setPubCREATED(String pubCREATED) {
        this.pubCREATED = pubCREATED;
    }

    public String getPubCOUNTRY() {
        return pubCOUNTRY;
    }

    public void setPubCOUNTRY(String pubCOUNTRY) {
        this.pubCOUNTRY = pubCOUNTRY;
    }

    public boolean isPubSTATUS() {
        return pubSTATUS;
    }

    public void setPubSTATUS(boolean pubSTATUS) {
        this.pubSTATUS = pubSTATUS;
    }

    public int getPubGAME() {
        return pubGAME;
    }

    public void setPubGAME(int pubGAME) {
        this.pubGAME = pubGAME;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)