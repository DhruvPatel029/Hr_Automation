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
<%@taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<body>
	<%@taglib prefix="i" uri="http://java.sun.com/jstl/core_rt"%>
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
									<h4 class="card-title">Add Allowance/Deduction</h4>
									<f:form method="post" action="saveAllowanceDeduction"
										modelAttribute="allowanceDeductionVO">
										<f:hidden path="id"/>
										<fieldset>
											<div class="form-group">
												<label for="DesignationName">Designation</label>
												<f:select class="form-control" id="designationId"
													name="designation" path="designationVO.id"
													onchange="getSalary()">
													<option disabled="disabled" selected="selected">Select
														Designation</option>
													<i:forEach var="i" items="${designationSearch}">
														<f:option value="${i.id}">${i.designationName}</f:option>
														</i:forEach>
												</f:select>
											</div>
											<div class="form-group">
												<label for="basicSalary"> Basic Salary</label>
												<f:input path="basicSalary" class="form-control"
													id="basicSalary" />
											</div>
											<div class="form-group">
												<label for="allowance/deduction">Allowance/Deduction<span
													class="text-danger">*</span></label>

												<div class="custom-control custom-radio">
													<f:radiobutton id="customRadio1" value="allowance"
														checked="checked" path="allowancdeduction"
														class="custom-control-input" />
													<label class="custom-control-label" for="customRadio1">Allowance</label>
												</div>
												<div class="custom-control custom-radio">
													<f:radiobutton id="customRadio2" value="deduction"
														path="allowancdeduction" class="custom-control-input" />
													<label class="custom-control-label" for="customRadio2">Deduction</label>
												</div>
											</div>


											<div class="form-group">
												<label for="Type"> Type</label>
												<f:input path="allowDedtype" class="form-control" />
											</div>
											<div class="form-group">
												<label for="Limit"> Limit(%)</label>
												<f:input path="allowancelimit" class="form-control" />
											</div>
											<div class="form-group">
												<label for="description"> Description</label>
												<f:textarea rows="3" cols="3" path="description"
													class="form-control"></f:textarea>
											</div>
											<button type="submit" class="btn btn-success mr-2">Submit</button>

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
	<script src="<%request.getContextPath();%>/adminResources/js/validation/allowanceDeduction.js"></script>
	
	<!-- End custom js for this page-->
</body>

</html>
