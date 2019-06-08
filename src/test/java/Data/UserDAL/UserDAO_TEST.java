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
import java.util.Collections;
import java.util.List;

public class UserDAO_TEST {

    private IMysqlConnection mySql = new MysqlConnection();
    private UserDAO udao = new UserDAO(mySql);
    private RoleDAO rdao = new RoleDAO(mySql);
   // private GameDAO gdao = new GameDAO(mySql);


    private List<RoleDTO> addRolesToDB() {
        RoleDTO r1 = new RoleDTO(1,"Normal User");
        RoleDTO r2 = new RoleDTO(2,"Editing User");
        List<RoleDTO> roleList = new ArrayList<>();
        roleList.add(r1);
        roleList.add(r2);

        rdao.createRole(r1);
        rdao.createRole(r2);

        return roleList;
    }
    private UserDTO addUserToDB(String userName, List<RoleDTO> roleList, List<Integer> gameList) {
        UserDTO u1 = new UserDTO(userName,"Password1","email@email.com1",gameList,roleList,"www.billede1.pic1");
        udao.createUser(u1);
        return u1;
    }
    private List<UserDTO> addUserListToDB() {
        List<RoleDTO> rlist = addRolesToDB();
        List<Integer> gmlist = null;
        List<UserDTO> ulist = new ArrayList<>();
        UserDTO u1 = addUserToDB("test1",rlist,gmlist);
        UserDTO u2 = addUserToDB("test2",rlist,gmlist);
        UserDTO u3 = addUserToDB("test3",rlist,gmlist);
        u1.setUserGAMEs(addGameListToDB(u1.getUserNAME()));
        u2.setUserGAMEs(addGameListToDB(u2.getUserNAME()));
        u3.setUserGAMEs(addGameListToDB(u3.getUserNAME()));
        ulist.add(u1);
        ulist.add(u2);
        ulist.add(u3);
        return ulist;
    }
    private List<Integer> addGameListToDB(String userName) {
        GameDTO gameID1 = addGameToDB(22);
        GameDTO gameID2 = addGameToDB(31);
        GameDTO gameID3 = addGameToDB(66);
        GameDTO gameID4 = addGameToDB(77);
        udao.addToUserGameList(userName,gameID1.getGameID());
        udao.addToUserGameList(userName,gameID2.getGameID());
        udao.addToUserGameList(userName,gameID3.getGameID());
        udao.addToUserGameList(userName,gameID4.getGameID());
        ArrayList<Integer> gmlist = new ArrayList<>();
        gmlist.add(gameID1.getGameID());
        gmlist.add(gameID2.getGameID());
        gmlist.add(gameID3.getGameID());
        gmlist.add(gameID4.getGameID());
        Collections.sort(gmlist);
        return gmlist;
    }
    private GameDTO addGameToDB(int gameID){
        GameDTO game = new GameDTO();
        String gameNAME = "TEST";
        List<Integer> gameCHAR;
        List<Integer> gameACTER;
        List<Integer> gameGENRE;
        List<Integer> gameGAMEMODE;
        DateDTO gameCREATED;
        WriterDTO gameWRITER;
        DeveloperDTO gameDEV;
        PublisherDTO gamePUB;
        ComposerDTO gameCOMP;
        SoundtrackDTO gameOST;
        String gameCOVER;
        String gameBG;
        String gameBIO;
        List<Integer> gameTRAILER;
        return game;
    }

    private void deleteTestRoles() {
        udao.deleteAllUserRoles("Jakup1");
        udao.deleteAllUserRoles("Jakup2");
        udao.deleteAllUserRoles("Jakup3");
        rdao.deleteRole(1);
        rdao.deleteRole(2);
    }

    @Test
    public void createUser() throws SQLException {
        mySql.createConnection();

        List<RoleDTO> roleList = addRolesToDB();
        List<Integer> gameList = null;
        UserDTO user = addUserToDB("test",roleList,gameList);
        gameList = addGameListToDB(user.getUserNAME());
        user.setUserGAMEs(gameList);
    }

    @Test
    public void getUser() throws SQLException {
        mySql.createConnection();
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
