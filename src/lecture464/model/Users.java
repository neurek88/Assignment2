package lecture464.model;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import lecture464.model.DBAccessClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class Users {
	
	private String userName;
	private String password;
	private String email;
	private int Id;
	
	public Users() {
		super();
	}
	
	public Users(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	
	public int getUserId() {
		return Id;
	}
	public void setUserId(int Id) {
		this.Id = Id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	public void registerUser(Users aUser) {
       	DBAccessClass db = new DBAccessClass();
       	db.connectMeIn();
       	db.addSingleUser(aUser);
       	db.closeConnection();
    }
    
    public boolean validateUserByUsername(String aUserName) {
    	    boolean userExists = false;
       	DBAccessClass db = new DBAccessClass();
       	db.connectMeIn();
       	userExists = db.findUserByUsername(aUserName);
       	db.closeConnection();
       	
       	return userExists;
    }
    
    public boolean validateUserByPassword(String password) {
	    boolean passwordMatches = false;
   	    DBAccessClass db = new DBAccessClass();
   	    db.connectMeIn();
   	    passwordMatches = db.findUserByPassword(password);
   	    db.closeConnection();
   	
   	    return passwordMatches;
    }
    
    
    public Users getUser(String aUserName) {   
	   	DBAccessClass db = new DBAccessClass();
	   	db.connectMeIn();
	   	Users aUser = db.returnUserByUsername(aUserName);
	   	db.closeConnection();
	   	
	   	return aUser;
    }
    
	
	public void SearchProducts(String pid){

		Connection conn = null;
	    Statement st;
	    try {

	        ArrayList al = null;
	        ArrayList pid_list = new ArrayList();
	        String query = "select * from Products where ProductName='" + pid + "' ";

	        System.out.println("query " + query);
	        st = conn.createStatement();
	        ResultSet rs = st.executeQuery(query);

	        while (rs.next()) {
	            al = new ArrayList();

//	            out.println(rs.getString(1));
//	            out.println(rs.getString(2));
//	            out.println(rs.getString(3));
//	            out.println(rs.getString(4));
	            al.add(rs.getString(1));
	            al.add(rs.getString(2));
	            al.add(rs.getString(3));
	            al.add(rs.getString(4));
	            

	            System.out.println("al :: " + al);
	            pid_list.add(al);
	        }
	        conn.close();
	        System.out.println("Disconnected!");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	   }
}
	

