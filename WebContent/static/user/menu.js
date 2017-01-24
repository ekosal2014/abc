$(document).ready(function(){
	$('.category-control ul li').click(function(){
		if ($(this).find('input[type="checkbox"]').is(':checked')){
			$(this).find('input[type="checkbox"]').prop('checked',false);
		}else{			
			$(this).find('input[type="checkbox"]').prop('checked',true);
		}
	});
	
	$('#btn-add-item').click(function(){
		$.each($('.category-control ul li').find('input[type="checkbox"]:checked'),function(k,v){
			var html = '<li class="dd-item" data-id="1">'+
                       '<div class="dd-handle">'+$(this).parent('li').text()+'</div>'+
                       '<span class="btn-remove">remove</span>'+
                       '</li>';
			$(this).parent('li').remove();
			$('#nestable>.dd-list').append(html);
		});
	});
	
	$('#nestable .btn-remove').click(function(){
		alert($(this).parent('li').attr('data-id'));
		
		
		$.ajax({
			  type: "GET",
			  url: '../user/remove-menu',
			  data: {'id':$(this).parent('li').attr('data-id')},
			  success: function(data){
				  var msg = jQuery.parseJSON(data)
				  alert(msg.msg);
				  window.location.href = "../user/addMenu";
			  },error:function(data){
				  var msg = jQuery.parseJSON(data)
				  alert(msg.msg);
				  window.location.href = "../user/addMenu";
			  }
			});
	});
	
	$('#btn-save').click(function(){
		$.ajax({
			  type: "POST",
			  url: '../user/menuAdd',
			  data: {'menuName':$('#txt-menu').val()},
			  success: function(data){
				  var msg = jQuery.parseJSON(data)
				  alert(msg.msg);
				  window.location.href = "../user/addMenu";
			  },error:function(data){
				  var msg = jQuery.parseJSON(data)
				  alert(msg.msg);
				  window.location.href = "../user/addMenu";
			  }
			});
	});
});