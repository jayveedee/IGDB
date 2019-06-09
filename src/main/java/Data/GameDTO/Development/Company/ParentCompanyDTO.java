package Data.GameDTO.Development.Company;

import Data.GameDTO.Info.DateDTO;

public class ParentCompanyDTO {

    private int         parentID;
    private String      parentNAME;
    private DateDTO     parentCREATED;
    private String      parentCOUNTRY;
    private boolean     parentSTATUS;

    public ParentCompanyDTO() {
    }

    public ParentCompanyDTO(int parentID, String parentNAME, DateDTO parentCREATED, String parentCOUNTRY, boolean parentSTATUS) {
        this.parentID = parentID;
        this.parentNAME = parentNAME;
        this.parentCREATED = parentCREATED;
        this.parentCOUNTRY = parentCOUNTRY;
        this.parentSTATUS = parentSTATUS;
    }

    public int getParentID() {
        return parentID;
    }

    public void setParentID(int parentID) {
        this.parentID = parentID;
    }

    public String getParentNAME() {
        return parentNAME;
    }

    public void setParentNAME(String parentNAME) {
        this.parentNAME = parentNAME;
    }

    public DateDTO getParentCREATED() {
        return parentCREATED;
    }

    public void setParentCREATED(DateDTO parentCREATED) {
        this.parentCREATED = parentCREATED;
    }

    public String getParentCOUNTRY() {
        return parentCOUNTRY;
    }

    public void setParentCOUNTRY(String parentCOUNTRY) {
        this.parentCOUNTRY = parentCOUNTRY;
    }

    public boolean isParentSTATUS() {
        return parentSTATUS;
    }

    public void setParentSTATUS(boolean parentSTATUS) {
        this.parentSTATUS = parentSTATUS;
    }
}
