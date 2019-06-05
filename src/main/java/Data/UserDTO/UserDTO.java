package Data.UserDTO;

import Data.GameDTO.GameDTO;

import java.util.List;

public class UserDTO {

    private String              userNAME;
    private String              userPASS;
    private String              userEMAIL;
    private List<Integer>       userGAMEs;
    private List<RoleDTO>       userROLEs;

    public UserDTO(String userNAME, String userPASS, String userEMAIL, List<Integer> userGAMEs, List<RoleDTO> userROLEs) {
        this.userNAME = userNAME;
        this.userPASS = userPASS;
        this.userEMAIL = userEMAIL;
        this.userGAMEs = userGAMEs;
        this.userROLEs = userROLEs;
    }

    public UserDTO() {
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

    public List<Integer> getUserGAMEs() {
        return userGAMEs;
    }

    public void setUserGAMEs(List<Integer> userGAMEs) {
        this.userGAMEs = userGAMEs;
    }

    public List<RoleDTO> getUserROLEs() {
        return userROLEs;
    }

    public void setUserROLEs(List<RoleDTO> userROLEs) {
        this.userROLEs = userROLEs;
    }
}
