<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
</head>
<body>


	<section class="mb-5">
		<div class="card bg-light">
			<div class="card-body">
			
				<c:if test="${not empty param['commnetErrorMsg']}">
	        		<div class="alert alert-danger alert-dismissible py-1 pull-left mt-3">${param['commnetErrorMsg']}</div>
	        	</c:if>
			
				<form:form modelAttribute="comment" method="post" class="mb-4">
					<form:textarea path="message" class="form-control" rows="3" placeholder="Leave a comment!"></form:textarea>
					<form:input path="postId" type="hidden" id="postId" name="postId" value="${param['id']}" />
					<button type="submit" class="btn btn-primary btn-sm shadow border-1 rounded-0 float-right my-2">Send</button>
                               	
				</form:form>
				
					
				<c:forEach var="comment" items="${commentList}" varStatus="item">
				
					<div class="d-flex my-3">
						<div class="flex-shrink-0">
							<img class="rounded-circle"
								src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." />
						</div>
						<div class="ms-3">
							<div class="fw-bold">${comment.user}</div>
							${comment.message}
						</div>
					</div>
				
				</c:forEach>

			</div>
		</div>
	</section>


</body>
</html>