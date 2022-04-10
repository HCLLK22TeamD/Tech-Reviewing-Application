<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TechZONE - AirDates</title>
     
  <link rel="stylesheet" href="<c:url value="/resources/css/calendar.css" />">
  
</head>
<body>

	<%@include file="header.jsp"%>
	
	
	<div class="jumbotron mb-3 bg-dark">
        <h2 class="row justify-content-center lead"><i class="fa fa-calendar-o pr-3 pt-1"></i> Air-Dates Tech Calendar</h2>
    </div>

    <div class="container-fluid row air-calendar">

		<c:if test="${empty calendar}">
			<div class="row justify-content-center col-md-12 lead">There is no any AirDate yet.</div>
		</c:if>

	    <c:forEach var="month" items="${calendar}">	
	    	
	  		<div class="col-lg-2 col-md-4 my-2 calendar-item">
		    	<ul class="list-group">
	               	<li href="#" class="list-group-item bg-info text-white small text-center py-0">
	                   <i class="fa fa-calendar-o px-2"></i> ${month.key}
	               	</li>
		    
		    		<c:forEach var="item" items="${month.value}">
	
	                <a href="<%=request.getContextPath() %>/posts/view?id=${item.postId}" class="list-group-item list-group-item-action px-2 py-0 pb-1 active-border">
	                    <div class="col-md-12 px-0 item-title small"> ${item.title} </div>
	                    <div class="col-6 px-0 item-category float-left"><span
	                            class="text-uppercase badge badge-warning rounded-0 py-1">${item.subCategory}</span></div>
	                    <div class="col-6 px-0 item-author float-right fa fa-user-circle pt-2 text-right"><span
	                            class="pl-1">${item.author}</span></div>
	                </a>
	                
	               	</c:forEach>
	                
		        </ul>
		    </div>
	
	    </c:forEach>


    </div>
	
	
	<%@include file="footer.jsp"%>

</body>
</html>