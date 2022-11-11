<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Asset Feedback</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Major+Mono+Display" rel="stylesheet">

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<!-- Local CSS -->
<link href="../asset_feedback/css/main.css" rel="stylesheet" type="text/css">
<link href="../asset_feedback/css/tableList.css" rel="stylesheet" type="text/css">
</head>

<body>
	<!-- Menu Bar -->	
	<div class="card" style="background-color: rgb(21, 69, 93);">
		<div class="card-body">
			<div class="col-sm-1">
						<h5><a href="dashboard.jsp" style="color: #ffffffde"><span class="glyphicon glyphicon-dashboard"></span> Dashboard</a></h5>
			</div>
			<div class="col-sm-1">
						<h5><a href="asset_detail_entry.jsp" style="color: #ffffffde"><span class="glyphicon glyphicon-file"></span> Asset Detail</a></h5>
			</div>
			<div class="col-sm-1">
						<h5><a href="asset_detail_list.jsp" style="color: #ffffffde"><span class="glyphicon glyphicon-file"></span> Asset List</a></h5>
			</div>
			<div class="col-sm-1">
						<h5><a href="asset_feedback_form.jsp" style="color: #ffffffde"><span class="glyphicon glyphicon-open-file"></span> Feedback Form</a></h5>
			</div>
			<div class="col-sm-1">
						<h5><a href="asset_feedback_list.jsp" style="color: #ffffffde"><span class="glyphicon glyphicon-list-alt"></span> Asset Feedback List</a></h5>
			</div>
			<div class="col-sm-6"></div>
			<div class="col-sm-1">
						<h5><a href="login.jsp" style="color: #ffffffde"><span class="glyphicon glyphicon-log-out"></span> Logout</a></h5>
			</div>
		</div>
	</div>
	<h4 style="font-size: 25px;">Asset Feedback List</h4>
	<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-sm-2">
						<label for="fromDate">From Date</label><br />
					</div>
					<div class="col-sm-2">
						<input name="fromDate" type="date" value="" /><br>
					</div>
					<div class="col-sm-2">
						<label for="toDate">To Date</label><br />
					</div>
					<div class="col-sm-2">
						<input name="toDate" type="date" value="" /><br>
					</div>
					<div class="col-sm-1">
						<button type="submit" class="btn btn-success btn-lg" id="submit">Search</button>
					</div>
					
					<div class="col-sm-1">
					<a href="asset_feedback_list.jsp">
						<button class="btn btn-primary btn-lg" id="cancel">Cancel</button>
					</a>
					</div>
				</div>	
			</div>
	</div>		
	<div class="card">
			<div class="card-body">
	<table class="paleBlueRows">
		<thead>
			<tr>
				<th>SL.No.</th>
				<th>Asset ID</th>
				<th>Type</th>
				<th>Date</th>
				<th>Question</th>
				<th>Feedback</th>
				<th>Status</th>
				<th>Action</th>
			</tr>
		</thead>
		<!-- <tfoot>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>Total</td>
				<td></td>
			</tr>
		</tfoot> -->
		<tbody>
			<tr>
				<td>1</td>
				<td>001</td>
				<td>Type-1</td>
				<td>01-11-2022</td>
				<td><span>Q1.Rate your satisfaction with our team in resolving your issue.</span></td>
				<td>Yes</td>
				<td>Completed</td>
				<td></td>
			</tr>
			<tr>
				<td>2</td>
				<td>002</td>
				<td>Type-2</td>
				<td>01-11-2022</td>
				<td><span>Q2.Did you feel that our team answered your inquiry promptly?</span></td>
				<td>No</td>
				<td>In Progress</td>
				<td><a href="#">Take Action</a></td>
			</tr>
			<tr>
				<td>3</td>
				<td>003</td>
				<td>Type-3</td>
				<td>30-10-2022</td>
				<td><span>Q3.Do you agree or disagree that your issue was effectively resolved?</span></td>
				<td>No</td>
				<td>Pending</td>
				<td><a href="#">Take Action</a></td>
			</tr>
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>