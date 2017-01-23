<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	                        <tr>
	                          <th scope="row" style="width:10%">1</th>
	                          <td style="width:70%">Mark</td>
	                          <td><a href="javascript:" class="btn btn-small btn-yellow">Edit</a> | <a href="javascript:" class="btn btn-small btn-red">Delete</a></td>
	                        </tr>
	                        <tr>
	                          <th scope="row" style="width:10%">2</th>
	                          <td style="width:70%">Jacob</td>
	                          <td><a href="javascript:" class="btn btn-small btn-yellow">Edit</a> | <a href="javascript:" class="btn btn-small btn-red">Delete</a></td>
	                        </tr>
	                        <tr>
	                          <th scope="row" style="width:10%">3</th>
	                          <td style="width:70%">Larry</td>
	                          <td><a href="javascript:" class="btn btn-small btn-yellow">Edit</a> | <a href="javascript:" class="btn btn-small btn-red">Delete</a></td>
	                        </tr>
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