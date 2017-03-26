package lecture464.model;

import java.util.ArrayList;

public class Bank {
	
	private int Id;
	private String CardHolderName;
	private int CreditCardNumber;
	private double Total; 
	private double DBbalance;

	public Bank (int CreditCardNumber, double Total) {
		super();
	  	this.CreditCardNumber = CreditCardNumber;
	    this.Total =  Total;

	    } 
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getCardHolderName() {
		return CardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		CardHolderName = cardHolderName;
	}
	public double getCreditCardNumber() {
		return CreditCardNumber;
	}
	public void setCreditCardNumber(int creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	public double getTotal() {
		return Total;
	}
	public void setTotal(double balance) {
		Total = balance;
	}
	
	public double getDBbalance (int creditNumber) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.setCreditBalance(creditNumber);
		DBbalance = db.getCreditBalance();
		db.closeConnection();
		return DBbalance;
	}
	
	public boolean checkDBbalance (int total) {
		boolean success = true;
		if (total>DBbalance) {
			success = false;
		}
		return success;
	}
	
	public void setNewBalance(double DBbalance, double Total, int creditNumber){
		double newBalance = (DBbalance-Total);
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.updateCreditBalance(creditNumber, newBalance);
		db.closeConnection();
	}
	
}
