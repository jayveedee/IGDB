import Data.IMysqlConnection;
import Data.MysqlConnection;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        //THIS CODE KILLS ALL ACTIVE CONNECTIONS!!
        IMysqlConnection mysqlConnection = new MysqlConnection();
        try {
            mysqlConnection.setConnection(mysqlConnection.createConnection());
            String query = "SHOW FULL processlist";
            mysqlConnection.setPrepStatment(mysqlConnection.getConnection().prepareStatement(query));
            ResultSet resultSet = mysqlConnection.getPrepStatement().executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("Id");
                System.out.println(id);
                mysqlConnection.setPrepStatment(mysqlConnection.getConnection().prepareStatement("KILL " + id));
                mysqlConnection.getPrepStatement().execute();
            }
            mysqlConnection.closeConnection(mysqlConnection.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)