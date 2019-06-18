package Data.UserDTO;

public class ChangesDTO {

    private int         changeID;
    private String      changeVER;
    private UserDTO     changeUSERNAME;
    private String      changeDATE;

    public ChangesDTO(int changeID, String changeVER, UserDTO changeUSERNAME, String changeDATE) {
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

    public String getChangeDATE() {
        return changeDATE;
    }

    public void setChangeDATE(String changeDATE) {
        this.changeDATE = changeDATE;
    }
}
