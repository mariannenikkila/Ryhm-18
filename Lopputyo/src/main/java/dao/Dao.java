package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Question;

import java.sql.Connection;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public ArrayList<Question> readAllQuestion() {
		ArrayList<Question> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from kysymykset");
			while (RS.next()){
				Question f = new Question();
				f.setKysymys_id(RS.getInt("kysymys_id"));
				f.setKysymys(RS.getString("kysymys"));
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Question> updateQuestion(Question f) {
		try {
			String sql="update kysymykset set kysymys=? where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getKysymys());
			pstmt.setInt(2, f.getKysymys_id());
			pstmt.executeUpdate();
			return readAllQuestion();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Question> createQuestion(Question f){
		try {
		String sql="insert into kysymykset(kysymys_id, kysymys) values(?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, f.getKysymys_id());
		pstmt.setString(2, f.getKysymys());
		int rowsInserted = pstmt.executeUpdate();
		if (rowsInserted > 0) {
			System.out.println("A new user was inserted successfully!");
		}
		 return readAllQuestion();
		}
		catch (SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Question> deleteQuestion(String kysymys_id) {
		try {
			String sql="delete from kysymykset where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, kysymys_id);
			pstmt.executeUpdate();
			return readAllQuestion();
		}
		catch(SQLException e) {
			return null;
		}
	}

	public Question readQuestion(String kysymys_id) {
		Question f=null;
		try {
			String sql="select * from kysymykset where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, kysymys_id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Question();
				f.setKysymys_id(RS.getInt("kysymys_id"));
				f.setKysymys(RS.getString("kysymys"));
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
}
