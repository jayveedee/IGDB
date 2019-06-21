package Data.GameDTO.Info;

public class TrailerDTO {

    private int         trailerID;
    private String      trailerURL;
    private int         trailerGameID;

    public TrailerDTO(int trailerID, String trailerURL, int trailerGameID) {
        this.trailerID = trailerID;
        this.trailerURL = trailerURL;
        this.trailerGameID = trailerGameID;
    }

    public TrailerDTO() {
    }

    public int getTrailerID() {
        return trailerID;
    }

    public void setTrailerID(int trailerID) {
        this.trailerID = trailerID;
    }

    public String getTrailerURL() {
        return trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public int getTrailerGameID() {
        return trailerGameID;
    }

    public void setTrailerGameID(int trailerGameID) {
        this.trailerGameID = trailerGameID;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)