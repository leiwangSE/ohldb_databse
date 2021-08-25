

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * AbstractDAO.java
 * This DAO class provides CRUD database operations for the table book
 * in the database.
 * @author Lei
 *
 */

public class ConsoleDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public ConsoleDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
     //connect with DB;
    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
            	//load DB driver, and each DB has its own driver;
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            //setup connection with DB;
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
    }
     //disconnect with the DB;
    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }
     //prepareStatement allows to issue SQL query to DB
    public boolean insertConsole(Console console) throws SQLException {
    	System.out.println("Call insetConsole");
        String sql = "INSERT INTO Consoles (TimeStamp, RivianPN, JulianDate, SN, Result, RotationYaw, RotationPitch, RotationRoll, LocationX, LocationY, LocationZ, Image) VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
        System.out.println("Sql script");
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, console.getTimeStamp());
        statement.setString(2, console.getRivianPN());
        statement.setString(3, console.getJulianDate());
        statement.setString(4, console.getSN());
        statement.setBoolean(5, console.getResult());
        statement.setDouble(6, console.getRotationYaw());
        statement.setDouble(7, console.getRotationPitch());
        statement.setDouble(8, console.getRotationRoll());
        statement.setDouble(9, console.getLocationX());
        statement.setDouble(10, console.getLocationY());
        statement.setDouble(11, console.getLocationZ());
        statement.setString(12, console.getImage());
        
        
        System.out.println("Result: "+ console.getResult());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        System.out.println("executed");
        statement.close();
        disconnect();
        return rowInserted;
    }


}
