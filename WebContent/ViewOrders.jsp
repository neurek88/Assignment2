<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<h2>Here are your previous orders</h2><br><br>

<form action="ManageOrder">
<table width="700px"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=7 align="center"
                    style="background-color:teal">
                    <b>Order History</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Product Name</b></td>
                <td><b>Product Category</b></td>
                <td><b>Seller Name</b></td>
                <td><b>Price</b></td>
                <td><b>Product Thumbnail</b></td>
                <td><b>View Product</b></td>
                <td><b>Action</b></td>
           </tr>
 <c:forEach items="${OrderArray}" var="list" varStatus="i">
           <tr>
           		<td>${list.getProductName()}</td>
           		<td>${list.getProductCategory()}</td>
                <td>${quantity}</td>
                <td><img src="${list.getProductThumbnail()}" alt="${list.getProductName()}" style="width:35px;height:35px;"></td>
                <td>${list.getSellerId()}</td>
                <td>${list.getAvailableQuantity()}</td>
                <td class="count-me"> ${list.getPrice()}</td>
                <td>${list.getEstimatedDeliveryDays()}</td>
                <td><form action=UpdateShoppingCart method="post"><button name="delete" type="submit" value="${i.index}">delete?</button></form></td>
                </tr>
           </c:forEach>
           <tr>
               	<td>Virtual Toast</td>
           		<td>food</td>
           		<td>ebay</td>
            	<td>$10</td>
            	<td><img src="VirtualToast.jpg" alt="VirtualToast" style="width:25px;height:25px;"></td>
            	<td><a href="ViewProductDetails.jsp"> Details </a></td>
            	<td><a href="ManageOrder.jsp"> Manage Order </a></td>
            <%@ page import="java.io.*" %>
           <%@ page import="java.io.ObjectOutputStream" %>
           <%@ page import="java.io.FileOutputStream" %>
           </tr>
           <tr>
               	<td>Virtual Toast</td>
           		<td>food</td>
           		<td>ebay</td>
            	<td>$10</td>
            	<td><img src="VirtualToast.jpg" alt="VirtualToast" style="width:25px;height:25px;"></td>
            	<td><a href="ViewProductDetails.jsp"> Details </a></td>
            	<td><a href="ManageOrder.jsp"> Manage Order </a></td>
            <%@ page import="java.io.*" %>
           <%@ page import="java.io.ObjectOutputStream" %>
           <%@ page import="java.io.FileOutputStream" %>
           </tr>
           </table>
           </form>
           
<br>
<br>


<h2>Go back to the Home Page to search again</h2><br>

</body>
</html>