<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%
	List<Empresa> lista = (List<Empresa>)request.getAttribute("lista");
%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:import url="Logout.jsp" />
	
	usuario logado : ${ usuario.login }
	
	<c:if test="${ not empty empresa}" >
			<p>empresa ${ empresa } cadastrada com sucesso</p>
	</c:if>
	<br>
	<ul>
		<!-- usa a tag forEach do pacote jstl.
			itens  - array para o for
			var - variavel que recebera cada um dos itens do array     -->
			
		<c:forEach items="${ lista }" var="empresa">
			<li> ${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy"/></li>
			<a href="/gerenciador/api?acao=MostraEmpresa&id=${ empresa.id }">editar</a>
			<a href="/gerenciador/api?acao=RemoveEmpresa&id=${ empresa.id }">Remove</a>
			<br>
			<br>	
		</c:forEach>
	
	</ul>
		
</body>
</html>