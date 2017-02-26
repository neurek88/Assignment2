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
import java.util.HashMap;
import java.util.Properties;

public class Orders {
	
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
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int qty) {
		this.Quantity = qty;
	}
	public Orders(int Id, int qty) {
		super();
		this.Id = Id;
		this.Quantity = qty;
	}
	
/*	private static HashMap<int, Id> orders;

	  static {
		  orders = new HashMap<String, Customer>();
		  orders.put("id001",
	                  new BankCustomer("id001",
	                                   "John",
	                                   "Hacker",
	                                   -3456.78));
		  orders.put("id002",
	                  new BankCustomer("id002",
	                                   "Jane",
	                                   "Hacker",
	                                   1234.56));
		  orders.put("id003",
	                  new BankCustomer("id003",
	                                   "Juan",
	                                   "Hacker",
	                                   987654.32));
	  }
*/	
}
	
