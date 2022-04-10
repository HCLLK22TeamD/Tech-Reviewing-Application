<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>TechZONE - Manage Post</title>


<style>
	table .action-btns a{
	  transition: 0.3s ease;
	}
	table .action-btns a.edit-btn:hover {
		background-color: #007bff;
	}
	table .action-btns a:hover i{
		color: white !important;
	}
	table .action-btns a.del-btn:hover {
		background-color: #dc3545;
	}
	
</style>

</head>
<body>

	<%@include file="header.jsp"%>

	<div class="container col-md-10 mt-4">

		<a href="<%=request.getContextPath() %>/posts/new-post" class="btn btn-primary rounded-0 my-4 shadow">Create Post</a>
	  
	  
	   	<c:if test="${not empty param['errorMsg']}">
			<div class="row col-12 ml-2 alert alert-danger alert-dismissible py-1 pull-left mt-3"><%= request.getParameter("errorMsg") %></div>
		</c:if>
	   	<c:if test="${not empty param['successMsg']}">
			<div class="row col-12 ml-2 alert alert-success alert-dismissible py-1 pull-left mt-3"><%= request.getParameter("successMsg") %></div>
		</c:if>
	
	
	
		<div class="table-responsive ">
			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">Title</th>
						<th scope="col">Category</th>
						<th scope="col">Sub Category</th>
						<th scope="col">Has AirDate</th>
						<th scope="col">AirDate</th>
						<th scope="col">Posted On</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="post" items="${postList}" varStatus="item">
						<tr>
							<th scope="row">${post.title}</th>
							<td>${post.category}</td>
							<td>${post.subCategory}</td>
							<td>${post.hasAirDate}</td>
							<td>${post.airDate}</td>
							<td>${post.createdAt}</td>
							
							<td class="action-btns">
								<a class="px-1 border rounded-0 p-2 edit-btn" href="<%=request.getContextPath() %>/posts/view?id=${post.id}"><i class="fa fa-eye"></i></a>
								<a class="px-1 border rounded-0 p-2 edit-btn" href="<%=request.getContextPath() %>/posts/update?id=${post.id}" ><i class="fa fa-pencil"></i></a>
								<a class="px-1 border rounded-0 p-2 del-btn" href="<%=request.getContextPath() %>/posts/delete?id=${post.id}" ><i class="fa fa-trash text-danger"></i></a>
							</td>	
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
	</div>	


	<%@include file="footer.jsp"%>


</body>
</html>