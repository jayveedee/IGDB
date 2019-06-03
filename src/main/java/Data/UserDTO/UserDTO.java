package Data.UserDTO;

import Data.GameDTO.GameDTO;

import java.util.List;

public class UserDTO {

    private int userid;
    private String username;
    private String password;
    private String email;
    private List<GameDTO> gamelist;
    private List<RolesDTO> roleList;

    public UserDTO(int userid, String username, String password, String email, List<GameDTO> gamelist, List<RolesDTO> roleList) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.email = email;
        this.gamelist = gamelist;
        this.roleList = roleList;
    }

    public UserDTO() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<GameDTO> getGamelist() {
        return gamelist;
    }

    public void setGamelist(List<GameDTO> gamelist) {
        this.gamelist = gamelist;
    }

    public List<RolesDTO> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RolesDTO> roleList) {
        this.roleList = roleList;
    }
}
