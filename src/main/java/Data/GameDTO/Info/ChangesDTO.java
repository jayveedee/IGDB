package Data.GameDTO.Info;

import Data.UserDTO.UserDTO;

public class ChangesDTO {

    private int changeID;
    private String changeVER;
    private String changeDATE;
    private UserDTO changeUSERNAME;

    public ChangesDTO() {
    }

    public ChangesDTO(int changeID, String changeVER, String changeDATE, UserDTO changeUSERNAME) {
        this.changeID = changeID;
        this.changeVER = changeVER;
        this.changeDATE = changeDATE;
        this.changeUSERNAME = changeUSERNAME;
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

    public String getChangeDATE() {
        return changeDATE;
    }

    public void setChangeDATE(String changeDATE) {
        this.changeDATE = changeDATE;
    }

    public UserDTO getChangeUSERNAME() {
        return changeUSERNAME;
    }

    public void setChangeUSERNAME(UserDTO changeUSERNAME) {
        this.changeUSERNAME = changeUSERNAME;
    }
}
