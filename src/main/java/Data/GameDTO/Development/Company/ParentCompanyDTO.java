package Data.GameDTO.Development.Company;

import Data.GameDTO.DateDTO;

public class ParentCompanyDTO {

    private int         parentID;
    private String      parentNAME;
    private String     parentCREATED;
    private String      parentCOUNTRY;
    private boolean     parentSTATUS;

    public ParentCompanyDTO() {
    }

    public ParentCompanyDTO(int parentID, String parentNAME, String parentCREATED, String parentCOUNTRY, boolean parentSTATUS) {
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

    public String getParentCREATED() {
        return parentCREATED;
    }

    public void setParentCREATED(String parentCREATED) {
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

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)