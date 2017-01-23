$(document).ready(function(){
	$(document).on('click','.image-content>ul>li #image-label', function(){
		$(this).parent('#image-preview').find('#image-upload').trigger('click');
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