package Data.GameDTO.Development;

import java.util.List;

public class MusicArtistDTO {

    private int                     artID;
    private String                  artNAME;
    private List<Integer>           artGAMEs;
    private List<Integer>           artOSTs;
    private String                  artPFP;

    public MusicArtistDTO(int artID, String artNAME, List<Integer> artGAMEs, List<Integer> artOSTs, String artPFP) {
        this.artID = artID;
        this.artNAME = artNAME;
        this.artGAMEs = artGAMEs;
        this.artOSTs = artOSTs;
        this.artPFP = artPFP;
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

    public List<Integer> getArtGAMEs() {
        return artGAMEs;
    }

    public void setArtGAMEs(List<Integer> artGAMEs) {
        this.artGAMEs = artGAMEs;
    }

    public List<Integer> getArtOSTs() {
        return artOSTs;
    }

    public void setArtOSTs(List<Integer> artOSTs) {
        this.artOSTs = artOSTs;
    }

    public String getArtPFP() {
        return artPFP;
    }

    public void setArtPFP(String artPFP) {
        this.artPFP = artPFP;
    }
}
