package Data.Game.Character;

import Data.Game.Development.ActorDTO;
import Data.Game.Info.DateDTO;
import Data.Game.GameDTO;

import java.util.List;

public class CharacterDTO {

    private int characterid;
    private String firstName;
    private String lastName;
    private DateDTO birthday;
    private List<ActorDTO> actorsPlayed;
    private List<GameDTO> gamesStarredin;

    private String biography;

    public CharacterDTO(int characterid, String firstName, String lastName, String biography, DateDTO birthday, List<ActorDTO> actorsPlayed, List<GameDTO> gamesStarredin) {
        this.characterid = characterid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.biography = biography;
        this.birthday = birthday;
        this.actorsPlayed = actorsPlayed;
        this.gamesStarredin = gamesStarredin;
    }

    public CharacterDTO() {
    }

    public int getCharacterid() {
        return characterid;
    }

    public void setCharacterid(int characterid) {
        this.characterid = characterid;
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

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public DateDTO getBirthday() {
        return birthday;
    }

    public void setBirthday(DateDTO birthday) {
        this.birthday = birthday;
    }

    public List<ActorDTO> getActorsPlayed() {
        return actorsPlayed;
    }

    public void setActorsPlayed(List<ActorDTO> actorsPlayed) {
        this.actorsPlayed = actorsPlayed;
    }

    public List<GameDTO> getGamesStarredin() {
        return gamesStarredin;
    }

    public void setGamesStarredin(List<GameDTO> gamesStarredin) {
        this.gamesStarredin = gamesStarredin;
    }
}
