<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

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
  <title>TechZONE - New Post</title>
  
</head>
<body>

	<%@include file="header.jsp"%>
	
	
	   <section class="vh-100">
        <div class="container-fluid h-custom ">
            <div class="row d-flex justify-content-center align-items-center h-100">
                <div class="col-md-9 col-lg-6 col-xl-4 mt-2"><img src="<c:url value="/resources/img/create_post_cover.png" />" class="img-fluid img-thumbnail"
                        alt="Sample image"></div>
                <div class="col-md-8 col-lg-6 col-xl-6 offset-xl-1 ml-lg-4">
                
                
                    <form:form modelAttribute="post" method="post" enctype="multipart/form-data">
                        <div
                            class="mt-3 d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                            <p class="lead fw-normal mb-3">Create your Tech Post with <a class="navbar-brand " href="#">T<span
                                        class="lead text-primary">ech</span><span class="font-weight-bold">ZONE</span>
                                </a></p>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label class="form-label" for="title">Post Title</label>
                                <form:input path="title" type="text" id="title" name="title" class="form-control rounded-0" placeholder="Post Title" value="" />
                                <div class="invalid-feedback">This field is required.</div>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="content">Post Content</label>
                                <form:textarea path="content" class="form-control rounded-0" placeholder="Post Content" id="content" name="content" rows="3" />
                            </div>

                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="category">Post Category</label>
                                <form:select path="category" class="form-control rounded-0" id="category" name="category">
                                    <form:option value="no_select" label="Select Category Type" />
                                    <form:option value="technology" label="Technology" />
                                    <form:option value="gadget" label="Gadget" />
                                    <form:option value="programming" label="Programming" />
                                </form:select>
                                <div class="invalid-feedback">Please select the account type.</div>
                            </div>

                            <div class="form-group col-md-6">
                                <label class="form-label" for="subCategory">Post Sub Category</label>
                                <form:input path="subCategory" type="text" id="subCategory" name="subCategory" class="form-control rounded-0" placeholder="Sub Category Type" value="" />
                                <div class="invalid-feedback">This field is required.</div>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6 mt-auto">
                                <div class="form-check">
                                    <form:checkbox path="hasAirDate" class="form-check-input" name="hasAirDate" id="hasAirDate" />
                                    <label class="form-check-label" for="hasAirDate">Has Air Date</label>
                                </div>
                            </div>
                            <div class="form-group col-md-6">
                                <label class="form-label" for="airDate">Air Date</label>
                                <form:input path="airDate" type="date" id="airDate" name="airDate" class="form-control rounded-0" placeholder="MM/YYYY" value="" />
                                <div class="invalid-feedback">This field is required.</div>
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label class="form-label" for="airDate">Post Cover</label>
                                <div class="custom-file">
                                    <input type="file" class="custom-file-input" name="coverImage" id="coverImage">
                                    <label class="custom-file-label" for="coverImg">Choose Cover Image..</label>
                                    <div class="invalid-feedback">invalid file format.</div>
                                </div>
                            </div>
                        </div>

                        <div class="d-flex justify-content-end">
                            <div class="text-center text-lg-start mt-2">
                              <button type="submit" class="btn btn-primary btn rounded-0"
                                    style="padding-left: 2.5rem; padding-right: 2.5rem;">Create Post</button>
                            </div>       
                        </div>
                        
                        <c:if test="${not empty errorMsg}"><div class="alert alert-danger alert-dismissible py-1 pull-left mt-3">${errorMsg}</div></c:if>  
						<c:if test="${not empty param['errorMsg']}">
							<div class="row col-12 ml-2 alert alert-danger alert-dismissible py-1 pull-left mt-3"><%= request.getParameter("errorMsg") %></div>
						</c:if>

                        <div class="container">
                            <div class="row">
                                <div class="modal fade " id="successModel" role="dialog">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <span class="font-weight-normal">TechZone - New Post</span>
                                                <button type="button" class="close" data-dismiss="modal" aria-label=""><span>×</span></button>
                                             </div>
                                            
                                            <div class="modal-body">
                                               
                                                <div class="row justify-content-center">
                                                    <img class="row col-md-3" src="./assets/img/green-tick.png" alt="">
                                                    <h1 class="col-md-12 text-center">Done!</h1>
                                                    <p>Your Post is successfully submited.</p>
                                                 </div>
                                                 
                                            </div>
                                            
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                        

                    </form:form>
                </div>

            </div>
        </div>
    </section>
    

	<%@include file="footer.jsp"%>
	
	<c:if test="${result eq 'success'}">
		<script type="text/javascript">
		    $(document).ready(function(){
		    	$('#successModel').modal('show')
		    });
		</script>
	</c:if>
	
	<c:if test="${result eq 'updateSuccess'}">
		<script type="text/javascript">
		    $(document).ready(function(){
		    	$('#successModel').modal('show')
		    });
		</script>
	</c:if>
	

</body>
</html>