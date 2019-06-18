package Data.UserDAL;

import Data.IMysqlConnection;
import Data.UserDTO.RatingDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RatingDAO implements IRatingDAO {

    private IMysqlConnection mySql;

    public RatingDAO(IMysqlConnection mySql) {
        this.mySql = mySql;
    }

    @Override
    public boolean createRating(RatingDTO rating) {
        String query = "INSERT INTO RatingList (ratingID, ratingUSER, ratingGameID) VALUES (?, ?, ?)";
        return handleDuplicateCode1(rating, query);
    }

    private boolean handleDuplicateCode1(RatingDTO rating, String query) {
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setDouble(1,rating.getRatingID());
            mySql.getPrepStatement().setString(2,rating.getRatingUSER());
            mySql.getPrepStatement().setInt(3,rating.getRatingGAME());
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public RatingDTO getRating(String userNAME, int gameID) {
        RatingDTO rating = new RatingDTO();
        String query = "SELECT * FROM RatingList WHERE ratingUSER = ? AND ratingGameID = ?";
        try {
            handle2xFirstIDsAsParams(userNAME, gameID, query);
            ResultSet rs = mySql.getPrepStatement().executeQuery();
            while (rs.next()){
                rating.setRatingID(rs.getDouble("ratingID"));
                rating.setRatingUSER(rs.getString("ratingUSER"));
                rating.setRatingGAME(rs.getInt("ratingGameID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rating;
    }

    private void handle2xFirstIDsAsParams(String userNAME, int gameID, String query) throws SQLException {
        mySql.getConnection().setAutoCommit(false);
        mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
        mySql.getPrepStatement().setString(1,userNAME);
        mySql.getPrepStatement().setInt(2,gameID);
    }

    @Override
    public double getAverageRating(int gameID) {
        String query = "SELECT ratingGameID, AVG(ratingID) AS 'average rating' FROM RatingList WHERE ratingGameID = ?";
        double averageRating = 0;
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setInt(1,gameID);
            ResultSet rs = mySql.getPrepStatement().executeQuery();
            if (rs.next()){
                averageRating = rs.getDouble("average rating");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return averageRating;
    }

    @Override
    public boolean updateUserRating(RatingDTO newRating) {
        String query = "UPDATE RatingList SET ratingID = ? WHERE ratingUSER = ? AND ratingGameID = ?";
        return handleDuplicateCode1(newRating, query);
    }

    @Override
    public boolean deleteUserRating(String userNAME, int gameID) {
        String query = "DELETE FROM RatingList WHERE ratingUSER = ? AND ratingGameID = ?";
        try {
            handle2xFirstIDsAsParams(userNAME, gameID, query);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteAllGameRatings(int gameID) {
        String query = "DELETE FROM RatingList WHERE ratingGameID = ?";
        return handleDeleteByID(gameID, query, mySql);
    }

    private boolean handleDeleteByID(int gameID, String query, IMysqlConnection mySql) {
        try {
            mySql.getConnection().setAutoCommit(false);
            mySql.setPrepStatment(mySql.getConnection().prepareStatement(query));
            mySql.getPrepStatement().setInt(1,gameID);
            mySql.getPrepStatement().executeUpdate();
            mySql.getConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
