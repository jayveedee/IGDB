package Data.Game;

import java.util.List;

public class MusicArtists {

    private int artistid;
    private String firstName;
    private String lastName;
    private List<Game> gamesStarredin;
    private List<Soundtrack> soundtracksStarredin;

    public MusicArtists(int artistid, String firstName, String lastName, List<Game> gamesStarredin, List<Soundtrack> soundtracksStarredin) {
        this.artistid = artistid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gamesStarredin = gamesStarredin;
        this.soundtracksStarredin = soundtracksStarredin;
    }

    public MusicArtists() {
    }

    public int getArtistid() {
        return artistid;
    }

    public void setArtistid(int artistid) {
        this.artistid = artistid;
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

    public List<Game> getGamesStarredin() {
        return gamesStarredin;
    }

    public void setGamesStarredin(List<Game> gamesStarredin) {
        this.gamesStarredin = gamesStarredin;
    }

    public List<Soundtrack> getSoundtracksStarredin() {
        return soundtracksStarredin;
    }

    public void setSoundtracksStarredin(List<Soundtrack> soundtracksStarredin) {
        this.soundtracksStarredin = soundtracksStarredin;
    }
}
