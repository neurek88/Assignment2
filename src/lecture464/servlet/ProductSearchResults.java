package lecture464.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.DBAccessClass;
import lecture464.model.Products;

/**
 * Servlet implementation class ProductSearchQuery
 */
public class ProductSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchResults() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String pid = request.getParameter("order");	
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.SearchProductInfo(pid);
		ArrayList<Products> ListName = (ArrayList<Products>)session.getAttribute("itemList");
		ListName = db.getProductList();
        try {
        	session.setAttribute("itemList", ListName);
            System.out.println(ListName.get(0).getProductName());
            RequestDispatcher view = request.getRequestDispatcher("ViewProductDetails.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(session.getAttribute("itemList"));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
