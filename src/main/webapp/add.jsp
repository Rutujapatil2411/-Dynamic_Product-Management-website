<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Add Record</title>
</head>
<body>
<jsp:include page="index.jsp" />   
<br> <hr>

<div style="text-align:center">

			<form action="insert-product" method="post">
			
				Product Name :	<input type="text" name = "pn"> <br> <br>
				Price: 	<input type="text" name = "pp"> <br> <br>
				Quantity :	<input type="text" name = "pq"> <br> <br>
				Category :	<input type="text" name = "pc"> <br> <br>
				<button type="submit" class="btn btn-primary"> add Product </button>
			
			</form>
	
</div>

</body>
</html>