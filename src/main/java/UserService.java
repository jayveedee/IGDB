import Data.IMysqlConnection;
import Data.UserDAL.IRoleDAO;
import Data.UserDAL.IUserDAO;
import Data.UserDAL.RoleDAO;
import Data.UserDAL.UserDAO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    IMysqlConnection mySQL;

    public UserService(IMysqlConnection mySQL) {
        this.mySQL=mySQL;
    }


    public boolean createUser(String username, String email, String password ){
        IUserDAO userDAO = new UserDAO(mySQL);
        IRoleDAO roleDAO = new RoleDAO(mySQL);
        UserDTO user = new UserDTO();
        RoleDTO role = new RoleDTO();
        RoleDTO role1 = new RoleDTO();

        role1.setRoleID(1);
        role1.setRoleNAME("Editor");

        role.setRoleID(2);
        role.setRoleNAME("User");

        ArrayList<RoleDTO> roleList = new ArrayList<>();
        roleList.add(role);
        roleList.add(role1);

        user.setUserEMAIL(email);
        user.setUserNAME(username);
        user.setUserPASS(password);
        user.setUserGAMEs(null);
        user.setUserROLEs(roleList);

        boolean answer = userDAO.createUser(user);

        return answer;
    }

    public UserDTO getUser(String username){
        IUserDAO userDAO = new UserDAO(mySQL);
        UserDTO user;
        user = userDAO.getUser(username);
        return user;
    }

    public boolean updateUser(UserDTO userDTO){
        IUserDAO userDAO = new UserDAO(mySQL);
        boolean answer = userDAO.updateUserInfo(userDTO);
        return answer;
    }

    public List<UserDTO> getUserList(){
        IUserDAO userDAO = new UserDAO(mySQL);
        List<UserDTO> userList = userDAO.getUserList();
        return userList;
    }

    public boolean removeUserPermissions(UserDTO user){
        IUserDAO userDAO = new UserDAO(mySQL);
        boolean answer = userDAO.deleteAllUserRoles(user.getUserNAME());
        return answer;
    }

    public boolean promoteUserPermissions(UserDTO user){
        IUserDAO userDAO = new UserDAO(mySQL);
        boolean answer = userDAO.promoteUserPermissions(user);
        return answer;
    }

    public UserDTO logIn(String username, String password){
        IUserDAO userDAO = new UserDAO(mySQL);
        UserDTO userDTO = userDAO.getUser(username);

        if (userDTO.getUserNAME()==null){
            userDTO.setUserNAME("usernameDoesNotExist");
            return userDTO;
        }

        if (!password.equals(userDTO.getUserPASS())){
            userDTO.setUserNAME("passwordIsWrong");
            return userDTO;
        }

        return userDTO;
    }

}
