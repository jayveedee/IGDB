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
    boolean handleUpdateUserRolesXCreateRole(String query, int roleID, String rolenameORusername) {
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
    public RoleDTO getSpecificRole(int roleID, String userNAME) {
        RoleDTO role = new RoleDTO();
        String query =
                "SELECT UserRoleList.userNAME, UserRoleList.roleID, Roles.roleNAME FROM UserRoleList " +
                "INNER JOIN Roles ON UserRoleList.roleID = Roles.roleID " +
                "WHERE UserRoleList.userNAME = ? AND UserRoleList.roleID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setString(1,userNAME);
            mySql.getPrepStatement().setInt(2,roleID);

            ResultSet rs = mySql.getPrepStatement().executeQuery();
            if (rs.next()){
                role.setRoleNAME(rs.getString("roleNAME"));
                role.setRoleID(rs.getInt("roleID"));
            }
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return role;
    }

    @Override
    public List<RoleDTO> getRoleList() {
        String query = "SELECT * FROM Roles ORDER BY roleID ASC";
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
    List<RoleDTO> handleGetRoleList(ResultSet rs) throws SQLException {
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
        String query1 = "DELETE FROM UserRoleList WHERE roleID = ?";
        String query2 = "DELETE FROM Roles WHERE roleID = ?";
        try {
            mySql.getConnection().setAutoCommit(false);
            boolean status = mySql.handleDeleteByID(roleID, query1, mySql) && mySql.handleDeleteByID(roleID, query2, mySql);
            mySql.getConnection().commit();
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)