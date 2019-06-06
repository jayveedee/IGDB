package Data.UserDAL;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Development.ActorDTO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.DateDTO;
import Data.GameDTO.Info.RatingDTO;
import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO_TEST {

    @org.junit.Test
    public void createUser() throws SQLException {
        IMysqlConnection mysql = new MysqlConnection();
        mysql.createConnection();
        UserDAO udao = new UserDAO(mysql);
        RoleDAO rdao = new RoleDAO(mysql);

        RoleDTO r1 = new RoleDTO(1,"Normal User");
        RoleDTO r2 = new RoleDTO(2,"Editing User");
        RoleDTO r3 = new RoleDTO(3,"Moderator");
        RoleDTO r4 = new RoleDTO(4,"Administrator");

        rdao.createRole(r1);
        rdao.createRole(r2);
        rdao.createRole(r3);
        rdao.createRole(r4);

        ArrayList<RoleDTO> rlist = new ArrayList<>();
        rlist.add(r1);
        rlist.add(r2);
        rlist.add(r3);
        rlist.add(r4);

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
