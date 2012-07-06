<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/Spring3Hibernate/templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" media="all"
	href="/Spring3Hibernate/jsDatePick_ltr.min.css" />
<title>Detalles Libro</title>

<script>
	var error = ${sessionScope.error};
	if (error == true) {
		alert("¡No puede añadir el mismo libro 2 veces a tu biblioteca!");
		<% request.getSession().setAttribute("error", false); %>
	}
</script>

</head>
<body>

	<div id="templatemo_container">
		<jsp:include page="../../head.jsp" />

		<div id="templatemo_content">

			<jsp:include page="../../leftContent.jsp"></jsp:include>

			<div id="templatemo_content_right">

				<h1>
					${requestScope.libro.titulo}<span> - ${requestScope.libro.autor.nombre}</span>
				</h1>
				<div class="image_panel">
					<img src="${requestScope.libro.urlImagen}" alt="CSS Template"
						width="100" height="150" />
				</div>
				<ul>
					<li>Editorial <a href="${requestScope.libro.editorial.url}">${requestScope.libro.editorial.nombre}</a></li>
					<li><fmt:formatDate pattern="dd/MM/yyyy"
										value="${requestScope.libro.fechaPublicacion}" /></li>
					<li>Páginas: ${requestScope.libro.pags}</li>
					<li>ISBN ${requestScope.libro.isbn}</li>
				</ul>

				<p>${requestScope.libro.sinopsis}</p>
				<br></br>
				<h3>Puntuación</h3>
				<p>${requestScope.puntuacion} sobre
					${requestScope.puntuacionTotal}</p>

				<c:if test="${sessionScope.usuario != null}">
					<a href="/Spring3Hibernate/libros/addLibroUsuario.html?lib=${requestScope.libro.id}">Añadir a tu biblioteca</a>
				</c:if>
				<div class="cleaner_with_height">&nbsp;</div>


			</div>
			<!-- end of content right -->

			<div class="cleaner_with_height">&nbsp;</div>
		</div>
		<!-- end of content -->

		<jsp:include page="../../footer.jsp"></jsp:include>
		<!--  Free CSS Template www.templatemo.com -->
	</div>
	<!-- end of container -->
</body>
</html>