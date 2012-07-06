<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
	<select name="idEditorial">
		<c:forEach items="${editoriales}" var="editorial">
			<option value="${editorial.id}">${editorial.nombre}</option>
		</c:forEach>
	</select>
</body>
</html>