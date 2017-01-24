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
			var html = '<li class="dd-item" data-id="'+$(this).parent('li').attr('data-id')+'">'+
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
	
	$('#btn-save-update').click(function(){
		var list = [];
		$.each($('#nestable>.dd-list>.dd-item'), function(){
			console.log("lvl1="+$(this).attr('data-id'));
			
			$.each($(this).find('.dd-list:eq(0)>.dd-item'), function(){
				console.log("lvl2="+$(this).attr('data-id'));
				var lvl3 = [];
				$.each($(this).find('.dd-list>.dd-item'), function(){
					console.log("lvl3="+$(this).attr('data-id'));
					var lvl3item = {
									   'menuId':$(this).attr('data-id'),
									   'menuParents':$(this).parent('ol').parent('li').attr('data-id')
									}
					list.push(lvl3item);
				});
				var lvl2item = {
						'menuId':$(this).attr('data-id'),
						'menuParents':$(this).parent('ol').parent('li').attr('data-id')
				}
			
				list.push(lvl2item);
			});
			var lvl1= {
					'menuId':$(this).attr('data-id'),
					'menuParents':'0'
			}
			list.push(lvl1);
		});
		
		$.ajax({
			  type: "POST",
			  url: '../user/update-menu',
			  data: JSON.stringify(list),
			  contentType : 'application/json; charset=utf-8',
		      dataType : 'json',
			  success: function(data){
				  console.log(data);
				  alert(data.msg);
				  window.location.href = "../user/addMenu";
			  },error:function(data){
				  alert(data.msg);
				  window.location.href = "../user/addMenu";
			  }
			});
	});
});