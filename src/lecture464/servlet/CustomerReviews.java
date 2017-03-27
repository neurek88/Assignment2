package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import lecture464.model.DBAccessClass;
import lecture464.model.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerQA
 */
public class CustomerReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Users getProfile(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Users profile = (Users) session.getAttribute("userBean");
	     return profile;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerReviews() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cReview = request.getParameter("cReview");
		int cRating = Integer.parseInt(request.getParameter("cRating"));
		System.out.println(cRating);
		Users profile = getProfile(request);
		int customerId = profile.getUserId();
		int productId = Integer.parseInt(request.getParameter("product"));
		System.out.println(cRating + customerId + productId + cReview);
			DBAccessClass db = new DBAccessClass();
			db.connectMeIn();
			db.insertReviewData(productId, customerId, cReview, cRating);
			db.closeConnection();
			PrintWriter out = response.getWriter(); 
			out.println("<tr><td>"+customerId+"</td><td>Just Now</td><td>"+cRating+"</td><td>"+cReview+"</td></tr>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
