package Data.UserDAL;

import Data.GenAccessDeleteAllTables;
import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDTO.RoleDTO;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoleDAO_TEST {

    private GenAccessDeleteAllTables del             = new GenAccessDeleteAllTables();
    private IMysqlConnection mySql = new MysqlConnection();
    private IRoleDAO rdao = new RoleDAO(mySql);

    @Test //GOOD TO GO
    public void createRole() throws SQLException {
        mySql.createConnection();
        del.deleteAllTables();

        RoleDTO role = new RoleDTO(1,"Admin");

        rdao.createRole(role);
        RoleDTO test = rdao.getRole(1);

        assertEquals(role.getRoleID(),test.getRoleID());
        assertEquals(role.getRoleNAME(),test.getRoleNAME());
        rdao.deleteRole(1);
        del.deleteAllTables();
        mySql.closeConnection(mySql.getConnection());
    }

    @Test //GOOD TO GO
    public void getRole() throws SQLException {
        mySql.createConnection();
        del.deleteAllTables();

        RoleDTO role = new RoleDTO(1,"Admin");
        rdao.createRole(role);

        RoleDTO test = rdao.getRole(role.getRoleID());

        assertEquals(role.getRoleID(),test.getRoleID());
        assertEquals(role.getRoleNAME(),test.getRoleNAME());
        rdao.deleteRole(role.getRoleID());
        del.deleteAllTables();
        mySql.closeConnection(mySql.getConnection());
    }

    @Test // GOOD TO GO
    public void getRoleList() throws SQLException {
        mySql.createConnection();
        del.deleteAllTables();

        List<RoleDTO> rlist = new ArrayList<>();
        RoleDTO r1 = new RoleDTO(1,"Admin");
        RoleDTO r2 = new RoleDTO(2,"Moderator");
        RoleDTO r3 = new RoleDTO(3,"Guest");
        rlist.add(r1);
        rlist.add(r2);
        rlist.add(r3);

        rdao.createRole(r1);
        rdao.createRole(r2);
        rdao.createRole(r3);

        List<RoleDTO> test = rdao.getRoleList();

        assertEquals(rlist.size(),test.size());
        for (int i = 0; i < rlist.size(); i++) {
            System.out.println("RLIST: roleid = " + rlist.get(i).getRoleID() + " TEST: roleid = " + test.get(i).getRoleID() + "\nRLIST: roleNAME = "
                    + rlist.get(i).getRoleNAME() + " TEST: roleNAME = " + test.get(i).getRoleNAME());
            assertEquals(rlist.get(i).getRoleID(),test.get(i).getRoleID());
            assertEquals(rlist.get(i).getRoleNAME(),test.get(i).getRoleNAME());
        }
        rdao.deleteRole(r1.getRoleID());
        rdao.deleteRole(r2.getRoleID());
        rdao.deleteRole(r3.getRoleID());
        del.deleteAllTables();
        mySql.closeConnection(mySql.getConnection());
    }

    @Test // GOOD TO GO
    public void updateRole() throws SQLException {
        mySql.createConnection();
        del.deleteAllTables();
        rdao.deleteRole(1);

        RoleDTO role = new RoleDTO(1,"Admin");
        assertTrue(rdao.createRole(role));
        RoleDTO t1 = rdao.getRole(role.getRoleID());
        System.out.println("t1: roleID = " + t1.getRoleID() + " roleNAME = " + t1.getRoleNAME());

        RoleDTO newRole = new RoleDTO(1,"Moderator");
        assertTrue(rdao.updateRole(newRole));
        RoleDTO t2 = rdao.getRole(role.getRoleID());
        System.out.println("t2: roleID = " + t2.getRoleID() + " roleNAME = " + t2.getRoleNAME());

        assertEquals(newRole.getRoleID(),t2.getRoleID());
        assertEquals(newRole.getRoleNAME(),t2.getRoleNAME());

        rdao.deleteRole(role.getRoleID());
        del.deleteAllTables();
        mySql.closeConnection(mySql.getConnection());
    }

    @Test //GOOD TO GO
    public void deleteRole() throws SQLException {
        mySql.createConnection();
        del.deleteAllTables();

        RoleDTO role = new RoleDTO(1,"Admin");
        rdao.createRole(role);

        RoleDTO test = rdao.getRole(role.getRoleID());

        assertEquals(1,test.getRoleID());
        assertEquals("Admin",test.getRoleNAME());

        rdao.deleteRole(test.getRoleID());
        test = rdao.getRole(1);

        assertNull(test.getRoleNAME());
        assertEquals(0, test.getRoleID());
        del.deleteAllTables();
        mySql.closeConnection(mySql.getConnection());
    }
}