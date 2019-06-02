package Data;

public class Roles {

    private int roleid;
    private String rolename;

    public Roles(int roleid, String rolename) {
        this.roleid = roleid;
        this.rolename = rolename;
    }

    public Roles() {
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
