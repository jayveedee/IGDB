package Data.GameDTO.Info;

import Data.GameDTO.GameDTO;

import java.util.List;

public class PlatformDTO {

    private int platformid;
    private String name;
    private List<GameDTO> gameList;

    public PlatformDTO(int platformid, String name, List<GameDTO> gameList) {
        this.platformid = platformid;
        this.name = name;
        this.gameList = gameList;
    }

    public PlatformDTO() {
    }

    public int getPlatformid() {
        return platformid;
    }

    public void setPlatformid(int platformid) {
        this.platformid = platformid;
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
