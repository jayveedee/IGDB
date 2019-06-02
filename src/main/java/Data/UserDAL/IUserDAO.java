package Data.UserDAL;

import Data.UserDTO.UserDTO;

import java.sql.Connection;
import java.util.List;

public interface IUserDAO {

    void createUser(UserDTO user);
    UserDTO getUser(int userid);
    List<UserDTO> getUserList();
    void updateUser(int userid);
    void deleteUser(int userid);
}
