package lecture464.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lecture464.model.Products;
import lecture464.model.Users;
import lecture464.model.DBAccessClass;

import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

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
		HttpSession session = request.getSession();
		String pid = request.getParameter("search");	
		session.setAttribute("search", pid);
		Users aUser= (Users)session.getAttribute("userBean");
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		db.SearchProductInfo(pid);
		ArrayList<Products> ListName = (ArrayList<Products>)session.getAttribute("piList");
		ListName = db.getProductList();
        try {
        	session.setAttribute("piList", ListName);
            RequestDispatcher view = request.getRequestDispatcher("ProductSearchResults.jsp");
            view.forward(request, response);
            System.out.print(aUser.getUserId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(session.getAttribute("piList"));
        System.out.println(ListName.get(0).getProductName());
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
