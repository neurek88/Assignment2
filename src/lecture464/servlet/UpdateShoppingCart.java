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
        int pid = Integer.parseInt(request.getParameter("cart"));
        System.out.println(pid);
        DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.SearchProduct(pid);
        ArrayList<Products> shoppingCart = (ArrayList<Products>)session.getAttribute("cart");
        if(shoppingCart == null){
          shoppingCart = new ArrayList<Products>();
          session.setAttribute("cart", shoppingCart);
        } 
        shoppingCart.add((Products)db.getProduct());
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
