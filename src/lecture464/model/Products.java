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
	
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Products {
	
	private int Id;
	private String ProductName;
	private int ProductCategoryIndex;
	private String ProductDescription;
	private int Price;
	private int AvailableQuantity;
	private int EstimatedDeliveryDays;
	private int SellerId;
	
	public int getUserId() {
		return Id;
	}
	public void setUserId(int Id) {
		this.Id = Id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Products(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	  static {
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

}
	

