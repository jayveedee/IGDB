package Data.UserDAL;

import Data.IMysqlConnection;
import Data.UserDTO.RoleDTO;

import java.sql.SQLException;
import java.util.List;

public class RoleDAO implements IRolesDAO {

    private IMysqlConnection mySql;

    public RoleDAO(IMysqlConnection mySql) {
        this.mySql = mySql;
    }

    @Override
    public void createRole(RoleDTO role) {
        String query = "INSERT INTO Roles (roleID, roleNAME) VALUES (?, ?)";

        int roleid = role.getRoleID();
        String rolename = role.getRoleNAME();

        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setInt(1,roleid);
            mySql.getPrepStatement().setString(2,rolename);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public RoleDTO getRole(int roleid) {
        return null;
    }

    @Override
    public List<RoleDTO> getRoleList() {
        return null;
    }

    @Override
    public void deleteRole(int roleid) {

    }
}
