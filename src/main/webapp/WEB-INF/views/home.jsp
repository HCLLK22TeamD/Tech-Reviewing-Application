<%@page import="java.nio.file.Path"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TechZONE</title>
  
  <link rel="stylesheet" href="<c:url value="/resources/css/home-styles.css" />">
 
  
</head>

<body>

	<%@include file="header.jsp"%>


	<div class="jumbotron pt-5">

		<h2 class="ml-5 pl-5 mb-4 lead">Highlights</h2>

		<div class="row ">

			<div
				class="col-lg-6 col-md-12 col-sm-12 d-flex justify-content-center">
				<div class="post post-thumb">
					<a class="post-img" href="<%=request.getContextPath() %>/post"><img src="<c:url value="/resources/img/cover1.jpg" />"
						alt="header-post" data-pagespeed-url-hash="67351088"
						onload="pagespeed.CriticalImages.checkImageForCriticality(this);">
					</a>
					<div class="post-body">
						<h3 class="highlights post-title">
							<a href="<%=request.getContextPath() %>/post">Lorem Ipsum is simply dummy text of the printing
								and typesetting industry.</a>
						</h3>
						<div class="post-meta">
							<a class="post-category cat-2" href="#">category</a> <span
								class="post-date pull-right">March 27, 2018</span>
						</div>
					</div>
				</div>
			</div>

			<div
				class="col-lg-6 col-md-12 col-sm-12 d-flex justify-content-center">
				<div class="post post-thumb">
					<a class="post-img" href="<%=request.getContextPath() %>/post"><img src="<c:url value="/resources/img/cover5.jpg" />"
						alt="header-post" data-pagespeed-url-hash="67351088"
						onload="pagespeed.CriticalImages.checkImageForCriticality(this);">
					</a>
					<div class="post-body">
						<h3 class="highlights post-title">
							<a href="<%=request.getContextPath() %>/post">Lorem Ipsum is simply dummy text of the printing
								and typesetting industry.</a>
						</h3>
						<div class="post-meta">
							<a class="post-category cat-2" href="#">category</a> <span
								class="post-date pull-right">March 27, 2018</span>
						</div>
					</div>
				</div>
			</div>

		</div>
	</div>



	<div class="container">
		<div class="row">

			<div class="col-8">

				<h2 class="mb-2 lead">Recent Posts</h2>

				<div class="row">

					<c:forEach var="post" items="${postList}" varStatus="item">
					
				        <div class="col-md-6 mt-4">
							<div class="post post-recent">
								<a class="post-img position-relative" href="<%=request.getContextPath() %>/posts/view?id=${post.id}">
									<img class="w-100 " src="<c:url value="/resources/img/cover6.jpg" />" alt=""> <span
									class="post-date pull-left ">${post.createdAt}</span>
								</a>
								<div class="post-body">
									<div class="post-meta">
										<a class="post-category cat-1 bg-success mr-0" href="category.html">${post.category}</a>
										<a class="post-category cat-1 bg-warning" href="category.html">${post.subCategory}</a>
										<div class="like-views text-primary pull-right">
											<i class="btn btn-sm px-0 fa fa-heart-o "></i> <i
												class="btn btn-sm px-0 fa fa-star-o"></i> <span
												class="border px-1 small border-primary">0 <i
												class="fa fa-eye"></i></span>
										</div>
									</div>
									<h3 class="pt-3 post-title small">
										<a href="<%=request.getContextPath() %>/posts/view?id=${post.id}">${post.title}</a>
									</h3>
								</div>
							</div>
						</div>
			            
			        </c:forEach>



				</div>
			</div>
			<div class="col-4">

				<div>
					<span class="lead">Popular Categories</span>
					<ul class="list-group mt-4">
						<li
							class="list-group-item d-flex justify-content-between align-items-center">Javascript
							<span class="badge badge-primary badge-pill">15</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center">Cloud
							Computing <span class="badge badge-primary badge-pill">10</span>
						</li>
						<li
							class="list-group-item d-flex justify-content-between align-items-center">Artificial
							Inteligent <span class="badge badge-primary badge-pill">5</span>
						</li>
					</ul>

					<div class="mt-2">
						<span class="badge badge-primary py-2 rounded-0 my-1">Category
							1</span> <span class="badge badge-primary py-2 rounded-0 my-1">Category
							2</span> <span class="badge badge-primary py-2 rounded-0 my-1">Category
							3</span> <span class="badge badge-primary py-2 rounded-0 my-1">Category
							4</span> <span class="badge badge-primary py-2 rounded-0 my-1">Category
							5</span>
					</div>

				</div>

				<div class="mt-4">
					<span class="lead">Popular Authors</span>
					<ul class="list-group mt-2">
						<li class="list-group-item"><i class="fa fa-user-circle mx-2"></i>@Author_1
							<span class="badge badge-warning py-1 pull-right">Posts <span
								class="badge badge-light badge-pill">15</span></span></li>
						<li class="list-group-item"><i class="fa fa-user-circle mx-2"></i>@Author_2
							<span class="badge badge-warning py-1 pull-right">Posts <span
								class="badge badge-light badge-pill">15</span></span></li>
						<li class="list-group-item"><i class="fa fa-user-circle mx-2"></i>@Author_3
							<span class="badge badge-warning py-1 pull-right">Posts <span
								class="badge badge-light badge-pill">15</span></span></li>

					</ul>
				</div>

				<div class="mt-5">
					<span class="lead">Archives</span>
					<ul class="list-group list-group-flush mt-2">
						<li class="list-group-item">March 2022</li>
						<li class="list-group-item">February 2022</li>
						<li class="list-group-item">January 2022</li>
						<li class="list-group-item">December 2021</li>
					</ul>
				</div>

			</div>

		</div>
	</div>


	<%@include file="footer.jsp"%>

</body>
</html>