<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TechZONE - Login</title>
  
  
</head>
<body>

	<%@include file="header.jsp"%>
	
	
	<section class="vh-100">
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-5">
                    <img src="<c:url value="/resources/img/login.jpg" />"
                        class="img-fluid" alt="Sample image">
                </div>
                <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                
                    <form action="<c:url value="/user/login" />" method="post">
                    
                    	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                    
                        <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                            <p class="lead fw-normal mb-3">Sign In with
                                <a class="navbar-brand " href="#">T<span class="lead text-primary">ech</span><span
                                        class="font-weight-bold">ZONE</span></a>
                            </p>
                        </div>

                        <!-- Email input -->
                        <div class="form-outline mb-4">
                            <label class="form-label" for="username">User Name</label>
                            <input type="text" id="username" name="username" class="form-control form-control rounded-0"
                                placeholder="Enter your email address" />
                            <div class="invalid-feedback">Please enter valid Email address.</div>
                        </div>

                        <!-- Password input -->
                        <div class="form-outline mb-2">
                            <label class="form-label" for="password">Password</label>
                            <input type="password" id="password" name="password" class="form-control form-control rounded-0"
                                placeholder="Enter password" />
                            <div class="invalid-feedback" id="errorPass">please enter correct password.</div>
                        </div>

                        <div class="d-flex justify-content-start">
                            <a href="#!" class="text-body">Forgot password?</a>
                        </div>
                        
                        <div class="d-flex justify-content-end">
                            <div class="text-center text-lg-start mt-2">
                              <button type="submit" class="btn btn-primary btn rounded-0"
                                    style="padding-left: 2.5rem; padding-right: 2.5rem;">Login</button>
                            </div>       
                        </div>
                                                   
                        <c:if test="${not empty errorMsg}"><div class="alert alert-danger alert-dismissible py-1 pull-left mt-3">${errorMsg}</div></c:if>
                      

                        <p class="row col-md-12 mt-4 justify-content-center small fw-bold mt-2 pt-1 mb-0 text-center">Don't have an account? <a href="<%=request.getContextPath() %>/user/register"
                            class="link-danger">Register</a></p>

                        <div class="divider d-flex align-items-center my-4">
                            <p class="text-center fw-bold mx-3 mb-0">OR</p>
                        </div>

                        <div class="row justify-content-center mb-4">
                            <button type="button" class="col-md-1 mx-1 btn rounded-0">
                                <i class="fa fa-google"></i>
                            </button>

                            <button type="button" class="col-md-1 mx-1 btn rounded-0">
                                <i class="fa fa-facebook"></i>
                            </button>

                            <button type="button" class="col-md-1 mx-1 btn rounded-0">
                                <i class="fa fa-linkedin"></i>
                            </button>
                        </div>

                    </form>
                    
                </div>
            </div>
        </div>

    </section>
	
	
	<%@include file="footer.jsp"%>

</body>
</html>