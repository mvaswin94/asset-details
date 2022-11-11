<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Asset Feedback</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/qrcode-generator/1.4.1/qrcode.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"> </script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/p opper.js/1.14.3/umd/popper.min.js"> </script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Major+Mono+Display">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css"
	integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP"
	crossorigin="anonymous">
	
<!-- Local CSS -->	
<link href="../asset_feedback/css/main.css" rel="stylesheet" type="text/css">

</head>


<body>

	<!-- <form accept-charset="UTF-8" action="asset_detail_entry.jsp" autocomplete="off" method="GET"
		target="_blank"> -->
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
	
	<!-- <form method="POST"> -->
	<fieldset>
		<h4 style="font-size: 25px;">Asset Details</h4>
		<div class="card">
			<div class="card-body">
				<div class="row">
					<div class="col-sm-1">
						<label for="zone">Zone</label><br />
					</div>
					<div class="col-sm-2">
						<input name='zone' id='zone' type='text'/><br>
					</div>
					<div class="col-sm-1">
						<label for="div">Div</label><br />
					</div>
					<div class="col-sm-2">
						<input name='div' id='div' type="text"/> <br />
					</div>
					<div class="col-sm-1">
						<label for="region">Region</label><br />
					</div>
					<div class="col-sm-2">
						<input name='region' id='region' type='text'/> <br />
					</div>
					<div class="col-sm-1">
						<label for="assetId">Asset ID</label><br />
					</div>
					<div class="col-sm-2">
						<input name='assetId' id='assetId"' type='text' onchange='addAssetId(this);' /> <br />
					</div>
					<br> <br>
				</div>

				<div class="row">
					<div class="col-sm-1">
						<label for="assetName">Asset Name</label><br />
					</div>
					<div class="col-sm-2">
						<input name='assetName' id='assetName' type='text' /> <br />
					</div>
					<div class="col-sm-1">
						<label for="assetType">Asset Type</label><br />
					</div>
					<div class="col-sm-2">
						<input name='assetType' id='assetType' type='text' /> <br />
					</div>
					<div class="col-sm-1">
						<label for="assetAddress">Asset Place</label><br />
					</div>
					<div class="col-sm-2">
						<input name='assetAddress' id='assetAddress' type='text'/> <br />
					</div>
					<div class="col-sm-3"></div>
					<br> <br>
				</div>
				<div class="row"></div>
			</div>
		</div>

	</fieldset>
	<br>
	<fieldset>
		<h4 style="font-size: 18px;">Feedback Form</h4>
		<div class="card">
			<div class="card-body">
				<div class="row">
				<div class="col-sm-3"></div>
					<div class="col-sm-6">
						<div id="questionArea">
							<label>Questions</label><br>
							<!-- <textarea id="question1" name="question1" rows="4" cols="50"></textarea> -->
							<input type='text' class='form-control input-lg' id='question'  style='font-size: 14px;'>
						</div>
					</div>
					<div class="col-sm-1">
					<input type="button" class="btn btn-dark btn-lg" onclick="javascript: appendQuestion()" value="Add" name="add" id="add" />
					</div>
				<div class="col-sm-2"></div>
				</div>
				
				<br>

				<!-- <div id="questionArea2">
					<label>Questions 2</label><br>
					<textarea id="question2" name="question2" rows="4" cols="50"></textarea>
				</div>
				<br> -->

				<!-- <div id="questionArea3">
					<label>Questions 3</label><br>
					<textarea id="question3" name="question3" rows="4" cols="50"></textarea> 
				</div>
				<br> -->

				<!-- <input name="yes_or_no" type="radio" value="yes" />Yes
			<input name="yes_or_no" type="radio" value="no" />No<br/> -->

				<!-- <button type="submit" value="Submit" id="generate">Generate QR Code</button> -->
			
	<!-- </form> -->

	<!-- <div class = "container mx-auto w-75 py-4 border my-4 bg-light"> -->
	<!-- <label for = "usr" class = "text-dark"> URL: </label> -->
	<input type="text" class="form-control" id="url" name="url" hidden>
	<!-- <a href="javascript:void(0)" > --> 
		<button type="submit" style="font-size: 13px;"  class="btn btn-success btn-lg" onclick="generate();">Submit</button>
	<!-- </a> -->
	<a href="asset_detail_entry.jsp" class="btn btn-primary btn- lg" style="font-size: 13px;" > Cancel</a>	
	</div>
		</div>

	</fieldset>
	<!-- </form> -->
	<!-- </div>   -->

	<div class="row">
		<div class="col-sm-5"></div>
			<div class="col-sm-2">
				<div class="card">
					<div class="card-body" id="dBtn">
							<!-- <div class="jumbotron mx-auto w-75 border my-4 py-4 text-center" id="dBtn"> -->
						<div id="placeHolder"></div>
							<canvas id="myCanvas"> </canvas>
							<br> <a href="#" class="btn btn-danger btn-lg" onclick="downloadQrCode(this);" download="QRcode.png"> Download </a>
					</div>
				</div>
			</div>
		<div class="col-sm-5"></div>
	</div>				
	<!-- <nav class = "navbar navbar-expand-sm bg-dark navbar-dark fixed-bottom p-1 ">  
     <ul class = "navbar-nav">  
     <li class = "nav-item">  
      <a class = "nav-link" href = "javascript:void(0)"> All Rights Reserved 2022 </a>  
    </li>  
       </ul>  
    </nav> -->

	<script>
	function appendQuestion(){
		 //$("questionArea").append("<label for='question'>Questions</label><br><textarea id='question' name='question' rows='4' cols='50'></textarea>");
		 //$($this).closest('div').find('div#questionArea').append("<label for="question">Questions</label><br><textarea id="question" name="question" rows="4" cols="50"></textarea>");
		document.getElementById("questionArea").innerHTML += "<br><input type='text' class='form-control input-lg' id='question'  style='font-size: 14px;'>"; 
		 }
		function generate() {
			var typeNumber = 4;
			var errorCorrectionLevel = 'L';
			var qr = qrcode(typeNumber, errorCorrectionLevel);
			var inputText = document.getElementById('url').value;
			qr.addData(inputText);
			qr.make();
			document.getElementById('placeHolder').innerHTML = qr.createImgTag();
			canvasScreen();
		}
		downloadQrCode = function(el) {
			var canvas = document.getElementById("myCanvas");
			var image = canvas.toDataURL("image/png");
			el.href = image;
		};
		function canvasScreen() {
			var a = document.getElementsByTagName("img")[0];
			a.setAttribute("id", "qrcode");
			var canvas = document.getElementById("myCanvas");
			var ctx = canvas.getContext("2d");
			var img = document.getElementById("qrcode");
			ctx.drawImage(img, 70, 0, 150, 150);
			document.getElementById("dBtn").style.display = "block";
		}
		function addAssetId($this) {
			var typevalue = $this.value;
			var tempURL = "asset_feedback/asset_feedback_form.jsp?assetId='"
					+ typevalue + "'";
			$('#url').val(tempURL);
		}
	</script>

</body>
</html>