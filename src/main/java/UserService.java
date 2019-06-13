import Data.IMysqlConnection;
import Data.UserDAL.IRoleDAO;
import Data.UserDAL.IUserDAO;
import Data.UserDAL.RoleDAO;
import Data.UserDAL.UserDAO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.util.ArrayList;

public class UserService {
    IMysqlConnection mySQL;

    public UserService(IMysqlConnection mySQL) {
        this.mySQL=mySQL;
    }

    //FIXME husk at gøre så useren bliver tildelt to roller som allerede eksisterer i databsen. nemlig: user og editor. Ved tilfælde af ban, mister useren sin editor-rolle (som står for redigering er artikler) men beholder user-rollen (som består af profil osv.)
    public boolean createUser(String username, String email, String password ){
        IUserDAO userDAO = new UserDAO(mySQL);
        IRoleDAO roleDAO = new RoleDAO(mySQL);
        UserDTO user = new UserDTO();
        RoleDTO role = new RoleDTO();

        role.setRoleID(2);
        role.setRoleNAME("User");

        ArrayList<RoleDTO> roleList = new ArrayList<>();
        roleList.add(role);

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

    public boolean updateUser(UserDTO user){
        IUserDAO userDAO = new UserDAO(mySQL);
        boolean answer = userDAO.updateUserInfo(user);
        return answer;
    }

    public String logIn(String username, String password){
        IUserDAO userDAO = new UserDAO(mySQL);
        UserDTO userDTO = userDAO.getUser(username);

        if (userDTO.getUserNAME()==null){
            System.out.println("hejsa");
            return "null";
        }

        if (!password.equals(userDTO.getUserPASS())){
            System.out.println("halojsa");
            return "null";
        }

        return userDTO.getUserNAME();
    }

}
