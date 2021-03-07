<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/api?acao=NovaEmpresa" var="LinkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="Logout.jsp" />
	<form action="${ LinkServletNovaEmpresa }" method="post">
		<label>nome: </label>
		<input type="text" name="nome" />
		<label>data abertura: </label>
		<input type="date" name="dataAbertura" />
		<input type="submit">
		
	</form>
</body>
</html>