package Data.GameDTO.Info;

public class RatingDTO {

    private int ratingid;
    private int ratings;

    public RatingDTO(int ratingid, int ratings) {
        this.ratingid = ratingid;
        this.ratings = ratings;
    }

    public RatingDTO() {
    }

    public int getRatingid() {
        return ratingid;
    }

    public void setRatingid(int ratingid) {
        this.ratingid = ratingid;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
}
