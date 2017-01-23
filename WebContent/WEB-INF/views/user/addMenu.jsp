<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/static/css/content.css" type="text/css" rel="stylesheet">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath }/static/user/menu.js"></script>

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
					<div style="padding:10px 0px 30px 10px;">
						<div class="form-group">
							<label class="col-sm-1 control-label">Category Name : </label>
							<div class="col-sm-5 col-xs-12">
								<input type="text" class="form-control col-xs-12" id="txt-menu" placeholder="Example placeholder..."/>
							</div>
							<a href="javascript:" style="margin-left:15px;" class="btn btn-green btn-success" id="btn-save">Save</a>
						</div>
						<div style="clear: both;"></div>
					</div>
					
					<div style="position:relative;width:100%">
					     <div class="col-sm-4 col-xs-12">
					     	<label>Category Name : </label>
					     	<div class="category-control">
					     		<div class="category-title"> Name </div>
					     		<div style="padding:10px;">
					     			<ul>
					     			   <c:forEach items="${menu }" var="item">
					     			        <c:if test="${item.sts == '0' }">
					     			        	<li><input type="checkbox">${item.menuName }</li>
					     			        </c:if>
					     			   </c:forEach>					     				
					     			</ul>
					     		</div>
					     		<div class="category-title" style="text-align:right; padding-right:10px;" >
					     			<a href="javascript:" id="btn-add-item" class="btn btn-default btn-success" style="padding: 3px 5px !important;"> ==></a>
					     		</div>
					     	</div>
					     </div>
					     <div class="col-sm-5 col-xs-12">
					     	<label>Menu Name : </label>
					     	<div class="category-control">
					     		<div class="category-title"> Name </div>
					     		<div style="padding:10px;">
					     			 <div class="dd" id="nestable">
							            <ol class="dd-list">
							               <c:forEach items="${menu }" var="lvl1">
							                   <c:if test="${lvl1.sts != '0' && lvl1.menuParents == '0'}">
							                   		<li class="dd-item" data-id="1">
									                    <div class="dd-handle"> ${lvl1.menuName }</div>		               
									                    <ol class="dd-list">
										                <c:forEach items="${menu }" var="lvl2">
										                  	<c:if test="${lvl2.sts != '0' && lvl2.menuParents == lvl1.menuId }">										              								                       
											                        <li class="dd-item" data-id="5">
											                            <div class="dd-handle">${lvl2.menuName }</div>
											                            <ol class="dd-list">
											                            	 <c:forEach items="${menu }" var="lvl3">
										                  						<c:if test="${lvl3.sts != '0' && lvl3.menuParents == lvl2.menuId }">
											                              			  <li class="dd-item" data-id="6"><div class="dd-handle">${lvl3.menuName }</div></li>									                              
												                            	</c:if>
											                				</c:forEach>
											                            </ol>
											                        </li>							                      
										                  	</c:if>
										                </c:forEach>
										                </ol>
									                </li>
								                   </c:if>							               		   
								               </c:forEach>									               
								            </ol>
								        </div>
					     		</div>
					     		<div class="category-title"> Name </div>
					     	</div>
					     </div>
					     <div style="clear: both;"></div>
					</div>
				</div>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
	
	<%@include file="footer.jsp" %>
	
	<div style="clear: both;"></div>
</div>
<script src="${pageContext.request.contextPath }/static/vendor/js/jquery-3.1.1.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/static/vendor/js/jquery.nestable.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
	
		 $('#nestable').nestable({
		        group: 1
		    });
		 $('#nestable-menu').on('click', function(e)
	     {
	        var target = $(e.target),
	            action = target.data('action');
	        if (action === 'expand-all') {
	            $('.dd').nestable('expandAll');
	        }
	        if (action === 'collapse-all') {
	            $('.dd').nestable('collapseAll');
	        }
	    });
	
	});

</script>
</body>
</html>