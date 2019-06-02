package Data.Game.Development;

import Data.Game.GameDTO;
import Data.Game.Info.SoundtrackDTO;

import java.util.List;

public class MusicArtistDTO {

    private int artistid;
    private String firstName;
    private String lastName;
    private List<GameDTO> gamesStarredin;
    private List<SoundtrackDTO> soundtracksStarredin;

    public MusicArtistDTO(int artistid, String firstName, String lastName, List<GameDTO> gamesStarredin, List<SoundtrackDTO> soundtracksStarredin) {
        this.artistid = artistid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gamesStarredin = gamesStarredin;
        this.soundtracksStarredin = soundtracksStarredin;
    }

    public MusicArtistDTO() {
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

    public List<GameDTO> getGamesStarredin() {
        return gamesStarredin;
    }

    public void setGamesStarredin(List<GameDTO> gamesStarredin) {
        this.gamesStarredin = gamesStarredin;
    }

    public List<SoundtrackDTO> getSoundtracksStarredin() {
        return soundtracksStarredin;
    }

    public void setSoundtracksStarredin(List<SoundtrackDTO> soundtracksStarredin) {
        this.soundtracksStarredin = soundtracksStarredin;
    }
}
