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
<li><a href="View&CheckoutShoppingCart.jsp"> Add to Cart </a></li>
</ul> </div>

<h1> World's Best Shopping Website</h1><br>
<h2>Your order is on the way from Toast, NC</h2><br>
<h3>Here is the route your product is taking</h3>
<h3>It will take 16 hours and 28 minutes and an infinite number of days to reach you.</h3><br>
<img src="ToastMap.jpg" alt="VirtualToastRoute" style="width:700px;height:325px;">
           <br>

</body>
</html>