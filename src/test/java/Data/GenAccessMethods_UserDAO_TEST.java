package Data;

import Data.GameDAL.GameDAO;
import Data.GameDTO.GameDTO;
import Data.UserDAL.RoleDAO;
import Data.UserDAL.UserDAO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GenAccessMethods_UserDAO_TEST {

    private IMysqlConnection mySql = new MysqlConnection();
    private GenAccessMethods_GameDAO_TEST g = new GenAccessMethods_GameDAO_TEST();
    private RoleDAO rdao = new RoleDAO(mySql);
    private GameDAO gdao = new GameDAO(mySql);
    private UserDAO udao = new UserDAO(mySql);

    public List<RoleDTO> createRoleList() {
        List<RoleDTO> roleList = new ArrayList<>();
        try (Connection c = mySql.createConnection()){
            RoleDTO test1 = new RoleDTO(1,"TEST");
            RoleDTO test2 = new RoleDTO(2,"TEST");
            RoleDTO test3 = new RoleDTO(3,"TEST");
            rdao.createRole(test1);
            rdao.createRole(test2);
            rdao.createRole(test3);
            roleList.add(test1);
            roleList.add(test2);
            roleList.add(test3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roleList;
    }

    public List<Integer> createUserGameList() {
        List<Integer> uglist = new ArrayList<>();
        try (Connection c = mySql.createConnection()){
            GameDTO game1 = g.createGameDB(44,"test");
            GameDTO game2 = g.createGameDB(55,"tetss");
            GameDTO game3 = g.createGameDB(66,"asdasd");
            uglist.add(game1.getGameID());
            uglist.add(game2.getGameID());
            uglist.add(game3.getGameID());
            gdao.createGame(game1);
            gdao.createGame(game2);
            gdao.createGame(game3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return uglist;
    }

    // Hjælpe metoder
    public RoleDTO createRoleDB() {
        RoleDTO role = new RoleDTO();
        role.setRoleNAME("TEST");
        role.setRoleID(100);
        return role;
    }

    // Hjælpe metoder
    public UserDTO createUserDB(String userNAME, List<Integer> gameList, List<RoleDTO> roleList) {
        UserDTO user = new UserDTO();
        user.setUserNAME(userNAME);
        user.setUserPASS("TEST");
        user.setUserEMAIL("YEST@TEST.TEST");
        user.setUserPFP("www.TEST.com/TEST.png");
        user.setUserGAMEs(gameList);
        user.setUserROLEs(roleList);
        return user;
    }
}
