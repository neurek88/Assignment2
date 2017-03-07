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
import lecture464.model.Products;
import lecture464.model.Users;

/**
 * Servlet implementation class Register
 */
public class CancelOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Users getProfile(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Users profile = (Users) session.getAttribute("userBean");
	     return profile;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelOrders() {
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
		int produductId = Integer.parseInt(request.getParameter("cancelProduct"));
		int orderId = Integer.parseInt(request.getParameter("cancelOrder"));
		Orders tpd = new Orders(produductId, orderId);
		request.setAttribute("singleOrderCancellation", tpd);
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.SearchProduct(produductId);
		Products itemName;
		itemName = (Products)db.getProduct();
		session.setAttribute("SingleProduct", itemName);
		
		RequestDispatcher view = request.getRequestDispatcher("CancelOrder.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
