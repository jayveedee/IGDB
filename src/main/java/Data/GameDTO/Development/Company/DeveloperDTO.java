package Data.GameDTO.Development.Company;

import Data.GameDTO.DateDTO;

import java.util.List;

public class DeveloperDTO {

    private int                 devID;
    private String              devNAME;
    private DateDTO             devCREATED;
    private boolean             devSTATUS;
    private String              devCOUNTRY;
    private ParentCompanyDTO    devPCOMPANY;
    private int                 devGAME;

    public DeveloperDTO(int devID, String devNAME, DateDTO devCREATED, boolean devSTATUS, String devCOUNTRY, ParentCompanyDTO devPCOMPANY, int devGAME) {
        this.devID = devID;
        this.devNAME = devNAME;
        this.devCREATED = devCREATED;
        this.devSTATUS = devSTATUS;
        this.devCOUNTRY = devCOUNTRY;
        this.devPCOMPANY = devPCOMPANY;
        this.devGAME = devGAME;
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

    public DateDTO getDevCREATED() {
        return devCREATED;
    }

    public void setDevCREATED(DateDTO devCREATED) {
        this.devCREATED = devCREATED;
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

    public ParentCompanyDTO getDevPCOMPANY() {
        return devPCOMPANY;
    }

    public void setDevPCOMPANY(ParentCompanyDTO devPCOMPANY) {
        this.devPCOMPANY = devPCOMPANY;
    }

    public int getDevGAME() {
        return devGAME;
    }

    public void setDevGAME(int devGAME) {
        this.devGAME = devGAME;
    }
}
