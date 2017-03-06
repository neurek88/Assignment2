package lecture464.model;

import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.xml.ws.Response;
import lecture464.model.DBAccessClass;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class Orders {
	
	private int CustomerId;
	private int OrderId;
	private int OrderCost;
	private int SellerId;
	private int ProductId;
	private int ProductPrice;
	private int Quantity;
	private int ShippingStatus;
	private int ShippingRefNo;
	private int Status;
	private ArrayList<Integer> ArrayOrderId = new ArrayList<Integer>();
	private ArrayList<ArrayList<Orders>> ArrayListOrders = new ArrayList<ArrayList<Orders>>();
	public int getUserId() {
		return CustomerId;
	}
	public void setUserId(int customerId) {
		this.CustomerId = customerId;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int qty) {
		this.Quantity = qty;
	}
	
	public int getOrderCost() {
		return OrderCost;
	}
	public void setOrderCost(int orderCost) {
		this.OrderCost = orderCost;
	}
	
	
	
	public Orders(int ProductId, int OrderId) {
		super();
		this.ProductId = ProductId;
		this.OrderId = OrderId;
		/*this.Quantity = qty;
		this.OrderCost = orderCost;*/
	}
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public int getSellerId() {
		return SellerId;
	}
	public void setSellerId(int sellerId) {
		SellerId = sellerId;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public int getProductPrice() {
		return ProductPrice;
	}
	public void setProductPrice(int productPrice) {
		ProductPrice = productPrice;
	}
	public int getShippingStatus() {
		return ShippingStatus;
	}
	public void setShippingStatus(int shippingStatus) {
		ShippingStatus = shippingStatus;
	}
	public int getShippingRefNo() {
		return ShippingRefNo;
	}
	public void setShippingRefNo(int shippingRefNo) {
		ShippingRefNo = shippingRefNo;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	
	public void setArrayOrderIdforUser(int userId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.findOrdersById(userId);
		ArrayOrderId = db.getOrderbyId();
	}
public ArrayList<Integer> getArrayOrderIdfromUser() {
	return ArrayOrderId;
}

/*public void insertOrderItemInfo(){
	DBAccessClass db = new DBAccessClass();
	db.connectMeIn();
	db.insertOrderItemInfo(OrderId, ProductId, OrderCost, Quantity);
	db.closeConnection();
}*/
	/*public void findProductsbyOrderId(ArrayList<Integer> ArrayOrderId) {
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.findProductsOrderedByOrderID(ArrayOrderId);
		ArrayListOrders = db.getCompleteOrderList();
	}
	public ArrayList<ArrayList<Orders>> getProductsbyOrderId() {
		return ArrayListOrders;
	}*/
}
	

