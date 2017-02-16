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
</ul> </div>

<h1> World's Best Shopping Website</h1><br>
<h2>Your Shopping Cart</h2>
<h2>Here are the items in your cart:</h2>
<table width="700px"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=7 align="center"
                    style="background-color:teal">
                    <b>Shopping Cart</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Product Name</b></td>
                <td><b>Product thumbnail</b></td>
                <td><b>Seller Name</b></td>
                <td><b>Quantity</b></td>
                <td><b>Price</b></td>
                <td><b>Estimated delivery date</b></td>
                <td><b>delete?</b></td>
            </tr>
            <tr> 
            	<td>Toast</td>
                <td><img src="VirtualToast.jpg" alt="VirtualToast" style="width:25px;height:25px;"></td>
                <td>Mike</td>
                <td>10</td>
                <td>$10</td>
                <td>Estimated delivery date</td>
                <td><a href="delete.java">delete?</a></td>
            	</tr>
            <tr>
            	<td><a href="CustomerTransaction.jsp"> Check Out </a></td>
            	<td></td>
            	<td></td>
            	<td colspan=2>Total Cost</td>	
            	<td>$100</td>
            	<td></td>
            	
</table>

<br>
<br>


</body>
</html>