import Data.IMysqlConnection;
import Data.MysqlConnection;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.sql.SQLException;

public class ConnectionService {
    private static ConnectionService singleInstance = null;
    private static IMysqlConnection mysqlConnection = new MysqlConnection();


    private ConnectionService(){

    }


    public String createConnection(){
        String answer;
        try {
            if (mysqlConnection.getConnection() == null || mysqlConnection.getConnection().isClosed()){
                mysqlConnection.setConnection(mysqlConnection.createConnection());
            }
            answer = "true";
        } catch (SQLException e) {
            e.printStackTrace();
            answer = "false";
        }
        return answer;
    }


    public String closeConnection(){
        String answer;
        try {
            mysqlConnection.closeConnection(mysqlConnection.getConnection());
            answer = "true";
        } catch (SQLException e) {
            e.printStackTrace();
            answer = "false";
        } catch (NullPointerException u){
            u.printStackTrace();
            answer = "true";
        }
        return answer;
    }

    public static ConnectionService getInstance(){
        if (singleInstance == null){
            singleInstance = new ConnectionService();
        }

        return singleInstance;
    }

    public IMysqlConnection getMysqlConnection(){
        return mysqlConnection;
    }

}

