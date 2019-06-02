package Data.Game.Development;

import Data.Game.GameDTO;
import Data.Game.Info.SoundtrackDTO;

import java.util.List;

public class MusicArtistDTO {

    private int artistid;
    private String name;
    private List<GameDTO> gamesStarredin;
    private List<SoundtrackDTO> soundtracksStarredin;

    public MusicArtistDTO(int artistid, String name, List<GameDTO> gamesStarredin, List<SoundtrackDTO> soundtracksStarredin) {
        this.artistid = artistid;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
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
