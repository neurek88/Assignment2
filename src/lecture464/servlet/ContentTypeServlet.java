package lecture464.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContentTypeServlet
 */
public class ContentTypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContentTypeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		/*
		 * You can specify the current page to load after every 1 second
		 * Use one of the following methods
		 */
		
		//response.setHeader("refresh", "1");
		
		//response.setIntHeader("refresh", 1);
		
		/*
		 * You can specify the page (using its URL) 
		 * to load after 2 seconds
		 */
		response.setHeader("Refresh", "2; URL=ProductSearchResults.jsp");
		
        response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
	    
	    String docType =
	    	      "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
	    	      "Transitional//EN\">\n";
	    	    String title = "Splash Screen";
	    	    out.println
	    	      (docType +
	    	       "<HTML>\n" +
	    	       "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +
	    	       "<BODY BGCOLOR=\"#FDF5E6\">\n" +
	    	       "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n");
	    	    
	    	        out.println("<H2> Search Results are Being Processed</H2>");
	    	   
	    	    out.println("</BODY></HTML>");
	    
	    
	    
	    out.close();
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
