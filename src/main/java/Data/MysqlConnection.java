package Data;

import java.sql.*;

public class MysqlConnection implements IMysqlConnection {

    private Statement           statement = null;
    private PreparedStatement   prepStatement = null;
    private Connection          connection = null;

    private String myURLStart = "jdbc:mysql://";
    private String myURL = "ec2-52-30-211-3.eu-west-1.compute.amazonaws.com/s170727?";
    private String myUserStart = "user=";
    private String myUser = "s170727&";
    private String myPassStart = "password=";
    private String myPass = "eUj4Tslz6nToV7wumc3nn";

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
