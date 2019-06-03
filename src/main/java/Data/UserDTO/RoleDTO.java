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
