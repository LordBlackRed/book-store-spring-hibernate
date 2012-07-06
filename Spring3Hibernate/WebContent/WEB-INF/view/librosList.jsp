<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Libros</title>

<c:choose>
<c:when test="${sessionScope.misLibros == false}">
<link href="/Spring3Hibernate/templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"
	src="/Spring3Hibernate/js/behavior.js"></script>
<script type="text/javascript" language="javascript" src="/Spring3Hibernate/js/rating.js"></script>
<link rel="stylesheet" type="text/css" href="/Spring3Hibernate/css/rating.css" />
</c:when>
<c:otherwise>
<link href="/Spring3Hibernate/templatemo_style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" language="javascript"
	src="/Spring3Hibernate/js/behavior.js"></script>
<script type="text/javascript" language="javascript" src="/Spring3Hibernate/js/rating.js"></script>
<link rel="stylesheet" type="text/css" href="/Spring3Hibernate/css/rating.css" />
</c:otherwise>
</c:choose>

<script>
	var puntuacionCorrecta = ${sessionScope.puntuacionCorrecta};
	if (puntuacionCorrecta == false) {
		alert("No se puede puntuar más de dos veces un mismo libro.");
	}
</script>

<script>
var error = ${sessionScope.error};
if (error == true) {
	alert("El usuario ya existe. Por favor, elija otro.");
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


				<c:forEach items="${libros}" var="libro">
					<c:set var="noOfRows" value="${noOfRows + 1 }" />

					<div class="templatemo_product_box">
						<h1>
							${libro.titulo} <span>${libro.autor.nombre}</span>
						</h1>
						<img src="${libro.urlImagen}" width="100" height="100" alt="image" />
						<div class="product_info">
							<p>${libro.sinopsis}</p>
							<c:if test="${sessionScope.usuario != null}">
								<div class="ratingblock">
									<div id="unit_long3xx">
										<ul id="unit_ul3xx" class="unit-rating" style="width: 130px;">
											<li><a href="/Spring3Hibernate/libros/puntua.html?lib=${libro.id}&punt=1"
												title="1 sobre 5" class="r1-unit rater" rel="nofollow">1</a></li>
											<li><a href="/Spring3Hibernate/libros/puntua.html?lib=${libro.id}&punt=2"
												title="2 sobre 5" class="r2-unit rater" rel="nofollow">2</a></li>
											<li><a href="/Spring3Hibernate/libros/puntua.html?lib=${libro.id}&punt=3"
												title="3 sobre 5" class="r3-unit rater" rel="nofollow">3</a></li>
											<li><a href="/Spring3Hibernate/libros/puntua.html?lib=${libro.id}&punt=4"
												title="4 sobre 5" class="r4-unit rater" rel="nofollow">4</a></li>
											<li><a href="/Spring3Hibernate/libros/puntua.html?lib=${libro.id}&punt=5"
												title="5 sobre 5" class="r5-unit rater" rel="nofollow">5</a></li>
										</ul>

									</div>
								</div>
							</c:if>
							<div class="detail_button">
								<a href="detalles.html?lib=${libro.id}">Detalles</a>
							</div>
						</div>
						<div class="cleaner">&nbsp;</div>
					</div>

					<c:choose>
						<c:when test="${noOfRows % 2 == 0}">
							<div class="cleaner_with_height">&nbsp;</div>
						</c:when>
						<c:otherwise>
							<div class="cleaner_with_width">&nbsp;</div>
						</c:otherwise>
					</c:choose>

				</c:forEach>

				<div class="cleaner_with_height">&nbsp;</div>
				<div class="centrado">
					<c:if test="${requestScope.numPaginas > 1}">
						<c:forEach begin="1" end="${requestScope.numPaginas}"
							var="contador">
							<c:choose>
								<c:when test="${sessionScope.misLibros == false}">
									<a href="inicio.html?pag=${contador}&gen=${genero}">${contador}</a>
								</c:when>
								<c:otherwise>
									<a
										href="/Spring3Hibernate/libros/misLibros.html?pag=${contador}&gen=${genero}">${contador}</a>
								</c:otherwise>
							</c:choose>


						</c:forEach>
					</c:if>
				</div>
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