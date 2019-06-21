package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface IMysqlConnection {

    Connection createConnection() throws SQLException;
    void closeConnection(Connection connection) throws SQLException;

    Statement getStatement();
    void setStatement(Statement statement);

    PreparedStatement getPrepStatement();
    void setPrepStatment(PreparedStatement prepStatement);

    Connection getConnection();
    void setConnection(Connection connection);

    boolean handleDeleteByID(int ID, String query, IMysqlConnection mySql);
}

//Lavet af gruppe 24 til CDIO Final - Specialopgave
//Medlemmer af gruppe 24:
//Simon Andersen (s185083), Asama Hayder(s185099), Jákup Viljam Dam(s185095), Christoffer Adrian Detlef(s185117) & Thaer Almalla(s170727)