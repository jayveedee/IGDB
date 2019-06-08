package Data;

import java.sql.*;

public class MysqlConnection implements IMysqlConnection {

    private Statement           statement;
    private PreparedStatement   prepStatement;
    private Connection          connection;

    private String myURLStart = "jdbc:mysql://";
    private String myURL = "ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185095?";
    private String myUserStart = "user=";
    private String myUser = "s185095&";
    private String myPassStart = "password=";
    private String myPass = "qSmM4qcR0JF1sAnR6OZss";

    @Override
    public Connection createConnection() throws SQLException {
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
