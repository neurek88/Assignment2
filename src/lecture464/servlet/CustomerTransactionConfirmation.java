package lecture464.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.Users;
import lecture464.model.DBAccessClass;
import lecture464.model.Orders;
import lecture464.model.Products;
import lecture464.model.Transactions;

/**
 * Servlet implementation class Register
 */
public class CustomerTransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Users getProfile(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Users profile = (Users) session.getAttribute("userBean");
	     return profile;
	}
	
	private ArrayList<Products> getCart(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     ArrayList<Products> cart = (ArrayList<Products>) session.getAttribute("cart");
	     return cart;
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerTransactionConfirmation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Users profile = getProfile(request);
		ArrayList<Products> shoppingCart = getCart(request);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int userId = profile.getUserId();
		//int sum = Integer.parseInt(request.getParameter("total"));
		double balance = 32.00;
		String shippingAddress = request.getParameter("shippingAddress");
		String billAddress = request.getParameter("billAddress");
	
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		HttpSession session = request.getSession();
		int transactionStatus = 0;
		if (firstName !=null && lastName !=null && shippingAddress != null && shippingAddress != null && request.getParameter("creditNumber") != null && request.getParameter("creditBrand") != null && request.getParameter("CVV") !=null && request.getParameter("expirationDate") !=null) {
		/*	orderUser.setFirstName(firstName);
			orderUser.setLastName(lastName);
			orderUser.setShippingAddress(shippingAddress);
			orderUser.setBillAddress(billAddress);
			session.setAttribute("orderUser", orderUser);
			successBean = "Success!";
			session.setAttribute("SuccessBean", successBean); */
			int creditNumber = Integer.parseInt(request.getParameter("creditNumber"));
			String creditBrand = request.getParameter("creditBrand");
			int CVV = Integer.parseInt(request.getParameter("CVV"));
			int expirationDate = Integer.parseInt(request.getParameter("expirationDate"));
			int success = 0;
				if(db.checkCreditCard(creditNumber, creditBrand, CVV)) {
					success = 88; 
				}
				System.out.println(expirationDate);
			System.out.println(success);
			if(success == 88) {
				transactionStatus = 11;
			} else {
				transactionStatus = 00;
			}
			/*		db.insertOrderData( userId, balance , shippingAddress, billAddress, creditNumber);
					db.findNewestOrderIdById(userId);
					int neworderId = db.getNewestOrderId();
					for (int i=0; i<shoppingCart.size();i++){
					int productId = shoppingCart.get(i).getProductId();
					db.insertOrderItemInfo(neworderId, productId, sum, 1, 1, 1);
					}
					int productId = Integer.parseInt(request.getParameter("productId"));
					Orders orderInfo = new Orders(productId, neworderId);
					session.setAttribute("OrderItems", orderInfo);
					successBean = "Success!";
					session.setAttribute("SuccessBean", successBean);
			} else {
				newCreditCard.setCardType("Incorrect Credit Card Information");
				session.setAttribute("newCreditCard", newCreditCard);
				successBean = "Transaction Failed";
				session.setAttribute("SuccessBean", successBean);
			}
			

		} else {
			orderUser.setFirstName("Missing User Info");
			session.setAttribute("orderUser", orderUser);
			successBean = "Transaction Failed";
			session.setAttribute("SuccessBean", successBean);
		} */
		}
		db.closeConnection();

		
		PrintWriter out = response.getWriter(); 
		out.println(transactionStatus);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
