package Data.Game;

import java.util.List;

public class Actor {

    private int actorid;
    private String fisrtName;
    private String lastName;
    private List<Character> charactersPlayed;
    private List<Game> gamesStarredIn;

    public Actor(int actorid, String firstName, String lastName, List<Character> charactersPlayed, List<Game> gamesStarredIn) {
        this.actorid = actorid;
        this.fisrtName = firstName;
        this.lastName = lastName;
        this.charactersPlayed = charactersPlayed;
        this.gamesStarredIn = gamesStarredIn;
    }

    public Actor() {
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

    public List<Character> getCharactersPlayed() {
        return charactersPlayed;
    }

    public void setCharactersPlayed(List<Character> charactersPlayed) {
        this.charactersPlayed = charactersPlayed;
    }

    public List<Game> getGamesStarredIn() {
        return gamesStarredIn;
    }

    public void setGamesStarredIn(List<Game> gamesStarredIn) {
        this.gamesStarredIn = gamesStarredIn;
    }
}
