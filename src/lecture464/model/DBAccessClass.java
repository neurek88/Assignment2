package lecture464.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import lecture464.model.Products;

import lecture464.model.Users;


public class DBAccessClass {	
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement ps = null;
  
	private ArrayList<Products> list = new ArrayList<Products>();
	private ArrayList<Products> orderProducts = new ArrayList<Products>();
	private ArrayList<ArrayList<Products>> completeOrderProducts = new ArrayList<ArrayList<Products>>();
	private ArrayList<Integer> orderList = new ArrayList<Integer>();
	private ArrayList<Orders> orderProductList = new ArrayList<Orders>();
	private ArrayList<Orders> completeOrderArray = new ArrayList<Orders>();
	private ArrayList<Orders> completeOrderInfo = new ArrayList<Orders>();
	private Orders OrderBean;
	private Products OrderProductBean;
	private Products ProductBean;
	private ArrayList<Products> ReviewList = new ArrayList<Products>();
	private ArrayList<Products> QuestionList = new ArrayList<Products>();
	private int cardBalance;
    private int userId;
    private int orderId;
    private int NewestOrderID;
	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";  
	//final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/rhooper";
	final String DB_URL = "jdbc:mysql://cse.unl.edu:3306/rhooper?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	

	//  Database credentials
	static final String USER = "rhooper"; // Replace with your CSE_LOGIN
	static final String PASS = "An6-vN";   // Replace with your CSE MySQL_PASSWORD0
	
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
	public void insertOrderData ( int customerId, double totalCost, String shippingAddress, String billAddress, int creditNumber) {
		if(conn !=null) {
		try{
			stmt = conn.createStatement();
			
		String sql = "INSERT INTO Orders ( `CustomerId`, `TotalCost`, `OrderDate`, `ShippingAddress`, `BillingAddress`, `CreditCardNumber`)" +
				"VALUES (" + customerId + ", " + totalCost + ", CURRENT_DATE(), '" + shippingAddress + "', '" + billAddress + "', '" + creditNumber +"' )";
		stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}
	
	public void insertQuestionData (int productId, int customerId, String question) {
		try{
			stmt = conn.createStatement();
			
		String sql = "INSERT INTO ProductQA ( `ProductId`, `CustomerId`, `Question`)" +
				"VALUES (" + productId + ", " + customerId + ",'" + question + "')";
		stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void insertReviewData (int productId, int customerId, String review, int reviewRating) {
		try{
			stmt = conn.createStatement();
			
		String sql = "INSERT INTO CustomerReviews ( `ProductId`, `CustomerId`, `ReviewDate`, `Rating`, `Review`)" +
				"VALUES (" + productId + ", " + customerId + ", CURRENT_DATE(), '" + reviewRating + "', '" + review +"' )";
		stmt.executeUpdate(sql);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void searchReviewData (int productId) {
		 String query = "SELECT * FROM CustomerReviews WHERE ProductId LIKE ?";
		    
		    try {
		    	
		        ps = conn.prepareStatement(query);
		        ps.setInt(1, productId);
		        
		        ResultSet rs = ps.executeQuery();
		        
		        
				  while(rs.next()){
					    //Retrieve by column name
					  int Id = rs.getInt("Id");
					  int CustomerId = rs.getInt("CustomerId");
					  Date ReviewDate = rs.getDate("ReviewDate");
					  String Review = rs.getString("Review");
					  int Rating = rs.getInt("Rating");
					  System.out.println(CustomerId);
					  Products ReviewBean = new Products(Id,null,0,null,0,0,0,0,null,null);
					  ReviewBean.setReviewCustomerID(CustomerId);
					  ReviewBean.setReview(Review);
					  ReviewBean.setRating(Rating);
					  ReviewBean.setReviewDate(ReviewDate);
					 ReviewList.add(ReviewBean); 
				  }
		            
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

	}
	public ArrayList<Products> getReviewInfo() {
		return ReviewList;
	}
	
	public void searchQuestionData (int productId) {
		 String query = "SELECT * FROM ProductQA WHERE ProductId LIKE ?";
		    
		    try {
		    	
		        ps = conn.prepareStatement(query);
		        ps.setInt(1, productId);
		        
		        ResultSet rs = ps.executeQuery();
		        
		        
				  while(rs.next()){
					    //Retrieve by column name
					  int Id = rs.getInt("Id");
					  int CustomerId = rs.getInt("CustomerId");
					  String productQuestion = rs.getString("Question");
					  String productAnswer = rs.getString("Answer");
					  Products QuestionBean = new Products(Id,null,0,null,0,0,0,0,null,null);
					  QuestionBean.setReviewCustomerID(CustomerId);
					  QuestionBean.setProductQuestion(productQuestion);
					  QuestionBean.setProductAnswer(productAnswer);
					 QuestionList.add(QuestionBean);
				  }
		            
		    } catch (Exception e) {
		        e.printStackTrace();
		    }

	}
	public ArrayList<Products> getQuestionData() {
		return QuestionList;
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
		String SQL = "SELECT Username, Password, FirstName, LastName from Users;";
	    Statement stat;
	   
	    Users aUser = new Users();
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){
				if(aUserName.equals( rs.getString("Username") )) {
					aUser.setUserName(rs.getString("Username"));
					aUser.setPassword(rs.getString("Password"));
					aUser.setFirstName(rs.getString("FirstName"));
					aUser.setLastName(rs.getString("LastName"));
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
		return userId;
	}
	
	public void connectMeIn() {
		try{
			//Register the JDBC driver
			Class.forName(JDBC_DRIVER);			
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
	            
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	}
	
	//public void SearchShippingS

	public void SearchOrderProducts(Orders aOrder){
	    String query = "SELECT * FROM Products WHERE Id LIKE ?";
	    
	    	try {
		    	int thisID = aOrder.getProductId();
		        ps = conn.prepareStatement(query);
		        ps.setInt(1, thisID);
		        
		        ResultSet rs = ps.executeQuery();
		        
		        
				  while(rs.next()){ 
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
				  OrderProductBean = new Products(Id, ProductName, ProductCategoryIndex, ProductDescription, Price, AvailableQuantity, EstimatedDeliveryDays, SellerId, ProductPhotosLinks, ProductThumbnail);  }
		            
		    } catch (Exception e) {
		        e.printStackTrace();
		    } 
	    
	    }
	public Products   getOrderProduct() {
		return OrderProductBean;
	}
	
	public void insertOrderItemInfo(int OrderId, int ProductId, double ProductPrice, int Quantity, int ShippingStatus, int Status) {
		try{
			stmt = conn.createStatement();
			
		String sql = "INSERT INTO OrderItems ( OrderId, ProductId, ProductPrice, Quantity, ShippingStatus, Status)" +
				"VALUES ('" + OrderId + "', '" + ProductId + "', '" + ProductPrice +"', '" + Quantity +"', '" + ShippingStatus +"', '" + Status + "')";
		stmt.executeUpdate(sql);


		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	    
	
	public void findNewestOrderIdById(int customerID){
	    String query = "SELECT Id, CustomerId FROM Orders WHERE CustomerId LIKE ?";
	    
	    int recentOrderID = 0;
	    try {
	    	
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, customerID);
	        
	        ResultSet rs = ps.executeQuery();
	        
			  while(rs.next()){
				  
				 
				 NewestOrderID = rs.getInt("Id");
				 if (NewestOrderID > recentOrderID) {
					 recentOrderID = NewestOrderID;
				 }
				 }
	            
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	}
	
	public int getNewestOrderId() {
		return NewestOrderID;
		
	}
	
	public void findOrdersById(int customerID){
	    String query = "SELECT Id, CustomerId FROM Orders WHERE CustomerId LIKE ?";
	    
	    try {
	    	
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, customerID);
	        
	        ResultSet rs = ps.executeQuery();
	        
			  while(rs.next()){
				 int orderID = rs.getInt("Id");
				 orderList.add(orderID);
				 }
	            
	    } catch (Exception e) {
	        e.printStackTrace();
	    } 
	}
	

	public void findProductsOrderedByOrderID(int orderArray){
	     String query = "SELECT ProductId, OrderId FROM OrderItems WHERE OrderId LIKE ?";
	     
	     ArrayList<Orders> orderProductList = new ArrayList<Orders>();
	     
	      try {
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, orderArray );
	          ResultSet rs = ps.executeQuery();
	          Orders objt = null;
	      while(rs.next()){
	      int orderID = rs.getInt("OrderId");
	      int productID = rs.getInt("ProductId");
	      objt = new Orders(productID, orderID);
	      if (objt!=null) {
		      orderProductList.add(objt);
		      }
	      }
	      
	      } catch (Exception e) {
	          e.printStackTrace();
	      } 
		  completeOrderArray.addAll(orderProductList);
		     orderProductList.clear();
	     }
	
	public void findOrderedInfoByOrderID(int orderArray){
	     String query = "SELECT ProductId, OrderId, ShippingStatus FROM OrderItems WHERE OrderId LIKE ?";
	     
	     ArrayList<Orders> orderProductList = new ArrayList<Orders>();
	     
	      try {
	          ps = conn.prepareStatement(query);
	          ps.setInt(1, orderArray );
	          ResultSet rs = ps.executeQuery();
	          Orders objt = null;
	      while(rs.next()){
	      int orderID = rs.getInt("OrderId");
	      int productID = rs.getInt("ProductId");
	      int ShippingStatus =rs.getInt("ShippingStatus");
	      objt = new Orders(productID, orderID);
	      objt.setShippingStatus(ShippingStatus);
	      }
	      
	      } catch (Exception e) {
	          e.printStackTrace();
	      } 
		  completeOrderArray.addAll(orderProductList);
		     orderProductList.clear();
	     }
	public ArrayList<Orders> getCompleteOrderInfo() {
		return completeOrderInfo;
	}
	
	
	public ArrayList<Orders> getCompleteOrderList() {
		return completeOrderArray;
	}

	public void clearOrderProductLists() {
		completeOrderArray.clear();
	}

	public int searchShippingStatus(int order) {
		int ShippingStatus = 0;
		try {
			Statement stat = conn.createStatement();
			String query = "SELECT ProductId, OrderId, ShippingStatus FROM OrderItems WHERE OrderId = " +order; 
			ResultSet rs = stat.executeQuery(query);
			
			while (rs.next()){
				 ShippingStatus =rs.getInt("ShippingStatus");
			}  
		}
	     
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
		return ShippingStatus;
	     }
	
	public void changeShippingStatus(int product, int order){
		
		try{
	    	  Statement stat = conn.createStatement();
	    	  String query = "UPDATE OrderItems SET ShippingStatus = 2 WHERE OrderId = " +order+" AND ProductId = "+product; 
	    	  stat.executeUpdate(query);
		}
	      
	      catch (Exception e) {
	          e.printStackTrace();
	      } 
	     }
	
	public ArrayList<Integer> getOrderbyId() {
		return orderList;
	}
	public Products getProduct() {
		return ProductBean;
	}
	
	public void SearchProductInfo(String pid){
    String query = "SELECT * FROM Products WHERE ProductName LIKE ?";
    
    try {
    	
        ps = conn.prepareStatement(query);
        ps.setString(1, "%" + pid + "%");
        
        ResultSet rs = ps.executeQuery();
        
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
            
    } catch (Exception e) {
        e.printStackTrace();
    } 
}
	public ArrayList<Products> getProductList() {
		return list;
	}
	
	public boolean checkCreditCard(int creditNumber, String creditBrand, int CVV) {
		boolean cardMatches = false;
		String SQL = "SELECT * from CreditCards";
	    Statement stat;
		try {
			stat = conn.createStatement();
			ResultSet rs = stat.executeQuery(SQL);
			
			while (rs.next()){	
				if(creditNumber == ( rs.getDouble(3)) && creditBrand.equals(rs.getString(5)) && CVV == (rs.getInt(7))) {
					cardMatches = true;
				}
			}
			
		    stat.close();
		        
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cardMatches;
	}
	
	public void setCreditBalance(int creditNumber) {
		String SQL = "SELECT * from CreditCards WHERE CreditCardNumber LIKE ?";
		try {
			ps = conn.prepareStatement(SQL);
	          ps.setInt(1, creditNumber );
	          ResultSet rs = ps.executeQuery();
			
			while (rs.next()){	
				int CardNumber = rs.getInt(3);
				cardBalance = rs.getInt(4);
				}
			}
			catch (Exception e) {
        e.printStackTrace();
    } 
		        
	}
	public int getCreditBalance() {
		return cardBalance; 
	}
	
	public void updateCreditBalance (int creditNumber, double balance) {
			
			try{
		    	  Statement stat = conn.createStatement();
		    	  String query = "UPDATE CreditCards SET Balance ="+balance+" WHERE CreditCardNumber = " +creditNumber; 
		    	  stat.executeUpdate(query);
			}
		      
		      catch (Exception e) {
		          e.printStackTrace();
		      } 

	}
	
	public void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
