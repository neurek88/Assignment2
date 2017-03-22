<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/Style.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>W.B.S.W.</title>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js">
		</script>
		<script>
			function getReview() {
				var cRating  = $("#Rating").val();
				var cReview  = $("#Review").val();
				var product = ${itemList.getProductId()};
			console.log(cName);
			   
				  $.post("CustomerReviews", {Rating:cRating, Review:cReview, pid:product}, function(data,status) {
				    
					  alert("Review Added");
			    			
			    });
			  }
			function getQuestion() {
				var cQuestion = $("#Question").val();
			   	var product = ${itemList.getProductId()};
				  $.post("CustomerQA", {Question:cQuestion, pid:product}, function(data,status) {
				    
					  alert("Question Added");
			    			
			    });
			  }
			function addedToCart() {
				var product = ${itemList.getProductId()};
				var pQuantity = $("#Question").value;
					//parseInt($("#pQuantity").text(), 10);
	
				console.log("product: " + product);
				console.log("quantity: " + pQuantity);
				
				if ($("#pQuantity").val()== null)
				 {
				 alert("Please fill in a quantity");
				 }
				 else
				 {
					 var pQuantity = $("#pQuantity").val();
						$.post("UpdateShoppingCart", {pid:product, pQuantity:pQuantity}, function(data,status) {
							alert("Added to Cart!");
						})
				 }
				
			}
		</script>
</head>
<body>
<div id=navigation><ul>
<li><a href="#">${sessionScope.userName}</a></li>
<li><a href="CustomerHomePage.jsp"> Home Page </a></li>
<li><a href="Login.jsp"> Login out </a></li>
<li><a href="View&CheckoutShoppingCart.jsp"> Add to Cart </a></li>
<li><form action = ViewOrders method = "post"><input type=submit name="submit" value="View Orders"></form></li>
</ul> </div>

<h1> World's Best Shopping Website</h1><br>
<h2>This product is available for purchase and use</h2>
<h3>details</h3>
<br>
<form action=UpdateShoppingCart method="post"><input type="text" name="quantity" id="pQuantiyt"> Quantity Requested  <button name="cart" type="submit" value="${itemList.getProductId()}" onClick="addedToCart()">add to cart</button></form> <br>
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
		
           <tr>
                <td>${itemList.getProductName()}</td>
                <td>${itemList.getPrice()}</td>
                <td>${itemList.getSellerId()}</td>
                <td>${itemList.getAvailableQuantity()}</td>
                <td>${itemList.getEstimatedDeliveryDays()}</td>
                <td><img src="${itemList.getProductThumbnail()}" alt="${itemList.getProductName()}" style="width:100px;height:100px;"></td>
                <td>${itemList.getProductDescription()}</td>
                </tr>
            
</table>
<br>
<table width="700px" align="center"
               style="border:1px solid #000000;">
            <tr>
                <td colspan=7 align="center"
                    style="background-color:teal">
                    <b>Questions and Answers</b></td>
            </tr>
            <tr style="background-color:lightgrey;">
                <td><b>Question</b></td>
                <td><b>Answer</b></td>
              </tr>
              <c:forEach items="${questionList}" var="qList">
              <tr>
              	<td>${qList.getProductQuestion()}</td>
              	<td>${qList.getProductAnswer()}</td>
              </tr>
              </c:forEach>
          </table>
          <form name="question" method="post" onsubmit="return getQuestion();">
          Question: 	<input type="text" id="Question" value="">
          <input type="submit" name="submit" value="Submit Question"></form>
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
        <c:forEach items="${reviewList}" var="rList">
            <tr>
            	<td>${rList.getReviewCustomerID()}</td>
            	<td>${rList.getReviewDate()}</td>
            	<td>${rList.getRating()}</td>
            	<td>${rList.getReview()}</td>
            </tr>
            </c:forEach>
 
</table>
<form name="review" method="post" onsubmit="return getReview();">
	Rating: 	<input type="text" id="Rating" value="">	<br>
	Your Review: 	<input type="text" id="Review" value="">	<br>
<input type="submit" name="submit" value="Submit Review"></form>
</body>
</html>