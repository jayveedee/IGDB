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
