package lecture464.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Transactions {

	private int Id;
	private String CardHolderName;
	private double CreditCardNumber;
	private double Balance; 
	private String CardType;
	private int UserId;
	private int CVV;
	private int ExpirationDate;
	
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
	public void setCreditCardNumber(double creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		Balance = balance;
	}
	
	public void setNewBalance(double sum){
		Balance = (Balance-sum);
	}
	
	public String getCardType() {
		return CardType;
	}
	public void setCardType(String cardType) {
		CardType = cardType;
	}
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	public int getCVV() {
		return CVV;
	}
	public void setCVV(int cVV) {
		CVV = cVV;
	}
	public int getExpirationDate() {
		return ExpirationDate;
	}
	public void setExpirationDate(int expirationDate) {
		ExpirationDate = expirationDate;
	}
	

}
	

