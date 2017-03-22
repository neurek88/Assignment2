package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.DBAccessClass;
import lecture464.model.Products;
import lecture464.model.Users;

/**
 * Servlet implementation class Register
 */
public class UpdateShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Products getCart(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Products cart = (Products) session.getAttribute("cart");
	     return cart;
	}
	
	private Users getProfile(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Users profile = (Users) session.getAttribute("userBean");
	     return profile;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users profile = getProfile(request);
        int customerId = profile.getUserId();
        int pQuantity = Integer.parseInt(request.getParameter("pQuantity"));
		int productId = Integer.parseInt(request.getParameter("pid"));
		
		System.out.println("Product Quantity: " + pQuantity);
		
        DBAccessClass db = new DBAccessClass();
		db.connectMeIn();		
        ArrayList<Products> shoppingCart = (ArrayList<Products>)session.getAttribute("cart");
        if (request.getParameter("cart") != null) {
        	Integer pid = Integer.parseInt(request.getParameter("cart"));
        	db.SearchProduct(pid);
        if(shoppingCart == null){
          shoppingCart = new ArrayList<Products>();
          session.setAttribute("cart", shoppingCart);
        } 
        shoppingCart.add((Products)db.getProduct());
        session.setAttribute("cart", shoppingCart);
        }
        else if (request.getParameter("cart") == null) {
        	int delete = Integer.parseInt(request.getParameter("delete"));
        	shoppingCart.remove(delete);
        	session.setAttribute("cart", shoppingCart);
        //} else if (request.getParameter("cart") != null && request.getParameter("quantity") != null) {
        	
        }
           
    	RequestDispatcher view = request.getRequestDispatcher("View&CheckoutShoppingCart.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
