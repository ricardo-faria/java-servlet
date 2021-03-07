<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/api?acao=EditaEmpresa&id=${ empresa.id }" var="LinkAlteraEmpresa"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="Logout.jsp" />
	<form action="${ LinkAlteraEmpresa }" method="post">
		<label>nome: </label>
		<input type="text" name="nome" value="${ empresa.nome }"/>
		<label>data abertura: </label>
		<input type="date" name="dataAbertura" value="<fmt:formatDate value="${ empresa.dataAbertura }" pattern="yyyy-MM-dd"/>" />       
		<input type="submit">
		
	</form>
	
</body>
</html>