<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>W.B.S.W.</title>
</head>
<body>
<div id=navigation><ul>
<li><a href="#">${sessionScope.userName}</a></li>
<li><a href="CustomerHomePage.jsp"> Home Page </a></li>
<li><a href="Login.jsp"> Login out </a></li>
<li><a href="ManageOrder.jsp"> Manage Orders </a></li>
</ul> </div>

<h1> World's Best Shopping Website</h1><br>
<h2>Your Shopping Cart</h2>
<h2>Here are the items in your cart:</h2>
<table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>Shopping Cart</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Product Name</b></td>
                <td><b>Seller Name</b></td>
                <td><b>Quantity</b></td>
                <td><b>Price</b></td>
            </tr>
            <tr> 
            	<td>Toast</td>
                <td>Mike</td>
                <td>10</td>
                <td>$10</td>
            	</tr>
            <tr>
            	<td><a href="CustomerTransactionConfirmation.jsp"> Check Out </a></td>
            	<td></td>
            	<td>Total Cost</td>
            	<td>$100</td>	
</table>
<br>
<form action=CustomerTransactionConfirmation.jsp>
First Name:<input type=text name=fName><br>
Last Name:<input type=text name=lName><br>
Shipping Address:<input type=text name=sAddress><br>
Billing Address:<input type=text name=bAddress><br>
 <select name="credit">
    <option value="AMEX">AMEX</option>
    <option value="Visa">Visa</option>
    <option value="MasterCard">Master Card</option>
  </select>
Card Number: <input type=text name=cardNum><br>
Security Code: <input type=text name=cardCode><br>
Expiration Date: <select name="expiration">
   <%
   int number = 1;
   for(int i=0;i<13;i++)
 {
out.println("<option value=" +(number+i)+ ">" + (number+i) + "</option> ");
 } %>
  </select>
  <select>
  <%
   int year = 2017;
   for(int i=0;i<12;i++)
 {
out.println("<option value=" + (year + i) + ">" + (year+i) + "</option> ");
 } %></select>
<input type=submit value="Submit"> <br> 
</form>
<a href="View&CheckoutShoppingCart.jsp">Cancel</a>
<br>
<br>


</body>
</html>