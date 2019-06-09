package Data.UserDAL;

import Data.GameDTO.Info.RatingDTO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;

import java.util.List;

public interface IUserDAO {

    boolean createUser(UserDTO user);
    boolean addToUserGameList(String userID, int gameID);
    boolean addRatingToGame(RatingDTO rating, int gameID);
    UserDTO getUser(String userNAME);
    List<UserDTO> getUserList();
    List<RoleDTO> getUserRoleList(String userNAME);
    List<Integer> getUserGameList(String userNAME);
    boolean updateUserInfo(UserDTO newUser);
    boolean updateSpecificUserRole(String userNAME, RoleDTO newRole);
    boolean deleteUser(String userNAME);
    boolean deleteAllUserRoles(String userNAME);
    boolean deleteAllUserGameLists(String userName);
}
