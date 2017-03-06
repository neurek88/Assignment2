package lecture464.servlet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
 * Servlet implementation class Register
 */
public class ViewOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Users getProfile(HttpServletRequest request) {
	     HttpSession session = request.getSession();
	     Users profile = (Users) session.getAttribute("userBean");
	     return profile;
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewOrders() {
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
		ArrayList<Integer> orderIDList = new ArrayList<Integer>();
		ArrayList<ArrayList<Orders>> finalListOfOrderedProducts = new ArrayList();
		ArrayList<Orders> completeOrderArray = new ArrayList<Orders>();
		
		ArrayList<ArrayList<Products>> completeOrderProducts = new ArrayList<ArrayList<Products>>();
		
		DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		
		db.findOrdersById(userId);
		orderIDList =db.getOrderbyId();
		
		session.setAttribute("OrderIDList", orderIDList);
		
		System.out.println("OrderIDList:" + orderIDList);
		session.setAttribute("orderIdList", orderIDList);
		for (int k = 0; k < orderIDList.size(); k++) {
			db.findProductsOrderedByOrderID(orderIDList.get(k));
			completeOrderArray = db.getCompleteOrderList();
			finalListOfOrderedProducts.add(new ArrayList<Orders>());
			finalListOfOrderedProducts.get(k).addAll(completeOrderArray);
			System.out.println("This Order List: " + completeOrderArray);
			db.clearOrderProductLists();
			completeOrderArray.clear();
		}
		
		System.out.println("final Order List: " + finalListOfOrderedProducts);
		
		//System.out.println("Order 0 ID: " + completeOrderArray.get(0).get(0).getOrderId() +"Product 0 ID: " + completeOrderArray.get(0).get(0).getProductId() );
		//System.out.println("completeOrderArray: " + completeOrderArray);
		
		for (int i = 0; i < finalListOfOrderedProducts.size(); i++) {
			ArrayList<Products> orderProducts = new ArrayList<Products>();
			
			for (int j = 0; j < finalListOfOrderedProducts.get(i).size(); j++) {
				db.SearchOrderProducts(finalListOfOrderedProducts.get(i).get(j));
				Products opd = db.getOrderProduct();
				//System.out.println("is this working?");
				//System.out.println(opd);
				orderProducts.add(opd);
			}
			completeOrderProducts.add(new ArrayList<Products>());
			completeOrderProducts.get(i).addAll(orderProducts);
		}
		
		System.out.println(completeOrderProducts);
		
	/*	DBAccessClass db = new DBAccessClass();
		db.connectMeIn();
		
		db.findOrdersById(userId);
		orderIDList =db.getOrderbyId();
		db.findProductsOrderedByOrderID(orderIDList);
	
		completeOrderArray = db.getCompleteOrderList();
		System.out.println("Entire Array"+completeOrderArray);
		System.out.println("Entire Array size"+completeOrderArray.size());
		System.out.println("Array:" + completeOrderArray.get(1).getProductId() + "," + completeOrderArray.get(1).getOrderId() + "," + completeOrderArray.get(0).getProductId());
		ArrayList<Products> orderProducts = new ArrayList<Products>();
		Products opd = null;
		for (int i = 0; i < completeOrderArray.size(); i++) {
			
				db.SearchOrderProducts(completeOrderArray.get(i));
				opd = db.getOrderProduct();
				orderProducts.add(opd);
		}
		
			System.out.println("Product Array size"+orderProducts.size());
			//System.out.println("Entire Products Array"+completeOrderProducts);
			//System.out.println("Products:"+completeOrderProducts.get(0).get(0).getProductName());
			System.out.println("completeOrderArray.get(0).get(0)"+ orderProducts.get(0).getProductName());
		
		System.out.println(completeOrderProducts);
		*/
		db.closeConnection();
		System.out.println("Final Big List: " +completeOrderProducts.get(0).get(0).getProductName());
		
		session.setAttribute("OrderArray", completeOrderProducts);
		
		RequestDispatcher view = request.getRequestDispatcher("ViewOrders.jsp");
        view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
