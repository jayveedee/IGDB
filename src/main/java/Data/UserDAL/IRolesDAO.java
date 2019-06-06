package Data.UserDAL;

import Data.UserDTO.RoleDTO;

import java.util.List;

public interface IRolesDAO {

    void createRole(RoleDTO role);
    RoleDTO getRole(int roleid);
    List<RoleDTO> getRoleList();
    void updateRole(int roleid);
    void deleteRole(int roleid);
}
