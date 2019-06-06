package Data.UserDAL;

import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserDAO_TEST {

    private IMysqlConnection mySql = new MysqlConnection();
    private UserDAO udao = new UserDAO(mySql);
    private RoleDAO rdao = new RoleDAO(mySql);

    @org.junit.Test
    public void createUser() throws SQLException {
        mySql.createConnection();

        RoleDTO r1 = new RoleDTO(1,"Normal User");
        RoleDTO r2 = new RoleDTO(2,"Editing User");
        rdao.createRole(r1);
        rdao.createRole(r2);

        ArrayList<RoleDTO> rlist = new ArrayList<>();
        rlist.add(r1);
        rlist.add(r2);

        ArrayList<Integer> gmlist = new ArrayList<>();
        gmlist.add(20);
        gmlist.add(50);
        gmlist.add(33);

        UserDTO u = new UserDTO("Jakup","Password","email@email.com",gmlist,rlist);
        udao.createUser(u);

    }

    @org.junit.Test
    public void getUser() {

    }

    @org.junit.Test
    public void getUserList() {
    }

    @org.junit.Test
    public void updateUser() {
    }

    @org.junit.Test
    public void deleteUser() {
    }
}
