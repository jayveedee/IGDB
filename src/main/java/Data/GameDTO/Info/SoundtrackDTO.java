package Data.GameDTO.Info;

import Data.GameDTO.Development.ComposerDTO;
import Data.GameDTO.Development.MusicArtistDTO;

import java.util.List;

public class SoundtrackDTO {

    private int                         ostID;
    private String                      ostTITLE;
    private ComposerDTO                 ostCOMP;
    private List<MusicArtistDTO>        ostMA;
    private int                         ostGAME;
    private String                      ostPFP;

    public SoundtrackDTO(int ostID, String ostTITLE, ComposerDTO ostCOMP, List<MusicArtistDTO> ostMA, int ostGAME, String ostPFP) {
        this.ostID = ostID;
        this.ostTITLE = ostTITLE;
        this.ostCOMP = ostCOMP;
        this.ostMA = ostMA;
        this.ostGAME = ostGAME;
        this.ostPFP = ostPFP;
    }

    public SoundtrackDTO() {
    }

    public int getOstID() {
        return ostID;
    }

    public void setOstID(int ostID) {
        this.ostID = ostID;
    }

    public String getOstTITLE() {
        return ostTITLE;
    }

    public void setOstTITLE(String ostTITLE) {
        this.ostTITLE = ostTITLE;
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

    public int getOstGAME() {
        return ostGAME;
    }

    public void setOstGAME(int ostGAME) {
        this.ostGAME = ostGAME;
    }

    public String getOstPFP() {
        return ostPFP;
    }

    public void setOstPFP(String ostPFP) {
        this.ostPFP = ostPFP;
    }
}
