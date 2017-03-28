package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.DBAccessClass;
import lecture464.model.Products;
import lecture464.model.Users;

/**
 * Servlet implementation class PlaceOrder
 */
public class PlaceOrder extends HttpServlet {
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
    public PlaceOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Users profile = getProfile(request);
		ArrayList<Products> shoppingCart = getCart(request);
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		int creditNumber = Integer.parseInt(request.getParameter("creditNumber"));
		int quantity = 1;
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		int userId = profile.getUserId();
		int sum = 0;
		if(request.getParameter("total")!= null){
			sum = Integer.parseInt(request.getParameter("total"));
		}
		String shippingAddress = request.getParameter("shippingAddress");
		String billAddress = request.getParameter("billAddress");
		System.out.println(shippingAddress);
		db.insertOrderData( userId, sum , shippingAddress, billAddress, creditNumber);
		db.findNewestOrderIdById(userId);
		int neworderId = db.getNewestOrderId();
		for (int i=0; i<shoppingCart.size();i++){
		int productId = shoppingCart.get(i).getProductId();
		quantity = shoppingCart.get(i).getCartQuantity();
		db.insertOrderItemInfo(neworderId, productId, sum, quantity, 1, 1);
		System.out.println(userId);
		}
		PrintWriter out = response.getWriter(); 
		out.println("Order # "+neworderId+" creditCard: "+creditNumber+" total cost: "+sum+" quantity: "+quantity);
		session.removeAttribute("cart");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
