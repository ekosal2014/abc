$(document).ready(function(){
	$(document).on('click','.image-content>ul>li #image-label', function(){
		$(this).parent('#image-preview').find('#image-upload').trigger('click');
	});
	
	$('#number-no').change(function(){
		$.ajax({
			  type: "GET",
			  url: '../user/search-product',
			  data: {'page':1,'size':$('#number-no').val(),'name': $('#p-name').val()},
			  success: function(data){
				  table_List(data);
			  },error:function(data){
				  console.log(data);
			  }
		});
	});
	
	$('#btn-search').click(function(){
		$.ajax({
			  type: "GET",
			  url: '../user/search-product',
			  data: {'page':1,'size':$('#number-no').val(),'name': $('#p-name').val()},
			  success: function(data){
				  table_List(data);
			  },error:function(data){
				  console.log(data);
			  }
		});
	});
	
	$('#tbl-result tbody td a.btn-delete').click(function(){
		var frm = window.confirm('Do you want to delete this item.');
		if (frm == true){
			$.ajax({
				  type: "GET",
				  url: '../user/delete-product',
				  data: {'pId':$(this).attr('data-id')},
				  success: function(data){
					  var msg = jQuery.parseJSON(data)
					  alert(msg.msg);
					  window.location.href = "../user/product";
				  },error:function(data){
					  var msg = jQuery.parseJSON(data)
					  alert(msg.msg);
					  window.location.href = "../user/product";
				  }
			});
		}
		
	});
	
	$('#txt-category-name').click(function(){
		$('#myModal').css('display','block');
	});
	$('.close,#btn_cancel').click(function(){
		$('#myModal').css('display','none');
	});
	$('.modal-body ul li').click(function(){
		console.log($('.modal-body ul').height());
        console.log($(this).children('.sub-menu').height());
		$(this).children('.sub-menu').slideDown(200);
	});
	
});

function imageView(input){
	 
	 if (input.files && input.files[0]) {
			 var extn = $(input)[0].value.substring($(input)[0].value.lastIndexOf('.') + 1).toLowerCase();
			 if (extn != "gif" && extn != "png" && extn != "jpg" && extn != "jpeg") {
				 alert("Error Format!");
				 return;
			 }
		    var reader = new FileReader();
		    reader.onload = function(e) {
		      $(input).parent('#image-preview').find('img').attr('src', e.target.result);
		    }

		    reader.readAsDataURL(input.files[0]);
		  }
}

function listData(obj){
	$.ajax({
		  type: "GET",
		  url: '../user/search-product',
		  data: {'page':$(obj).attr('data-id'),'size':$('#number-no').val(),'name': $('#p-name').val()},
		  success: function(data){
			  table_List(data);
		  },error:function(data){
			  console.log(data);
		  }
	});
}

