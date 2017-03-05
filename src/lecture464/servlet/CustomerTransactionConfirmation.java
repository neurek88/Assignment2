package lecture464.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int creditNumber = Integer.parseInt(request.getParameter("creditNumber"));
		String creditBrand = request.getParameter("creditBrand");
		int userId = profile.getUserId();
		int productId = Integer.parseInt(request.getParameter("productId"));
		int sum = Integer.parseInt(request.getParameter("total"));
		double balance = 32.00;
		int CVV = Integer.parseInt(request.getParameter("CVV"));
		int expirationDate = Integer.parseInt(request.getParameter("expirationDate"));
		String shippingAddress = request.getParameter("shippingAddress");
		String billAddress = request.getParameter("billAddress");
		System.out.println(creditBrand);
		System.out.println(firstName);
		System.out.println(creditNumber);
		System.out.println(userId);
		System.out.println(CVV);
		System.out.println(sum);
		System.out.println(productId);
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		HttpSession session = request.getSession();
		Users orderUser = new Users();
		Transactions newCreditCard = new Transactions();
		//if (firstName !=null || shippingAddress != null || creditNumber!=0 || creditBrand!=null || userId!=0 || CVV!=0) {
		if (firstName !=null || lastName !=null || shippingAddress != null || shippingAddress != null) {
			orderUser.setFirstName(firstName);
			orderUser.setLastName(lastName);
			orderUser.setShippingAddress(shippingAddress);
			orderUser.setBillAddress(billAddress);
			session.setAttribute("orderUser", orderUser);
				if (db.checkCreditCard(creditNumber, creditBrand, CVV)) {
					newCreditCard.setCardType(creditBrand);
					newCreditCard.setCVV(CVV);
					newCreditCard.setCreditCardNumber(creditNumber);
					newCreditCard.setExpirationDate(expirationDate);
		//			newCreditCard.setNewBalance(sum);
					session.setAttribute("newCreditCard", newCreditCard);
					session.removeAttribute("cart");
					db.insertOrderData( userId, balance , shippingAddress, billAddress, creditNumber);
					db.findNewestOrderIdById(userId);
					int orderId = db.getNewestOrderId();
					db.SearchProduct(productId);
					Orders orderInfo = new Orders(orderId, productId);
					orderInfo.setOrderId(orderId);
					session.setAttribute("OrderItems", orderInfo);
					
			} else {
				newCreditCard.setCardType("Incorrect Credit Card Information");
				session.setAttribute("newCreditCard", newCreditCard);
			}
			

		} else {
			orderUser.setFirstName("Missing User Info");
			session.setAttribute("orderUser", orderUser);
		}	
        RequestDispatcher view = request.getRequestDispatcher("CustomerTransactionConfirmation.jsp");
        view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
