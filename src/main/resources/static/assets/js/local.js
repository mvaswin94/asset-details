
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

});

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

function verifyOtp(){
	
	var otp = $("#otp").val();
	
	$.ajax({
			type: "GET",
			url: '/asset/feedback/verifyOtp',
			data: {'otp':otp},
			dataType: 'json',
			success: function(message) {
					 alert("OTP is Verified!!!");
					if(message!="Error"){
					 alert("OTP is Verified!!!");
					}else{
					 alert("OTP is Incorrect!!!");	
					}
			}
	    });
}



