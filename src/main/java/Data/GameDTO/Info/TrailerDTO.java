package Data.GameDTO.Info;

import Data.GameDTO.GameDTO;

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
