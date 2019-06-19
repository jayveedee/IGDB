package Data.UserDAL;

import Data.UserDTO.RatingDTO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.util.List;

public interface IUserDAO {

    //CREATE
    boolean createUser                  (UserDTO user);
    boolean addToUserGameList           (String userID, int gameID);
    boolean addRatingToGame             (RatingDTO rating, int gameID);

    //READ
    UserDTO getUser                     (String userNAME);
    List<UserDTO> getUserList();
    List<RoleDTO> getUserRoleList       (String userNAME);
    List<Integer> getUserGameList       (String userNAME);

    //UPDATE
    boolean updateUserInfo              (UserDTO newUser);
    boolean updateSpecificUserRole      (String userNAME, int roleID);
    boolean promoteUserPermissions      (UserDTO userDTO);

    //DELETE
    boolean deleteUser                  (String userNAME);
    boolean deleteAllUserRoles          (String userNAME);
    boolean deleteAllUserGameLists      (String userName);
}
