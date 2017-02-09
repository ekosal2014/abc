<%@page import="java.util.Arrays"%>
<%@page import="javax.mail.MessagingException"%>
<%@page import="javax.mail.NoSuchProviderException"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.Folder"%>
<%@page import="javax.mail.Store"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
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
<script src="${pageContext.request.contextPath }/static/user/email.js"></script>
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
					<%-- <c:forEach items="${email }" var="mail">
							<div>${mail }</div>
					</c:forEach> --%>
					<%
					try {

					      //create properties field
					      Properties properties = new Properties();

					      properties.put("mail.pop3.host", "pop.gmail.com");
					      properties.put("mail.pop3.port", "995");
					      properties.put("mail.pop3.starttls.enable", "true");
					      Session emailSession = Session.getDefaultInstance(properties);
					  
					      //create the POP3 store object and connect with the pop server
					      Store store = emailSession.getStore("pop3s");

					      store.connect("pop.gmail.com", "ekosal2014@gmail.com", "bmyncvxibaywftpx");

					      //create the folder object and open it
					      Folder emailFolder = store.getFolder("INBOX");
					      emailFolder.open(Folder.READ_ONLY);

					      // retrieve the messages from the folder in an array and print it
					      Message[] messages = emailFolder.getMessages(1,15);
					      System.out.println("messages.length---" + messages.length);
					     
					     for (int i = 0, n = messages.length; i < n; i++) {
					    	 Message message = messages[i];
					    	%>
					          <table>
					          	 <tbody>
					          	 	<tr>
					          	 		<td><%=(i + 1) %></td>
					          	 		<td><%=message.getSentDate() %></td>
					          	 		<td><%=message.getSubject() %></td>
					          	 		<td><%=message.getFrom()[0] %></td>
					          	 		<td><%=message.getContent().toString() %></td>
					          	 	</tr>
					          	 </tbody>
					          </table>
					         		
					       
					     <%}
					     
					      //close the store and folder objects
					      emailFolder.close(false);
					      store.close();
			              
					      } catch (NoSuchProviderException e) {
					         e.printStackTrace();
					      } catch (MessagingException e) {
					         e.printStackTrace();
					      } catch (Exception e) {
					         e.printStackTrace();
					      }
					%>
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