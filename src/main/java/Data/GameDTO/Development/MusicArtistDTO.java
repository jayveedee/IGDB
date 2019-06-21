package Data.GameDTO.Development;

public class MusicArtistDTO {

    private int                     artID;
    private String                  artNAME;
    private String                  artPFP;

    public MusicArtistDTO(int artID, String artNAME, String artPFP) {
        this.artID = artID;
        this.artNAME = artNAME;
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

    public String getArtPFP() {
        return artPFP;
    }

    public void setArtPFP(String artPFP) {
        this.artPFP = artPFP;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)