<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>W.B.S.W</title>
</head>
<body>
<div id=navigation><ul>
<li><a href="#">${sessionScope.userName}</a></li>
<li><a href="CustomerHomePage.jsp"> Home Page </a></li>
<li><a href="Login.jsp"> Login out </a></li>
<li><form action = ViewOrders method = "post"><input type=submit name="submit" value="View Orders"></form></li>
</ul> </div>

<h1> World's Best Shopping Website</h1><br>
<h2>Manage Your Orders</h2><br>
<h3>You may Cancel or Track your orders.</h3>

<form action="CancelOrder">
 <c:forEach items="${OrderArray}" var="Orders" varStatus="i">
<table width="700px"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=7 align="center"
                    style="background-color:teal">
                    <b>Order History :<c:out value="${OrderIDList[i.index]}"/></b></td>
            </tr>
           
            <tr style="background-color:lightgrey;">
                <td><b>Product Name</b></td>
                <td><b>Product Category</b></td>
                <td><b>Price</b></td>
                <td><b>Product Thumbnail</b></td>
<<<<<<< HEAD
                <td><b>Track Order</b></td>
                <td><b>Cancel Order</b></td>
=======
                <td><b>View Product</b></td>
                <td><b>Action</b></td>
>>>>>>> branch 'NickWork3_6' of https://github.com/neurek88/Assignment2
           </tr>
<<<<<<< HEAD
 	<c:forEach items="${singleOrder}" var="ProductList" varStatus="i">
=======
 	<c:forEach items="${Orders}" var="ProductList" varStatus="i">
>>>>>>> branch 'NickWork3_6' of https://github.com/neurek88/Assignment2
           <tr>
           		<td>${ProductList.getProductName()}</td>
           		<td><c:out value="${ProductList.getProductCategoryIndex()}"/></td>
<<<<<<< HEAD
           		<td>${ProductList.getSellerId()}</td>
           		<td><c:out value="${ProductList.getPrice()}"/></td>
           		<td><img src="${ProductList.getProductThumbnail()}" alt="${Productlist.ProductName}" style="width:35px;height:35px;"></td>
           		<td>${ProductList.getProductName()}</td>
                <td><form action=CancelOrders method="post"><button name="cancel" type="submit" value="${ProductList.getProductId()}">Cancel</button></form></td>

                </tr>
           </c:forEach>
           </table>

           </form>
           <br>
=======
           		<td><c:out value="${ProductList.getPrice()}"/></td>
           		<td><img src="${ProductList.getProductThumbnail()}" alt="${Productlist.ProductName}" style="width:35px;height:35px;"></td>
           		<td><form action=ProductSearchResults method="post"><button name="order" type="submit" value="${ProductList.getProductName()}">view product</button></form></td>
                <td><form action=CancelOrders method="post"><button name="manage" type="submit" value="${ProductList.getProductId()}">Manage</button></form></td>

                </tr>
           </c:forEach>
       
           </table><br>
             </c:forEach>
           </form>
           
<br>
<br>
<%--
<form action="CancelOrder">
<table width="700px"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=8 align="center"
                    style="background-color:teal">
                    <b>Order #22222</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Product Name</b></td>
                <td><b>Product Category</b></td>
                <td><b>Seller Name</b></td>
                <td><b>Price</b></td>
                <td><b>Product Thumbnail</b></td>
                <td><b>Re-Order</b></td>
                <td><b>Track Order</b></td>
                <td><b>Cancel Order</b></td>
           </tr>
           <tr>
           		<td>Virtual Toast</td>
           		<td>food</td>
           		<td>ebay</td>
            	<td>$10</td>
            	<td><img src="VirtualToast.jpg" alt="VirtualToast" style="width:25px;height:25px;"></td>
            	<td><a href="View&CheckoutShoppingCart.jsp"> Re-Order </a></td>
            	<td><a href="TrackOrder.jsp"> Track Order </a></td>
            	<td><a href="CancelOrder.jsp"> Cancel Order </a></td>
            <%@ page import="java.io.*"
           <%@ page import="java.io.ObjectOutputStream" %>
           <%@ page import="java.io.FileOutputStream" %>
           </tr>
           </table>
           </form>--%>
<br>
<br
>>>>>>> branch 'NickWork3_6' of https://github.com/neurek88/Assignment2
</body>
</html>