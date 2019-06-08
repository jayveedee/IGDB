package Data.GameDTO.Info;

public class TrailerDTO {

    private int         trailerID;
    private String      trailerURL;

    public TrailerDTO(int trailerID, String trailerURL) {
        this.trailerID = trailerID;
        this.trailerURL = trailerURL;
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
}
