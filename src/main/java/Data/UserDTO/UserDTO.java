package Data.UserDTO;

import Data.GameDTO.GameDTO;

import java.util.List;

public class UserDTO {

    private int                 userID;
    private String              userNAME;
    private String              userPASS;
    private String              userEMAIL;
    private List<GameDTO>       userGAMEs;
    private List<RoleDTO>       userROLEs;

    public UserDTO(int userID, String userNAME, String userPASS, String userEMAIL, List<GameDTO> userGAMEs, List<RoleDTO> userROLEs) {
        this.userID = userID;
        this.userNAME = userNAME;
        this.userPASS = userPASS;
        this.userEMAIL = userEMAIL;
        this.userGAMEs = userGAMEs;
        this.userROLEs = userROLEs;
    }

    public UserDTO() {
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserNAME() {
        return userNAME;
    }

    public void setUserNAME(String userNAME) {
        this.userNAME = userNAME;
    }

    public String getUserPASS() {
        return userPASS;
    }

    public void setUserPASS(String userPASS) {
        this.userPASS = userPASS;
    }

    public String getUserEMAIL() {
        return userEMAIL;
    }

    public void setUserEMAIL(String userEMAIL) {
        this.userEMAIL = userEMAIL;
    }

    public List<GameDTO> getUserGAMEs() {
        return userGAMEs;
    }

    public void setUserGAMEs(List<GameDTO> userGAMEs) {
        this.userGAMEs = userGAMEs;
    }

    public List<RoleDTO> getUserROLEs() {
        return userROLEs;
    }

    public void setUserROLEs(List<RoleDTO> userROLEs) {
        this.userROLEs = userROLEs;
    }
}
