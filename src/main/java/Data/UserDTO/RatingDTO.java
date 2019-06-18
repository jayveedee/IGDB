package Data.UserDTO;

public class RatingDTO {

    private double      ratingID;
    private String      ratingUSER;
    private int         ratingGAME;

    public RatingDTO(int ratingID, String ratingUSER, int ratingGAME) {
        this.ratingID = ratingID;
        this.ratingUSER = ratingUSER;
        this.ratingGAME = ratingGAME;
    }

    public RatingDTO() {
    }

    public double getRatingID() {
        return ratingID;
    }

    public void setRatingID(double ratingID) {
        this.ratingID = ratingID;
    }

    public String getRatingUSER() {
        return ratingUSER;
    }

    public void setRatingUSER(String ratingUSER) {
        this.ratingUSER = ratingUSER;
    }

    public int getRatingGAME() {
        return ratingGAME;
    }

    public void setRatingGAME(int ratingGAME) {
        this.ratingGAME = ratingGAME;
    }
}
