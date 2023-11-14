<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<!-- Include Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-4">
		<h1>Add Product</h1>
		<form action="catalogue?action=newProduct" method="POST">
			<div class="form-group">
				<label for="name">Name:</label> <input type="text"
					class="form-control" id="name" name="name" value="${produit.nom}">
			</div>
			<div class="form-group">
				<label for="ref">Reference:</label> <input type="text"
					class="form-control" id="ref" name="ref" value="${produit.pren}">
			</div>
			<div class="form-group">
				<label for="quantity">Quantity:</label> 
				<input type="text"
					class="form-control" id="quantity" name="quantity"
					value="${produit.qte}">
			</div>
			<div class="form-group">
				<label for="category">Category:</label> 
				<select class="form-control"
					id="ctg" name="ctg">
					<!-- Iterate over categories and create options -->
					<c:forEach var="categorie" items="${categories}">
						<option value="${categorie.id}"
							${categorie.id eq produit.categorie.id ? 'selected' : ''}>${categorie.name}</option>
					</c:forEach>
				</select>
			</div>
			<button type="submit" class="btn btn-primary">Add Product</button>
		</form>
	</div>

	<!-- Include Bootstrap JS and jQuery (optional) for enhanced functionality -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
