package lecture464.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductSearchQuery
 */
public class ProductSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductSearchQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String productName = request.getParameter("search");
		
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
