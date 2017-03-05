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
<li><a href="ProductSearchResults.jsp"> Back to Search </a></li>
</ul> </div>

<h1> World's Best Shopping Website</h1><br>
<h2>Your Shopping Cart</h2>
<h2>Here are the items in your cart:</h2>
<table width="700px" id="countit"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=9 align="center"
                    style="background-color:teal">
                    <b>Shopping Cart</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
            	<td><b>Product ID</b></td>
            	<td><b>Product Name</b></td>
                <td><b>Requested Quantity</b></td>
                <td><b>Product thumbnail</b></td>
                <td><b>Seller Name</b></td>
                <td><b>Available Quantity</b></td>
                <td><b>Price</b></td>
                <td><b>Estimated delivery date</b></td>
                <td><b>delete?</b></td>
            </tr> 
 <c:forEach items="${cart}" var="list" varStatus="i">
           <tr>
           		<td>${list.getProductId()}</td>
           		<td>${list.getProductName()}</td>
                <td>${quantity}</td>
                <td><img src="${list.getProductThumbnail()}" alt="${list.getProductName()}" style="width:35px;height:35px;"></td>
                <td>${list.getSellerId()}</td>
                <td>${list.getAvailableQuantity()}</td>
                <td class="count-me"> ${list.getPrice()}</td>
                <td>${list.getEstimatedDeliveryDays()}</td>
                <td><form action=UpdateShoppingCart method="post"><button name="delete" type="submit" value="${i.index}">delete?</button></form></td>
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
            document.getElementById('countit').innerHTML += '<tr><td><a href="CustomerTransaction.jsp"> Check Out </a></td><td colspan=3></td><td colspan=2>Total Cost:</td><td>' + sum + '</td><td colspan=2></td></tr>';
        </script>	

<br>
<br>

</body>
</html>