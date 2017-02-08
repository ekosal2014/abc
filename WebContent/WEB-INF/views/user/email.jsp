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
				<div id="content">
					<c:forEach items="${email }" var="mail">
							<div>${mail }</div>
					</c:forEach>
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