package Data.UserDTO;

public class RoleDTO {

    private int         roleID;
    private String      roleNAME;

    public RoleDTO(int roleID, String roleNAME) {
        this.roleID = roleID;
        this.roleNAME = roleNAME;
    }

    public RoleDTO() {
    }

    public int getRoleID() {
        return roleID;
    }

    public void setRoleID(int roleID) {
        this.roleID = roleID;
    }

    public String getRoleNAME() {
        return roleNAME;
    }

    public void setRoleNAME(String roleNAME) {
        this.roleNAME = roleNAME;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)