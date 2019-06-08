package Data.GameDTO.Info;

import Data.GameDTO.Development.ComposerDTO;

import java.util.List;

public class SoundtrackDTO {

    private int                 ostID;
    private String              ostTITLE;
    private ComposerDTO         ostCOMP;
    private List<Integer>       ostMA;
    private List<Integer>       ostGAMEs;
    private String              ostPFP;

    public SoundtrackDTO(int ostID, String ostTITLE, ComposerDTO ostCOMP, List<Integer> ostMA, List<Integer> ostGAMEs, String ostPFP) {
        this.ostID = ostID;
        this.ostTITLE = ostTITLE;
        this.ostCOMP = ostCOMP;
        this.ostMA = ostMA;
        this.ostGAMEs = ostGAMEs;
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

    public List<Integer> getOstMA() {
        return ostMA;
    }

    public void setOstMA(List<Integer> ostMA) {
        this.ostMA = ostMA;
    }

    public List<Integer> getOstGAMEs() {
        return ostGAMEs;
    }

    public void setOstGAMEs(List<Integer> ostGAMEs) {
        this.ostGAMEs = ostGAMEs;
    }

    public String getOstPFP() {
        return ostPFP;
    }

    public void setOstPFP(String ostPFP) {
        this.ostPFP = ostPFP;
    }
}
