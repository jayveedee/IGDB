package Data.UserDAL;

import Data.*;
import Data.GameDAL.GameDAO;
import Data.GameDAL.IGameDAO;
import Data.UserDTO.RatingDTO;
import Data.UserDTO.RoleDTO;
import Data.UserDTO.UserDTO;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class RatingDAO_TEST {

    private GenAccessMethods_UserDAO_TEST u             = new GenAccessMethods_UserDAO_TEST();
    private GenAccessMethods_GameDAO_TEST g             = new GenAccessMethods_GameDAO_TEST();
    private GenAccessTestMethods del                    = new GenAccessTestMethods();
    private IMysqlConnection mySql                      = new MysqlConnection();
    private IRatingDAO                      radao       = new RatingDAO(mySql);
    private IGameDAO gdao                               = new GameDAO(mySql);
    private IUserDAO                        udao        = new UserDAO(mySql);

    @Test
    public void createRating() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
            List<RoleDTO> roleList = u.createRoleList();
            List<Integer> ugList   =  u.createUserGameList();
            UserDTO user = u.createUserDB("ASDASD",ugList,roleList);
            udao.createUser(user);
            for (int i = 0; i < user.getUserGAMEs().size(); i++) {
                udao.addToUserGameList(user.getUserNAME(),user.getUserGAMEs().get(i));
            }
            RatingDTO rating = new RatingDTO(10,user.getUserNAME(),44);
            assertTrue(radao.createRating(rating));
            radao.deleteUserRating(user.getUserNAME(),44);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRating() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
            List<RoleDTO> roleList = u.createRoleList();
            List<Integer> ugList   =  u.createUserGameList();
            UserDTO user = u.createUserDB("ASDSADASDASDAS",ugList,roleList);
            udao.createUser(user);
            for (int i = 0; i < user.getUserGAMEs().size(); i++) {
                udao.addToUserGameList(user.getUserNAME(),user.getUserGAMEs().get(i));
            }
            RatingDTO rating = new RatingDTO(10,user.getUserNAME(),44);
            assertTrue(radao.createRating(rating));

            RatingDTO dbRating = radao.getRating(user.getUserNAME(),44);
            assertEquals(rating.getRatingGAME(),dbRating.getRatingGAME());
            assertEquals(rating.getRatingID(),dbRating.getRatingID(),1);
            assertEquals(rating.getRatingUSER(),dbRating.getRatingUSER());
            radao.deleteUserRating(user.getUserNAME(),dbRating.getRatingGAME());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAverageRating() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
            List<RoleDTO> roleList =  u.createRoleList();
            List<Integer> ugList   =  u.createUserGameList();
            UserDTO user1 = u.createUserDB("TEST1",ugList,roleList);
            UserDTO user2 = u.createUserDB("TEST2",ugList,roleList);
            UserDTO user3 = u.createUserDB("TEST3",ugList,roleList);
            udao.createUser(user1);
            RatingDTO rating1 = new RatingDTO(5,user1.getUserNAME(),44);
            udao.createUser(user2);
            RatingDTO rating2 = new RatingDTO(8,user2.getUserNAME(),44);
            udao.createUser(user3);
            RatingDTO rating3 = new RatingDTO(1,user3.getUserNAME(),44);
            radao.createRating(rating1);
            radao.createRating(rating3);
            radao.createRating(rating2);
            double avgRating = (5.0 + 8.0 + 1.0) / 3.0;
            double dbAvgRating = radao.getAverageRating(44);
            assertEquals(avgRating,dbAvgRating,1);
            radao.deleteAllGameRatings(44);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateUserRating() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
            List<RoleDTO> roleList =  u.createRoleList();
            List<Integer> ugList   =  u.createUserGameList();
            UserDTO user1 = u.createUserDB("TEST1",ugList,roleList);
            udao.createUser(user1);
            RatingDTO rating = new RatingDTO(5,user1.getUserNAME(),44);
            radao.createRating(rating);
            RatingDTO newRating = new RatingDTO(8,user1.getUserNAME(),44);
            assertTrue(radao.updateUserRating(newRating));
            RatingDTO updatedRating = radao.getRating(user1.getUserNAME(),44);

            assertEquals(newRating.getRatingUSER(),updatedRating.getRatingUSER());
            assertEquals(newRating.getRatingID(),updatedRating.getRatingID(),1);
            assertEquals(newRating.getRatingGAME(),updatedRating.getRatingGAME());
            radao.deleteUserRating(user1.getUserNAME(),newRating.getRatingGAME());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUserRating() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
            List<RoleDTO> roleList =  u.createRoleList();
            List<Integer> ugList   =  u.createUserGameList();
            UserDTO user1 = u.createUserDB("TEST1",ugList,roleList);
            udao.createUser(user1);
            RatingDTO rating = new RatingDTO(5,user1.getUserNAME(),44);
            radao.createRating(rating);
            assertTrue(radao.deleteUserRating(user1.getUserNAME(),rating.getRatingGAME()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteAllGameRatings() {
        try (Connection c = mySql.createConnection()){
            del.deleteAllTables();
            List<RoleDTO> roleList =  u.createRoleList();
            List<Integer> ugList   =  u.createUserGameList();
            UserDTO user1 = u.createUserDB("TEST1",ugList,roleList);
            UserDTO user2 = u.createUserDB("TEST2",ugList,roleList);
            UserDTO user3 = u.createUserDB("TEST3",ugList,roleList);
            udao.createUser(user1);
            RatingDTO rating1 = new RatingDTO(5,user1.getUserNAME(),44);
            udao.createUser(user2);
            RatingDTO rating2 = new RatingDTO(8,user2.getUserNAME(),44);
            udao.createUser(user3);
            RatingDTO rating3 = new RatingDTO(1,user3.getUserNAME(),44);
            radao.createRating(rating1);
            radao.createRating(rating3);
            radao.createRating(rating2);
            assertTrue(radao.deleteAllGameRatings(44));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}