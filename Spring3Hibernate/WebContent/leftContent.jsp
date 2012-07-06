<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div id="templatemo_content_left">
		<div class="templatemo_content_left_section">
			<h1>Géneros</h1>
			<ul>
				<c:forEach items="${generos}" var="genero">
					<c:choose>
						<c:when test="${sessionScope.misLibros == false}">
							<li><a
								href="/Spring3Hibernate/libros/inicio.html?pag=1&gen=${genero.id}">${genero.genero}</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="/Spring3Hibernate/libros/misLibros.html?pag=1&gen=${genero.id}">${genero.genero}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- end of content left -->
</body>
</html>