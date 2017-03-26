<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
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
<li><form action = ViewOrders method = "post"><input type=submit name="submit" value="View Orders"></form></li>
</ul> </div>

<h1> ${initParam['WebsiteName']}</h1><br>

<h2> The page you are looking for has vanished!</h2>
<p>get back to safety</p>


</body>
</html>