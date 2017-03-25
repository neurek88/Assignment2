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
<li><a href="View&CheckoutShoppingCart.jsp"> Shopping Cart </a></li>
<li><form action = ViewOrders method = "post"><input type=submit name="submit" value="View Orders"></form></li>
</ul> </div>

<h1> World's Best Shopping Website</h1><br>
<h2>Your search results are:</h2><br><br>
<h3>Virtual Toast</h3>
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
                <td>${list.getSellerId()}</td>
                <td>${list.getPrice()}</td>
                <td><img src="${list.getProductThumbnail()}" alt="${list.getProductName()}" style="width:35px;height:35px;"></td>
                <td><form action=ProductSearchResults method="post"><button name="productId" type="submit" value="${list.getProductId()}">view product</button></form></td>
                <td><form action=UpdateShoppingCart method="post"><button name="cart" type="submit" value="${list.getProductId()}">add to cart</button></form></td>
                </tr>
           </c:forEach> 
   </table> 

<br>


<h2>Go back to the Home Page to search again</h2><br>

</body>
</html>