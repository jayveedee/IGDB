package Data.GameDTO.Development.Company;

import Data.GameDTO.Info.DateDTO;

import java.util.List;

public class PublisherDTO {

    private int                 pubID;
    private String              pubNAME;
    private DateDTO             pubCREATED;
    private String              pubCOUNTRY;
    private boolean             pubSTATUS;
    private List<Integer>       pubGAMEs;

    private String biography;

    public PublisherDTO(int pubID, String pubNAME, DateDTO pubCREATED, String pubCOUNTRY, boolean pubSTATUS, List<Integer> pubGAMEs, String biography) {
        this.pubID = pubID;
        this.pubNAME = pubNAME;
        this.pubCREATED = pubCREATED;
        this.pubCOUNTRY = pubCOUNTRY;
        this.pubSTATUS = pubSTATUS;
        this.pubGAMEs = pubGAMEs;
        this.biography = biography;
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

    public DateDTO getPubCREATED() {
        return pubCREATED;
    }

    public void setPubCREATED(DateDTO pubCREATED) {
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

    public List<Integer> getPubGAMEs() {
        return pubGAMEs;
    }

    public void setPubGAMEs(List<Integer> pubGAMEs) {
        this.pubGAMEs = pubGAMEs;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
