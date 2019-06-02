package Data;

import java.sql.*;

public class MysqlConnection implements IMysqlConnection {

    private Statement statement = null;
    private PreparedStatement prepStatement = null;

    private String myURLStart = "jdbc:mysql://";
    private String myURL = "ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s185099?";
    private String myUserStart = "user=";
    private String myUser = "s185099&";
    private String myPassStart = "password=";
    private String myPass = "zhKW0aeedrH5Jvd9UDGJp";

    @Override
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection
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
}
