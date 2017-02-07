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
							<div id="controll-menu">
								<span id="menu-step-1">a</span><span id="menu-step-2"> => b </span><span id="menu-step-3"> => c </span><a class="btn" id="btn-change-menu"> Change</a>
							</div>
							
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
							<select class="form-control col-xs-12">
								 <c:forEach items="${menu }" var="lvl1">
			                     <c:if test="${lvl1.sts != '0' && lvl1.menuParents == '0'}">
		                   			 <c:set var="count" value="${count + 1}" scope="page"/>
			                   		 <option value="lvl1.menuId">${lvl1.menuName }</option>
					                <c:forEach items="${menu }" var="lvl2">
					                  	<c:if test="${lvl2.sts != '0' && lvl2.menuParents == lvl1.menuId }">	
					                  	   <c:set var="count" value="${count + 1}" scope="page"/> 									              								                       
			                    		   <option value="lvl2.menuId"> __ ${lvl2.menuName }</option>
			                            	 <c:forEach items="${menu }" var="lvl3">
		                  						<c:if test="${lvl3.sts != '0' && lvl3.menuParents == lvl2.menuId }">
		                  						       <c:set var="count" value="${count + 1}" scope="page"/>
			                              			  <option value="lvl3.menuId"> __ __${lvl3.menuName }</option>
								                </c:if>
			                				</c:forEach>						                      							                      
					                  	</c:if>
					                </c:forEach>					          
				                   </c:if>							               		   
				               </c:forEach>		  
							</select>
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
				     <a href="javascript:" style="margin-left:15px;" class="btn btn-green btn-success" id="btn-cancel">Save</a>
					 <a href="javascript:" style="margin-left:15px;" class="btn btn-green btn-success" id="btn-save">Save</a>
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
		        <c:forEach items="${menu }" var="lvl1" varStatus="i">
		             <c:if test="${lvl1.sts != '0' && lvl1.menuParents == '0'}">
		                 <c:set var="count1" value="0" scope="page" />
		                 <c:forEach items="${menu }" var="txt1">
		                 		<c:if test="${txt1.menuParents == lvl1.menuId}">
		                 			<c:set var="count1" value="${count1 + 1}" scope="page"/>
		                 		</c:if> 
		                 </c:forEach>
		                 <c:if test="${count1 == 0 }">
		                 	 <li><a href="javascript:" data-id="${lvl1.menuId }" class="main data-id">${lvl1.menuName }</a></li>
		                 </c:if>
			        	 <c:if test="${count1 > 0 }">
				        	 <li class="dropdown"><a href="javascript:" data-id="${lvl1.menuId }" class="main">${lvl1.menuName }</a>
					        	<ul class="sub-menu">
					        	     <c:forEach items="${menu }" var="lvl2">
					        	        <c:set var="count2" value="0" scope="page" />
										<c:if test="${lvl2.sts != '0' && lvl2.menuParents == lvl1.menuId }">
										 <c:forEach items="${menu }" var="txt2">
						                 		<c:if test="${txt2.menuParents == lvl2.menuId}">
						                 			<c:set var="count2" value="${count2 + 1}" scope="page"/>
						                 		</c:if> 
						                 </c:forEach>
						                 <c:if test="${count2 == 0 }">
						                 	 <li><a href="javascript:" class="submain data-id" data-id="${lvl2.menuId }">${lvl2.menuName }</a></li>
						                 </c:if>
							              <c:if test="${count2 > 0 }">
							              		<li class="dropdown ">
							                    <a href="javascript:" class="submain" data-id="${lvl2.menuId }">${lvl2.menuName }</a>
							                    <ul class="sub-menu">
							                    	 <c:forEach items="${menu }" var="lvl3">
											            <c:if test="${lvl3.sts != '0' && lvl3.menuParents == lvl2.menuId }">
									                        <li><a href="javascript:" class="data-id" data-id="${lvl3.menuId }">${lvl3.menuName }</a></li>
									                        
									                	 </c:if>
									                 </c:forEach>
							                    </ul>
							                </li>
							              </c:if>							              
						          		 </c:if>
						           </c:forEach>
					            </ul>
					            </li>
			        	 </c:if>
				         
				        
				      
			         </c:if>
		        </c:forEach>
		        
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