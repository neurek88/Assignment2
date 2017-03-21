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
	private Products getProfile(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Products profile = (Products) session.getAttribute("itemList");
	     return profile;
	}
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
		Products profile = getProfile(request);
		Products ProductBean;
		ArrayList<Products> ReviewData = new ArrayList<Products>();
		ArrayList<Products> QuestionData = new ArrayList<Products>();
		int productId;
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		if(session.getAttribute("itemList") != null) {
			productId = profile.getProductId();
			ProductBean = (Products) session.getAttribute("itemList");
	}
		 else {
			productId = Integer.parseInt(request.getParameter("productId"));
			ProductBean = new Products(0,null,0,null,0,0,0,0,null,null);
			db.SearchProduct(productId);
			ProductBean = db.getProduct();
		}
		System.out.println(productId);
		db.searchReviewData(productId);
		db.searchQuestionData(productId);
		ReviewData = db.getReviewInfo();
		QuestionData = db.getQuestionData();
		request.setAttribute("questionList", QuestionData);
		request.setAttribute("reviewList", ReviewData);
        try {
        	session.setAttribute("itemList", ProductBean);
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
