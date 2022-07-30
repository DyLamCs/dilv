<%@page import="com.entiti.Loginbean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<p>You are successfully logged in!</p>
	<%
	Loginbean bean = (Loginbean) request.getAttribute("bean");
	out.println("Xin chào chào chào, " + bean.getUsername() + "\n");
	out.println("<hr>");
	%>

	<form action="process.jsp" method="post">
		Number 1:<input type="text" name="n1" /><br>
		<br> Number 2:<input type="text" name="n2" /><br> <br>
		<input type="submit" value="Chia" />
	</form>
 

</body>

</html>