$(document).ready(function(){
	$.ajax({
		 type: "GET",
		 url: '../user/emaillist',
		success:function(data){
			console.log(data);
		}
	});
});