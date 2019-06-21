package Data.UserDTO;

import Data.GameDTO.DateDTO;

public class ChangesDTO {

    private int         changeID;
    private String      changeVER;
    private UserDTO     changeUSERNAME;
    private DateDTO changeDATE;

    public ChangesDTO(int changeID, String changeVER, UserDTO changeUSERNAME, DateDTO changeDATE) {
        this.changeID = changeID;
        this.changeVER = changeVER;
        this.changeUSERNAME = changeUSERNAME;
        this.changeDATE = changeDATE;
    }

    public ChangesDTO() {
    }

    public int getChangeID() {
        return changeID;
    }

    public void setChangeID(int changeID) {
        this.changeID = changeID;
    }

    public String getChangeVER() {
        return changeVER;
    }

    public void setChangeVER(String changeVER) {
        this.changeVER = changeVER;
    }

    public UserDTO getChangeUSERNAME() {
        return changeUSERNAME;
    }

    public void setChangeUSERNAME(UserDTO changeUSERNAME) {
        this.changeUSERNAME = changeUSERNAME;
    }

    public DateDTO getChangeDATE() {
        return changeDATE;
    }

    public void setChangeDATE(DateDTO changeDATE) {
        this.changeDATE = changeDATE;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)