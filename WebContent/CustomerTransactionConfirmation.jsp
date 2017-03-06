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

<h2>Your order Status: <c:out value="${SuccessBean}"/></h2>
<h2>Thanks for shopping on the World's Best Shopping Website!</h2>

<table width="700px" id="countit"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=8 align="center"
                    style="background-color:teal">
                    <b>Confirmation Order Number:<c:out value="${OrderItems.getOrderId()}"/> </b></td>
            </tr>
            <tr style="background-color:lightgrey;">
            	<td><b>First Name</b></td>
            	<td><b>Last Name</b></td>
                <td><b>Shippping Address</b></td>
                <td><b>Billing Address</b></td>
                <td><b>Credit Card</b></td>
                <td><b>Credit Card Type</b></td>
                <td><b>CVV</b></td>
                <td><b>Expiration Date</b></td>
             </tr>
            <tr>
           		<td>${orderUser.getFirstName()}</td>
           		<td>${orderUser.getLastName()}</td>
                <td>${orderUser.getShippingAddress()}</td>
                <td>${orderUser.getBillAddress()}</td>
                <td>${newCreditCard.getCreditCardNumber()}</td>
                <td>${newCreditCard.getCardType()}</td>
                <td>${newCreditCard.getCVV()}</td>
                <td>${newCreditCard.getExpirationDate()}</td>
             </tr>
	</table>

<br>
<input type="submit" value="print for your records" onClick="window.print()"/> 
<br>


</body>
</html>