package Data.Game.Development;

import Data.Game.GameDTO;

import java.util.List;

public class WriterDTO {

    private int writerid;
    private String firstName;
    private String lastName;
    private List<GameDTO> gamesStarredin;

    public WriterDTO(int writerid, String firstName, String lastName, List<GameDTO> gamesStarredin) {
        this.writerid = writerid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gamesStarredin = gamesStarredin;
    }

    public WriterDTO() {
    }

    public int getWriterid() {
        return writerid;
    }

    public void setWriterid(int writerid) {
        this.writerid = writerid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<GameDTO> getGamesStarredin() {
        return gamesStarredin;
    }

    public void setGamesStarredin(List<GameDTO> gamesStarredin) {
        this.gamesStarredin = gamesStarredin;
    }
}
