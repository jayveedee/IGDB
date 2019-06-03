package Data.GameDTO.Development.Company;

import Data.GameDTO.Info.DateDTO;
import Data.GameDTO.GameDTO;

import java.util.List;

public class PublisherDTO {

    private int                 pubID;
    private String              pubNAME;
    private DateDTO             pubESTABLISHED;
    private String              pubCOUNTRY;
    private boolean             pubSTATUS;
    private List<GameDTO>       pubGAMEs;

    private String biography;

    public PublisherDTO(int pubID, String pubNAME, DateDTO pubESTABLISHED, String pubCOUNTRY, boolean pubSTATUS, List<GameDTO> pubGAMEs, String biography) {
        this.pubID = pubID;
        this.pubNAME = pubNAME;
        this.pubESTABLISHED = pubESTABLISHED;
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

    public DateDTO getPubESTABLISHED() {
        return pubESTABLISHED;
    }

    public void setPubESTABLISHED(DateDTO pubESTABLISHED) {
        this.pubESTABLISHED = pubESTABLISHED;
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

    public List<GameDTO> getPubGAMEs() {
        return pubGAMEs;
    }

    public void setPubGAMEs(List<GameDTO> pubGAMEs) {
        this.pubGAMEs = pubGAMEs;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
