<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<body>
		<c:import url="Logout.jsp" />
		<c:if test="${ not empty empresa}" >
			<p>empresa ${ empresa } cadastrada com sucesso</p> 
		</c:if>

		<c:if test="${ empty empresa}" >
			<p>nenhuma empresa cadastrada</p>
		</c:if>
	
	</body>
</html>