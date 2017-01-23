$(document).ready(function(){
	$('.category-control ul li').click(function(){
		if ($(this).find('input[type="checkbox"]').is(':checked')){
			$(this).find('input[type="checkbox"]').prop('checked',false);
		}else{			
			$(this).find('input[type="checkbox"]').prop('checked',true);
		}
	});
	
	$('#btn-add-item').click(function(){
		
	});
	
	$('#btn-save').click(function(){
		
	});
});