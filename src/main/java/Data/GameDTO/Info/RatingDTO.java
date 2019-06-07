package Data.GameDTO.Info;

import Data.UserDTO.UserDTO;

public class RatingDTO {

    private int ratingID;
    private int ratingRATED;
    private UserDTO ratingUSER;

    public RatingDTO(int ratingID, int ratingRATED, UserDTO ratingUSER) {
        this.ratingID = ratingID;
        this.ratingRATED = ratingRATED;
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

    public int getRatingRATED() {
        return ratingRATED;
    }

    public void setRatingRATED(int ratingRATED) {
        this.ratingRATED = ratingRATED;
    }

    public UserDTO getRatingUSER() {
        return ratingUSER;
    }

    public void setRatingUSER(UserDTO ratingUSER) {
        this.ratingUSER = ratingUSER;
    }

}
