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
    private int myNumber = 66;   
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
		ArrayList<Products> ReviewData = new ArrayList<Products>();
		ArrayList<Products> QuestionData = new ArrayList<Products>();
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		int productId = -1;
		if(myNumber==88){
			productId = profile.getProductId();
		} else {
			productId = Integer.parseInt(request.getParameter("productId"));
		}
		db.SearchProduct(productId);
		Products ProductBean = (Products) session.getAttribute("itemList");
		ProductBean = db.getProduct();
		System.out.println(productId);
		db.searchReviewData(productId);
		db.searchQuestionData(productId);
		ReviewData = db.getReviewInfo();
		QuestionData = db.getQuestionData();
		request.setAttribute("questionList", QuestionData);
		request.setAttribute("reviewList", ReviewData);
        try {
        	session.setAttribute("itemList", ProductBean);
        	myNumber = 88;
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
