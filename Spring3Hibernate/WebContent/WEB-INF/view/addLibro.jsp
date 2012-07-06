<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../templatemo_style.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" media="all"
	href="../jsDatePick_ltr.min.css" />
<title>Añadir Libro</title>

<script type="text/javascript" src="../jsDatePick.min.1.3.js"></script>
<script type="text/javascript" src="../scripts.js"></script>
<script src="../jquery.js"></script>

<script type="text/javascript">
	window.onload = function() {
		new JsDatePick({
			useMode : 2,
			target : "fechaPublicacion",
			dateFormat : "%d/%m/%Y"
		/*selectedDate:{				This is an example of what the full configuration offers.
			day:5,						For full documentation about these settings please see the full version of the code.
			month:9,
			year:2006
		},
		yearsRange:[1978,2020],
		limitToToday:false,
		cellColorScheme:"beige",
		dateFormat:"%m-%d-%Y",
		imgPath:"img/",
		weekStartDay:1*/
		});
	};

	$(document).ready(function() {

		//select all the a tag with name equal to modal
		$('a[name=modal]').click(function(e) {
			//Cancel the link behavior
			e.preventDefault();

			//Get the A tag
			var id = $(this).attr('href');

			//Get the screen height and width
			var maskHeight = $(document).height();
			var maskWidth = $(window).width();

			//Set heigth and width to mask to fill up the whole screen
			$('#mask').css({
				'width' : maskWidth,
				'height' : maskHeight
			});

			//transition effect		
			$('#mask').fadeIn(1000);
			$('#mask').fadeTo("slow", 0.8);

			//Get the window height and width
			var winH = $(window).height();
			var winW = $(window).width();

			//Set the popup window to center
			$(id).css('top', winH / 2 - $(id).height() / 2);
			$(id).css('left', winW / 2 - $(id).width() / 2);

			//transition effect
			$(id).fadeIn(2000);

		});

		//if close button is clicked
		$('.window .close').click(function(e) {
			//Cancel the link behavior
			e.preventDefault();

			$('#mask').hide();
			$('.window').hide();
		});

		//if mask is clicked
		$('#mask').click(function() {
			$(this).hide();
			$('.window').hide();
		});

		$(window).resize(function() {

			var box = $('#boxes .window');

			//Get the screen height and width
			var maskHeight = $(document).height();
			var maskWidth = $(window).width();

			//Set height and width to mask to fill up the whole screen
			$('#mask').css({
				'width' : maskWidth,
				'height' : maskHeight
			});

			//Get the window height and width
			var winH = $(window).height();
			var winW = $(window).width();

			//Set the popup window to center
			box.css('top', winH / 2 - box.height() / 2);
			box.css('left', winW / 2 - box.width() / 2);

		});

	});
</script>
</head>
<body>

	<div id="templatemo_container">
		<jsp:include page="../../head.jsp" />

		<div id="templatemo_content">

			<jsp:include page="../../leftContent.jsp"></jsp:include>

			<div id="templatemo_content_right">

				<c:url var="guardarLibroUrl" value="/libros/guardar.html" />
				<form:form modelAttribute="libro" method="POST"
					action="${guardarLibroUrl}" name="formAddLibro">
					<div class="contenedor">
						<div class="addLibroLeft">
							<form:label path="titulo">Titulo:</form:label>
							<form:input path="titulo" id="titulo" />
							<br />
							<form:label path="isbn">ISBN:</form:label>
							<form:input path="isbn" id="isbn" />
							<br />
							<form:label path="fechaPublicacion">Fecha Publicación:</form:label>
							<form:input path="fechaPublicacion" id="fechaPublicacion" />
							<br />
							<form:label path="pags">Nº Páginas:</form:label>
							<form:input path="pags" id="pags" />
							<br />
							<form:label path="urlImagen">Imagen:</form:label>
							<form:input path="urlImagen" />
							<br />
							<form:label path="sinopsis">Sinopsis:</form:label>
							<form:textarea path="sinopsis" rows="6" cols="35" />
						</div>
						<div class="addLibroRight">
							<label for="idAutor">Autor:</label>
							<div id="autoresAjax">
								<select name="idAutor">
									<c:forEach items="${autores}" var="autor">
										<option value="${autor.id}">${autor.nombre}</option>
									</c:forEach>
								</select>
							</div>
							<a href="#dialog1" name="modal">Añadir Autor</a> <br /> <label
								for="idEditorial">Editorial:</label>
							<div id="editorialesAjax">
								<select name="idEditorial">
									<c:forEach items="${editoriales}" var="editorial">
										<option value="${editorial.id}">${editorial.nombre}</option>
									</c:forEach>
								</select>
							</div>
							<a href="#dialogEditorial" name="modal">Añadir Editorial</a> <br />
							<label for="idGenero">Genero:</label> <select name="idGenero">
								<c:forEach items="${generos}" var="genero">
									<option value="${genero.id}">${genero.genero}</option>
								</c:forEach>
							</select>
						</div>
						<div class="addLibroBoton">
							<button type="submit"
								onclick="return validarDatosLibro(formAddLibro);">Guardar
								Libro</button>

						</div>
					</div>
				</form:form>

				<div class="cleaner_with_height">&nbsp;</div>

				<div id="boxes">

					<!-- End of Login Dialog -->
					<div id="dialog1" class="window">
						<div class="d-header">
							<fieldset>
								<label for="nombre">Nombre</label> <input type="text"
									id="nombre" name="nombre" /><br /> <label for="apellidos">Apellidos</label>
								<input type="text" id="apellidos" name="apellidos" /> <br></br>
								<button onclick="doAjaxPostAutor()">Añadir Autor</button>
							</fieldset>
						</div>
					</div>

					<div id="dialogEditorial" class="window">
						<div class="d-header">
							<fieldset>
								<label for="nombreEditorial">Nombre</label> <input type="text"
									id="nombreEditorial" name="nombreEditorial" /><br /> <label
									for="url">Direccion web</label><input type="text"
									id="urlEditorial" name="urlEditorial" /> <br></br>
								<button onclick="doAjaxPostEditorial()">Añadir
									Editorial</button>
							</fieldset>
						</div>
					</div>
					<!-- Mask to cover the whole screen -->
					<div id="mask"></div>

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