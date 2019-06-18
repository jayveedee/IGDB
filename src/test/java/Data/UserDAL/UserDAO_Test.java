package Data.UserDAL;

import Data.*;
import Data.GameDAL.GameDAO;
import Data.GameDTO.GameDTO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserDAO_Test {

    private GenAccessMethods_UserDAO_TEST   a                   = new GenAccessMethods_UserDAO_TEST();
    private GenAccessMethods_GameDAO_TEST   g                   = new GenAccessMethods_GameDAO_TEST();
    private IMysqlConnection                mySql               = new MysqlConnection();

    private GenAccessTestMethods del                 = new GenAccessTestMethods();
    private UserDAO udao                = new UserDAO(mySql);
    private RoleDAO rdao                = new RoleDAO(mySql);
    private GameDAO                         gdao                = new GameDAO(mySql);


    @Test // GOOD TO GO
    public void createUserDB() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
            List<Integer> gameList = new ArrayList<>();
            List<RoleDTO> roleList = a.createRoleList();

            UserDTO user = a.createUserDB("KEK",gameList, roleList);
            RoleDTO role = a.createRoleDB();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test // GOOD TO GO
    public void getUser() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
            List<Integer> gameList = new ArrayList<>();
            List<RoleDTO> roleList = a.createRoleList();

            UserDTO user = a.createUserDB("KEKKKER",gameList, roleList);
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
            for (int i = 0; i < roleList.size(); i++) {
                assertTrue(rdao.deleteRole(roleList.get(i).getRoleID()));
            }
            del.deleteAllTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test   // GOOD TO GO %%
    public void addToUserGameList() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();

            List<Integer> GameList = new ArrayList<>();
            List<RoleDTO> RoleList = new ArrayList<>();

            RoleDTO Role1 = new RoleDTO();
            RoleDTO Role2 = new RoleDTO();
            GameDTO g1 = g.createGameDB(444,"TEST12");

            Role1.setRoleID(100);       Role1.setRoleNAME("YAJ");
            Role2.setRoleID(110);       Role2.setRoleNAME("UJU");
            RoleList.add(Role1);
            RoleList.add(Role2);

            UserDTO u1 = new UserDTO();
            u1.setUserNAME("Yam");
            u1.setUserPASS("uaau");
            u1.setUserPFP("iuf");
            u1.setUserEMAIL("Eref");
            u1.setUserROLEs(RoleList);
            u1.setUserGAMEs(GameList);

            gdao.createGame(g1);
            rdao.createRole(Role1);
            rdao.createRole(Role2);
            udao.createUser(u1);

            assertTrue(udao.addToUserGameList(u1.getUserNAME(),g1.getGameID()));

            udao.deleteAllUserRoles(u1.getUserNAME());
            udao.deleteAllUserGameLists(u1.getUserNAME());
            udao.deleteUser(u1.getUserNAME());
            rdao.deleteRole(Role1.getRoleID());
            rdao.deleteRole(Role2.getRoleID());
            gdao.deleteGame(g1.getGameID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test // GOOD TO GO
    public void getUserList() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test // GOOD TO GO
    public void getUserRoleList() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test // GOOD TO GO
    public void getUserGameList() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();

            List<RoleDTO> rlist = new ArrayList<>();
            List<Integer> gmlist = new ArrayList<>();


            RoleDTO r1 = new RoleDTO(1,"kek");
            RoleDTO r2 = new RoleDTO(2,"asd");
            rlist.add(r1);
            rlist.add(r2);
            UserDTO u1 = new UserDTO();
            GameDTO g1 = g.createGameDB(500,"list1");
            GameDTO g2 = g.createGameDB(501,"list2");
            GameDTO g3 = g.createGameDB(502,"list3");
            gmlist.add(g1.getGameID());
            gmlist.add(g2.getGameID());
            gmlist.add(g3.getGameID());
            u1.setUserNAME("test");
            u1.setUserPASS("test32");
            u1.setUserEMAIL("test");
            u1.setUserPFP("test");
            u1.setUserGAMEs(gmlist);
            u1.setUserROLEs(rlist);

            gdao.createGame(g1);
            gdao.createGame(g2);
            gdao.createGame(g3);
            rdao.createRole(r1);
            rdao.createRole(r2);
            udao.createUser(u1);
            udao.addToUserGameList(u1.getUserNAME(),500);
            udao.addToUserGameList(u1.getUserNAME(),501);
            udao.addToUserGameList(u1.getUserNAME(),502);

            List<Integer> testGameList = udao.getUserGameList(u1.getUserNAME());
            for (int i = 0; i < gmlist.size(); i++) {
                assertEquals(gmlist.get(i),testGameList.get(i));
            }
            assertEquals(gmlist.size(),testGameList.size());

            udao.deleteAllUserRoles(u1.getUserNAME());
            udao.deleteAllUserGameLists(u1.getUserNAME());
            udao.deleteUser(u1.getUserNAME());
            rdao.deleteRole(r1.getRoleID());
            rdao.deleteRole(r2.getRoleID());
            gdao.deleteGame(g1.getGameID());
            gdao.deleteGame(g2.getGameID());
            gdao.deleteGame(g3.getGameID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test // GOOD TO GO
    public void updateUserInfo() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test // GOOD TO GO
    public void updateSpecificUserRole() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
            List<Integer>GameLIST = new ArrayList<>();
            List<RoleDTO>RoleLIST = new ArrayList<>();
            RoleDTO Role1 = new RoleDTO();
            RoleDTO Role2 = new RoleDTO();
            RoleDTO newRole = new RoleDTO(420,"kek");
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

            udao.updateSpecificUserRole(user1.getUserNAME(),newRole.getRoleID());
            RoleDTO role132 = rdao.getSpecificRole(newRole.getRoleID(),user1.getUserNAME());
            assertEquals(newRole.getRoleID(),role132.getRoleID());

            udao.deleteAllUserRoles(user1.getUserNAME());
            rdao.deleteRole(Role1.getRoleID());
            rdao.deleteRole(Role2.getRoleID());
            rdao.deleteRole(newRole.getRoleID());
            udao.deleteUser(user1.getUserNAME());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test // GOOD TO GO
    public void deleteUser() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test // GOOD TO GO
    public void deleteAllUserRoles() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test  // GOOD TO GO
    public void deleteAllUserGameLists() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
            List<Integer> GameList = new ArrayList<>();
            List<RoleDTO> RoleList = new ArrayList<>();

            RoleDTO R1 = new RoleDTO();
            RoleDTO R2 = new RoleDTO();
            GameDTO G1 = g.createGameDB(101,"TEST");


            R1.setRoleID(200);     R1.setRoleNAME("JUJ");
            R2.setRoleID(220);     R2.setRoleNAME("UJU");
            RoleList.add(R1);
            RoleList.add(R2);

            UserDTO U1 = new UserDTO();
            U1.setUserNAME("WOOM");
            U1.setUserPASS("sdad");
            U1.setUserEMAIL("Sfadf");
            U1.setUserPFP("rafa");
            U1.setUserROLEs(RoleList);
            U1.setUserGAMEs(GameList);

            rdao.createRole(R1);
            rdao.createRole(R2);
            udao.createUser(U1);
            gdao.createGame(G1);
            udao.addToUserGameList(U1.getUserNAME(),G1.getGameID());

            assertTrue(udao.deleteAllUserGameLists(U1.getUserNAME()));

            udao.deleteAllUserRoles(U1.getUserNAME());
            udao.deleteAllUserGameLists(U1.getUserNAME());
            udao.deleteUser(U1.getUserNAME());
            rdao.deleteRole(R1.getRoleID());
            rdao.deleteRole(R2.getRoleID());
            gdao.deleteGame(G1.getGameID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


