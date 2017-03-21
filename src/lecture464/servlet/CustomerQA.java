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
public class CustomerQA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Users getProfile(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Users profile = (Users) session.getAttribute("userBean");
	     return profile;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerQA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cQuestion = request.getParameter("Question");
		Users profile = getProfile(request);
		int customerId = profile.getUserId();
		int productId = Integer.parseInt(request.getParameter("pid"));
		System.out.println(productId);
			DBAccessClass db = new DBAccessClass();
			db.connectMeIn();
			db.insertQuestionData(productId, customerId, cQuestion);
			db.closeConnection();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
