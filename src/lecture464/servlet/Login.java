package lecture464.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.Users;

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
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		/* The users.properties file is stored in the "WEB-INF" folder.
		   To access this file, you will need its absolute path. */
		
		/*
		 * Note: the content of the properties file may not be visible
		 */
		 
		/* Following two statements are used to obtain the absolute path 
		   of the users.properies file from its relative path. */
		ServletContext sc = this.getServletContext();
		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
	
		boolean myCheckBox = request.getParameter("cbox") != null;
		if(myCheckBox) {
		Cookie cookie = new Cookie("userName", userName);
		cookie.setMaxAge(3200);
		response.addCookie(cookie);
		System.out.println(cookie);
		}
		System.out.println(myCheckBox);
		
		/*	
		Properties p = new Properties();
	

		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			
			p.load(fis);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(fis != null) {
				fis.close();
			}
		}*/
		Users aUser = new Users(userName, password);
		if (aUser.validateUser(aUser,propFilePath)) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", aUser);
			session.setAttribute("userName", userName);
			response.sendRedirect("CustomerHomePage.jsp");
		} else {
			response.sendRedirect("Registration.jsp");
		}
		/*
		 * Instead using servlet methods (above) for user login,
		 * instantiate a Users object and 
		 * use appropriate method for user login from the Users class.
		 */

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
