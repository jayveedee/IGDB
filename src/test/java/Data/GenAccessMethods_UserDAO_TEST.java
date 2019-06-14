package Data;

import Data.UserDAL.RoleDAO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class GenAccessMethods_UserDAO_TEST {

    private IMysqlConnection mySql = new MysqlConnection();
    private RoleDAO rdao = new RoleDAO(mySql);

    public List<RoleDTO> createRoleList() {
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

    // Hjælpe metoder
    public RoleDTO createRoleDB() {
        RoleDTO role = new RoleDTO();
        role.setRoleNAME("TEST");
        role.setRoleID(100);
        return role;
    }

    // Hjælpe metoder
    public UserDTO createUserDB(List<Integer> gameList, List<RoleDTO> roleList) {
        UserDTO user = new UserDTO();
        user.setUserNAME("TEST");
        user.setUserPASS("TEST");
        user.setUserEMAIL("YEST@TEST.TEST");
        user.setUserPFP("www.TEST.com/TEST.png");
        user.setUserGAMEs(gameList);
        user.setUserROLEs(roleList);
        return user;
    }
}
