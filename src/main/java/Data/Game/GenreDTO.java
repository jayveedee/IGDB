package Data.Game;

import Data.Game.GameDTO;

import java.util.List;

public class GenreDTO {

    private int genreid;
    private String genreName;
    private List<GameDTO> gameList;

    public GenreDTO(int genreid, String genreName, List<GameDTO> gameList) {
        this.genreid = genreid;
        this.genreName = genreName;
        this.gameList = gameList;
    }

    public GenreDTO() {
    }

    public int getGenreid() {
        return genreid;
    }

    public void setGenreid(int genreid) {
        this.genreid = genreid;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public List<GameDTO> getGameList() {
        return gameList;
    }

    public void setGameList(List<GameDTO> gameList) {
        this.gameList = gameList;
    }
}
