package Data.Game;

import Data.Game.GameCompany.ComposerDTO;
import Data.Game.GameCompany.MusicArtistDTO;

import java.util.List;

public class SoundtrackDTO {

    private int soundtrackid;
    private String name;
    private ComposerDTO composerDTO;
    private List<MusicArtistDTO> musicArtistDTOStarred;
    private List<GameDTO> gameDTOSoundtracksUsed;

    public SoundtrackDTO(int soundtrackid, String name, ComposerDTO composerDTO, List<MusicArtistDTO> musicArtistDTOStarred, List<GameDTO> gameDTOSoundtracksUsed) {
        this.soundtrackid = soundtrackid;
        this.name = name;
        this.composerDTO = composerDTO;
        this.musicArtistDTOStarred = musicArtistDTOStarred;
        this.gameDTOSoundtracksUsed = gameDTOSoundtracksUsed;
    }

    public SoundtrackDTO() {
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

    public ComposerDTO getComposerDTO() {
        return composerDTO;
    }

    public void setComposerDTO(ComposerDTO composerDTO) {
        this.composerDTO = composerDTO;
    }

    public List<MusicArtistDTO> getMusicArtistDTOStarred() {
        return musicArtistDTOStarred;
    }

    public void setMusicArtistDTOStarred(List<MusicArtistDTO> musicArtistDTOStarred) {
        this.musicArtistDTOStarred = musicArtistDTOStarred;
    }

    public List<GameDTO> getGameDTOSoundtracksUsed() {
        return gameDTOSoundtracksUsed;
    }

    public void setGameDTOSoundtracksUsed(List<GameDTO> gameDTOSoundtracksUsed) {
        this.gameDTOSoundtracksUsed = gameDTOSoundtracksUsed;
    }
}
