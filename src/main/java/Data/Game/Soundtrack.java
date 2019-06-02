package Data.Game;

import java.util.List;

public class Soundtrack {

    private int soundtrackid;
    private String name;
    private Composer composer;
    private List<MusicArtists> musicArtistsStarred;
    private List<Game> gameSoundtracksUsed;

    public Soundtrack(int soundtrackid, String name, Composer composer, List<MusicArtists> musicArtistsStarred, List<Game> gameSoundtracksUsed) {
        this.soundtrackid = soundtrackid;
        this.name = name;
        this.composer = composer;
        this.musicArtistsStarred = musicArtistsStarred;
        this.gameSoundtracksUsed = gameSoundtracksUsed;
    }

    public Soundtrack() {
    }

    public int getSoundtrackid() {
        return soundtrackid;
    }

    public void setSoundtrackid(int soundtrackid) {
        this.soundtrackid = soundtrackid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Composer getComposer() {
        return composer;
    }

    public void setComposer(Composer composer) {
        this.composer = composer;
    }

    public List<MusicArtists> getMusicArtistsStarred() {
        return musicArtistsStarred;
    }

    public void setMusicArtistsStarred(List<MusicArtists> musicArtistsStarred) {
        this.musicArtistsStarred = musicArtistsStarred;
    }

    public List<Game> getGameSoundtracksUsed() {
        return gameSoundtracksUsed;
    }

    public void setGameSoundtracksUsed(List<Game> gameSoundtracksUsed) {
        this.gameSoundtracksUsed = gameSoundtracksUsed;
    }
}
