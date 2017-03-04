<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
 <c:forEach items="${cart}" var="list">
           <tr>
                <td>${list.getProductName()}</td>
                <td>${list.getSellerId()}</td>
                <td>${list.getAvailableQuantity()}</td>
                <td class="count-me"> ${list.getPrice()}</td>
            </tr>
           </c:forEach> 
           </table>
           <script language="javascript" type="text/javascript">
            var tds = document.getElementById('countit').getElementsByTagName('td');
            var sum = 0;
            for(var i = 0; i < tds.length; i ++) {
                if(tds[i].className == 'count-me') {
                    sum += isNaN(tds[i].innerHTML) ? 0 : parseInt(tds[i].innerHTML);
                }
            }
            document.getElementById('countit').innerHTML += '<tr><td></td><td colspan=2>Total Cost:</td><td>' + sum + '</td></tr>';
        </script>	
<br>
<form action=CustomerTransactionConfirmation method=post>
First Name:<input type=text name=firstName><br>
Last Name:<input type=text name=lastName><br>
Shipping Address:<input type=text name=shippingAddress><br>
Billing Address:<input type=text name=billAddress><br>
 <select name="creditBrand">
    <option value="AMEX">AMEX</option>
    <option value="Visa">Visa</option>
    <option value="MasterCard">Master Card</option>
  </select>
Card Number: <input type=text name=cardNumber><br>
Security Code: <input type=text name=CVV><br>
Expiration Date: <select name="expirationDate">
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
<form action=CancelOrders method="post"><button type="submit" value="cancel">Cancel</button>
</form>
<br>
<br>


</body>
</html>