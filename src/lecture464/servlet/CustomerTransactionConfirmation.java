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
		String userName = firstName;
		double creditNumber = Double.parseDouble(request.getParameter("creditNumber"));
		String creditBrand = request.getParameter("creditBrand");
		int userId = profile.getUserId();
		//double sum = Double.parseDouble(request.getParameter("total"));
		double balance = 32.00;
		int CVV = Integer.parseInt(request.getParameter("CVV"));
		int expirationDate = Integer.parseInt(request.getParameter("expirationDate"));
		String shippingAddress = request.getParameter("shippingAddress");
		String billAddress = request.getParameter("billAddress");
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		if (userName !=null || creditNumber!=0 || creditBrand!=null || userId!=0 || CVV!=0) {
		if (db.checkCreditCard(creditNumber, creditBrand, CVV)) {
	//		System.out.println(sum);
		HttpSession session = request.getSession();
		Users orderUser = new Users();
			orderUser.setFirstName(firstName);
			orderUser.setLastName(lastName);
			orderUser.setShippingAddress(shippingAddress);
			orderUser.setBillAddress(billAddress);
		session.setAttribute("orderUser", orderUser);
		
		Transactions newCreditCard = new Transactions();
			newCreditCard.setCardType(creditBrand);
			newCreditCard.setCVV(CVV);
			newCreditCard.setCreditCardNumber(creditNumber);
			newCreditCard.setExpirationDate(expirationDate);
	//		newCreditCard.setNewBalance(sum);
		session.setAttribute("newCreditCard", newCreditCard);
		
		db.insertOrderData( userId, balance , shippingAddress, billAddress, creditNumber);
		
        RequestDispatcher view = request.getRequestDispatcher("CustomerTransactionConfirmation.jsp");
        view.forward(request, response);
			}
		}else {
            RequestDispatcher view = request.getRequestDispatcher("CustomerTransaction.jsp");
            view.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
