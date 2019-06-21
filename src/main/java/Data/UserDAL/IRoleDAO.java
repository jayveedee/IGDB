package Data.UserDAL;

import Data.UserDTO.RoleDTO;

import java.util.List;

public interface IRoleDAO {

    //CREATE
    boolean createRole          (RoleDTO role);

    //READ
    RoleDTO getRole             (int roleid);
    RoleDTO getSpecificRole     (int roleID, String userNAME);
    List<RoleDTO> getRoleList();

    //UPDATE
    boolean updateRole          (RoleDTO newUser);

    //DELETE
    boolean deleteRole          (int roleid);
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)