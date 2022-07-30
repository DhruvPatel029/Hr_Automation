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
<link rel="stylesheet"
	href="<%request.getContextPath();%>/adminResources/css/dataTables.bootstrap4.css" />
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%request.getContextPath();%>/adminResources/css/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%request.getContextPath();%>/adminResources/images/favicon.png" />
</head>

<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->

		<jsp:include page="header.jsp"></jsp:include>
		<%@taglib prefix="f" uri="http://java.sun.com/jstl/core_rt"%>
									
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<div class="row row-offcanvas row-offcanvas-right">
				<!-- partial:partials/_sidebar.html -->

				<jsp:include page="menu.jsp"></jsp:include>

				<!-- partial -->
				<div class="content-wrapper">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title">PAYMENT SLIP</h4>
							<div class="row">
								<div class="col-12">
									<div class="table-responsive">
										<table id="order-listing" class="table">
											<thead>
												<tr>
												    <th>Sr.No</th>
													<th>Employee Id</th>
													<th>Employee Name</th>
													<th>Genrate Slip</th>
													
												</tr>
											</thead>
											<tbody>
												<f:forEach items="${employeeList1}" var="i" varStatus="j">
													<tr>
														<td>${j.count}</td>
														<td>${i.employeeId}</td>
														<td>${i.firstName}</td>
														<td>
														<f:forEach items="${attendenceList}"  var ="k">
															
															<f:if test="${k.employeeVO.employeeId eq i.employeeId }">
															<f:if test = "${k.paySlipStatus eq 'pending'}">
																<f:set var="se" value="${k.paySlipStatus }"></f:set>
															</f:if>
															</f:if>
															
														</f:forEach>
														
														<f:if test="${se eq 'pending'}">
                    	          							<a href = "CalculatePayment?employeeTableId=${i.employeeTableId}"><button>Generate Payment Slip</button></a>
                    	          						</f:if>	
 														<f:if test="${se ne 'pending'}">
 														<f:forEach items="${employeeList}" var = "j">
 														<f:if test="${j.employeeVO.employeeId eq i.employeeId}">
                    	          						<f:set var="link" value="${j.salarySlipLink}"></f:set>
                        	    						</f:if>
                        	    						</f:forEach>
                        	    						<a href="${link}" download>download</a>
                        	    						</f:if>
                        	    						</td>
														
													</tr>
													</f:forEach>
											</tbody>
										</table>
									</div>
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
	<script src="<%request.getContextPath();%>/adminResources/js/jquery.dataTables.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/dataTables.bootstrap4.js"></script>
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="<%request.getContextPath();%>/adminResources/js/off-canvas.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/hoverable-collapse.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/misc.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/settings.js"></script>
	<script src="<%request.getContextPath();%>/adminResources/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script src="<%request.getContextPath();%>/adminResources/js/data-table.js"></script>
	<!-- End custom js for this page-->
</body>

</html>