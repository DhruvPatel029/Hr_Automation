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
	href="<%=request.getContextPath()%>/adminResources/css/materialdesignicons.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/simple-line-icons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/flag-icon.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/perfect-scrollbar.min.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/adminResources/css/style.css">
<!-- endinject -->
<!--  -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/adminResources/images/favicon.png" />
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
									<h4 class="card-title">Add Employee</h4>
									<f:form method="post" action="saveEmployee"
										modelAttribute="employeeVO" onsubmit="return addEmployee()">

										<fieldset>

											<f:hidden path="employeeTableId" />
											<div class="row">
												<div class="form-group col-md-6">
													<label>First Name<span class="text-danger">*</span></label>
													<f:input type="text" id="firstName" name="firstName"
														path="firstName" placeholder="Please enter your firstname"
														class="form-control" />
												</div>

												<div class="form-group col-md-6">
													<label>Last Name<span
														placeholder="Please enter your firstname"
														class="text-danger">*</span></label>
													<f:input id="lastName" name="lastName" path="lastName"
														placeholder="Please enter your firstname"
														class="form-control" />
												</div>

											</div>


											<div class="row">
												<div class="form-group col-md-6">
													<label>Gender<span class="text-danger">*</span></label>
													<f:select class="form-control" id="gender" path="gender"
														name="gender">
														<f:option value="Male">Male</f:option>
														<f:option value="Female">Female</f:option>
													</f:select>
												</div>
												<div class="form-group col-md-6">
													<label>Martial Status<span class="text-danger">*</span></label>
													<f:select class="form-control" id="maritalStatus"
														path="maritalStatus" name="maritalStatus">
														<f:option value="Single">Single</f:option>
														<f:option value="Married">Married</f:option>
													</f:select>
												</div>
											</div>



											<div class="form-group">
												<label>Date Of Birth</label>
												<f:input class="form-control" type="date" path="dateOfBirth"
													placeholder="dd/mm/yyyy" />
											</div>

											<div class="row">
												<div class="form-group col-md-6">
													<label>Email<span class="text-danger">*</span></label>
													<f:input type="text" class="form-control" id="email"
														name="email" path="loginVO.username" />
												</div>
												<div class="form-group col-md-6">
													<label>Mobile number<span class="text-danger">*</span>
													</label>
													<f:input type="text" class="form-control" id="mobileNumber"
														name="mobileNumber" path="mobileNumber" />
												</div>
											</div>

											<div class="row">
												<div class="form-group col-md-6">
													<label>Department<span class="text-danger">*</span></label>

													<f:select class="form-control" id="department"
														name="department" path="departmentVO.id">
														<option>Select Department</option>
														<i:forEach var="i" items="${departmentSearch}">
															<f:option value="${i.id}">${i.departmentName}</f:option>
														</i:forEach>

													</f:select>
												</div>
												<div class="form-group col-md-6">
													<label>Designation<span class="text-danger">*</span></label>
													<f:select class="form-control" id="designation"
														name="designation" path="designationVO.id">
														<option>Select Designation</option>
														<i:forEach var="i" items="${designationSearch}">
															<f:option value="${i.id}">${i.designationName}</f:option>
														</i:forEach>
													</f:select>
												</div>

											</div>

											<div class="row">
												<div class="form-group col-md-6">
													<label>Employee Id<span class="text-danger">*</span>
													</label>
													<f:input type="text" class="form-control" id="employeeId"
														name="employeeId" path="employeeId" />
												</div>


												<div class="form-group col-md-6">
													<label>Blood Group<span class="text-danger">*</span>
													</label>
													<f:select class="form-control" path="bloodGroup">
														<f:option value="">select blood group</f:option>
														<f:option value="A+">A+</f:option>
														<f:option value="A-">A-</f:option>
														<f:option value="B+">B+</f:option>
														<f:option value="B-">B-</f:option>
														<f:option value="AB+">AB+</f:option>
														<f:option value="AB-">AB-</f:option>
														<f:option value="O+">O+</f:option>
														<f:option value="O-">O-</f:option>
													</f:select>
												</div>
											</div>




											<div class="form-group">
												<label for="exampleTextarea1">Address<span
													class="text-danger">*</span></label>
												<f:textarea class="form-control" id="address" name="address"
													path="address" rows="3" cols="3"></f:textarea>
											</div>



											<input class="btn btn-primary" type="submit" value="Submit">
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
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/popper.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/perfect-scrollbar.jquery.min.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/jquery.validate.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bootstrap-maxlength.min.js"></script>
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/off-canvas.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/adminResources/js/misc.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/settings.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script
		src="<%=request.getContextPath()%>/adminResources/js/form-validation.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/bt-maxLength.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/file-upload.js"></script>
	<script
		src="<%=request.getContextPath()%>/adminResources/js/validation/addEmployee.js"></script>

	<!-- End custom js for this page-->
</body>