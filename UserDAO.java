package jspservletlopputyo.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;

import jspservletlopputyo.model.User;


public class UserDAO {
	
	private String driver = "com.mysql.jdbc.Driver";
	private String dbURL = "//localhost/vaalikone";
	private String dbUsername = "root";
	private String dbPassword = "root123";
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (EHDOKAS_ID, SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, IKA, MIKSI_EDUSKUNTAAN, MITA_ASIOITA_HALUAT_EDISTAA, AMMATTI) VALUES " +
	        " (?, ?, ?, ?, ?, ?, ? ,? ,?);";

	    private static final String SELECT_USER_BY_ID = "EHDOKAS_ID, SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, IKA, MIKSI_EDUSKUNTAAN, MITA_ASIOITA_HALUAT_EDISTAA, AMMATTI from users where id =?";
	    private static final String SELECT_ALL_USERS = "select * from users";
	    private static final String DELETE_USERS_SQL = "delete from users where EHDOKAS_ID = ?;";
	    private static final String UPDATE_USERS_SQL = "update users set SUKUNIMI = ?,ETUNIMI= ?, PUOLUE =?, KOTIPAIKKAKUNTA =?, IKA =?, MIKSI_EDUSKUNTAAN =?, MITA_ASIOITA_HALUAT_EDISTAA=?, AMMATTI=? where EHDOKAS_ID = ?;";
	    
	    
	    protected Connection getConnection() 
	    {
	        Connection connection = null;
	        try {
	            Class.forName("driver");
	            connection = DriverManager.getConnection("jdbc:mysql:" + dbURL, dbUsername, dbPassword);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return connection;
	    }
	    
	    // Create or insert user
	    
	    public void insertUser(User user) throws SQLException 
	    {
	        System.out.println(INSERT_USERS_SQL);
	        // try-with-resource statement will auto close the connection.
	        try (Connection connection = getConnection(); java.sql.PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, user.getEHDOKAS_ID());
	            preparedStatement.setString(2, user.getSUKUNIMI());
	            preparedStatement.setString(3, user.getETUNIMI());
	            preparedStatement.setString(4, user.getPUOLUE());
	            preparedStatement.setString(5, user.getKOTIPAIKKAKUNTA());
	            preparedStatement.setInt(6, user.getIKA());
	            preparedStatement.setString(7, user.getMIKSI_EDUSKUNTAAN());
	            preparedStatement.setString(8, user.getMITA_ASIOITA_HALUAISIT_EDISTAA());
	            preparedStatement.setString(9, user.getAMMATTI());
	            preparedStatement.executeUpdate();
	            
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	    }
	    
	    
	    //Updates user
	    
	    public boolean updateUser(User user) throws SQLException 
	    {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); java.sql.PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
	            
	        	//statement.setInt(1, user.getEHDOKAS_ID());
	            statement.setString(2, user.getSUKUNIMI());
	            statement.setString(3, user.getETUNIMI());
	            statement.setString(4, user.getPUOLUE());
	            statement.setString(5, user.getKOTIPAIKKAKUNTA());
	            statement.setInt(6, user.getIKA());
	            statement.setString(7, user.getMIKSI_EDUSKUNTAAN());
	            statement.setString(8, user.getMITA_ASIOITA_HALUAISIT_EDISTAA());
	            statement.setString(9, user.getAMMATTI());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
	    
	    // Select user by id
	    
	    public User selectUser(int EHDOKAS_ID) 
	    {
	        User user = null;
	        // Step 1: Establishing a Connection
	        try (Connection connection = getConnection();
	            // Step 2:Create a statement using connection object
	            java.sql.PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
	            preparedStatement.setInt(1, EHDOKAS_ID);
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            ResultSet rs = preparedStatement.executeQuery();

	            // Step 4: Process the ResultSet object.
	            while (rs.next()) {
	                
	                String sukunimi = rs.getString("SUKUNIMI");
	                String etunimi = rs.getString("ETUNIMI");
	                String puolue = rs.getString("PUOLUE");
	                String kotipaikkakunta = rs.getString("KOTIPAIKKAKUNTA");
	                int ika = rs.getInt("IKA");
	                String miksi_eduskuntaan = rs.getString("MIKSI_EDUSKUNTAAN");
	                String mita_asioita_haluat_edistaa = rs.getString("MITA_ASIOITA_HALUAT_EDISTAA");
	                String ammatti = rs.getString("AMMATTI");
	                user = new User(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti);
	            }
	        } catch (SQLException e) {
	            printSQLException(e);
	        }
	        return user;
	        
	        
	        
	        
	    }
	    
	    private void printSQLException(SQLException ex) 
	    {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	    
	    
}
