package lecture464.model;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.xml.ws.Response;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Transactions {

	private int Id;
	private double creditCard;
	private double creditCardBal;
	
	
	public int getUserId() {
		return Id;
	}
	public void setUserId(int Id) {
		this.Id = Id;
	}
	public double getCreditCard() {
		return creditCard;
	}
	public void setBalance (double balance) {
		creditCardBal = balance;
	}
	public Transactions(int Id, double creditCard) {
		super();
		this.Id = Id;
		this.creditCard = creditCard;
	}

}
	

