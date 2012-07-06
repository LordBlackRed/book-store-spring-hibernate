<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />

<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.6.4.min.js"></script>

<script>
var loginFail = ${sessionScope.loginFail};
if (loginFail == true) {
	alert("Login Incorrecto.");
	<% request.getSession().setAttribute("loginFail", false); %>
}

	$(document).ready(function() {
		$('a.login-window').click(function() {

			//Getting the variable's value from a link 
			var loginBox = $(this).attr('href');

			//Fade in the Popup
			$(loginBox).fadeIn(300);

			//Set the center alignment padding + border see css style
			var popMargTop = ($(loginBox).height() + 24) / 2;
			var popMargLeft = ($(loginBox).width() + 24) / 2;

			$(loginBox).css({
				'margin-top' : -popMargTop,
				'margin-left' : -popMargLeft
			});

			// Add the mask to body
			$('body').append('<div id="maskDos"></div>');
			$('#maskDos').fadeIn(300);

			return false;
		});

		// When clicking on the button close or the mask layer the popup closed
		$('a.close, #maskDos').live('click', function() {
			$('#maskDos , .login-popup').fadeOut(300, function() {
				$('#maskDos').remove();
			});
			return false;
		});
	});
	
	
</script>
</head>
<body>

	<div id="templatemo_menu">
		<ul>
			<li><a href="/Spring3Hibernate/libros/inicio.html?pag=1&gen=0"
				class="current">Inicio</a></li>
			<li><a href="/Spring3Hibernate/libros/add.html">Añadir Libro</a></li>
			<c:if test="${sessionScope.usuario != null}">
				<li><a
					href="/Spring3Hibernate/libros/misLibros.html?pag=1&gen=0">Mis
						Libros</a></li>
			</c:if>
			<li><a href="/Spring3Hibernate/usuarios/add.html">Registrarse</a></li>
			<li><c:choose>
					<c:when test="${sessionScope.usuario != null}">

						<a href="/Spring3Hibernate/usuarios/destruirSesion.html">${sessionScope.usuario.nick}</a>
					</c:when>
					<c:otherwise>
						<a href="#login-box" class="login-window">Login</a>
					</c:otherwise>
				</c:choose></li>
		</ul>
	</div>
	<!-- end of menu -->

	<div id="templatemo_header">
		<div id="templatemo_special_offers">
			<p>
				¡Añade libros a la biblioteca y puntúalos para así compartir tu voto con otros usuarios! 
			</p>
		</div>


		<div id="templatemo_new_books">
			<ul>
				<li>Sistema de puntuación de libros</li>
				<li>Gestión de altas de libros, editoriales y autores</li>
				<li>Filtración por Género</li>
			</ul>
		</div>
	</div>

	<!-- Panel Modal Login -->

	<div id="login-box" class="login-popup">
		<a href="usuarios.html" class="close"><img src="/Spring3Hibernate/images/close_pop.png"
			class="btn_close" title="Close Window" alt="Close" /></a>

		<c:url var="loguearUsuarioUrl" value="/usuarios/loguear.html" />

		<form method="POST" action="${loguearUsuarioUrl}" class="signin">
			<fieldset class="textbox">
				<label class="username"> <span>Nick de Usuario</span> <input
					id="username" name="nick" value="" type="text" autocomplete="on"
					placeholder="Nick">
				</label> <label class="password"> <span>Password</span> <input
					id="password" name="password" value="" type="password"
					placeholder="Password">
				</label>
				<button class="submit button" type="submit">Enviar</button>
			</fieldset>
		</form>

	</div>

</body>
</html>