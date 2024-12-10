<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
<jsp:include page="index.jsp" />  
<br> <hr>
${obj}
<div style="text-align:center">

			<form action="update-product" method="post">
			
				Product ID :	<input type="text" name = "pid" value="${obj.ID}" disabled="disabled"> <br> <br>
				Product Name :	<input type="text" name = "pn" value="${obj.name}"> <br> <br>
				Price: 	<input type="text" name = "pp" value="${obj.price}"> <br> <br>
				Quantity :	<input type="text" name = "pq" value="${obj.quantity}"> <br> <br>
				Category :	<input type="text" name = "pc" value="${obj.category}"> <br> <br>
				<button type="submit" class="btn btn-primary"> Update Product </button>
			
			</form>
	
</div>

</body>
</html>