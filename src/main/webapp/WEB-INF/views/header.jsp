<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false" %>
	
<!DOCTYPE html>
<html>
<head>

  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

  <link href="<c:url value="/resources/css/navbar-styles.css" />" rel="stylesheet">
  
  <style type="text/css">

	.divider:after, .divider:before {
		content: "";
		flex: 1;
		height: 1px;
		background: #eee;
	}
	
	.h-custom {
		height: calc(100% - 73px);
	}
	
	@media ( max-width : 450px) {
		.h-custom {
			height: 100%;
		}
	}
	
  </style>

</head>
<body>

	<nav
		class="navbar navbar-expand-lg navbar-light bg-white py-0 border-bottom">
		<a class="navbar-brand px-4" href="<%=request.getContextPath() %>/home">T<span
			class="lead text-primary">ech</span><span class="font-weight-bold">ZONE</span>
		</a>
		<button class="navbar-toggler py-3" type="button"
			data-toggle="collapse" data-target="#navbarNavDropdown"
			aria-controls="navbarNavDropdown" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active bar-home">
					<a class="nav-link" href="<%=request.getContextPath() %>/home"><i class="fa fa-home"></i> Home <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item dropdown bar-categories">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">
					<i class="fa fa-newspaper-o pr-1"></i>Categories</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">Category 1</a>
						<a class="dropdown-item" href="#">Category 2</a>
						<a class="dropdown-item" href="#">Category 3</a>
					</div>
				</li>
				<li class="nav-item bar-gadget"><a class="nav-link" href="#"><i
						class="fa fa-gamepad"></i> Gadgets</a></li>
				<li class="nav-item bar-calander"><a class="nav-link"
					href="<%=request.getContextPath() %>/calendar"><i class="fa fa-calendar"></i> Air Dates</a></li>
			</ul>
			
			<ul class="navbar-nav navbar-right ml-auto">
			
				<c:if test="${sessionScope.user == null}">
					<li class="nav-item"><a href="<%=request.getContextPath() %>/user/login" class="nav-link">
						<i class="fa fa-sign-in pr-2"></i>Sign In</a>
					</li>		
					<li class="nav-item"><a href="<%=request.getContextPath() %>/user/register" class="nav-link">
						<i class="fa fa-user pr-2"></i>Sign Up</a>
					</li>
				</c:if>
				
				<c:if test="${sessionScope.user != null}">
				
					<c:if test="${sessionScope.user_role == 1}">
				        <li class="nav-item bar-newpost">
				          <a href="<%=request.getContextPath() %>/posts/new-post" class="nav-link">
				          	<i class="fa fa-pencil pr-2"></i>Create Post</a>
				        </li>
					</c:if>
					
					<li class="nav-item dropdown bar-usermenu">
			            <a class="nav-link text-dark" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown">
			              <span><i class="fa fa-user-circle-o align-middle pr-2"></i>${sessionScope.user.firstName} ${sessionScope.user.lastName}</span>
			              <span>
			                <svg class="align-middle" xmlns="http://www.w3.org/2000/svg" width="15" height="15" viewBox="0 0 16 16">
			                  <path d="M9.5 13a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zm0-5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0z"/>
			                </svg>
			              </span>
			            </a>
			            <div class="dropdown-menu">
			              <a class="dropdown-item" href="<%=request.getContextPath() %>/user/profile">My Account</a>
			              <c:if test="${sessionScope.user_role == 1}">
			                  <a class="dropdown-item" href="<%=request.getContextPath() %>/posts/manage">Manage Posts</a>
			              </c:if> 
			              <div class="dropdown-divider"></div>
			              <a class="dropdown-item" href="<%=request.getContextPath() %>/user/logout">Logout</a>
			            </div>
			        </li>
					
				</c:if>
		
		
				<li class="nav-item nav-item-search">
					<button class="search-btn" onclick="searchToggle(true)"><i class="fa fa-search"></i></button>
				</li>
				<div id="nav-searchbar" class="search-form px-0">
					<input class="search-input lead font-weight-normal pl-5 " type="text" name="search" placeholder="Find out yourtech interests">
					<button class="search-close" onclick="searchToggle(false)">
						<i class="fa fa-times"></i>
					</button>
				</div>
			</ul>
		</div>
	</nav>
	
	
	<script type="text/javascript">
	
    function searchToggle(isOpen) {
        if (isOpen) {
            document.getElementById("nav-searchbar").classList.add("active");
        } else {
            document.getElementById("nav-searchbar").classList.remove("active");
        }
    }
	
	</script>

</body>
</html>