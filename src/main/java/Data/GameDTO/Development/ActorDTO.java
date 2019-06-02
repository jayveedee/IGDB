package Data.GameDTO.Development;

import Data.GameDTO.Character.CharacterDTO;
import Data.GameDTO.Info.DateDTO;
import Data.GameDTO.GameDTO;

import java.util.List;

public class ActorDTO {

    private int actorid;
    private String fisrtName;
    private String lastName;
    private DateDTO birthday;
    private List<CharacterDTO> charactersPlayed;
    private List<GameDTO> gamesStarredIn;

    public ActorDTO(int actorid, String firstName, String lastName, DateDTO birthday, List<CharacterDTO> charactersPlayed, List<GameDTO> gamesStarredIn) {
        this.actorid = actorid;
        this.fisrtName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.charactersPlayed = charactersPlayed;
        this.gamesStarredIn = gamesStarredIn;
    }

    public ActorDTO() {
    }

    public int getActorid() {
        return actorid;
    }

    public void setActorid(int actorid) {
        this.actorid = actorid;
    }

    public String getfisrtName() {
        return fisrtName;
    }

    public void setfisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getFisrtName() {
        return fisrtName;
    }

    public void setFisrtName(String fisrtName) {
        this.fisrtName = fisrtName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateDTO getBirthday() {
        return birthday;
    }

    public void setBirthday(DateDTO birthday) {
        this.birthday = birthday;
    }

    public List<CharacterDTO> getCharactersPlayed() {
        return charactersPlayed;
    }

    public void setCharactersPlayed(List<CharacterDTO> charactersPlayed) {
        this.charactersPlayed = charactersPlayed;
    }

    public List<GameDTO> getGamesStarredIn() {
        return gamesStarredIn;
    }

    public void setGamesStarredIn(List<GameDTO> gamesStarredIn) {
        this.gamesStarredIn = gamesStarredIn;
    }
}
