package lecture464.model;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Users {
	
	private String userName;
	private String password;
	private int Id;
	
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
	public Users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public void registerUser(Users aUser, String propFilePath) {
		
		Properties p = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			p.load(fis);
			p.setProperty(aUser.getUserName(), aUser.getPassword());
			p.store(new FileOutputStream(propFilePath), null);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	// validateUser
	public boolean validateUser(Users aUser, String propFilePath){
		boolean success = true;
		Properties p = new Properties();
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			
			p.load(fis);
				
			// Check whether the username exists or not
			if(!p.containsKey(aUser.getUserName())) {			
				// Link-redirection
				success = false;
			} else { // Check whether the password matches or not
				String pword = p.getProperty(aUser.getUserName());  
				if(!pword.equals(aUser.getPassword())) {
					success = false; // Link-redirection
				} else {
					success = true; // Link-redirection
				}
				System.out.println(success);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			success = false;
		} finally {
				if(fis!=null) {
					try {
						fis.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
		//First check whether the user already exists via methods from Users class
		 	
	// removeUser
	}
		return success;
	}
}
	

