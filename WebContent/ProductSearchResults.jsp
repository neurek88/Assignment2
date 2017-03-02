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
<li><a href="View&CheckoutShoppingCart.jsp"> Add to Cart </a></li>
</ul> </div>

<h1> World's Best Shopping Website</h1><br>
<h2>Your search results are:</h2><br><br>
<h3>Virtual Toast</h3>
<form action="addtocart">
<table width="700px"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=7 align="center"
                    style="background-color:teal">
                    <b>Search Results</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Product Name</b></td>
                <td><b>Product Category</b></td>
                <td><b>Seller Name</b></td>
                <td><b>Price</b></td>
                <td><b>Product Thumbnail</b></td>
                <td><b>View Product</b></td>
                <td><b>Add to Cart</b></td>
           </tr>
         <c:forEach items="${piList}" var="list">
           <tr>
                <td>${list.getProductName()}</td>
                <td>${list.getProductCategoryIndex()}</td>
                <td>${list.getPrice()}</td>
                <td>${list.getPrice()}</td>
                <td>${list.getProductName()}</td>
                <td>${sessionScope.list.getPrice()}</td>
                <td>${sessionScope.list.getProductCategory()}</td>
                </tr>
           </c:forEach> 

           <tr>
           		<td>Virtual Toast</td>
           		<td>food</td>
           		<td>ebay</td>
            	<td>$10</td>
            	<td><img src="VirtualToast.jpg" alt="VirtualToast" style="width:25px;height:25px;"></td>
            	<td><a href="ViewProductDetails.jsp"> Details </a></td>
            	<td><a href="View&CheckoutShoppingCart.jsp"> Add to Cart </a></td>
   </table> 
</form>

<br>


<h2>Go back to the Home Page to search again</h2><br>

</body>
</html>