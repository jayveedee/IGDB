package Data.Game;

import java.util.List;

public class Actor {

    private int actorid;
    private String name;
    private List<Character> charactersPlayed;
    private List<Game> gamesStarredIn;

    public Actor(int actorid, String name, List<Character> charactersPlayed, List<Game> gamesStarredIn) {
        this.actorid = actorid;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
