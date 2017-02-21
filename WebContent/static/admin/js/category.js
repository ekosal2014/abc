$(document).ready(function(){
	$('#btn-add').click(function(){
		$('#myModal').css('display','block');
	});

	$('.close,#btn_cancel').click(function(){
		$('#myModal').css('display','none');
	});
});