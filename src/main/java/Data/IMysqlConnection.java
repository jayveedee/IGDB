package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public interface IMysqlConnection {

    Connection createConnection() throws SQLException, ClassNotFoundException;
    void closeConnection(Connection connection) throws SQLException;

    Statement getStatement();
    void setStatement(Statement statement);

    PreparedStatement getPrepStatement();
    void setPrepStatment(PreparedStatement prepStatement);

    Connection getConnection();
    void setConnection(Connection connection);
}
