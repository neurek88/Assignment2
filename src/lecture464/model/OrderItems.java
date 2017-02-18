package lecture464.model;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import lecture.mvcel.BankCustomer;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class OrderItems {
	
	private int Id;
	private int OrderId;
	private int SellerId;
	private int ProductId;
	private int ProductPrice;
	private int Quantity;
	private int ShippingStatus;
	private int ShippingRefNo;
	private int Status;
	
	
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
	public OrderItems(String userName, String password) {
		super();
		this.Id = Id;
		this.password = password;
	}
	
	private static HashMap<String, Customer> customers;

	  static {
	    customers = new HashMap<String, Customer>();
	    customers.put("id001",
	                  new BankCustomer("id001",
	                                   "John",
	                                   "Hacker",
	                                   -3456.78));
	    customers.put("id002",
	                  new BankCustomer("id002",
	                                   "Jane",
	                                   "Hacker",
	                                   1234.56));
	    customers.put("id003",
	                  new BankCustomer("id003",
	                                   "Juan",
	                                   "Hacker",
	                                   987654.32));
	  }
	
}
	

