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
<li><a href="View&CheckoutShoppingCart.jsp"> Add to Cart </a></li>
</ul> </div>

<h1> World's Best Shopping Website</h1><br>
<h2>This product is available for purchase and use</h2>
<h3>details</h3>
<br>
<a href="View&CheckoutShoppingCart.jsp"> Add to Cart </a> <br>
<br>
<table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=7 align="center"
                    style="background-color:teal">
                    <b>Product Record</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Product Name</b></td>
                <td><b>Price</b></td>
                <td><b>Seller Name</b></td>
                <td><b>Available quantity</b></td>
                <td><b>Estimated delivery date</b></td>
                <td><b>Product photos</b></td>
                <td><b>Product description</b></td>
            </tr>
            <tr>
            	<td>Virtual Toast</td>
            	<td>$10</td>
            	<td>Vitual Toast</td>
            	<td>3929</td>
            	<td>Never</td>
            	<td><img src="VirtualToast.jpg" alt="VirtualToast" style="width:100px;height:100px;"></td>
            	<td>Virtual Toast. what else do you need to know</td>
</table>
<h3>Customer Questions and Answers</h3><br>
<b>Question</b> <p> How does it taste?</p><br>
<b>Answer</b> <p>delicious</p><br>
<br>
<h3>Customer Reviews</h3><br>
<b>Overall Rating</b><br>
<table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>User Reviews</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Customer Name</b></td>
                <td><b>Review Date</b></td>
                <td><b>Rating out of 5 stars</b></td>
                <td><b>Customer Review</b></td>
            </tr>
            <tr>
            	<td>Fred</td>
            	<td>8/8/2004</td>
            	<td>4.5</td>
            	<td>This toast is awesome. Tastes great but not filling</td>
            </tr>
</table>
<br>

</body>
</html>