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
	<form>
		<!-- <fieldset> -->
			<h4 style="font-size: 25px;">Feedback Form</h4>
			<!-- <div class="card">
			<div class="card-body">
			
			<div id="questionArea1">
				<label for="question1">Questions 1</label><br>
				<textarea id="question1" name="question1" rows="4" cols="50"></textarea>
				<span>Q1.Rate your satisfaction with our team in resolving your issue.</span>
				
				<input name="yes_or_no" type="radio" value="yes" />Yes
				<input name="yes_or_no" type="radio" value="no" />No<br/>
			</div>
			<br>
			

			<div id="questionArea2">
				<label for="question1">Questions 1</label><br>
				<textarea id="question1" name="question1" rows="4" cols="50"></textarea>
				<span>Q2.Did you feel that our team answered your inquiry promptly?</span>
				
				<input name="yes_or_no" type="radio" value="yes" />Yes
				<input name="yes_or_no" type="radio" value="no" />No<br/>
			</div>

			<div id="questionArea3">
				<label for="question1">Questions 1</label><br>
				<textarea id="question1" name="question1" rows="4" cols="50"></textarea>
				<span>Q3.Do you agree or disagree that your issue was effectively resolved?</span>
				
				<input name="yes_or_no" type="radio" value="yes" />Yes
				<input name="yes_or_no" type="radio" value="no" />No<br/>
			</div>
			<br>
			<button type="submit" class="btn btn-success btn-lg" id="submit">Submit</button>
			
			<a href="asset_feedback_form.jsp">
				<button class="btn btn-primary btn-lg" id="cancel">Cancel</button>
			</a>
			
			</div>
			</div> -->
			
			<div class="card">
			<div class="card-body">
				<table class="paleBlueRows" style="width: 750px;">
					<thead>
						<tr>
							<th>SL.No.</th>
							<th>Question</th>
							<th>Yes</th>
							<th>No</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td><span>Q1.Rate your satisfaction with our team in resolving your issue.</span></td>
							<td><input name="yes_or_no" type="radio" value="yes" />Yes</td>
							<td><input name="yes_or_no" type="radio" value="no" />No</td>
						</tr>
						<tr>
							<td>2</td>
							<td><span>Q2.Did you feel that our team answered your inquiry promptly?</span></td>
							<td><input name="yes_or_no" type="radio" value="yes" />Yes</td>
							<td><input name="yes_or_no" type="radio" value="no" />No</td>
						</tr>
						<tr>
							<td>3</td>
							<td><span>Q3.Do you agree or disagree that your issue was effectively resolved?</span></td>
							<td><input name="yes_or_no" type="radio" value="yes" />Yes</td>
							<td><input name="yes_or_no" type="radio" value="no" />No</td>
						</tr>

					</tbody>
				</table>
				<br>
			<button type="submit" class="btn btn-success btn-lg" id="submit">Submit</button>
			
			<a href="asset_feedback_form.jsp">
				<button class="btn btn-primary btn-lg" id="cancel">Cancel</button>
			</a>
	</div>
	</div>
		<!-- </fieldset> -->
	</form>
</body>
</html>