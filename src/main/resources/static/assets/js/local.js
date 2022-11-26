
//Restrict the Text field to only accept numeric values
$(function(){

	  $('#mobileNo').keypress(function(e) {
		if(isNaN(this.value+""+String.fromCharCode(e.charCode))) return false;
	  })
	  .on("cut copy paste",function(e){
		e.preventDefault();
	  });
	  
	  $('#otp').keypress(function(e) {
		if(isNaN(this.value+""+String.fromCharCode(e.charCode))) return false;
	  })
	  .on("cut copy paste",function(e){
		e.preventDefault();
	  });
	  
	  getZoneNo();

});

//Getting Zone No
function getZoneNo() {

	$.ajax({
		type: "GET",
		url: '/asset/api/getZoneNo',
		dataType: 'json',
		success: function(bodyMessage) {
			var tempJson = bodyMessage['ZoneDetailsResult'];
			for (var i = 0; i < tempJson.length; i++) {
				var tempJsonValue = tempJson[i]['ZoneId'];
				var tempJsonLabel = tempJson[i]['ZoneName'];
				$('#zoneNo').append("<option value='" + tempJsonValue + "'>" + tempJsonLabel + "</option>");
			}
		}, error: function(e, ts, et) 
		{ 
			alert(ts) 
		}

	});
}

//Sending OTP
function sendOtp(){
	
	var mobileNo = $("#mobileNo").val();
	
	$.ajax({
			type: "GET",
			url: '/asset/feedback/sendOtp',
			data: {'mobileNo':mobileNo},
			dataType: 'json',
			success: function(bodyMessage) {
					
					if(bodyMessage!="Error"){
					 alert("OTP Send Successfully!!!");
					}else{
					 alert("OTP Not Send!!!");	
					}
			}
	    });
}

//Verify OTP
function verifyOtp(){
	
	var otp = $("#otp").val();
	
	$.ajax({
			type: "GET",
			url: '/asset/feedback/verifyOtp',
			data: {'otp':otp},
			dataType: 'json',
			success: function(bodyMessage) {
					 alert("OTP is Verified!!!");
					if(bodyMessage!="Error"){
					 alert("OTP is Verified!!!");
					}else{
					 alert("OTP is Incorrect!!!");	
					}
			}
	    });
}



