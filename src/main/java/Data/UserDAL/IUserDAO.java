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

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)