

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

public class CameraDao {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
     
    public CameraDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
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
    public boolean insertCamera(Camera camera) throws SQLException {
    	System.out.println("Call insetCamera");
        String sql = "INSERT INTO cameras (CameraID, RotationYaw, RotationPitch, RotationRoll, LocationX, LocationY,LocationZ ) VALUES (?, ?, ?, ?, ?, ?,?)";
        System.out.println("Sql script");
        connect();
        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, camera.getCameraID());
        statement.setDouble(2, camera.getRotationYaw());
        statement.setDouble(3, camera.getRotationPitch());
        statement.setDouble(4, camera.getRotationRoll());
        statement.setDouble(5, camera.getLocationX());
        statement.setDouble(6, camera.getLocationY());
        statement.setDouble(7, camera.getLocationZ());
        
        System.out.println("Result: "+ camera.getLocationZ());
        
        boolean rowInserted = statement.executeUpdate() > 0;
        System.out.println("executed");
        statement.close();
        disconnect();
        return rowInserted;
    }


}
