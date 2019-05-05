package Data;

import java.util.List;

public interface IUserData {

    User getUser(int userID);
    List<User> getUserList();
    boolean createUser(User user);
    boolean updateUser (User user);
    void deleteUser(int userID);

    void createConnection();
    void closeConnection();
}
