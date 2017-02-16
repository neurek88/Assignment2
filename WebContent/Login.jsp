<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>W.B.S.W.</title>
<script language="JavaScript">
function validate(form)
{
 if (form.userName.value=="")
 {
 alert("Please fill in your user name");
 form.userName.focus();
 }
 else if (form.password.value=="")
 {
 alert("Please fill in your password");
 form.password.focus();
 }
 else
 {
 form.submit();
 }
}
</script>
</head>
<body>
<div id=navigation><ul>
<li><a href="Registration.jsp"> Register </a></li>
</ul> </div>
<h1> World's Best Shopping Website</h1>
<h2> Login here</h2>

<form action=Login method="post">

User Name: <input type=text name=userName value="${cookie.userName.value}"><br>
Password: <input type=password name=password><br>
<input type=submit value=Login onClick="validate(this.form)"> <br> 
<input type="checkbox" id="cbox" name="cbox" value="userCheckbox"> <label for="cbox">Remember Me:</label>
</form>
<br>
<br>

</body>
</html>