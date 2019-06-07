package Data.UserDAL;

import Data.IMysqlConnection;
import Data.UserDTO.RoleDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAO implements IRoleDAO {

    private IMysqlConnection mySql;

    public RoleDAO(IMysqlConnection mySql) {
        this.mySql = mySql;
    }

    @Override
    public boolean createRole(RoleDTO role) {
        String query = "INSERT INTO Roles (roleID, roleNAME) VALUES (?, ?)";
        return handleUpdateUserRolesXCreateRole(query, role.getRoleID(), role.getRoleNAME());
    }

    public boolean handleUpdateUserRolesXCreateRole(String query, int roleID, String rolenameORusername) {
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setInt(1,roleID);
            mySql.getPrepStatement().setString(2,rolenameORusername);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public RoleDTO getRole(int roleID) {
        String query = "SELECT * FROM Roles WHERE roleID = ?";
        RoleDTO role = new RoleDTO();
        try {
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setInt(1,roleID);
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
        List<RoleDTO> rList = new ArrayList<>();
        try {
            mySql.setStatement(mySql.getConnection().createStatement());
            ResultSet rs = mySql.getStatement().executeQuery(query);
            rList = handleGetRoleList(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rList;
    }

    @Override
    public boolean updateRole(RoleDTO newRole) {
        String query = "UPDATE Roles SET roleNAME = ? WHERE roleID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setString(1,newRole.getRoleNAME());
            mySql.getPrepStatement().setInt(2,newRole.getRoleID());
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static List<RoleDTO> handleGetRoleList(ResultSet rs) throws SQLException {
        List<RoleDTO> rList = new ArrayList<>();
        while (rs.next()){
            RoleDTO role = new RoleDTO();
            role.setRoleID(rs.getInt("roleID"));
            role.setRoleNAME(rs.getString("roleNAME"));
            rList.add(role);
        }
        return rList;
    }

    @Override
    public boolean deleteRole(int roleID) {
        String query1 = "DELETE FROM UserRoles WHERE roleID = ?";
        String query2 = "DELETE FROM Roles WHERE roleID = ?";
        return handleDeleteByID(roleID, query1) && handleDeleteByID(roleID, query2);
    }

    private boolean handleDeleteByID(int roleid, String query) {
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setInt(1,roleid);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
