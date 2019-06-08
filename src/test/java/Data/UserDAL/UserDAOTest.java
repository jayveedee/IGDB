package Data.UserDAL;

import Data.GameDAL.GameDAO;
import Data.GameDTO.Development.Company.DeveloperDTO;
import Data.GameDTO.Development.Company.PublisherDTO;
import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.WriterDTO;
import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.DateDTO;
import Data.GameDTO.Info.SoundtrackDTO;
import Data.IMysqlConnection;
import Data.MysqlConnection;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDAOTest {

    private IMysqlConnection mySql = new MysqlConnection();
    private UserDAO udao = new UserDAO(mySql);
    private RoleDAO rdao = new RoleDAO(mySql);
    private GameDAO gdao = new GameDAO(mySql);


    private List<RoleDTO> createRoleList() {
        RoleDTO test1 = new RoleDTO(1,"TEST");
        RoleDTO test2 = new RoleDTO(2,"TEST");
        RoleDTO test3 = new RoleDTO(3,"TEST");
        rdao.createRole(test1);
        rdao.createRole(test2);
        rdao.createRole(test3);
        List<RoleDTO> roleList = new ArrayList<>();
        roleList.add(test1);
        roleList.add(test2);
        roleList.add(test3);
        return roleList;
    }

    @Test // GOOD TO GO
    public void createUserDB() throws SQLException {
        mySql.createConnection();

        List<Integer> gameList = null;
        List<RoleDTO> roleList = createRoleList();

        UserDTO user = createUserDB(gameList, roleList);
        RoleDTO role = createRoleDB();
        rdao.createRole(role);
        udao.createUser(user);
        UserDTO testUser = udao.getUser(user.getUserNAME());
        assertEquals(user.getUserNAME(),testUser.getUserNAME());
        assertEquals(user.getUserPFP(),testUser.getUserPFP());
        assertEquals(user.getUserPASS(),testUser.getUserPASS());
        assertEquals(user.getUserEMAIL(),testUser.getUserEMAIL());
        List<RoleDTO> testRoleList = udao.getUserRoleList(user.getUserNAME());
        assertEquals(roleList.size(),testRoleList.size());
        for (int i = 0; i < roleList.size(); i++) {
            assertEquals(roleList.get(i).getRoleNAME(),testRoleList.get(i).getRoleNAME());
            assertEquals(roleList.get(i).getRoleID(),testRoleList.get(i).getRoleID());
        }
        assertTrue(udao.deleteAllUserRoles(user.getUserNAME()));
        assertTrue(udao.deleteUser(user.getUserNAME()));
        assertTrue(rdao.deleteRole(role.getRoleID()));
        for (int i = 0; i < roleList.size(); i++) {
            assertTrue(rdao.deleteRole(roleList.get(i).getRoleID()));
        }
    }

          // Hjælpe metoder
    private RoleDTO createRoleDB() {
        RoleDTO role = new RoleDTO();
        role.setRoleNAME("TEST");
        role.setRoleID(100);
        return role;
    }

          // Hjælpe metoder
    private UserDTO createUserDB(List<Integer> gameList, List<RoleDTO> roleList) {
        UserDTO user = new UserDTO();
        user.setUserNAME("TEST");
        user.setUserPASS("TEST");
        user.setUserEMAIL("YEST@TEST.TEST");
        user.setUserPFP("www.TEST.com/TEST.png");
        user.setUserGAMEs(gameList);
        user.setUserROLEs(roleList);
        return user;
    }

    @Test // GOOD TO GO
    public void getUser() throws SQLException {
        mySql.createConnection();
        List<Integer> gameList = null;
        List<RoleDTO> roleList = createRoleList();

        UserDTO user = createUserDB(gameList, roleList);
        RoleDTO role = createRoleDB();
        rdao.createRole(role);
        udao.createUser(user);
        UserDTO testUser = udao.getUser(user.getUserNAME());
        assertEquals(user.getUserNAME(),testUser.getUserNAME());
        assertEquals(user.getUserPFP(),testUser.getUserPFP());
        assertEquals(user.getUserPASS(),testUser.getUserPASS());
        assertEquals(user.getUserEMAIL(),testUser.getUserEMAIL());
        List<RoleDTO> testRoleList = udao.getUserRoleList(user.getUserNAME());
        assertEquals(roleList.size(),testRoleList.size());
        for (int i = 0; i < roleList.size(); i++) {
            assertEquals(roleList.get(i).getRoleNAME(),testRoleList.get(i).getRoleNAME());
            assertEquals(roleList.get(i).getRoleID(),testRoleList.get(i).getRoleID());
        }
        assertTrue(udao.deleteAllUserRoles(user.getUserNAME()));
        assertTrue(udao.deleteUser(user.getUserNAME()));
        assertTrue(rdao.deleteRole(role.getRoleID()));
        for (int i = 0; i < roleList.size(); i++) {
            assertTrue(rdao.deleteRole(roleList.get(i).getRoleID()));
        }
    }

    @Test
    public void addToUserGameList() throws SQLException {
        mySql.createConnection();

        List<Integer> gameList = null;
        List<RoleDTO> roleList = createRoleList();

        UserDTO user = createUserGameList(gameList, roleList);
        RoleDTO role = createRoleDB();
        for (int i = 0; i < gameList.size(); i++) {
            GameDTO game = createGameDB(gameList.get(i));
        }
        rdao.createRole(role);
        udao.createUser(user);
    }

    private GameDTO createGameDB(int gameID) {
        GameDTO game = new GameDTO();
        DateDTO date = null;
        WriterDTO writer = null;
        DeveloperDTO dev = null;
        PublisherDTO pub = null;
        ComposerDTO comp = null;
        SoundtrackDTO ost = null;

        List<Integer> gameCHARs = null;
        List<Integer> gameGENREs = null;
        List<Integer> gameACTOR = null;
        List<Integer> gameRATING = null;
        List<Integer> gameGAMEMODE = null;
        List<Integer> gameTRAILER = null;
        List<Integer> gamePics = null;

        game.setGameID(gameID);
        game.setGameBG("INSERT BACKGROUND URL");
        game.setGameBIO("INSERT DESCRIPTION HERE");
        game.setGameNAME("INSERT GAME TITLE HERE");
        game.setGameCOMP(comp);
        game.setGameDEV(dev);
        game.setGameOST(ost);
        game.setGamePUB(pub);
        game.setGameRELEASEDATE(date);
        game.setGameWRI(writer);
        game.setGameACs(gameACTOR);
        game.setGameCHs(gameCHARs);
        game.setGameGENREs(gameGENREs);
        game.setGameGMs(gameGAMEMODE);
        game.setGamePICs(gamePics);
        game.setGameRATINGs(gameRATING);
        game.setGameTRAILERs(gameTRAILER);
        gdao.createGame(game);

        return game;
    }

    private UserDTO createUserGameList(List<Integer> gameList, List<RoleDTO> roleList) {
        UserDTO user = createUserDB(gameList, roleList);
        gameList.add(1);
        gameList.add(2);
        gameList.add(3);
        user.setUserGAMEs(gameList);
        return user;
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
    public void updateSpecificUserRole() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void deleteAllUserRoles() {
    }

    @Test
    public void deleteAllUserGameLists() {
    }
}