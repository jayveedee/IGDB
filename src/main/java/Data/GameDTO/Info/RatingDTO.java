package Data.GameDTO.Info;

public class RatingDTO {

    private int ratingID;
    private int ratingRATED;

    public RatingDTO(int ratingID, int ratingRATED) {
        this.ratingID = ratingID;
        this.ratingRATED = ratingRATED;
    }

    public RatingDTO() {
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public int getRatingRATED() {
        return ratingRATED;
    }

    public void setRatingRATED(int ratingRATED) {
        this.ratingRATED = ratingRATED;
    }

}
