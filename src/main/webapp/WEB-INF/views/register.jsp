<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
  <meta  http-equiv="Content-Type" charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>TechZONE - Register</title>
  
</head>
<body>

	<%@include file="header.jsp"%>
	
	<section class="vh-100">
        <div class="container-fluid h-custom">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-4"><img src="<c:url value="/resources/img/login.jpg" />" class="img-fluid"
                        alt="Sample image"></div>
                <div class="col-md-8 col-lg-6 col-xl-6 offset-xl-1">

                    <div class="mt-3 d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                        <p class="lead fw-normal mb-3">Register with <a class="navbar-brand " href="#">T<span
                                    class="lead text-primary">ech</span><span class="font-weight-bold">ZONE</span>
                            </a>
                        </p>
                    </div>

                    <form:form modelAttribute="user" method="post" onsubmit="return registerValidate();">
                   
                        <div class="form-row">
                            <div class="form-outline col-md-6 mb-3"><label class="form-label" for="firstName">First
                                    Name</label><input type="text" id="firstName" name="firstName"
                                    class="form-control rounded-0" placeholder="* First Name" value="" />
                                <div class="invalid-feedback">First Name is required.</div>
                            </div>

                            <div class="form-outline col-md-6 mb-3"><label class="form-label" for="lastName">Last
                                    Name</label><input type="text" id="lastName" name="lastName"
                                    class="form-control rounded-0" placeholder="* Last Name" value="" />
                                <div class="invalid-feedback">Last Name is required.</div>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col-md-6 form-outline mb-3"><label class="form-label"
                                    for="password">Password</label><input type="password" id="password" name="password"
                                    class="form-control rounded-0" placeholder="*Password" value="" />
                                <div class="col-sm-4 bg-light"></div>
                                <div class="invalid-feedback" id="errorPass">password should contain min:4
                                    characters and max:12 characters.</div>
                            </div>
                            <div class="col-md-6 form-outline mb-3"><label class="form-label" for="re-password">Confirm
                                    Password</label><input type="password" id="re-password" name="re-password"
                                    class="form-control rounded-0" placeholder="*Confirm Password" value="" />
                                <div class="invalid-feedback">Password did not matched.</div>
                            </div>
                        </div>


                        <div class="form-row">
                            <div class="col-md-6 form-outline mb-3"><label class="form-label" for="email">Email
                                    Address</label><input type="text" id="email" name="email"
                                    class="form-control rounded-0" placeholder="* Email Address" value="" />
                                <div class="invalid-feedback">Please enter valid Email address.</div>
                            </div>
                            <div class="col-md-6 form-outline mb-3"><label class="form-label" for="mobile">Mobile
                                    Number</label><input type="text" id="mobile" name="mobile"
                                    class="form-control rounded-0" placeholder="* Mobile Number" value="" />
                                <div class="invalid-feedback">Please enter valid 10 digit mobile number.</div>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="col-md-6 form-group form-outline mb-3">
                            	<label for="role">Account Type</label>
                            	<select class="form-control" id="role" name="role">
                                    <option value=0>Select Account Type</option>
                                    <option value=1>As a Publisher</option>
                                    <option value=2>As a Reader</option>
                                </select>
                                <div class="invalid-feedback">Please select the account type.</div>
                            </div>
                            <div class="col-md-6 form-inline form-outline pt-lg-3">

                                <div class="custom-control custom-radio mr-4"><input type="radio" id="gender-male"
                                        name="gender" value="M" class="custom-control-input "><label
                                        class="custom-control-label" for="gender-male">Male</label></div>
                                <div class="custom-control custom-radio"><input type="radio" id="gender-female"
                                        name="gender" value="F" class="custom-control-input"><label
                                        class="custom-control-label" for="gender-female">Female</label></div>
                                <div class="invalid-feedback">Please select the Gender.</div>
                            </div>
                        </div>

                        <div class="row justify-content-end mt-2">
                            <div class="text-lg-start ">
                            	<button type="submit" class="btn btn-primary btn rounded-0 mr-3"
                                    style="padding-left: 2.5rem; padding-right: 2.5rem;">Register</button>
                            </div>
                        </div>
                        
                        <div class="row col-md-12">
                        	<c:if test="${not empty errorMsg}"><div class="alert alert-danger alert-dismissible py-1 my-2 mr-3">${errorMsg}</div></c:if>
                			<c:if test="${not empty successMsg}"><div class="alert alert-success alert-dismissible py-1 my-2">${successMsg}</div></c:if>
                  		</div>
                        
                    </form:form>
                    
                    <div class="divider d-flex align-items-center my-4">
                        <p class="text-center badge badge-secondary badge-pill mx-2 mb-0">OR</p>
                    </div>
                    <div class="row justify-content-center"><button type="button"
                            class="col-md-1 btn btn-outline-secondary mb-1 mx-1 rounded-0"><i
                                class="fa fa-google"></i></button>


                        <button type="button" class="col-md-1 btn btn-outline-secondary mb-1 mx-1 rounded-0"><i
                                class="fa fa-facebook"></i></button><button type="button"
                            class="col-md-1 btn btn-outline-secondary mb-1 mx-1 rounded-0"><i
                                class="fa fa-linkedin"></i></button>
                    </div>
                    <p class="small fw-bold my-2 pt-1 mb-4 text-center">Do you already have an TechZONE Account? <a
                            href="<%=request.getContextPath() %>/user/login" class="link-danger">Login Here</a></p>


                    <div class="container">
                        <div class="row">
                            <div class="modal fade " id="successModel" role="dialog">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <span class="font-weight-normal">TechZone - New User</span>
                                            <button type="button" class="close" data-dismiss="modal" aria-label=""><span>×</span></button>
                                         </div>
                                        
                                        <div class="modal-body">
                                           
                                            <div class="row justify-content-center">
                                                <img class="row col-md-3" src="./assets/img/green-tick.png" alt="">
                                                <h1 class="col-md-12 text-center">Congradulations!</h1>
                                                <p><c:if test="${not empty successMsg}">${successMsg}</c:if></p>
                                                <p><a href="<%=request.getContextPath() %>/user/login" class="link-danger">Login Here</a></p>
                                             </div>
                                             
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    

                </div>
            </div>
        </div>
    </section>
    
	<script type="text/javascript" src="<c:url value="/resources/js/register-validation.js" />"></script>
	
	<%@include file="footer.jsp"%>
	
	
	<c:if test="${not empty successMsg}">
		<script type="text/javascript">
		    $(document).ready(function(){
		    	$('#successModel').modal('show')
		    });
		</script>
	</c:if>

</body>
</html>