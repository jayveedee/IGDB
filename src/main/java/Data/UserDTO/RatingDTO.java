package Data.UserDTO;

import Data.GameDTO.GameDTO;

public class RatingDTO {

    private int         ratingID;
        private UserDTO     ratingUSER;
    private GameDTO     ratingGAME;

    public RatingDTO(int ratingID, UserDTO ratingUSER, GameDTO ratingGAME) {
        this.ratingID = ratingID;
        this.ratingUSER = ratingUSER;
        this.ratingGAME = ratingGAME;
    }

    public RatingDTO() {
    }

    public int getRatingID() {
        return ratingID;
    }

    public void setRatingID(int ratingID) {
        this.ratingID = ratingID;
    }

    public UserDTO getRatingUSER() {
        return ratingUSER;
    }

    public void setRatingUSER(UserDTO ratingUSER) {
        this.ratingUSER = ratingUSER;
    }

    public GameDTO getRatingGAME() {
        return ratingGAME;
    }

    public void setRatingGAME(GameDTO ratingGAME) {
        this.ratingGAME = ratingGAME;
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)