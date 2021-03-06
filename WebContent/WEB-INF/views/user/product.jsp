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
<script src="${pageContext.request.contextPath }/static/vendor/js/moment.js"></script>
<script src="${pageContext.request.contextPath }/static/vendor/js/command.js"></script>
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
				<div class="content-search ">
				    <!-- <div class="col-sm-1 col-xs-12">
						<input type="text" class="form-control col-xs-12" name="start-dt" id="start-dt"> 
					</div>
					 <div class="col-xs-12" style="margin-left: 10px;margin-top: 10px;">
						~
					</div>
					<div style="padding-left:0px;" class="col-sm-1 col-xs-12" >
						<input type="text" class="form-control col-xs-12" name="end-dt" id="end-dt">
					</div> -->
					<div style="padding-left:0px;" class="col-sm-1 col-xs-12" >
					    <select class="form-control col-xs-12" id="number-no">
					    	<option value="15">15</option>
					    	<option value="30">30</option>
					    	<option value="50">50</option>
					    	<option value="100">100</option>
					    </select>
					</div>
					<div class="col-sm-4 col-xs-12">
						<input type="text" class="form-control col-xs-12" name="p-name" id="p-name" placeholder="Example placeholder..." style="margin-left: 20px;">
					</div>
					<div class="col-sm-2 col-xs-12">
						<a href="javascript:" id="btn-search" class="btn btn-blue btn-big" style="margin-left: 30px;">Search</a>
					</div>					
				</div>
				<div class="content-tool">				   
					<a href="../user/addProduct" class="btn btn-blue btn-big">Add New</a>
				</div>
				<div id="content">
					<div class="x_content">
	                    <table class="table" id="tbl-result">
	                      <thead>
	                        <tr>
	                          <th>#</th>
	                          <th>Product Name</th>
	                          <th>Price</th>
	                          <th>Discount</th>
	                          <th>Date</th>
	                          <th>Status</th>
	                          <th>Action</th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                       	<c:forEach items="${pagedListHolder }" var="item" varStatus="i">
		                       		<tr>
			                          <th scope="row" style="width:10%"><c:out value="${i.index + 1 }"></c:out></th>
			                          <td style="width:20%">${item.P_NAME }</td>
			                          <th>${item.P_PRICE }</th>
			                          <th>${item.P_DISCOUND }</th>
			                          <td>${item.P_START_DT }</td>
			                          <td>
			                          	<c:if test="${item.P_STS=='1' }">
			                          		<span style="color:blue">Completed</span>
			                          	</c:if>
			                          	<c:if test="${item.P_STS=='0' }">
			                          		<span style="color:red">Waiting</span>
			                          	</c:if>
			                         </td>
			                          <td style="width:15%">
			                          	<a href="javascript:" class="btn btn-small btn-yellow" data-id="${item.P_ID }">Edit</a> | 
			                          	<a href="javascript:" class="btn btn-small btn-red btn-delete" data-id="${item.P_ID }">Delete</a>
			                          </td>
			                   	    </tr>
			                   	    
	                       	</c:forEach>
	                      </tbody>
	                    </table>	
	                  </div>
	                  <div style="text-align:right;">
	                  		<ul class="pagination modal-4">
	                  		
	                  		      <c:if test="${pagination.totalPage > 0 }">
	                  		            <c:if test="${pagination.currentPage == 1 }">
	                  		            	 <c:set var="dis" value="disable" scope="page" />	
	                  		            </c:if>
	                  		      		 <li><a href="javascript:" class="prev  ${dis }">
										    <i class="fa fa-chevron-left"></i>
										      Previous
										    </a>
										 </li>
										 <c:choose>
										 		<c:when test="${pagination.totalPage > 10 }">
										 			<c:forEach begin="1" end="5" step="1" var="i">
													  	<c:choose>
													  		<c:when test="${pagination.currentPage == i}">
													  			<li><a href="javascript:" class="active" data-id="${i }" onclick="listData(this)">${i }</a></li>
													  		</c:when>
													  		<c:otherwise>
													  			<li><a href="javascript:" class="normal" data-id="${i }" onclick="listData(this)">${i }</a></li>
													  		</c:otherwise>
													  	</c:choose>													  									  	
													  </c:forEach> 
													  <li><a href="javascript:" class="normal" data-id="${i }" >...</a></li>
													  <li><a href="javascript:" class="normal" data-id="${pagination.totalPage - 1 }" onclick="listData(this)">${pagination.totalPage - 1 }</a></li>
													  <li><a href="javascript:" class="normal" data-id="${pagination.totalPage }" onclick="listData(this)">${pagination.totalPage }</a></li>
										 		</c:when>
										 		<c:otherwise>
										 			<c:forEach begin="${pagination.currentPage }" end="${pagination.totalPage }" step="1" var="i">
													  	<c:choose>
													  		<c:when test="${pagination.currentPage == i}">
													  			<li><a href="javascript:" class="active" data-id="${i }" onclick="listData(this)">${i }</a></li>
													  		</c:when>
													  		<c:otherwise>
													  			<li><a href="javascript:" class="normal" data-id="${i }" onclick="listData(this)">${i }</a></li>
													  		</c:otherwise>
													  	</c:choose>
													  									  	
													  </c:forEach> 
										 		</c:otherwise>
										 </c:choose>
																	 
										
										  
										 
										  <c:if test="${pagination.currentPage >= pagination.totalPage }">
	                  		            	 <c:set var="next" value="disable" scope="page" />	
	                  		              </c:if>
										  <li><a href="javascript:" class="next ${next}"> Next 
										    	<i class="fa fa-chevron-right"></i>
										  </a></li>
	                  		      </c:if>
								  
							</ul>
	                  
	                  </div>
				</div>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
	
	<%@include file="footer.jsp" %>
	
	<div style="clear: both;"></div>
</div>
<script>
	$(document).ready(function(){
		command.ui.setDateRangePicker('#start-dt',"#end-dt",1);
		//$("#start-dt").datepicker('getDate');
		//$("#end-dt").datepicker();
	});
</script>
</body>
</html>