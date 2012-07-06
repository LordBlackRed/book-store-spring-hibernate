<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="/Spring3Hibernate/templatemo_style.css" rel="stylesheet" type="text/css" />

<title>Registrar Usuario</title>

<script type="text/javascript" src="/Spring3Hibernate/scripts.js"></script>
<script src="../jquery.js"></script>

</head>
<body>

	<div id="templatemo_container">
		<jsp:include page="../../head.jsp" />

		<div id="templatemo_content">

			<jsp:include page="../../leftContent.jsp"></jsp:include>

			<div id="templatemo_content_right">
				<div class="registrarUsuario">
					<c:url var="guardarUsuarioUrl" value="/usuarios/guardar.html" />
					<form:form modelAttribute="usuario" method="POST"
						action="${guardarUsuarioUrl}" id="formAddUsuario" name="formAddUsuario">
						<form:label path="nick">Nick:</form:label>
						<form:input path="nick" id="nick" />
						<br />
						<form:label path="password">Password:</form:label>
						<form:password path="password" id="password" />
						<br />
						<button type="submit" onclick="return validarDatosUsuario(formAddUsuario);">Registrar</button>
					</form:form>

					<div class="cleaner_with_height">&nbsp;</div>

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