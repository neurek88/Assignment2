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
public class ManageOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Users getProfile(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Users profile = (Users) session.getAttribute("userBean");
	     return profile;
	}
	
	private ArrayList<Products> orderProducts = new ArrayList<Products>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOrders() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Orders> completeOrderArray = new ArrayList<Orders>();
		ArrayList<Products> orderProducts = new ArrayList<Products>();
	
		Integer pid = Integer.parseInt(request.getParameter("manage"));
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		
		db.findProductsOrderedByOrderID(pid);
		completeOrderArray = db.getCompleteOrderList();
		request.setAttribute("singleOrderInfo", completeOrderArray);
		for (int j = 0; j < completeOrderArray.size(); j++) {
			db.SearchOrderProducts(completeOrderArray.get(j));
			Products opd = db.getOrderProduct();
			System.out.println("is this working?");
			//System.out.println(opd);
			orderProducts.add(opd);
		}
		System.out.println("Complete Order Array:" + completeOrderArray.get(0).getShippingStatus());
		request.setAttribute("singleOrder", orderProducts);
		System.out.println("final Order List: " + orderProducts);

		RequestDispatcher view = request.getRequestDispatcher("ManageOrder.jsp");

        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
