package Data.GameDTO.Info;

import Data.UserDTO.UserDTO;

public class RatingDTO {

    private int         ratingID;
    private int         ratingGIVEN;
    private UserDTO     ratingUSER;

    public RatingDTO(int ratingID, int ratingGIVEN, UserDTO ratingUSER) {
        this.ratingID = ratingID;
        this.ratingGIVEN = ratingGIVEN;
        this.ratingUSER = ratingUSER;
    }

    public RatingDTO() {
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public int getRatingGIVEN() {
        return ratingGIVEN;
    }

    public void setRatingGIVEN(int ratingGIVEN) {
        this.ratingGIVEN = ratingGIVEN;
    }

    public UserDTO getRatingUSER() {
        return ratingUSER;
    }

    public void setRatingUSER(UserDTO ratingUSER) {
        this.ratingUSER = ratingUSER;
    }

}
