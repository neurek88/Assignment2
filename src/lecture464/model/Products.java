package lecture464.model;

import java.io.FileInputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.Response;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Products {
	
	private int Id;
	private String ProductName;
	private int ProductCategoryIndex;
	private String ProductDescription;
	private int Price;
	private int AvailableQuantity;
	private int EstimatedDeliveryDays;
	private int SellerId;
	private String ProductPhotoLinks;
	private String ProductPhotosLinks;
	private String ProductVideosLinks;
	private String ProductThumbnail;
	private ArrayList pid_list;
	
	public int getUserId() {
		return Id;
	}
	public void setUserId(int Id) {
		this.Id = Id;
	}

	public Products() {
		super();

	}
	public void SearchProducts(String pid){

	Connection conn = null;
    Statement st;
    try {

        ArrayList al = null;
        ArrayList pid_list = new ArrayList();
        String query = "select * from Products where ProductName='" + pid + "' ";

        System.out.println("query " + query);
        st = conn.createStatement();
        ResultSet rs = st.executeQuery(query);

        while (rs.next()) {
            al = new ArrayList();

//            out.println(rs.getString(1));
//            out.println(rs.getString(2));
//            out.println(rs.getString(3));
//            out.println(rs.getString(4));
            al.add(rs.getString(1));
            al.add(rs.getString(2));
            al.add(rs.getString(3));
            al.add(rs.getString(4));
            

            System.out.println("al :: " + al);
            pid_list.add(al);
        }
        conn.close();
        System.out.println("Disconnected!");
    } catch (Exception e) {
        e.printStackTrace();
    }
   }
	
	 public ArrayList getList()
	 {
	     
	     return pid_list;
	 }
	/*  static {
		    product = new HashMap<String, BankCustomer>();
		    product.put("id001",
		                  new BankCustomer("id001",
		                                   "John",
		                                   "Hacker",
		                                   -3456.78));
		    product.put("id002",
		                  new BankCustomer("id002",
		                                   "Jane",
		                                   "Hacker",
		                                   1234.56));
		    product.put("id003",
		                  new BankCustomer("id003",
		                                   "Juan",
		                                   "Hacker",
		                                   987654.32));
		  }
*/
}
	

