<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>W.B.S.W.</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
		<script>
			 $( function() {
				    $( "#expirationDate" ).datepicker();
				  } );
			 
			 $(function() {
					$('#creditFormSubmit').on('submit', function (e) {
				
				var firstName = $("#firstName").val();
				var lastName = $("#lastName").val();
				var total = $("#total").val();
				var shippingAddress = $("#shippingAddress").val();
				var billAddress = $("#billAddress").val();
				var creditNumber = $("#creditNumber").val();
				var creditBrand = $("#creditBrand").val();
				var CVV = $("#CVV").val();
				var expirationDate = $("#expirationDate").val();
				
				$.ajax({
					  method: "POST",
					  url: "CustomerTransactionConfirmation",
					  data: {firstName:firstName, lastName:lastName, total:total, shippingAddress:shippingAddress, billAddress:billAddress, creditNumber:creditNumber, creditBrand:creditBrand, CVV:CVV, expirationDate:expirationDate }
					}).done(function(data,status) {
						creditCardConfirmed(data,status);
				}).fail(function()  {
				    alert("Sorry. Server unavailable. ");
				}); 
				alert("Order is Processing...")
				e.preventDefault();
			});
		});
			
			function creditCardConfirmed(data,status) {
			    
	    		var test = data;
	    	 // Following data values are received from the "Order" app
	    		if(data == 00) {	    			
	    			alert("FROM BANKING APP: Your credit card does not have enough balance or invalid");
	    		}
	    		
	    		if(data == 11) {
	    			
			        $("#cartOrder").load("OrderSuccess.txt");
			        $("#response").html(status);
			        alert("credit card looks good")
			        place_order_function();
						}
			}
			
			function place_order_function (){
				var firstName = $("#firstName").val();
				var lastName = $("#lastName").val();
				var total = $("#total").val();
				var shippingAddress = $("#shippingAddress").val();
				var billAddress = $("#billAddress").val();
				var creditNumber = $("#creditNumber").val();

					 $.post("PlaceOrder", {firstName:firstName, lastName:lastName, total:total, shippingAddress:shippingAddress, billAddress:billAddress, creditNumber:creditNumber }, function(data,status) {
						 $("#cartOrder").html('<input type="button" value="Print for your records" onClick="window.print()"/><br><br>'+data);
						 $("#response").html(status);
					 });
					}
			function printButton(){
			    var $input = $('<input type="button" value="new button" onClick="window.print()"/>');
			    $input.appendTo($("#cartOrder"));
			}
		</script>
</head>
<body>
<div id=navigation><ul>
<li><a href="#">${sessionScope.userName}</a></li>
<li><a href="CustomerHomePage.jsp"> Home Page </a></li>
<li><a href="Login.jsp"> Login out </a></li>
<li><form action = ViewOrders method = "post"><input type=submit name="submit" value="View Orders"></form></li>
</ul> </div>

<h1>${initParam['WebsiteName']}</h1><br>
<h2>Your Shopping Cart</h2>
<h2>Here are the items in your cart:</h2>
<div id="cartOrder"></div><br>
 <div id="response"></div><br>	
<table width="700px" align="center" id='countit'
               style="border:1px solid #000000;" >
            <tr>
                <td colspan=4 align="center"
                    style="background-color:teal">
                    <b>Shopping Cart</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Product Name</b></td>
                <td><b>Seller Name</b></td>
                <td><b>Quantity</b></td>
                <td><b>Price</b></td>
            </tr>
      
 <c:forEach items="${cart}" var="list">
           <tr>
                <td>${list.getProductName()}</td>
                <td>${list.getSellerId()}</td>
                <td>${list.getAvailableQuantity()}</td>
                <td class="count-me"> ${list.getPrice()}</td>
                
            </tr>
           </c:forEach> 
           </table>
 <form name="creditCheck" method="post" id="creditFormSubmit">
           <script language="javascript" type="text/javascript">
            var tds = document.getElementById('countit').getElementsByTagName('td');
            var sum = 0;
            for(var i = 0; i < tds.length; i ++) {
                if(tds[i].className == 'count-me') {
                    sum += isNaN(tds[i].innerHTML) ? 0 : parseInt(tds[i].innerHTML);
                }
            }
            document.getElementById('countit').innerHTML += '<tr><td></td><td colspan=2>Total Cost:</td><td>' + sum + '</td><input type="hidden" id="total" name="total" value="'+ sum +'"></tr>';
        </script>
       
<br>
First Name:<input type=text id="firstName" value="${userBean.getFirstName()}"><br>
Last Name:<input type=text id="lastName" value="${userBean.getLastName()}"><br>
Shipping Address:<input type=text id="shippingAddress" value=""><br>
Billing Address:<input type=text id="billAddress" value=""><br>
 <select name="creditBrand" id="creditBrand">
    <option value="AMEX">AMEX</option>
    <option value="Visa">Visa</option>
    <option value="MasterCard">Master Card</option>
  </select>
Card Number: <input type=text id="creditNumber" value=""><br>
Security Code: <input type=text id="CVV" value=""><br>
Expiration Date: <input type=text id="expirationDate">
<br>
<input type="submit" name="submit" value="Submit Order"> <br> 
</form>
<br>
<br>


</body>
</html>