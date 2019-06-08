package Data.UserDAL;

import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;
import org.junit.Test;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO_TEST {

    private IMysqlConnection mySql = new MysqlConnection();
    private UserDAO udao = new UserDAO(mySql);
    private RoleDAO rdao = new RoleDAO(mySql);


    private List<RoleDTO> addTestRolesToDB() {
        RoleDTO r1 = new RoleDTO(1,"Normal User");
        RoleDTO r2 = new RoleDTO(2,"Editing User");
        rdao.createRole(r1);
        rdao.createRole(r2);
        ArrayList<RoleDTO> rlist = testUserRoleLIST(r1, r2);
        return rlist;
    }
    private void deleteTestRoles() {
        udao.deleteAllUserRoles("Jakup1");
        udao.deleteAllUserRoles("Jakup2");
        udao.deleteAllUserRoles("Jakup3");
        rdao.deleteRole(1);
        rdao.deleteRole(2);
    }
    private List<UserDTO> addTestUsersToDB() {
        List<RoleDTO> rlist = addTestRolesToDB();
        List<Integer> gmlist = testUGameLIST();
        List<UserDTO> ulist = new ArrayList<>();
        UserDTO u1 = new UserDTO("Jakup1","Password1","email@email.com1",gmlist,rlist,"www.billede1.pic1");
        UserDTO u2 = new UserDTO("Jakup2","Password2","email@email.com2",gmlist,rlist,"www.billede1.pic2");
        UserDTO u3 = new UserDTO("Jakup3","Password3","email@email.com3",gmlist,rlist,"www.billede1.pic3");
        ulist.add(u1);
        ulist.add(u2);
        ulist.add(u3);
        return ulist;
    }
    private ArrayList<RoleDTO> testUserRoleLIST(RoleDTO r1, RoleDTO r2) {
        ArrayList<RoleDTO> rlist = new ArrayList<>();
        rlist.add(r1);
        rlist.add(r2);
        return rlist;
    }
    private ArrayList<Integer> testUGameLIST() {
        ArrayList<Integer> gmlist = new ArrayList<>();
        gmlist.add(20);
        gmlist.add(50);
        gmlist.add(33);
        return gmlist;
    }

    @Test
    public void createUser() throws SQLException {
        mySql.createConnection();

        List<RoleDTO> rlist = addTestRolesToDB();
        ArrayList<Integer> gmlist = testUGameLIST();
        UserDTO u = new UserDTO("Jakup","Password","email@email.com",gmlist,rlist,"www.billede1.pic");
        assertTrue(udao.createUser(u));
        System.out.println("u1: userNAME = " + u.getUserNAME() + " userEMAIL = " + u.getUserEMAIL() + " userPASS = " + u.getUserPASS() + " userPIC = " + u.getUserPFP());
        UserDTO t1 = udao.getUser(u.getUserNAME());
        System.out.println("t1: userNAME = " + t1.getUserNAME() + " userEMAIL = " + t1.getUserEMAIL() + " userPASS = " + t1.getUserPASS() + " userPIC = " + t1.getUserPFP());

        assertEquals(u.getUserEMAIL(),t1.getUserEMAIL());
        assertEquals(u.getUserNAME(),t1.getUserNAME());
        assertEquals(u.getUserPASS(),t1,t1.getUserPASS());
        assertEquals(u.getUserPFP(),t1.getUserPFP());
        for (int i = 0; i < rlist.size(); i++) {
            assertEquals(rlist.get(i).getRoleID(),);
            assertEquals(rlist.get(i).getRoleNAME(),);
        }
        for (int i = 0; i < gmlist.size(); i++) {
            assertEquals(gmlist.get(i),);
        }
        udao.deleteUser(u.getUserNAME());
        deleteTestRoles();
    }

    @Test
    public void getUser() throws SQLException {
        mySql.createConnection();

        List<RoleDTO> rlist = addTestRolesToDB();
        ArrayList<Integer> gmlist = testUGameLIST();

    }

    @Test
    public void getUserList() {
    }

    @Test
    public void getUserRoleList() {
    }

    @Test
    public void getUserGameList() {
    }

    @Test
    public void updateUserInfo() {
    }

    @Test
    public void updateSpecificUserRole(){
    }

    @Test
    public void deleteUser() {
    }
}
