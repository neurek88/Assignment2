package lecture464.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.DBAccessClass;
import lecture464.model.Orders;
import lecture464.model.Users;

/**
 * Servlet implementation class Register
 */
public class ViewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Users getProfile(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Users profile = (Users) session.getAttribute("userBean");
	     return profile;
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		Users profile = getProfile(request);
		int userId = profile.getUserId();
		ArrayList<Integer> orderIDList = new ArrayList<Integer>();
		ArrayList<ArrayList<Orders>> completeOrderArray = new ArrayList<ArrayList<Orders>>();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.findOrdersById(userId);
		orderIDList =db.getOrderbyId();
		db.findProductsOrderedByOrderID(orderIDList);
		completeOrderArray = db.getCompleteOrderList();
		db.closeConnection();
		System.out.println(userId);
		
		session.setAttribute("OrderArray", completeOrderArray);
		
		RequestDispatcher view = request.getRequestDispatcher("ViewOrders.jsp");
        view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
