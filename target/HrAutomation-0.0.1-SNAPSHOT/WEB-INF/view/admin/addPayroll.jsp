<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Victory Admin</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="<%request.getContextPath();%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet" href="<%request.getContextPath();%>/adminResources/css/simple-line-icons.css">
<link rel="stylesheet" href="<%request.getContextPath();%>/adminResources/css/flag-icon.min.css">
<link rel="stylesheet"
	href="<%request.getContextPath();%>/adminResources/css/perfect-scrollbar.min.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%request.getContextPath();%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%request.getContextPath();%>/adminResources/images/favicon.png" />
</head>
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form" %>

<body>
<%@taglib prefix="i" uri="http://java.sun.com/jstl/core_rt" %>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->

		<jsp:include page="header.jsp"></jsp:include>

		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<div class="row row-offcanvas row-offcanvas-right">
				<!-- partial:partials/_sidebar.html -->

				<jsp:include page="menu.jsp"></jsp:include>

				<!-- partial -->
				<div class="content-wrapper">

					<div class="row">
						<div class="col-lg-12">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">Payroll</h4>
								<f:form  method="post" action="savePayroll" modelAttribute="PayrollVO">
										<fieldset>
											<div class="form-group">
												<label for="DesignationName">Add Designation</label> 
									 <f:select class="form-control" id="designation" name="designation" path="designationVO.id">
														 <option>Select Designation</option>
															<i:forEach var="i" items="${designationSearch}">
																		<f:option value="${i.id}">${i.designationName}</f:option>
																	</i:forEach>	
														</f:select> 
										<br>
										<f:hidden path="id"/>
												<div class="form-group">
												<label for="Salary">Basic Salary</label> 
												<f:input path="basicSalary" class="form-control"/> 
													
											</div>
											  <button type="submit" class="btn btn-success mr-2">Submit</button>
											</div>
										</fieldset>
									</f:form>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->

				<jsp:include page="footer.jsp"></jsp:include>

				<!-- partial -->
			</div>
			<!-- row-offcanvas ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- plugins:js -->
	<script src="<%request.getContextPath();%>/adminResources/js/jquery.min.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/popper.min.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/bootstrap.min.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/perfect-scrollbar.jquery.min.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<script src="<%request.getContextPath();%>/adminResources/js/jquery.validate.min.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/bootstrap-maxlength.min.js"></script>
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="<%request.getContextPath();%>/adminResources/js/off-canvas.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/misc.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/settings.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="<%request.getContextPath();%>/adminResources/js/form-validation.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/bt-maxLength.js"></script>
	<!-- End custom js for this page-->
</body>

</html>
