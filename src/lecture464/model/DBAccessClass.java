package lecture464.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBAccessClass {	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
	
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	//static final String DB_URL = "jdbc:mysql://localhost/EMP"; 
	final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/rhooper";
	
	

	//  Database credentials
	static final String USER = "rhooper"; // Replace with your CSE_LOGIN
	static final String PASS = "An6-vN";   // Replace with your CSE MySQL_PASSWORD
	
/*	public void createEmployeeTable() {
		  
		  try {
			stmt = conn.createStatement();
		
		  String sql;
		  sql = "DROP TABLE IF EXISTS Employees";
		  stmt.executeUpdate(sql);

		  sql = "CREATE TABLE Employees " +
		          "(ID INTEGER not NULL, " +
		          " First_Name VARCHAR(255), " + 
		          " Last_Name VARCHAR(255), " + 
		          " Salary DOUBLE, " + 
		          " PRIMARY KEY ( ID ))"; 

		  stmt.executeUpdate(sql);

		  sql = "INSERT INTO Employees " +
		          "VALUES (111, 'Richard', 'Feynman', 1000.00)";
		  stmt.executeUpdate(sql);
		  sql = "INSERT INTO Employees " +
		          "VALUES (112, 'Alan', 'Turing', 5000.00)";
		  stmt.executeUpdate(sql);
		  sql = "INSERT INTO Employees " +
		          "VALUES (113, 'Ada', 'Lovelace', 4000.00)";
		  stmt.executeUpdate(sql);
		  sql = "INSERT INTO Employees " +
		          "VALUES (114, 'Albert', 'Einstein', 2000.00)";
		  stmt.executeUpdate(sql);
		  
		  } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
	}*/
	
	public void insertData (String firstName, String lastName, int id, double salary) {
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
		*/}
		catch (SQLException e) {
			e.printStackTrace();
		}
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
	
	public double getSalary(String lastName) {
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
	}
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
