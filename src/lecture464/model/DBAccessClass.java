package lecture464.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lecture464.model.Products;

import lecture464.model.Users;


public class DBAccessClass {	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
  
	private ArrayList<Products> list = new ArrayList<Products>();
	private Products ProductBean;
    private int userId;
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/rhooper";
	
	

	//  Database credentials
	static final String USER = "rhooper"; // Replace with your CSE_LOGIN
	static final String PASS = "An6-vN";   // Replace with your CSE MySQL_PASSWORD
	
	public void insertCreditData (String userName, int creditNumber, String creditBrand, int userId, int CVV, int expirationDate) {
		int ccLimit = 1000;
		try{
			stmt = conn.createStatement();
			
		String sql = "INSERT INTO CreditCards (CardHolderName, CreditCardNumber, Balance, CardType, UserId, CVV, ExpirationDate)" +
				"VALUES ("+ userName +","+ creditNumber + "," + creditBrand +","+ ccLimit +"," + userId +"," + CVV +","+expirationDate+ ")";
		stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addSingleUser(Users aUser) {
		  
		try {
		  stmt = conn.createStatement();
		  String sql;
		  
		  String userName = aUser.getUserName();
		  String firstName = aUser.getFirstName();
		  String lastName = aUser.getLastName();
		  String password = aUser.getPassword();
		  String email = aUser.getEmail();
		  

		  sql = "INSERT INTO Users (FirstName, LastName, EmailAddress, Username, Password)" +
		          "VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', '" + userName + "', '" + password + "')";
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
	
	public int returnUserIDbyUsername (String aUserName) {
		String SQL = "SELECT Username, Id from Users;";
	    Statement stat;
	   
	
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(aUserName.equals( rs.getString("Username") )) {
					userId = rs.getInt("Id");
				} 
		    }
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(userId);
		return userId;
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
	public void SearchProduct(int pid){
	    String query = "SELECT * FROM Products WHERE Id LIKE ?";
	    
	    try {
	    	
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, pid);
	        
	        ResultSet rs = ps.executeQuery();
	        System.out.println("query " + query);
	        
	        
			  while(rs.next()){
				    //Retrieve by column name
				  int Id = rs.getInt("Id");
				  String ProductName = rs.getString("ProductName");
				  int ProductCategoryIndex = rs.getInt("ProducCategoryIndex");
				  String ProductDescription = rs.getString("ProductDescription");
				  double Price = rs.getInt("Price");
				  int AvailableQuantity = rs.getInt("AvailableQuantity");
				  int EstimatedDeliveryDays = rs.getInt("EstimatedDeliveryDays");
				  int SellerId = rs.getInt("SellerId");
				  String ProductPhotosLinks = rs.getString("ProductPhotosLinks");
				  String ProductThumbnail = rs.getString("ProductThumbnail");
				  ProductBean = new Products(Id, ProductName, ProductCategoryIndex, ProductDescription, Price, AvailableQuantity, EstimatedDeliveryDays, SellerId, ProductPhotosLinks, ProductThumbnail);
			  }
			  
			  System.out.println(ProductBean.getProductName());
	            
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	}
	
	public Object getProduct() {
		return ProductBean;
	}
	
	public void SearchProductInfo(String pid){
    String query = "SELECT * FROM Products WHERE ProductName LIKE ?";
    
    try {
    	
        ps = conn.prepareStatement(query);
        ps.setString(1, "%" + pid + "%");
        
        ResultSet rs = ps.executeQuery();
        System.out.println("query " + query);
        
        
		  while(rs.next()){
			    //Retrieve by column name
			  int Id = rs.getInt("Id");
			  String ProductName = rs.getString("ProductName");
			  int ProductCategoryIndex = rs.getInt("ProducCategoryIndex");
			  String ProductDescription = rs.getString("ProductDescription");
			  double Price = rs.getInt("Price");
			  int AvailableQuantity = rs.getInt("AvailableQuantity");
			  int EstimatedDeliveryDays = rs.getInt("EstimatedDeliveryDays");
			  int SellerId = rs.getInt("SellerId");
			  String ProductPhotosLinks = rs.getString("ProductPhotosLinks");
			  String ProductThumbnail = rs.getString("ProductThumbnail");
			  Products ProductBean = new Products(Id, ProductName, ProductCategoryIndex, ProductDescription, Price, AvailableQuantity, EstimatedDeliveryDays, SellerId, ProductPhotosLinks, ProductThumbnail);
			  //store Data
			  list.add(ProductBean);
		  }
		  
		  System.out.println(list.get(0).getProductName());
            
    } catch (Exception e) {
        e.printStackTrace();
    } 
}
	public ArrayList<Products> getProductList() {
		return list;
	}
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
