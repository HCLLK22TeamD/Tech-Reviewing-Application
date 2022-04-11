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
  <title>TechZONE</title>
  
    <link rel="stylesheet" href="<c:url value="/resources/css/single-post.css" />">
  
  
</head>
<body>

	<%@include file="header.jsp"%>
	
	
	<div class="container mt-5">
        <div class="row justify-content-center">
        
        	<c:if test="${not empty errorMsg}">
        		<div class="col-md-8 alert alert-danger alert-dismissible py-1 pull-left mt-3">WARNING: ${errorMsg}</div>
        	</c:if>
        
	       <c:if test="${not empty post}">
	     
	            <div class="col-lg-8">
	                <article>
	                    <header class="mb-4">
	                        <h1 class="fw-bolder mb-1 ">${post.title}</h1>
	                        <div class="small text-muted mb-2">Posted on ${post.createdAt} by ${author}</div>
	                        <a class="badge badge-primary shadow rounded-0 py-2 px-2 text-decoration-none link-light text-uppercase" href="#!">${post.category}</a>
	                        <a class="badge badge-warning shadow rounded-0 py-2 px-2 text-decoration-none link-light text-uppercase" href="#!">${post.subCategory}</a>
	                    </header>
	                    
	                    <figure class="mb-4"><img class="img-fluid rounded-0 shadow-sm"
	                            src="<c:url value="/resources/img/cover5.jpg" />" alt="post" />
	                    </figure>
	                    
	                    <section class="mb-5">${post.content}</section>
	                
	                </article>
	
	
					<%@include file="comment.jsp"%>
	            
	            </div>
	            
	       </c:if> 

        </div>
    </div>
	
	
	<%@include file="footer.jsp"%>

</body>
</html>