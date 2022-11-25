function sendOtp(){
	
	var mobileNo = $("#mobileNo").val();
	
	$.ajax({
			type: "GET",
			url: '/asset/feedback/sendOtp',
			data: {'mobileNo':mobileNo},
			dataType: 'json',
			success: function(bodyMessage) {
					
					if(bodyMessage!="ERROR"){
					 alert("OTP Send Successfully!!!");
					}else{
					 alert("OTP Not Send!!!");	
					}
					 
			}
	    });
	
}