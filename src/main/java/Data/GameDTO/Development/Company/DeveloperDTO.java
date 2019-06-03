package Data.GameDTO.Development.Company;

import Data.GameDTO.Info.DateDTO;
import Data.GameDTO.GameDTO;

import java.util.List;

public class DeveloperDTO {

    private int                 devID;
    private String              devNAME;
    private DateDTO             devESTABLISHED;
    private boolean             devSTATUS;
    private String              devCOUNTRY;
    private PublisherDTO        devPCOMPANY;
    private List<GameDTO>       devGAMEs;

    private String biography;

    public DeveloperDTO(int devID, String devNAME, DateDTO devESTABLISHED, boolean devSTATUS, String devCOUNTRY, PublisherDTO devPCOMPANY, List<GameDTO> devGAMEs, String biography) {
        this.devID = devID;
        this.devNAME = devNAME;
        this.devESTABLISHED = devESTABLISHED;
        this.devSTATUS = devSTATUS;
        this.devCOUNTRY = devCOUNTRY;
        this.devPCOMPANY = devPCOMPANY;
        this.devGAMEs = devGAMEs;
        this.biography = biography;
    }

    public DeveloperDTO() {
    }

    public int getDevID() {
        return devID;
    }

    public void setDevID(int devID) {
        this.devID = devID;
    }

    public String getDevNAME() {
        return devNAME;
    }

    public void setDevNAME(String devNAME) {
        this.devNAME = devNAME;
    }

    public DateDTO getDevESTABLISHED() {
        return devESTABLISHED;
    }

    public void setDevESTABLISHED(DateDTO devESTABLISHED) {
        this.devESTABLISHED = devESTABLISHED;
    }

    public boolean isDevSTATUS() {
        return devSTATUS;
    }

    public void setDevSTATUS(boolean devSTATUS) {
        this.devSTATUS = devSTATUS;
    }

    public String getDevCOUNTRY() {
        return devCOUNTRY;
    }

    public void setDevCOUNTRY(String devCOUNTRY) {
        this.devCOUNTRY = devCOUNTRY;
    }

    public PublisherDTO getDevPCOMPANY() {
        return devPCOMPANY;
    }

    public void setDevPCOMPANY(PublisherDTO devPCOMPANY) {
        this.devPCOMPANY = devPCOMPANY;
    }

    public List<GameDTO> getDevGAMEs() {
        return devGAMEs;
    }

    public void setDevGAMEs(List<GameDTO> devGAMEs) {
        this.devGAMEs = devGAMEs;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
