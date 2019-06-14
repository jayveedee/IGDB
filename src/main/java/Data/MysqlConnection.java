package Data;

import javax.inject.Singleton;
import java.sql.*;

@Singleton
public class MysqlConnection implements IMysqlConnection {

    private Statement           statement;
    private PreparedStatement   prepStatement;
    private Connection          connection;

    private static MysqlConnection mysqlConnection = null;

    public static MysqlConnection getInstance() {
        if(mysqlConnection == null) {
            mysqlConnection = new MysqlConnection();
        }
        return mysqlConnection;
    }

    @Override
    public Connection createConnection() throws SQLException {
        String myURLStart = "jdbc:mysql://";
        String myURL = "ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185095?";
        String myUserStart = "user=";
        String myUser = "s185095&";
        String myPassStart = "password=";
        String myPass = "qSmM4qcR0JF1sAnR6OZss";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection = DriverManager.getConnection
                (
                        myURLStart +
                                myURL +
                                myUserStart +
                                myUser +
                                myPassStart +
                                myPass
                );
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    @Override
    public Statement getStatement() {
        return statement;
    }

    @Override
    public void setStatement(Statement statement) {
        this.statement = statement;
    }

    @Override
    public PreparedStatement getPrepStatement() {
        return prepStatement;
    }

    @Override
    public void setPrepStatment(PreparedStatement prepStatement) {
        this.prepStatement = prepStatement;
    }

    @Override
    public Connection getConnection() {
        return connection;
    }

    @Override
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
