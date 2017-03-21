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
import lecture464.model.Users;

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
		ArrayList<Products> ReviewData = new ArrayList<Products>();
		ArrayList<Products> QuestionData = new ArrayList<Products>();
		int productId = Integer.parseInt(request.getParameter("productId"));	
		System.out.println(productId);
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.SearchProductInfo(pid);
		db.searchReviewData(productId);
		db.searchQuestionData(productId);
		ReviewData = db.getReviewInfo();
		QuestionData = db.getQuestionData();
		request.setAttribute("questionList", QuestionData);
		request.setAttribute("reviewList", ReviewData);
		ArrayList<Products> ListName = (ArrayList<Products>)session.getAttribute("itemList");
		ListName = db.getProductList();
        try {
        	session.setAttribute("itemList", ListName);
            RequestDispatcher view = request.getRequestDispatcher("ViewProductDetails.jsp");
            view.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
