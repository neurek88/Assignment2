<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
 <c:forEach items="${OrderArray}" var="Orderlist" varStatus="i">
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
                <td><b>Price</b></td>
                <td><b>Product Thumbnail</b></td>
                <td><b>View Product</b></td>
                <td><b>Action</b></td>
           </tr>
 <c:forEach items="${OrderList}" var="Productlist" varStatus="j">
           <tr>
           		<td><c:out value="${Productlist.getProductName()}"/></td>
           		<td><c:out value="${Productlist.getProductCategoryIndex()}"/></td>
           		<td><c:out value="${Productlist.getPrice()}"/></td>
           		<td><img src="${Productlist.getProductThumbnail()}" alt="${Productlist.ProductName}" style="width:35px;height:35px;"></td>
           		<%-- <td>${Productlist.getProductCategory()}</td>
                <td>${Productlist.getSellerId()}</td>
                <td><img src="${Productlist.getProductThumbnail()}" alt="${list.getProductName()}" style="width:35px;height:35px;"></td>
                <td>${Productlist.getSellerId()}</td>
                <td>${Productlist.getAvailableQuantity()}</td>
                <td> ${Productlist.getPrice()}</td>
                <td>${Productlist.getEstimatedDeliveryDays()}</td>--%>
                </tr>
           </c:forEach>
           </table><br>
           </c:forEach>
           </form>
           
<br>
<br>


<h2>Go back to the Home Page to search again</h2><br>

</body>
</html>