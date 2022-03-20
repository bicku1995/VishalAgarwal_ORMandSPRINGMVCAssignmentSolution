<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	<title>Customers List</title>
</head>
<body>
	<div class="container">
		<table class="table table-bordered table-striped">
			<tr>
				<th style="background-color: lightgreen ">
					<h1>Customer Relationship Management</h1>
				</th>
			</tr>
		</table>
		<hr />
		<h2>
			<a href="/CustomerRelationshipManagement/customers/add"
				class="btn btn-primary btn-sm float-end" style="float: left;">
				Add Customer</a>
		</h2>
		<hr />
		<table class="table table-bordered table-striped">
			<tr>
				<th style="background-color: White">First Name</th>
				<th style="background-color: white">Last Name</th>
				<th style="background-color: white">Email</th>
				<th style="background-color: White">Action</th>
			</tr>
			<tbody>
				<c:forEach items="${Customers}" var="customer">
					<tr>
						<td><c:out value="${customer.firstname}" /></td>
						<td><c:out value="${customer.lastname}" /></td>
						<td><c:out value="${customer.email}" /></td>
						<td><a href="/CustomerRelationshipManagement/customers/update?id=${customer.id}"
						       class="btn btn-primary btn-sm">Update</a> 
						    <a> </a>
						    <a href="/CustomerRelationshipManagement/customers/delete?id=${customer.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>