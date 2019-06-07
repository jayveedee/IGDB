package Data.UserDAL;

import Data.UserDTO.RoleDTO;

import java.util.List;

public interface IRoleDAO {

    boolean createRole(RoleDTO role);
    boolean handleUpdateUserRolesXCreateRole(String query, int roleid, String rolenameORusername);
    RoleDTO getRole(int roleid);
    List<RoleDTO> getRoleList();
    boolean updateRole(RoleDTO newUser);
    boolean deleteRole(int roleid);
}