function table_List(input){
	var xhtml = '',
	    xpagi = '',
		i     = (input['pagination']['currentPage'] - 1) * $('#number-no').val(),
	    sts   = '';
	$('#tbl-result tbody').empty();
	$('.pagination').empty();
	$.each(input['List'],function(k,v){	
		i    = i + 1;
		 if (v['P_STS'] == '1'){
        	 sts = '<span style="color:blue">Completed</span>';
         }else{
        	 sts = '<span style="color:red">Waiting</span>';
         }
      	    
		 xhtml += '<tr>'+
                      '<th scope="row" style="width:10%">'+i+'</th>'+
                      '<td style="width:20%">'+v['P_NAME']+'</td>'+
                      '<th>'+v['P_PRICE']+'</th>'+
                      '<th>'+v['P_DISCOUND']+'</th>'+
                      '<th>'+v['P_START_DT']+'</th>'+
                      '<th>'+ sts +'</th>'+
                      '<td style="width:15%">'+
                      	'<a href="javascript:" class="btn btn-small btn-yellow">Edit</a> | '+
                      	'<a href="javascript:" class="btn btn-small btn-red">Delete</a>'+
                      '</td>'+
               	     '</tr>';
		 
	});
	
	if (input['pagination']['totalPage'] > 0){	
		var pre = '',next='',min=1,max=1;
		if (input['pagination']['currentPage'] <= 1){
			pre = 'disable';
		}else{
			min = input['pagination']['currentPage'] - 1;
		}
	    xpagi +='<li><a href="javascript:" class="prev '+pre+'" data-id="'+min+'" onclick="listData(this)">'+
			    '<i class="fa fa-chevron-left"></i>'+
			      'Previous'+
				  '</a>'+
				 '</li>';
	    if (input['pagination']['totalPage'] > 10){
	        if (input['pagination']['currentPage'] < 6 ){
	        	var cur = 5;
	        	if (input['pagination']['currentPage'] > 3){
	        		cur = input['pagination']['currentPage'] + 2;
	        	}
	        	for(var i=1; i <= cur; i++){
	        		if ( i == input['pagination']['currentPage']){
			    		xpagi += '<li><a href="javascript:" class="active normal" data-id="'+i+'" onclick="listData(this)">'+i+'</a></li>';
			    	}else{
			    		xpagi += '<li><a href="javascript:" class="normal" data-id="'+i+'" onclick="listData(this)">'+i+'</a></li>';
			    	}	        		
	        	}
	        	xpagi += '<li><a href="javascript:" class="normal" data-id="'+i+'" >...</a></li>';
        		xpagi += '<li><a href="javascript:" class="normal" data-id="'+(input['pagination']['totalPage']-1)+'" onclick="listData(this)">'+(input['pagination']['totalPage']-1)+'</a></li>';
        		xpagi += '<li><a href="javascript:" class="normal" data-id="'+input['pagination']['totalPage']+'" onclick="listData(this)">'+input['pagination']['totalPage']+'</a></li>';
	        }else if (input['pagination']['totalPage'] < input['pagination']['currentPage'] + 6 ){
	        	var cur = input['pagination']['currentPage']-2;
	        	if (input['pagination']['totalPage'] <= input['pagination']['currentPage'] + 2){
	        		cur = input['pagination']['totalPage'] - 5;
	        	} 
	    		xpagi += '<li><a href="javascript:" class="normal" data-id="1" onclick="listData(this)">1</a></li>';
        		xpagi += '<li><a href="javascript:" class="normal" data-id="2" onclick="listData(this)">2</a></li>';	        	
	        	xpagi += '<li><a href="javascript:" class="normal" data-id="'+i+'" >...</a></li>';	        	
	        	for(var i=cur; i<= input['pagination']['totalPage']; i++){
	        		if ( i == input['pagination']['currentPage']){
			    		xpagi += '<li><a href="javascript:" class="active normal" data-id="'+i+'" onclick="listData(this)">'+i+'</a></li>';
			    	}else{
			    		xpagi += '<li><a href="javascript:" class="normal" data-id="'+i+'" onclick="listData(this)">'+i+'</a></li>';
			    	}
	        	}
	        }else{
	        	xpagi += '<li><a href="javascript:" class="normal" data-id="1" onclick="listData(this)">1</a></li>';
        		xpagi += '<li><a href="javascript:" class="normal" data-id="2" onclick="listData(this)">2</a></li>';	        	
	        	xpagi += '<li><a href="javascript:" class="normal" data-id="'+i+'" >...</a></li>';
	        	xpagi += '<li><a href="javascript:" class="normal" data-id="'+(input['pagination']['currentPage']-1)+'" onclick="listData(this)">'+(input['pagination']['currentPage']-1)+'</a></li>';
        		xpagi += '<li><a href="javascript:" class="active normal" data-id="'+(input['pagination']['currentPage'])+'" onclick="listData(this)">'+(input['pagination']['currentPage'])+'</a></li>';
	        	xpagi += '<li><a href="javascript:" class="normal" data-id="'+(input['pagination']['currentPage']+1)+'" onclick="listData(this)">'+(input['pagination']['currentPage']+1)+'</a></li>';
	        	xpagi += '<li><a href="javascript:" class="normal" data-id="'+i+'" >...</a></li>';
	        	xpagi += '<li><a href="javascript:" class="normal" data-id="'+(input['pagination']['totalPage']-1)+'" onclick="listData(this)">'+(input['pagination']['totalPage']-1)+'</a></li>';
        		xpagi += '<li><a href="javascript:" class="normal" data-id="'+(input['pagination']['totalPage'])+'" onclick="listData(this)">'+(input['pagination']['totalPage'])+'</a></li>';
	        }
	    }else{
	    	for(var i = 1; i <= input['pagination']['totalPage']; i++){
		    	if ( i == input['pagination']['currentPage']){
		    		xpagi += '<li><a href="javascript:" class="active normal" data-id="'+i+'" onclick="listData(this)">'+i+'</a></li>';
		    	}else{
		    		xpagi += '<li><a href="javascript:" class="normal" data-id="'+i+'" onclick="listData(this)">'+i+'</a></li>';
		    	}
		    }
	    }
	    
	    if (input['pagination']['currentPage'] >= input['pagination']['totalPage']){
			next = 'disable';
			max  = input['pagination']['totalPage'];
		}else{
			max  = input['pagination']['currentPage'] + 1;
		}
	    xpagi += ' <li><a href="javascript:" class="next '+next+'" data-id="'+max+'" onclick="listData(this)"> Next'+
				    	'<i class="fa fa-chevron-right"></i>'+
				  '</a></li>';
	}
	
	$('#tbl-result tbody').append(xhtml);
	$('.pagination').append(xpagi);
}