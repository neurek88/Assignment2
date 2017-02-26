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
<li><a href="ManageOrder.jsp"> Manage Orders </a></li>
</ul> </div>

<h1> World's Best Shopping Website</h1><br>

<h2>Welcome to the Home Page!</h2>
<h2>Thanks for logging in!</h2>

<br>
<br>

<h2>Please search our secret database</h2><br>

<form action= ProductSearchQuery method="post">
Category:
 <select name="input">
    <option value="Food">Food</option>
    <option value="Fancy">Fancy</option>
    <option value="Funny">Funny</option>
  </select>
Your Query: <input type=text name=searchQuery><input type=submit value="Search"> <br> 

</form>

<br>
<br>


</body>
</html>