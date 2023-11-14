<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Catalog</title>
<!-- Include Bootstrap CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<!-- Include Font Awesome for icons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col mt-4">
				<h1>Product Catalog</h1>
			</div>
			<div class="col text-right">
				<!-- Add Product Button with GET request -->
				<a href="catalogue?action=add" class="btn btn-primary mt-4"> <i
					class="fas fa-plus"></i> Add product
				</a>
			</div>
		</div>

		<form class="mt-4" action="catalogue" method="GET">
			<input type="hidden" name="action" value="search">
			<div class="input-group mb-3">
				<input type="text" class="form-control"
					placeholder="Search products..." name="arg">
				<div class="input-group-append">
					<!-- Search Button -->
					<button type="submit" class="btn btn-outline-secondary">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
		</form>


		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Ref</th>
					<th>Categorie</th>
					<th>Quantity</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<%-- Loop through the list of products and populate the table rows --%>
				<c:forEach items="${produits}" var="produit">
					<tr>
						<td>${produit.id}</td>
						<td>${produit.nom}</td>
						<td>${produit.pren}</td>
						<td>${produit.categorie.name}</td>
						<td>${produit.qte}</td>

						<td><a href="#"
							onClick="openEditModal(${produit.id}, '${produit.nom}', '${produit.pren}', ${produit.qte}, ${produit.categorie.id})">
								<i class="fas fa-edit"></i> Modify

						</a> <!-- Modal for Editing Product -->
							<div class="modal fade" id="editModal" tabindex="-1"
								role="dialog" aria-labelledby="editModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="editModalLabel">Edit Product</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<!-- Edit Product Form -->
											<form id="editForm" action="catalogue?action=edit"
												method="Post">
												<div class="form-group">
													<label for="editId">ID:</label> <input type="text"
														class="form-control" id="id" name="id" readonly>
												</div>
												<div class="form-group">
													<label for="editName">Name:</label> <input type="text"
														class="form-control" id="name" name="name">
												</div>
												<div class="form-group">
													<label for="editRef">Reference:</label> <input type="text"
														class="form-control" id="ref" name="ref">
												</div>
												<div class="form-group">
													<label for="editQte">Quantity:</label> <input type="text"
														class="form-control" id="qte" name="qte">
												</div>
												<div class="form-group">
													<label for="category">Category:</label> <select
														class="form-control" id="ctg" name="ctg">
														<!-- Iterate over categories and create options -->
														<c:forEach var="categorie" items="${categories}">
															<option value="${categorie.id}"
																${categorie.id eq produit.categorie.id ? 'selected' : ''}>${categorie.name}</option>
														</c:forEach>
													</select>
												</div>
												<div class="modal-footer">
													<button type=button class="btn btn-secondary"
														data-dismiss="modal">Cancel</button>
													<button type="submit" class="btn btn-primary">Apply</button>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div> <a href="catalogue?action=delete&id=${produit.id}"> <i
								class="fas fa-trash-alt"></i> Delete
						</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<!-- Include Bootstrap JS and jQuery (optional) for enhanced functionality -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.3/dist/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

	<script>
    // Function to open the modal and populate fields with product data
    function openEditModal(id, name, ref, qte, cid) {
    	
        $('#id').val(id);
        $('#name').val(name);
        $('#ref').val(ref);
        $('#qte').val(qte);
        $('#ctg').val(cid);
        $('#editModal').modal('show');
    }
	</script>

</body>
</html>
