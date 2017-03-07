package lecture464.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class CancelUpdate
 */
public class CancelUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Users getProfile(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Users profile = (Users) session.getAttribute("userBean");
	     return profile;
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Users profile = getProfile(request);
		int userId = profile.getUserId();
			
		Integer pid = Integer.parseInt(request.getParameter("cancelPID"));
		Integer oid = Integer.parseInt(request.getParameter("cancelOID"));
		System.out.println(pid);
		System.out.println(oid);
		
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.changeShippingStatus(oid, pid);
		db.closeConnection();
		
		RequestDispatcher view = request.getRequestDispatcher("CancellationConfirmation.jsp");
        view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
