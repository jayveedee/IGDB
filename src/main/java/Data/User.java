package Data;

import Data.Game.Game;

import java.util.List;

public class User {

    private int userid;
    private String username;
    private String password;
    private List<Game> gamelist;
    private List<Roles> roleList;

    public User(int userid, String username, String password, List<Game> gamelist, List<Roles> roleList) {
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.gamelist = gamelist;
        this.roleList = roleList;
    }

    public User() {
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

    public List<Game> getGamelist() {
        return gamelist;
    }

    public void setGamelist(List<Game> gamelist) {
        this.gamelist = gamelist;
    }

    public List<Roles> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Roles> roleList) {
        this.roleList = roleList;
    }
}
