package lecture464.model;

import java.io.FileInputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import lecture464.model.DBAccessClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
	
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Products {
	
	private int Id;
	private String ProductName;
	private int ProductCategoryIndex;
	private String ProductDescription;
	private double Price;
	private int AvailableQuantity;
	private int EstimatedDeliveryDays;
	private int SellerId;
	private String ProductPhotoLinks;
	private String ProductPhotosLinks;
	private String ProductVideosLinks;
	private String ProductThumbnail;
	
	public int getProductId() {
		return Id;
	}
	public void setProductId(String anId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		
		Id = db.SearchProductInfo(anId);
	}

	public Products() {
		super();

	}
	
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		
		//ProductName = db.SearchProductInfo(ProductName);
	}
	public int getProductCategoryIndex() {
		return ProductCategoryIndex;
	}
	public void setProductCategoryIndex(int productCategoryIndex) {
		ProductCategoryIndex = productCategoryIndex;
	}
	public String getProductDescription() {
		return ProductDescription;
	}
	public void setProductDescription(String productDescription) {
		ProductDescription = productDescription;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public int getAvailableQuantity() {
		return AvailableQuantity;
	}
	public void setAvailableQuantity(int availableQuantity) {
		AvailableQuantity = availableQuantity;
	}
	public String getProductPhotosLinks() {
		return ProductPhotosLinks;
	}
	public void setProductPhotosLinks(String productPhotosLinks) {
		ProductPhotosLinks = productPhotosLinks;
	}
	public String getProductThumbnail() {
		return ProductThumbnail;
	}
	public void setProductThumbnail(String productThumbnail) {
		ProductThumbnail = productThumbnail;
	}
	public void SearchProductInfo(String pid){
	Connection conn = null;
	PreparedStatement ps = null;
    Statement st;
    String query = "select * from Products where ProductName=? ";
    try {
        ps = conn.prepareStatement(query);
        ps.setString(1, pid);
        
        System.out.println("query " + query);
        st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

		  while(rs.next()){
			    //Retrieve by column name
			  	Id = rs.getInt("Id");
			    ProductName = rs.getString("ProductName");
				ProductCategoryIndex = rs.getInt("ProductCategoryIndex");
				ProductDescription = rs.getString("ProductDescription");
				Price = rs.getDouble("getInt");
				System.out.println(ProductName);
		  }
          
            
    } catch (Exception e) {
        e.printStackTrace();
    }
   }

	public void SearchProductInt(String pid){
	Connection conn = null;
	PreparedStatement ps = null;
	DBAccessClass db = new DBAccessClass();
	db.connectMeIn();
    Statement st;
    String query = "select * from Products where ProductName=? ";
    try {
        ps = conn.prepareStatement(query);
        ps.setString(1, pid);
        
        System.out.println("query " + query);
        st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

		  while(rs.next()){
			    //Retrieve by column name
			  	Id = rs.getInt("Id");
			    ProductName = rs.getString("ProductName");
				ProductCategoryIndex = rs.getInt("ProductCategoryIndex");
				ProductDescription = rs.getString("ProductDescription");
				Price = rs.getDouble("getInt");
				System.out.println(ProductName);
		  }
  
            
    } catch (Exception e) {
        e.printStackTrace();
    }
	}
	public void SearchProductDouble(String pid, String cat){
	Connection conn = null;
	PreparedStatement ps = null;
    Statement st;
    String query = "select * from Products where ProductName=? ";
    try {
        ps = conn.prepareStatement(query);
        ps.setString(1, pid);
        
        System.out.println("query " + query);
        st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

		  while(rs.next()){
			    //Retrieve by column name
			  	Id = rs.getInt("Id");
			    ProductName = rs.getString("ProductName");
				ProductCategoryIndex = rs.getInt("ProductCategoryIndex");
				ProductDescription = rs.getString("ProductDescription");
				cat = rs.getString(cat);
		  }
          
            
    } catch (Exception e) {
        e.printStackTrace();
    }
   }
	/*  static {
		    product = new HashMap<String, BankCustomer>();
		    product.put("id001",
		                  new BankCustomer("id001",
		                                   "John",
		                                   "Hacker",
		                                   -3456.78));
		    product.put("id002",
		                  new BankCustomer("id002",
		                                   "Jane",
		                                   "Hacker",
		                                   1234.56));
		    product.put("id003",
		                  new BankCustomer("id003",
		                                   "Juan",
		                                   "Hacker",
		                                   987654.32));
		  }
*/
}
	

