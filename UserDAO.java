package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO 
{
	
	private String jdbcURL = "jdbc:mysql://localhost/:3306/vaalikone?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root123";
	
	// SQL Statements
	
	private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (EHDOKAS_ID, SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, IKA, MIKSI_EDUSKUNTAAN, MITA_ASIOITA_HALUAT_EDISTAA, AMMATTI) VALUES " +
	        " (?, ?, ?, ?, ?, ?, ? ,? ,?);";

	    private static final String SELECT_USER_BY_ID = "select EHDOKAS_ID, SUKUNIMI, ETUNIMI, PUOLUE, KOTIPAIKKAKUNTA, IKA, MIKSI_EDUSKUNTAAN, MITA_ASIOITA_HALUAT_EDISTAA, AMMATTI from users where EHDOKAS_ID =?";
	    private static final String SELECT_ALL_USERS = "select * from users";
	    private static final String DELETE_USERS_SQL = "delete from users where EHDOKAS_ID = ?;";
	    private static final String UPDATE_USERS_SQL = "update users set SUKUNIMI = ?,ETUNIMI= ?, PUOLUE =?, KOTIPAIKKAKUNTA =?, IKA =?, MIKSI_EDUSKUNTAAN =?, MITA_ASIOITA_HALUAT_EDISTAA=?, AMMATTI=? where EHDOKAS_ID = ?;";
	    
	    protected Connection getConnection()
	    {
	    	Connection connection = null;
	    	try
	    	{
	    		connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	    	} 
	    	catch (Exception e) 
	    	{
				e.printStackTrace();
			}
	    	return connection;
	    }
	    
	    // Insert record in database
	    
	    public void insertUser(User user)
	    {
	    	//Try-with-resource statement here
	    	
	    	try(Connection connection = getConnection();
	    			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL))
	    	{
	    		preparedStatement.setInt(1, user.getId());
	    		preparedStatement.setString(2, user.getSukunimi());
	    		preparedStatement.setString(3, user.getEtunimi());
	    		preparedStatement.setString(4, user.getPuolue());
	    		preparedStatement.setString(5, user.getKotipaikkakunta());
	    		preparedStatement.setInt(6, user.getIka());
	    		preparedStatement.setString(7, user.getMiksiEk());
	    		preparedStatement.setString(8, user.getMitaAsioita());
	    		preparedStatement.setString(9, user.getAmmatti());
	    		preparedStatement.executeUpdate();
	    		}
	    	catch (Exception e) 
	    	{
	    		System.err.println(e.getLocalizedMessage());
			}
	    }
	    
	    // Select user from database
	    
	    public User selectUser(int id)
	    {
	    	User user = null;
	    	try(Connection connection = getConnection();
	    			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS))
	    	{
	    		preparedStatement.setInt(1, id);
	    		ResultSet resultSet = preparedStatement.executeQuery();
	    		while(resultSet.next())
	    		{
	    			String sukunimi = resultSet.getString("sukunimi");
	    			String etunimi = resultSet.getString("etunimi");
	    			String puolue = resultSet.getString("puolue");
	    			String kotipaikkakunta = resultSet.getString("kotipaikkakunta");
	    			int ika = resultSet.getInt("ika");
	    			String miksiEk = resultSet.getString("miksiEk");
	    			String mitaAsioita = resultSet.getString("mitaAsioita");
	    			String ammatti = resultSet.getString("ammatti");
	    			
	    			user = new User(sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksiEk, mitaAsioita, ammatti);
	    			
	    		}
	    	}
	    	catch 
	    	(Exception e) 
	    	{
				e.printStackTrace();
			}
	    	return user;
	    }
	    
	    // Select all users from database
	    
	    public List < User > selectAllUsers()
	    {
	    	List < User > users = new ArrayList < > ();
	    	
	    	//Step 1: Establishing a connection
	    	try(Connection connection = getConnection();
	    			
	    			
	    	// Step 2: Create a statement using connection object
	    	PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);){
	    	System.out.println(preparedStatement);
	    	// Step 3: Execute the query or update query
	    	ResultSet rs = preparedStatement.executeQuery();
	    		
	    		// Step 4: Process the ResultSet object
	    		while (rs.next()) {
	    			int id = rs.getInt("id");
	    			String sukunimi = rs.getString("sukunimi");
	    			String etunimi = rs.getString("etunimi");
	    			String puolue = rs.getString("puolue");
	    			String kotipaikkakunta = rs.getString("kotipaikkakunta");
	    			int ika = rs.getInt("ika");
	    			String miksiEk = rs.getString("miksiEk");
	    			String mitaAsioita = rs.getString("mitaAsioita");
	    			String ammatti = rs.getString("ammatti");
	    			users.add(new User(id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksiEk, mitaAsioita, ammatti));
	    			}
	    	} catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return users;

	    }
	    
	    
	    
	    // Delete user from database
	    
	    public boolean deleteUser(int id) throws SQLException{
	    	boolean rowDeleted;
	    	
	    	try(Connection connection = getConnection(); 
	    			PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);){
	    		statement.setInt(1, id);
	    		rowDeleted = statement.executeUpdate() > 0;
	    	}
	    	return rowDeleted;	
	    }
	    
	    // Update user in database
	    
	    public boolean updateUser(User user) throws SQLException {
	    	boolean rowUpdated;
	    	try(Connection connection = getConnection();
	    			PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);){
	    		statement.setString(2, user.getSukunimi());
	    		statement.setString(3, user.getEtunimi());
	    		statement.setString(4, user.getPuolue());
	    		statement.setString(5, user.getKotipaikkakunta());
	    		statement.setInt(6, user.getIka());
	    		statement.setString(7, user.getMiksiEk());
	    		statement.setString(8, user.getMitaAsioita());
	    		statement.setString(9, user.getAmmatti());
	    		
	    		rowUpdated = statement.executeUpdate() > 0;
	    	}
	    	return rowUpdated;
	    }
	    
	    
	   
}
