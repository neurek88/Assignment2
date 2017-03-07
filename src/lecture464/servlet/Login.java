package lecture464.servlet;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.Users;
import lecture464.model.DBAccessClass;


/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		DBAccessClass db = new DBAccessClass();
		
		db.connectMeIn();
		
		boolean userExists = false;
		boolean userPasswordMatches = false;
		
		
		boolean myCheckBox = request.getParameter("cbox") != null;
		if(myCheckBox) {
		Cookie cookie = new Cookie("userName", userName);
		cookie.setMaxAge(3200);
		response.addCookie(cookie);
		}
		
		Users aUser = new Users();
		
		userExists = aUser.validateUserByUsername(userName);
		userPasswordMatches = aUser.validateUserByPassword(password);
		
		if(userExists && userPasswordMatches) {
			aUser = aUser.getUser(userName);
			int userID = aUser.getUserID(userName);
			aUser.setUserId(userID);

			HttpSession session = request.getSession();
		    session.setAttribute("userBean", aUser);
		    session.setAttribute("userName", userName);
		    
		    String address = "CustomerHomePage.jsp";
		    RequestDispatcher dispatcher =
		      request.getRequestDispatcher(address);
		    dispatcher.forward(request, response);
		    db.closeConnection();
			
		} else {
			response.sendRedirect("Registration.jsp");
			db.closeConnection();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
