$(document).ready(function(){
	$(document).on('click','#NEXT-STEP-1',function(){
		
		$('#REGISTER-STET_1').ajaxSubmit({
			url:'./register-step-1',
			type:'POST',
			success:function(data){
				console.log(data);
			},
			error:function(data){
				console.log(data);
			}
		});
	});
	
	$(document).on('click', '#BTN_LOGIN', function(){
		$('#FORM_LOGIN').ajaxSubmit({
			url:'./login',
			type:'POST',
			success:function(data){
				console.log(data);
			},
			error:function(data){
				console.log(data);
			}
		});
	});
});