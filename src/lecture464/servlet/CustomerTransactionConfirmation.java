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

import lecture464.model.Users;
import lecture464.model.DBAccessClass;

/**
 * Servlet implementation class Register
 */
public class CustomerTransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		String userName = request.getParameter("userName");
		int creditId = Integer.parseInt("creditId");
		int creditNumber = Integer.parseInt("creditNumber");
		String creditBrand = request.getParameter("creditBrand");
		int userId = Integer.parseInt("userId");
		double balance = Double.parseDouble("salary");
		int CVV = Integer.parseInt("CVV");
		int expirationDate = Integer.parseInt("expirationDate");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String shippingAddress = request.getParameter("shippingAddress");
		String billAddress = request.getParameter("billAddress");
		
		DBAccessClass db = new DBAccessClass();
		
		db.connectMeIn();
		if (userName !=null || creditId !=0 || creditNumber!=0 || creditBrand!=null || userId!=0 || balance!=0 || CVV!=0 || expirationDate!=0) {
		db.insertCreditData(creditId, userName, creditNumber, balance, creditBrand, userId, CVV, expirationDate);
        RequestDispatcher view = request.getRequestDispatcher("CustomerTranscationConfirmation.jsp");
        view.forward(request, response);
		} else {
            RequestDispatcher view = request.getRequestDispatcher("CustomerTranscation.jsp");
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
