<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath }/static/css/content.css" type="text/css" rel="stylesheet">
</head>
<body>
<div class="page-wrapper">
	<%@include file="header.jsp" %>
	<div id="page-wrapper-content">
		<%@include file="sidebar.jsp" %>	
		<div id="page-contet-wrapper"> 
			<div id="content-wrapper">
				<div class="content-header blue">lkdaa</div>
				<div class="content-tool">
					<a href="../user/addMenu" class="btn btn-blue btn-big">Add New</a>
				</div>
				<div id="content">
					<div class="x_content">
	                    <table class="table" id="tbl-result">
	                      <thead>
	                        <tr>
	                          <th>#</th>
	                          <th>Menu Name</th>
	                          <th>Action</th>
	                        </tr>
	                      </thead>
	                      <tbody>
	                        <c:set var="count" value="0" scope="page" />	                      
	                        <c:forEach items="${menu }" var="lvl1">
			                   <c:if test="${lvl1.sts != '0' && lvl1.menuParents == '0'}">
		                   			 <c:set var="count" value="${count + 1}" scope="page"/>
			                   		<tr>
			                          <th scope="row" style="width:10%"><c:out value="${count}"></c:out></th>
			                          <td style="width:70%">${lvl1.menuName }<input type="hidden" value="${lvl1.menuName }" class="txt-name"/></td>
			                          <td><a href="javascript:" class="btn btn-small btn-yellow btn-edit" data-id="${lvl1.menuId }">Edit</a> | <a href="javascript:" class="btn btn-small btn-red btn-delete" data-id="${lvl1.menuId }">Delete</a></td>
			                        </tr>
					                <c:forEach items="${menu }" var="lvl2">
					                  	<c:if test="${lvl2.sts != '0' && lvl2.menuParents == lvl1.menuId }">	
					                  	   <c:set var="count" value="${count + 1}" scope="page"/> 									              								                       
			                    		   <tr>
					                          <th scope="row" style="width:10%"><c:out value="${count}"></c:out></th>
					                          <td style="width:70%">&nbsp&nbsp __ &nbsp&nbsp ${lvl2.menuName } <input type="hidden" value="${lvl1.menuName }" class="txt-name"/></td>
					                          <td><a href="javascript:" class="btn btn-small btn-yellow btn-edit" data-id="${lvl2.menuId }">Edit</a> | <a href="javascript:" class="btn btn-small btn-red btn-delete" data-id="${lvl2.menuId }">Delete</a></td>
					                        </tr>
			                            	 <c:forEach items="${menu }" var="lvl3">
		                  						<c:if test="${lvl3.sts != '0' && lvl3.menuParents == lvl2.menuId }">
		                  						       <c:set var="count" value="${count + 1}" scope="page"/>
			                              			  <tr>
								                          <th scope="row" style="width:10%"><c:out value="${count}"></c:out></th>
								                          <td style="width:70%">&nbsp&nbsp __ &nbsp&nbsp __ &nbsp&nbsp ${lvl3.menuName } <input type="hidden" value="${lvl1.menuName }" class="txt-name"/> </td>
								                          <td><a href="javascript:" class="btn btn-small btn-yellow btn-edit" data-id="${lvl3.menuId }">Edit</a> | <a href="javascript:" class="btn btn-small btn-red btn-delete" data-id="${lvl3.menuId }">Delete</a></td>
								                        </tr>
								                </c:if>
			                				</c:forEach>						                      							                      
					                  	</c:if>
					                </c:forEach>					          
				                   </c:if>							               		   
				               </c:forEach>		                        
	                      </tbody>
	                    </table>	
	                  </div>
				</div>
			</div>
		</div>
		<div style="clear: both;"></div>
	</div>
	
	<%@include file="footer.jsp" %>
	
	<div style="clear: both;"></div>
</div>
<!-- The Modal -->
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content" style="width:500px;">
    <div class="modal-header">
      <span class="close">&times;</span>
      <h3>Modal Header</h3>
    </div>
    <div class="modal-body">
      <p style="position: relative;">
      		<div class="col-sm-5 col-xs-12">
				<input type="text" class="form-control col-xs-12" id="txt-menu-edit" placeholder="Example placeholder..."/>
				<input type="hidden" class="txt-name-id"/>
			</div>
			<div style="clear: both;"></div>
      </p>
      <p style="padding-left: 10px;">
      	 <a href="javascript:" class="btn btn-small btn-yellow btn-edit" data-id="${lvl3.menuId }">Save</a> 
      	 <a href="javascript:" class="btn btn-small btn-red" id="btn_cancel" data-id="${lvl3.menuId }">Cancel</a>
      </p>
    </div>
    <div class="modal-footer">
      <h3>Modal Footer</h3>
    </div>
  </div>

</div>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="${pageContext.request.contextPath }/static/user/menu.js"></script>
</body>
</html>