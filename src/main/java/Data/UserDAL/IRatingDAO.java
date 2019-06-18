package Data.UserDAL;

import Data.UserDTO.RatingDTO;

public interface IRatingDAO {

    //CREATE
    boolean createRating(RatingDTO rating);

    //READ
    RatingDTO getRating(String userNAME, int gameID);
    double getAverageRating(int gameID);

    //UPDATE
    boolean updateUserRating(RatingDTO newRating);

    //DELETE
    boolean deleteUserRating(String userNAME, int gameID);
    boolean deleteAllGameRatings(int gameID);
}
