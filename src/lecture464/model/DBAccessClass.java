package lecture464.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import lecture464.model.Users;


public class DBAccessClass {	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/rhooper";
	
	

	//  Database credentials
	static final String USER = "rhooper"; // Replace with your CSE_LOGIN
	static final String PASS = "An6-vN";   // Replace with your CSE MySQL_PASSWORD
	
	
	/*public void insertData (String firstName, String lastName, int id, double salary) {
		try{
			stmt = conn.createStatement();
			
		String sql = "INSERT INTO Employees" +
				"VALUES ("+firstName+","+ lastName+","+ id+","+ salary+")";
		stmt.executeUpdate(sql);

			   /*     PreparedStatement ps = conn.prepareStatement(sql);
			        ps.setString(1, firstName);
			        ps.setString(2, lastName);
			        ps.setInt(3, id);
			        ps.setDouble(4, salary);
			        ps.executeQuery();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}*/
	
	public void addSingleUser(Users aUser) {
		  
		try {
		  stmt = conn.createStatement();
		  String sql;
		  
		  String userName = aUser.getUserName();
		  String password = aUser.getPassword();
		  String email = aUser.getEmail();
		  

		  sql = "INSERT INTO Users (EmailAddress, Username, Password)" +
		          "VALUES ('" + email + "', '" + userName + 
				  "', '" + password + "')";
		  stmt.executeUpdate(sql);
		  
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}
	
	public boolean findUserByUsername(String aUserName) {
		boolean userExists = false;
		String SQL = "SELECT * from Users";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){	
				if(aUserName.equals( rs.getString(14) )) {
					userExists = true;
				}    
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userExists;
	}
	public boolean findUserByPassword(String password) {
		boolean passwordMatches = false;
		String SQL = "SELECT * from Users";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){	
				if(password.equals( rs.getString(15) )) {
					passwordMatches = true;
				}    
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return passwordMatches;
	}
	
	public Users returnUserByUsername(String aUserName) {
		String SQL = "SELECT Username, Password from Users;";
	    Statement stat;
	   
	    Users aUser = new Users();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(aUserName.equals( rs.getString("Username") )) {
					aUser.setUserName(rs.getString("Username"));
					aUser.setPassword(rs.getString("Password"));
				} 
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return aUser;
	}
	
	public void connectMeIn() {
		try{
			//Register the JDBC driver
			Class.forName("com.mysql.jdbc.Driver");			
		}catch(ClassNotFoundException e){
			System.err.println(e);
			System.exit (-1);
		}
		try {
			 //Open a connection
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	/*public double getSalary(String lastName) {
		 double salary = -99.0;
		 String sql = "SELECT * FROM Employees where Last_Name=?";
		 try {
			 ps = conn.prepareStatement(sql);
		
			 ps.setString(1, lastName);
			  
			 ResultSet rs = ps.executeQuery();
			  
			  //Extract data from result set
			  while(rs.next()){
				    //Retrieve by column name
				    salary = rs.getInt("Salary");
			  }
		  
		 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	     }
		 return salary;
	}*/
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
