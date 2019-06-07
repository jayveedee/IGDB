package Data.UserDAL;

import Data.IMysqlConnection;
import Data.UserDTO.RoleDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        String query = "SELECT * FROM Roles WHERE roleID = ?";
        RoleDTO role = new RoleDTO();

        try {
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setInt(1,roleid);

            ResultSet rs = mySql.getPrepStatement().executeQuery();
            if (rs.next()){
                role.setRoleID(rs.getInt("roleID"));
                role.setRoleNAME(rs.getString("roleNAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }

    @Override
    public List<RoleDTO> getRoleList() {
        String query = "SELECT * FROM Roles";
        List<RoleDTO> rlist = new ArrayList<>();

        try {
            mySql.setStatement(mySql.getConnection().createStatement());

            ResultSet rs = mySql.getStatement().executeQuery(query);
            rlist = handleGetRoleList(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rlist;
    }

    @Override
    public void updateRole(int roleid) {

    }

    static List<RoleDTO> handleGetRoleList(ResultSet rs) throws SQLException {
        List<RoleDTO> rlist = new ArrayList<>();
        while (rs.next()){
            RoleDTO role = new RoleDTO();
            role.setRoleID(rs.getInt("roleID"));
            role.setRoleNAME(rs.getString("roleNAME"));
            rlist.add(role);
        }
        return rlist;
    }

    @Override
    public void deleteRole(int roleid) {
        String query1 = "DELETE FROM UserRoles WHERE roleID = ?";
        String query2 = "DELETE FROM Roles WHERE roleID = ?";

        try {
            handleDeleteByID(roleid, query1);
            handleDeleteByID(roleid, query2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void handleDeleteByID(int roleid, String query2) throws SQLException {
        mySql.getConnection().setAutoCommit(false);
        mySql.setPrepStatment(mySql.getConnection().prepareStatement(query2));
        mySql.getPrepStatement().setInt(1,roleid);
        mySql.getPrepStatement().executeUpdate();
        mySql.getConnection().commit();
    }
}
