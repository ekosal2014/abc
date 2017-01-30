<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/static/css/content.css" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="${pageContext.request.contextPath }/static/vendor/ckeditor/ckeditor.js"></script>
<script src="${pageContext.request.contextPath }/static/user/product.js"></script>
</head>
<body>
<div class="page-wrapper">
	<%@include file="header.jsp" %>
	<div id="page-wrapper-content">
		<%@include file="sidebar.jsp" %>	
		<div id="page-contet-wrapper"> 
			<div id="content-wrapper">
				<div class="content-header blue">lkdaa</div>				
				<div id="content">					
	                  <div class="form-group" style="padding:10px 0 0 0;">
						<label class="col-sm-1 control-label">Product Name : </label>
						<div class="col-sm-5 col-xs-12">
							<input type="text" class="form-control col-xs-12" id="" placeholder="Example placeholder..."/>
						</div>
						<div style="clear: both;"></div>
					 </div>
					 <div class="form-group" style="padding:10px 0 0 0;">
						<label class="col-sm-1 control-label">Category Name : </label>
						<div class="col-sm-5 col-xs-12">
							<input type="text" class="form-control col-xs-12" id="txt-category-name" placeholder="Example placeholder..."/>
						</div>
						<div style="clear: both;"></div>
					</div>
					<div class="form-group" style="padding:10px 0 0 0;display:none"> 
						<label class="col-sm-1 control-label">Price : </label>
						<div class="col-sm-5 col-xs-12">
							<input type="number" class="form-control col-xs-12" id="" placeholder="Example placeholder..." maxlength="9"/>
						</div>
						<div style="clear: both;"></div>
					</div>
					<div class="form-group" style="padding:10px 0 0 0;display:none;">
						<label class="col-sm-1 control-label">Discount : </label>
						<div class="col-sm-5 col-xs-12">
							<input type="number" class="form-control col-xs-12" id="" placeholder="Example placeholder..." maxlength="2"/>
						</div>
						<div style="clear: both;"></div>
					</div>
					<div class="form-group" style="padding:10px 0 0 0;display: none;">
						<label class="col-sm-1 control-label">Menu Name : </label>
						<div class="col-sm-5 col-xs-12">
							<input type="text" class="form-control col-xs-12" id="" placeholder="Example placeholder..."/>
						</div>
						<div style="clear: both;"></div>
					</div>
				</div>
				<div class="content-image-controll">
					<div class="image-title">Please Insert Image</div>
					<div class="image-content">
					     <ul >
					     	 <li>
					     		<div id="image-preview">
								  <label id="image-label">Choose File</label>
								  <img  id="image" alt="" src="${pageContext.request.contextPath }/static/vendor/img/thin-363_photo_image_album-512.png" width="90" height="90">
								  <input type="file" name="image" id="image-upload" style="visibility: hidden;" onchange="imageView(this)"/>
								</div>
					     	 </li>
					     	 <li>
					     	 	<div id="image-preview">
								  <label  id="image-label">Choose File</label>
								   <img alt="" src="${pageContext.request.contextPath }/static/vendor/img/thin-363_photo_image_album-512.png" width="90" height="90">
								  <input type="file" name="image" id="image-upload" onchange="imageView(this)"/>
								</div>
					     	 </li>
					     	 <li>
					     	 	<div id="image-preview">
								  <label  id="image-label">Choose File</label>
								  <img alt="" src="${pageContext.request.contextPath }/static/vendor/img/thin-363_photo_image_album-512.png" width="90" height="90">
								  <input type="file" name="image" id="image-upload" onchange="imageView(this)"/>
								</div>
					     	 </li>
					     	 <li>
					     	 	<div id="image-preview">
								  <label  id="image-label">Choose File</label>
								   <img alt="" src="${pageContext.request.contextPath }/static/vendor/img/thin-363_photo_image_album-512.png" width="90" height="90">
								  <input type="file" name="image" id="image-upload" onchange="imageView(this)"/>
								</div>
					     	 </li>
					     	 <li>
					     	 	<div id="image-preview">
								  <label  id="image-label">Choose File</label>
								   <img alt="" src="${pageContext.request.contextPath }/static/vendor/img/thin-363_photo_image_album-512.png" width="90" height="90">
								  <input type="file" name="image" id="image-upload" onchange="imageView(this)"/>
								</div>
					     	 </li>
					     	 <li>
					     	 	<div id="image-preview">
								  <label  id="image-label">Choose File</label>
								   <img alt="" src="${pageContext.request.contextPath }/static/vendor/img/thin-363_photo_image_album-512.png" width="90" height="90">
								  <input type="file" name="image" id="image-upload" onchange="imageView(this)"/>
								</div>
					     	 </li>
					     	 <li>
					     	 	<div id="image-preview">
								  <label  id="image-label">Choose File</label>
								  <img alt="" src="${pageContext.request.contextPath }/static/vendor/img/thin-363_photo_image_album-512.png" width="90" height="90">
								  <input type="file" name="image" id="image-upload" onchange="imageView(this)"/>
								</div>
					     	 </li>
					     </ul>
					</div>
					<div class="image-title">Add More</div>
				</div>
				<div>
					<div class="form-group" style="padding:10px 0 0 0;">
						<label class="control-label">Description : </label>
						<div class="">
							<textarea name="editor1" id="editor1" rows="10" cols="80">
				                This is my text area to be replaced with CKEditor.
				            </textarea>
				            <script>
				                // Replace the <textarea id="editor1"> with a CKEditor
				                // instance, using default configuration.
				                CKEDITOR.replace( 'editor1' );
				            </script>
						</div>
						<div style="clear: both;"></div>
					</div>
				</div>
				<div>
				</div>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
	
	<%@include file="footer.jsp" %>
	
	<div style="clear: both;"></div>
</div>
<script type="text/javascript">

</script>
<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content" style="width:800px;">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h3>Modal Header</h3>
    </div>
    <div class="modal-body">
      	  <nav>
		    <ul>
		        <li><a href="javascript:">Nav 1</a></li>
		        <li><a href="javascript:">Nav 2</a></li>
		        <li class="dropdown">
		            <a href="javascript:">Nav 3</a>
		            <ul class="sub-menu">
		                <li><a href="javascript:">Nav 3.1</a></li>
		                <li class="dropdown">
		                    <a href="javascript:">Nav 3.4</a>
		                    <ul class="sub-menu">
		                        <li><a href="javascript:">Nav 3.4.1</a></li>
		                        <li>
		                            <a href="javascript:">Nav 3.4.2</a>
		                           
		                        </li>
		                    </ul>
		                </li>
		                <li><a href="javascript:">Nav 3.5</a></li>
		                <li><a href="javascript:">Nav 3.5</a></li>
		                <li><a href="javascript:">Nav 3.5</a></li>
		                <li><a href="javascript:">Nav 3.5</a></li>
		                <li><a href="javascript:">Nav 3.5</a></li>
		                <li><a href="javascript:">Nav 3.5</a></li>
		            </ul>
		         </li>
			</ul>
		</nav>    
    </div>
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
  </div>

</div>
</body>
</html>