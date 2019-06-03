package Data.GameDTO.Development;

import Data.GameDTO.GameDTO;
import Data.GameDTO.Info.SoundtrackDTO;

import java.util.List;

public class MusicArtistDTO {

    private int                     artID;
    private String                  artNAME;
    private List<GameDTO>           artGAMEs;
    private List<SoundtrackDTO>     artOSTs;

    public MusicArtistDTO(int artID, String artNAME, List<GameDTO> artGAMEs, List<SoundtrackDTO> artOSTs) {
        this.artID = artID;
        this.artNAME = artNAME;
        this.artGAMEs = artGAMEs;
        this.artOSTs = artOSTs;
    }

    public MusicArtistDTO() {
    }

    public int getArtID() {
        return artID;
    }

    public void setArtID(int artID) {
        this.artID = artID;
    }

    public String getArtNAME() {
        return artNAME;
    }

    public void setArtNAME(String firstName) {
        this.artNAME = firstName;
    }

    public List<GameDTO> getArtGAMEs() {
        return artGAMEs;
    }

    public void setArtGAMEs(List<GameDTO> artGAMEs) {
        this.artGAMEs = artGAMEs;
    }

    public List<SoundtrackDTO> getArtOSTs() {
        return artOSTs;
    }

    public void setArtOSTs(List<SoundtrackDTO> artOSTs) {
        this.artOSTs = artOSTs;
    }
}
