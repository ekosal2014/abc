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
							                <li class="dd-item" data-id="1">
							                    <div class="dd-handle">Home</div>
									                </li>
									                <li class="dd-item" data-id="2">
									                    <div class="dd-handle">Item 2</div>
									                    <ol class="dd-list">
									                        <li class="dd-item" data-id="3"><div class="dd-handle">Item 3</div></li>
									                        <li class="dd-item" data-id="4"><div class="dd-handle">Item 4</div></li>
									                        <li class="dd-item" data-id="5">
									                            <div class="dd-handle">Item 5</div>
									                            <ol class="dd-list">
									                                <li class="dd-item" data-id="6"><div class="dd-handle">Item 6</div></li>
									                                <li class="dd-item" data-id="7"><div class="dd-handle">Item 7</div></li>
									                                <li class="dd-item" data-id="8"><div class="dd-handle">Item 8</div></li>
									                            </ol>
									                        </li>
									                        <li class="dd-item" data-id="9"><div class="dd-handle">Item 9</div></li>
									                        <li class="dd-item" data-id="10"><div class="dd-handle">Item 10</div></li>
									                    </ol>
									                </li>
									                <li class="dd-item" data-id="11">
									                    <div class="dd-handle">Contact Us</div>
									                </li>
									                <li class="dd-item" data-id="12">
									                    <div class="dd-handle">About Us</div>
									                </li>
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