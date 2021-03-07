<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/api?acao=Login" var= "linkApi" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="Logout.jsp" />
	<form action="${ linkApi }" method="POST">
		login: <input type="text" name="login" />
		senha: <input type="password" name="senha" />
		
		<input type="hidden" name="acao" value="login" />
		
		<input type="submit" />
	</form>
</body>
</html>