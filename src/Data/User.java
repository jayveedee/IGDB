package Data;

import java.util.List;

public class User implements IUserData {

    @Override
    public User getUser(int userID) {
        return null;
    }

    @Override
    public List<User> getUserList() {
        return null;
    }

    @Override
    public boolean createUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public void deleteUser(int userID) {

    }

    @Override
    public void createConnection() {

    }

    @Override
    public void closeConnection() {

    }
}
