import Data.IMysqlConnection;
import Data.MysqlConnection;

import javax.inject.Singleton;
import java.sql.SQLException;

@Singleton
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

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)