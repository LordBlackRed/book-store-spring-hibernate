<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Spring 3 MVC and Hibernate 3 Example application using
	Annotations</title>
	<script type="text/javascript">
	var puntuacionCorrecta = ${sessionScope.puntuacionCorrecta};
	if (puntuacionCorrecta == false) {
		alert("No se puede puntuar más de dos veces un mismo libro.");
	}
</script>
</head>
<body>

	<div id="templatemo_container">
		
	<jsp:include page="head.jsp"/>		
		<!-- end of header -->

		<div id="templatemo_content">

			<jsp:include page="leftContent.jsp" />

			<div id="templatemo_content_right">
			
				
				<c:forEach items="${libros}" var="libro">
				
				<div class="templatemo_product_box">
					<h1>
						<c:out value="${libro.titulo}"/> <span><c:out value="${libro.autor.nombre}"/></span>
					</h1>
					<img src="<c:out value="${libro.urlImagen}"/>" alt="image" />
					<div class="product_info">
						<p>Etiam luctus. Quisque facilisis suscipit elit. Curabitur...</p>
						<h3>$55</h3>
						<div class="buy_now_button">
							<a href="subpage.html">Buy Now</a>
						</div>
						<div class="detail_button">
							<a href="subpage.html">Detail</a>
						</div>
					</div>
					<div class="cleaner">&nbsp;</div>
				</div>

				<div class="cleaner_with_width">&nbsp;</div>

				
				</c:forEach>
				

				<div class="cleaner_with_height">&nbsp;</div>

				<a href="subpage.html"><img src="images/templatemo_ads.jpg"
					alt="ads" /></a>
			</div>
			<!-- end of content right -->

			<div class="cleaner_with_height">&nbsp;</div>
		</div>
		<!-- end of content -->

		<jsp:include page="footer.jsp"></jsp:include>
		<!--  Free CSS Template www.templatemo.com -->
	</div>
	<!-- end of container -->
</body>
</html>