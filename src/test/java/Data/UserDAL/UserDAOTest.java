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

import javax.management.relation.RoleList;
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
    public void getUserList() throws SQLException {
        mySql.createConnection();
        List<Integer>GameLIST = new ArrayList<>();
        List<RoleDTO>RoleLIST = new ArrayList<>();
        RoleDTO Role1 = new RoleDTO();
        RoleDTO Role2 = new RoleDTO();
        Role1.setRoleID(400);
        Role1.setRoleNAME("WOOOW");
        Role2.setRoleID(420);
        Role2.setRoleNAME("WOOOOOOW");

        RoleLIST.add(Role1);
        RoleLIST.add(Role2);


        UserDTO user1 = new UserDTO();
        UserDTO user2 = new UserDTO();
        UserDTO user3 = new UserDTO();
        user1.setUserNAME("Asama");
        user1.setUserPASS("123456Asama");
        user1.setUserEMAIL("aaaaa@derr.com");
        user1.setUserGAMEs(GameLIST);
        user1.setUserROLEs(RoleLIST);
        user1.setUserPFP("terer");


        user2.setUserNAME("Simon");
        user2.setUserPASS("1281Gahshefa");
        user2.setUserEMAIL("Weadfeafe@faef.com");
        user2.setUserGAMEs(GameLIST);
        user2.setUserROLEs(RoleLIST);
        user2.setUserPFP("unafu");

        user3.setUserNAME("Thaer");
        user3.setUserPASS("bN21345d445");
        user3.setUserEMAIL("thaeeu@dg.efee");
        user3.setUserGAMEs(GameLIST);
        user3.setUserROLEs(RoleLIST);
        user3.setUserPFP("fasf3af");

        rdao.createRole(Role1);
        rdao.createRole(Role2);

        udao.createUser(user1);
        udao.createUser(user2);
        udao.createUser(user3);

        List<UserDTO> userLIST = udao.getUserList();

        List<UserDTO> testUserLIST = new ArrayList<>();
        testUserLIST.add(user1);
        testUserLIST.add(user2);
        testUserLIST.add(user3);

        assertEquals(testUserLIST.size(),userLIST.size());

        for (int i = 0; i < testUserLIST.size(); i++) {
            assertEquals(testUserLIST.get(i).getUserNAME(),userLIST.get(i).getUserNAME());
            assertEquals(testUserLIST.get(i).getUserPASS(), userLIST.get(i).getUserPASS());
            assertEquals(testUserLIST.get(i).getUserEMAIL(),userLIST.get(i).getUserEMAIL());
            for (int j = 0; j < testUserLIST.get(i).getUserROLEs().size(); j++) {
                assertEquals(testUserLIST.get(i).getUserROLEs().get(j).getRoleID(),userLIST.get(i).getUserROLEs().get(j).getRoleID());
                assertEquals(testUserLIST.get(i).getUserROLEs().get(j).getRoleNAME(),userLIST.get(i).getUserROLEs().get(j).getRoleNAME());
            }
            assertEquals(testUserLIST.get(i).getUserPFP(), userLIST.get(i).getUserPFP());
            assertTrue(testUserLIST.get(i).getUserGAMEs().isEmpty());
        }

        udao.deleteAllUserRoles(user1.getUserNAME());
        udao.deleteAllUserRoles(user2.getUserNAME());
        udao.deleteAllUserRoles(user3.getUserNAME());

        udao.deleteUser(user1.getUserNAME());
        udao.deleteUser(user2.getUserNAME());
        udao.deleteUser(user3.getUserNAME());

        rdao.deleteRole(Role1.getRoleID());
        rdao.deleteRole(Role2.getRoleID());
    }

    @Test
    public void getUserRoleList() throws SQLException {
        mySql.createConnection();
        List<Integer>GameLIST = new ArrayList<>();
        List<RoleDTO>RoleLIST = new ArrayList<>();
        RoleDTO Role1 = new RoleDTO();
        RoleDTO Role2 = new RoleDTO();
        Role1.setRoleID(400);
        Role1.setRoleNAME("WOOOW");
        Role2.setRoleID(420);
        Role2.setRoleNAME("WOOOOOOW");

        RoleLIST.add(Role1);
        RoleLIST.add(Role2);

        UserDTO user1 = new UserDTO();

        user1.setUserNAME("Asama");
        user1.setUserPASS("123456Asama");
        user1.setUserEMAIL("aaaaa@derr.com");
        user1.setUserGAMEs(GameLIST);
        user1.setUserROLEs(RoleLIST);
        user1.setUserPFP("terer");

        rdao.createRole(Role1);
        rdao.createRole(Role2);
        udao.createUser(user1);

        List<RoleDTO> TestRoleLIST = udao.getUserRoleList(user1.getUserNAME());

        assertEquals(RoleLIST.size(), TestRoleLIST.size());
        for (int i = 0; i < RoleLIST.size(); i++) {
            assertEquals(RoleLIST.get(i).getRoleNAME(),TestRoleLIST.get(i).getRoleNAME());
            assertEquals(RoleLIST.get(i).getRoleID(),TestRoleLIST.get(i).getRoleID());
        }
        udao.deleteAllUserRoles(user1.getUserNAME());
        udao.deleteUser(user1.getUserNAME());
        rdao.deleteRole(Role1.getRoleID());
        rdao.deleteRole(Role2.getRoleID());


    }

    @Test
    public void getUserGameList() throws SQLException {
        mySql.createConnection();



    }

    @Test
    public void updateUserInfo() throws SQLException {

        mySql.createConnection();
        List<Integer>GameLIST = new ArrayList<>();
        List<RoleDTO>RoleLIST = new ArrayList<>();
        RoleDTO Role1 = new RoleDTO();
        RoleDTO Role2 = new RoleDTO();
        Role1.setRoleID(400);
        Role1.setRoleNAME("WOOOW");
        Role2.setRoleID(420);
        Role2.setRoleNAME("WOOOOOOW");

        RoleLIST.add(Role1);
        RoleLIST.add(Role2);

        UserDTO user1 = new UserDTO();
        user1.setUserNAME("Asama");
        user1.setUserPASS("123456Asama");
        user1.setUserEMAIL("aaaaa@derr.com");
        user1.setUserGAMEs(GameLIST);
        user1.setUserROLEs(RoleLIST);
        user1.setUserPFP("terer");

        rdao.createRole(Role1);
        rdao.createRole(Role2);
        udao.createUser(user1);

        UserDTO newUser = new UserDTO("Asama","asdasdasd","asdasdasd",GameLIST,RoleLIST,"asdasdasd");
        assertTrue(udao.updateUserInfo(newUser));
        UserDTO updatedUser = udao.getUser(user1.getUserNAME());

        assertEquals(newUser.getUserPASS(), updatedUser.getUserPASS());
        assertEquals(newUser.getUserEMAIL(), updatedUser.getUserEMAIL());
        assertTrue(newUser.getUserGAMEs().isEmpty() && updatedUser.getUserGAMEs().isEmpty());
        for (int i = 0; i < RoleLIST.size(); i++) {
            assertEquals(newUser.getUserROLEs().get(i).getRoleID(),updatedUser.getUserROLEs().get(i).getRoleID());
            assertEquals(newUser.getUserROLEs().get(i).getRoleNAME(),updatedUser.getUserROLEs().get(i).getRoleNAME());
        }
        assertEquals(newUser.getUserPFP(),updatedUser.getUserPFP());

        udao.deleteAllUserRoles(newUser.getUserNAME());
        udao.deleteUser(newUser.getUserNAME());
        rdao.deleteRole(Role1.getRoleID());
        rdao.deleteRole(Role2.getRoleID());



    }

    @Test
    public void updateSpecificUserRole() throws SQLException {
        mySql.createConnection();
        List<Integer>GameLIST = new ArrayList<>();
        List<RoleDTO>RoleLIST = new ArrayList<>();
        RoleDTO Role1 = new RoleDTO();
        RoleDTO Role2 = new RoleDTO();
        RoleDTO newRole = new RoleDTO(520,"kek");
        Role1.setRoleID(400);
        Role1.setRoleNAME("WOOOW");
        Role2.setRoleID(420);
        Role2.setRoleNAME("WOOOOOOW");

        RoleLIST.add(Role1);
        RoleLIST.add(Role2);


        UserDTO user1 = new UserDTO();

        user1.setUserNAME("Asama");
        user1.setUserPASS("123456Asama");
        user1.setUserEMAIL("aaaaa@derr.com");
        user1.setUserGAMEs(GameLIST);
        user1.setUserROLEs(RoleLIST);
        user1.setUserPFP("terer");

        rdao.createRole(newRole);
        rdao.createRole(Role1);
        rdao.createRole(Role2);
        udao.createUser(user1);

        udao.updateSpecificUserRole(user1.getUserNAME(),newRole);
        RoleDTO testRole = rdao.getRole(newRole.getRoleID());
        UserDTO testUser = udao.getUser(user1.getUserNAME());

        assertEquals(newRole.getRoleNAME(),testRole.getRoleNAME());
        assertEquals(newRole.getRoleID(),testRole.getRoleID());
        assertEquals(2,testUser.getUserROLEs().size());
        for (int i = 0; i < testUser.getUserROLEs().size(); i++) {
            System.out.println(testUser.getUserROLEs().get(i).getRoleID());
            System.out.println(testUser.getUserROLEs().get(i).getRoleNAME());
        }

        udao.deleteAllUserRoles(user1.getUserNAME());
        rdao.deleteRole(Role1.getRoleID());
        rdao.deleteRole(Role2.getRoleID());
        rdao.deleteRole(newRole.getRoleID());
        udao.deleteUser(user1.getUserNAME());
    }

    @Test
    public void deleteUser() throws SQLException {
        mySql.createConnection();

        List<Integer>GameLIST = new ArrayList<>();
        List<RoleDTO>RoleLIST = new ArrayList<>();
        RoleDTO Role1 = new RoleDTO();
        RoleDTO Role2 = new RoleDTO();
        Role1.setRoleID(400);
        Role1.setRoleNAME("WOOOW");
        Role2.setRoleID(420);
        Role2.setRoleNAME("WOOOOOOW");

        RoleLIST.add(Role1);
        RoleLIST.add(Role2);


        UserDTO user1 = new UserDTO();

        user1.setUserNAME("Asama");
        user1.setUserPASS("123456Asama");
        user1.setUserEMAIL("aaaaa@derr.com");
        user1.setUserGAMEs(GameLIST);
        user1.setUserROLEs(RoleLIST);
        user1.setUserPFP("terer");


        rdao.createRole(Role1);
        rdao.createRole(Role2);
        udao.createUser(user1);

        assertTrue(udao.deleteUser(user1.getUserNAME()));

        UserDTO testDeleteUser = udao.getUser(user1.getUserNAME());
        assertNull(testDeleteUser.getUserNAME());
        assertNull(testDeleteUser.getUserPFP());
        assertNull(testDeleteUser.getUserEMAIL());
        assertNull(testDeleteUser.getUserPASS());
        assertTrue(testDeleteUser.getUserROLEs().isEmpty());
        assertTrue(testDeleteUser.getUserGAMEs().isEmpty());

        rdao.deleteRole(Role1.getRoleID());
        rdao.deleteRole(Role2.getRoleID());
    }

    @Test
    public void deleteAllUserRoles() throws SQLException {
        mySql.createConnection();
        List<Integer>GameLIST = new ArrayList<>();
        List<RoleDTO>RoleLIST = new ArrayList<>();
        RoleDTO Role1 = new RoleDTO();
        RoleDTO Role2 = new RoleDTO();
        Role1.setRoleID(400);
        Role1.setRoleNAME("WOOOW");
        Role2.setRoleID(420);
        Role2.setRoleNAME("WOOOOOOW");

        RoleLIST.add(Role1);
        RoleLIST.add(Role2);

        UserDTO user1 = new UserDTO();

        user1.setUserNAME("Asama");
        user1.setUserPASS("123456Asama");
        user1.setUserEMAIL("aaaaa@derr.com");
        user1.setUserGAMEs(GameLIST);
        user1.setUserROLEs(RoleLIST);
        user1.setUserPFP("terer");

        rdao.createRole(Role1);
        rdao.createRole(Role2);
        udao.createUser(user1);

        assertTrue(udao.deleteAllUserRoles(user1.getUserNAME()));
        assertTrue(udao.deleteUser(user1.getUserNAME()));
        rdao.deleteRole(Role1.getRoleID());
        rdao.deleteRole(Role2.getRoleID());
    }

    @Test
    public void deleteAllUserGameLists() throws SQLException {
        mySql.createConnection();



    }
}