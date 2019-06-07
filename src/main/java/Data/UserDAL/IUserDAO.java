package Data.UserDAL;

import Data.UserDTO.UserDTO;

import java.util.List;

public interface IUserDAO {

    void createUser(UserDTO user);
    UserDTO getUser(String userNAME);
    List<UserDTO> getUserList();
    List<Integer> getUGameLIST(String userNAME);
    void updateUser(String userNAME);
    void deleteUser(String userNAME);
}
