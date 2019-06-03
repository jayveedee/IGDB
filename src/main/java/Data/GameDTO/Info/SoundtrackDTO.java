package Data.GameDTO.Info;

import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.MusicArtistDTO;
import Data.GameDTO.GameDTO;

import java.util.List;

public class SoundtrackDTO {

    private int ostID;
    private String ostNAME;
    private ComposerDTO ostCOMP;
    private List<MusicArtistDTO> ostMA;
    private List<GameDTO> ostGAMEs;

    public SoundtrackDTO(int ostID, String ostNAME, ComposerDTO ostCOMP, List<MusicArtistDTO> ostMA, List<GameDTO> ostGAMEs) {
        this.ostID = ostID;
        this.ostNAME = ostNAME;
        this.ostCOMP = ostCOMP;
        this.ostMA = ostMA;
        this.ostGAMEs = ostGAMEs;
    }

    public SoundtrackDTO() {
    }

    public int getOstID() {
        return ostID;
    }

    public void setOstID(int ostID) {
        this.ostID = ostID;
    }

    public String getOstNAME() {
        return ostNAME;
    }

    public void setOstNAME(String ostNAME) {
        this.ostNAME = ostNAME;
    }

    public ComposerDTO getOstCOMP() {
        return ostCOMP;
    }

    public void setOstCOMP(ComposerDTO ostCOMP) {
        this.ostCOMP = ostCOMP;
    }

    public List<MusicArtistDTO> getOstMA() {
        return ostMA;
    }

    public void setOstMA(List<MusicArtistDTO> ostMA) {
        this.ostMA = ostMA;
    }

    public List<GameDTO> getOstGAMEs() {
        return ostGAMEs;
    }

    public void setOstGAMEs(List<GameDTO> ostGAMEs) {
        this.ostGAMEs = ostGAMEs;
    }
}
