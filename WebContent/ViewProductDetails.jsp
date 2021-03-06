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
		$(function() {
			$('#submitReview').on('submit', function (e) {
				var cRating  = $("#Rating").val();
				var cReview  = $("#Review").val();
				var product = ${itemList.getProductId()};
			   
				  $.post("CustomerReviews", {cRating:cRating, cReview:cReview, product:product}, function(data,status) {
					  $('#reviewTable').append(data);
					  alert("Review Added");
			    			
			    });
				  e.preventDefault();
			  });
		});
		
		$(function() {
			$('#submitQuestion').on('submit', function (e) {
				var cQuestion = $("#Question").val();
			   	var product = ${itemList.getProductId()};
				  $.post("CustomerQA", {Question:cQuestion, pid:product}, function(data,status) {
					  $('#questionTable').append('<tr><td>'+data+'</td><td></td></tr>');
					  alert("Question Added");
			    			
				  });
				  e.preventDefault();
			  });
		});
		
		$(function() {
			$('#addCart').on('submit', function (e) {
				var pQuantity = $('#pQuantity').val();
				var cart = ${itemList.getProductId()};
					//parseInt($("#pQuantity").text(), 10);
				
				if ($("#pQuantity").val()== null)
				 {
				 alert("Please fill in a quantity");
				 }
				 else
				 {
					// var pQuantity = $("#pQuantity").val();
						$.post("UpdateShoppingCart", {pQuantity:pQuantity, cart:cart}, function(data,status) {
							alert("Added to Cart!");
						})
				 }
				e.preventDefault();
			});
		});
			
		</script>
</head>
<body>
<div id=navigation><ul>
<li><a href="#">${sessionScope.userName}</a></li>
<li><a href="CustomerHomePage.jsp"> Home Page </a></li>
<li><a href="Login.jsp"> Login out </a></li>
<li><a href="ProductSearchResults.jsp"> Back to Search Results </a></li>
<li><a href="View&CheckoutShoppingCart.jsp"> View Shopping Cart </a></li>
<li><form action = ViewOrders method = "post"><input type=submit name="submit" value="View Orders"></form></li>
</ul> </div>

<h1>${initParam['WebsiteName']}</h1><br>
<h2>This product is available for purchase and use</h2>
<h3>details</h3>
<br>
<form method="post" id="addCart"><input type="text" name="pQuantity" id="pQuantity" value="1"> Quantity Requested  <button name="cart" type="submit" value="${itemList.getProductId()}">add to cart</button></form> <br>
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
<table width="700px" align="center" id="questionTable"
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
          <form name="question" id="submitQuestion" method="post">
          Question: 	<input type="text" id="Question" value="">
          <input type="submit" name="submit" value="Submit Question"></form>
<br>

<h3>Customer Reviews</h3><br>
<b>Overall Rating</b><br>
<table width="700px" align="center" id="reviewTable"
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
<form name="review" id="submitReview" method="post">
	Rating: 	<input type="text" id="Rating" value="">	<br>
	Your Review: 	<input type="text" id="Review" value="">	<br>
<input type="submit" name="submitReview" value="Submit Review"></form>
<br>
<a href="View&CheckoutShoppingCart.jsp"> View Shopping Cart </a>
</body>
</html>
