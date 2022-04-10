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
<title>TechZONE - My Profile</title>

<link rel="stylesheet" href="<c:url value="/resources/css/profile-styles.css" />">
 

</head>
<body>

	<%@include file="header.jsp"%>


	<div class="container mt-5">
		<div class="main-body">
			<div class="row">
				<div class="col-lg-4">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<img src="https://bootdey.com/img/Content/avatar/avatar6.png" alt="Admin" class="rounded-circle p-1 bg-primary" width="110">
								<div class="mt-3">
									<h4>${user.firstName} ${user.lastName}</h4>
									<p class="text-secondary mb-1">
										<c:if test="${user.role == 1 }">Publisher</c:if> 
										<c:if test="${user.role == 2 }">Reader</c:if>
									</p>
									<p class="text-primary font-size-sm ">${user.email }</p>
									<c:if test="${user.role == 1 }">
										<a href="<%=request.getContextPath() %>/posts/manage" class="btn btn-outline-primary rounded-0">Manage My Posts</a>
									</c:if>
								</div>
							</div>
							<hr class="my-4">
						</div>
					</div>
				</div>
				
				
				<div class="col-lg-8">
					<div class="card">
						<div class="card-body">
						
							<form:form modelAttribute="user" method="post" onsubmit="return registerValidate();">
                   
		                        <div class="form-row">
		                            <div class="form-outline col-md-6 mb-3">
			                            <label class="form-label" for="firstName">First Name</label>
			                            <form:input path="firstName" type="text" id="firstName" name="firstName" class="form-control rounded-0" placeholder="* First Name" value="" />
			                            <div class="invalid-feedback">First Name is required.</div>
		                            </div>
		
		                            <div class="form-outline col-md-6 mb-3">
			                            <label class="form-label" for="lastName">Last Name</label>
			                            <form:input path="lastName" type="text" id="lastName" name="lastName" class="form-control rounded-0" placeholder="* Last Name" value="" />
			                            <div class="invalid-feedback">Last Name is required.</div>
		                            </div>
		                        </div>
		
		                        <div class="form-row">
		                            <div class="col-md-6 form-outline mb-3">
			                            <label class="form-label" for="password">Password</label>
			                            <form:password path="password" id="password" name="password" class="form-control rounded-0" placeholder="*Password" value="" />
			                            <div class="col-sm-4 bg-light"></div>
			                            <div class="invalid-feedback" id="errorPass">password should contain min:4 characters and max:12 characters.</div>
			                       </div>
		                        </div>
		
		                        <div class="form-row">
		                            <div class="col-md-6 form-outline mb-3">
			                            <label class="form-label" for="email">Email Address</label>
			                            <form:input path="email" type="text" id="email" name="email" class="form-control rounded-0" placeholder="* Email Address" value="" />
			                            <div class="invalid-feedback">Please enter valid Email address.</div>
		                            </div>
		                            <div class="col-md-6 form-outline mb-3">
			                            <label class="form-label" for="mobile">Mobile Number</label>
			                            <form:input path="mobile" type="text" id="mobile" name="mobile" class="form-control rounded-0" placeholder="* Mobile Number" value="" />
			                            <div class="invalid-feedback">Please enter valid 10 digit mobile number.</div>
		                            </div>
		                        </div>
		
		                        <div class="form-row">
		                            <div class="col-md-6 form-group form-outline mb-3">
		                            	<label for="role">Account Type</label>
		                            	<form:select path="role" class="form-control" id="role" name="role">
		                                    <form:option value="0" label="Select Account Type" />
		                                    <form:option value="1" label="As a Publisher" />
		                                    <form:option value="2" label="As a Reader" />
		                                </form:select>
		                                <div class="invalid-feedback">Please select the account type.</div>
		                            </div>
		                            
		                            <div class="col-md-6 form-inline form-outline pt-lg-3">
		                                <div class="custom-control custom-radio mr-4">
			                                <form:radiobutton path="gender" id="gender-male" name="gender" value="M" class="custom-control-input" />
			                                <label class="custom-control-label" for="gender-male">Male</label>
		                                </div>
		                                <div class="custom-control custom-radio">
			                                <form:radiobutton path="gender" id="gender-female" name="gender" value="F" class="custom-control-input" />
			                                <label class="custom-control-label" for="gender-female">Female</label>
		                                </div>
		                                <div class="invalid-feedback">Please select the Gender.</div>
		                            </div>
		                        </div>
		
		                        <div class="row justify-content-end mt-2">
		                        	<div class="text-lg-start mr-3">
		                             	<a href="<%=request.getContextPath() %>/user/profile/delete?id=${user.id}" class="btn btn-danger btn rounded-0" style="padding-left: 2.5rem; padding-right: 2.5rem;">Delete Account</a>
		                             </div>
		                             <div class="text-lg-start mr-3">
		                             	<button type="submit" class="btn btn-primary btn rounded-0" style="padding-left: 2.5rem; padding-right: 2.5rem;">Update</button>
		                             </div>
		                        </div>
		                        
                        
                    		</form:form>
                    		
                    		<c:if test="${not empty errorMsg}"><div class="alert alert-danger alert-dismissible py-1 mt-3">${errorMsg}</div></c:if>
                    		<c:if test="${not empty successMsg}"><div class="alert alert-success alert-dismissible py-1 mt-3">${successMsg}</div></c:if>
                    		
                    		
                    		<div class="container">
	                            <div class="row">
	                                <div class="modal fade " id="successModel" role="dialog">
	                                    <div class="modal-dialog">
	                                        <div class="modal-content">
	                                            <div class="modal-header">
	                                                <span class="font-weight-normal">TechZone - User Profile</span>
	                                                <button type="button" class="close" data-dismiss="modal" aria-label=""><span>×</span></button>
	                                             </div>
	                                            
	                                            <div class="modal-body">
	                                               
	                                                <div class="row justify-content-center">
	                                                    <img class="row col-md-3" src="/recources/img/green-tick.png" alt="">
	                                                    <h1 class="col-md-12 text-center">Done!</h1>
	                                                    <p>${successMsg}</p>
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
			</div>
		</div>
	</div>


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