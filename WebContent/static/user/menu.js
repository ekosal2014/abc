$(document).ready(function(){
	$('.category-control ul li').click(function(){
		if ($(this).find('input[type="checkbox"]').is(':checked')){
			$(this).find('input[type="checkbox"]').prop('checked',false);
		}else{			
			$(this).find('input[type="checkbox"]').prop('checked',true);
		}
	});
	
	$('#btn-add-item').click(function(){
		sd
	});
	
	$('#btn-save').click(function(){
		$.ajax({
			  type: "POST",
			  url: '../user/menuAdd',
			  data: {'menuName':'abc'},
			  success: function(data){
				  
			  }
			});
	});
});