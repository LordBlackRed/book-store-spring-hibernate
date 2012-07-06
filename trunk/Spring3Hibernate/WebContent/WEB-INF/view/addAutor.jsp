<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head><title>Add Autor</title></head>
<body>
<h1>Add Autor</h1>

<c:url var="viewAutoresUrl" value="/autores.html" />
<a href="${viewAutoresUrl}">Show All Autores</a>

<br />
<br />
<c:url var="saveAutorUrl" value="/autores/save.html" />
<form:form modelAttribute="autor" method="POST" action="${saveAutorUrl}">
	<form:label path="nombre">Nombre:</form:label>
	<form:input path="nombre" />
	<br />
	<form:label path="apellidos">Apellidos:</form:label>
	<form:input path="apellidos" />
	<br />
	<input type="submit" value="Save Autor" />
</form:form>

</body>
</html>