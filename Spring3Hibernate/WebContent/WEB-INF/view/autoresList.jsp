<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<select name="idAutor">
		<c:forEach items="${autores}" var="autor">
			<option value="${autor.id}">${autor.nombre}</option>
		</c:forEach>
	</select>
</body>
</html>