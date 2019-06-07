package Data.UserDAL;

import Data.UserDTO.UserDTO;

import java.util.List;

public interface IUserDAO {

    boolean createUser(UserDTO user);
    UserDTO getUser(String userNAME);
    List<UserDTO> getUserList();
    List<Integer> getUGameLIST(String userNAME);
    boolean updateUserInfo(UserDTO newUser);
    boolean deleteUser(String userNAME);
}
