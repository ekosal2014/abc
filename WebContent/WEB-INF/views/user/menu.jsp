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
	                    <table class="table">
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
			                          <td style="width:70%">${lvl1.menuName }</td>
			                          <td><a href="javascript:" class="btn btn-small btn-yellow">Edit</a> | <a href="javascript:" class="btn btn-small btn-red">Delete</a></td>
			                        </tr>
					                <c:forEach items="${menu }" var="lvl2">
					                  	<c:if test="${lvl2.sts != '0' && lvl2.menuParents == lvl1.menuId }">	
					                  	   <c:set var="count" value="${count + 1}" scope="page"/> 									              								                       
			                    		   <tr>
					                          <th scope="row" style="width:10%"><c:out value="${count}"></c:out></th>
					                          <td style="width:70%">&nbsp&nbsp __ &nbsp&nbsp ${lvl2.menuName }</td>
					                          <td><a href="javascript:" class="btn btn-small btn-yellow">Edit</a> | <a href="javascript:" class="btn btn-small btn-red">Delete</a></td>
					                        </tr>
			                            	 <c:forEach items="${menu }" var="lvl3">
		                  						<c:if test="${lvl3.sts != '0' && lvl3.menuParents == lvl2.menuId }">
		                  						       <c:set var="count" value="${count + 1}" scope="page"/>
			                              			  <tr>
								                          <th scope="row" style="width:10%"><c:out value="${count}"></c:out></th>
								                          <td style="width:70%">&nbsp&nbsp __ &nbsp&nbsp __ &nbsp&nbsp ${lvl3.menuName }</td>
								                          <td><a href="javascript:" class="btn btn-small btn-yellow">Edit</a> | <a href="javascript:" class="btn btn-small btn-red">Delete</a></td>
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
</body>
</html>