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
<h1> World's Best Shopping Website</h1>
<h2>Are you sure you want to cancel the purchase of such a wonderful product?</h2><br><br>
<br>
<form action="CancelOrder">
<table width="700px"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=8 align="center"
                    style="background-color:teal">
                    <b>Order to be Cancelled</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Product Name</b></td>
                <td><b>Product Category</b></td>
                <td><b>Seller Name</b></td>
                <td><b>Price</b></td>
                <td><b>Product Thumbnail</b></td>
                <td><b>Cancel Order?</b></td>
                <td></td>

           </tr>
           <tr>
           		<td>Virtual Toast</td>
           		<td>food</td>
           		<td>ebay</td>
            	<td>$10</td>
            	<td><img src="VirtualToast.jpg" alt="VirtualToast" style="width:25px;height:25px;"></td>
            	<td><a href="ManageOrder.jsp"> No </a></td>
            	<td><a href="CancellationConfirmation.jsp"> Yes </a></td>

           </tr>
           </table>
           </form>

<br>

<br>


<h2>Go back to the Home Page to search again</h2><br>

</body>
</html>