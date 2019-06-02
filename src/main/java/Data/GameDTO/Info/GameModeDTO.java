package Data.GameDTO.Info;

import Data.GameDTO.GameDTO;

import java.util.List;

public class GameModeDTO {

    private int gameModeid;
    private String name;
    private List<GameDTO> gameList;

    public GameModeDTO(int gameModeid, String name, List<GameDTO> gameList) {
        this.gameModeid = gameModeid;
        this.name = name;
        this.gameList = gameList;
    }

    public GameModeDTO() {
    }

    public int getGameModeid() {
        return gameModeid;
    }

    public void setGameModeid(int gameModeid) {
        this.gameModeid = gameModeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GameDTO> getGameList() {
        return gameList;
    }

    public void setGameList(List<GameDTO> gameList) {
        this.gameList = gameList;
    }
}
