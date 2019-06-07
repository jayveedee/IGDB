package Data.UserDAL;

import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDTO.RoleDTO;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RoleDAO_TEST {

    private IMysqlConnection mySql = new MysqlConnection();
    private IRolesDAO rdao = new RoleDAO(mySql);

    @Test //GOOD TO GO
    public void createRole() throws SQLException {
        mySql.createConnection();

        RoleDTO role = new RoleDTO(1,"Admin");

        rdao.createRole(role);
        RoleDTO test = rdao.getRole(1);

        assertEquals(role.getRoleID(),test.getRoleID());
        assertEquals(role.getRoleNAME(),test.getRoleNAME());
        rdao.deleteRole(1);
    }

    @Test //GOOD TO GO
    public void getRole() throws SQLException {
        mySql.createConnection();

        RoleDTO role = new RoleDTO(1,"Admin");
        rdao.createRole(role);

        RoleDTO test = rdao.getRole(role.getRoleID());

        assertEquals(role.getRoleID(),test.getRoleID());
        assertEquals(role.getRoleNAME(),test.getRoleNAME());
        rdao.deleteRole(role.getRoleID());
    }

    @Test // GOOD TO GO
    public void getRoleList() throws SQLException {
        mySql.createConnection();

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
    }

    @Test
    public void updateRole() {

    }

    @Test //GOOD TO GO
    public void deleteRole() throws SQLException {
        mySql.createConnection();

        RoleDTO role = new RoleDTO(1,"Admin");
        rdao.createRole(role);

        RoleDTO test = rdao.getRole(role.getRoleID());

        assertEquals(1,test.getRoleID());
        assertEquals("Admin",test.getRoleNAME());

        rdao.deleteRole(test.getRoleID());
        test = rdao.getRole(1);

        assertNull(test.getRoleNAME());
        assertEquals(0, test.getRoleID());
    }
}