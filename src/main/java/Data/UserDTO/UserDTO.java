package Data.UserDTO;

import java.util.List;

public class UserDTO {

    private String              userNAME;
    private String              userPASS;
    private String              userEMAIL;
    private List<Integer>       userGAMEs;
    private List<RoleDTO>       userROLEs;
    private String              userPFP;

    public UserDTO(String userNAME, String userPASS, String userEMAIL, List<Integer> userGAMEs, List<RoleDTO> userROLEs, String userPFP) {
        this.userNAME = userNAME;
        this.userPASS = userPASS;
        this.userEMAIL = userEMAIL;
        this.userGAMEs = userGAMEs;
        this.userROLEs = userROLEs;
        this.userPFP = userPFP;
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

    public String getUserPFP() {
        return userPFP;
    }

    public void setUserPFP(String userPFP) {
        this.userPFP = userPFP;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)