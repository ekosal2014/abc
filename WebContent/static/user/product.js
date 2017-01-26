$(document).ready(function(){
	$(document).on('click','.image-content>ul>li #image-label', function(){
		$(this).parent('#image-preview').find('#image-upload').trigger('click');
	});
	
	$('.pagination li a.normal').click(function(){
		$.ajax({
			  type: "GET",
			  url: '../user/search-product',
			  data: {'page':$(this).attr('data-id'),'size':$('#number-no').val()},
			  success: function(data){
				 console.log(data);
			  },error:function(data){
				  console.log(data);
			  }
			});
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

function table_List(){
	
	
}