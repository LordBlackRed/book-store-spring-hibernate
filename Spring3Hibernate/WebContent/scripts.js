function doAjaxPostAutor() {
	// get the form values
	var nombre = $('#nombre').val();
	var apellidos = $('#apellidos').val();

	$.ajax({
		type : "POST",
		url : "../autores/save.html",
		data : "nombre=" + nombre + "&apellidos=" + apellidos,
		success : function(response) {
			// we have the response
			$('#autoresAjax').html(response);
			$('#nombre').val('');
			$('#apellidos').val('');

			$('#mask').hide();
			$('.window').hide();
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function doAjaxPostEditorial() {
	// get the form values
	var nombreEditorial = $('#nombreEditorial').val();
	var urlEditorial = $('#urlEditorial').val();
	$.ajax({
		type : "POST",
		url : "../editoriales/guardar.html",
		data : "nombre=" + nombreEditorial + "&url=" + urlEditorial,
		success : function(response) {
			// we have the response
			$('#editorialesAjax').html(response);
			$('#nombreEditorial').val('');
			$('#urlEditorial').val('');
			$('#mask').hide();
			$('.window').hide();
		},
		error : function(e) {
			alert('Error: ' + e);
		}
	});
}

function isDate(Cadena) {
	var Fecha = new String(Cadena);
	var RealFecha = new Date();
	var Ano = new String(Fecha.substring(Fecha.lastIndexOf("/") + 1,
			Fecha.length));
	var Mes = new String(Fecha.substring(Fecha.indexOf("/") + 1, Fecha
			.lastIndexOf("/")));
	var Dia = new String(Fecha.substring(0, Fecha.indexOf("/")));

	if (isNaN(Ano) || Ano.length < 4 || parseFloat(Ano) < 1900) {
		return false;
	}
	if (isNaN(Mes) || parseFloat(Mes) < 1 || parseFloat(Mes) > 12) {
		return false;
	}
	if (isNaN(Dia) || parseInt(Dia, 10) < 1 || parseInt(Dia, 10) > 31) {
		return false;
	}
	if (Mes == 4 || Mes == 6 || Mes == 9 || Mes == 11 || Mes == 2) {
		if (Mes == 2 && Dia > 28 || Dia > 30) {
			return false;
		}
	}

	return true;
}

function trim(myString) {
	return myString.replace(/^\s+/g, '').replace(/\s+$/g, '')
}

function validarDatosLibro(formulario) {
	var titulo = trim(formulario.titulo.value);
	var isbn = trim(formulario.isbn.value);
	var fecha = isDate(formulario.fechaPublicacion.value);
	var pags = isNaN(formulario.pags.value);

	if (titulo == "" || isbn == "" || formulario.pags.value == "") {
		alert("Todos los campos obligatorios no han sido rellenados");
		return false;
	} else if (!fecha) {
		alert("Formato de fecha incorrecto");
		return false;
	} else if (pags) {
		alert("Numero de paginas introducido incorrecto");
		return false;
	} else {
		return true;
	}
}

function validarDatosUsuario(formulario){
	var nick = trim(formulario.nick.value);
	var password = trim(formulario.password.value);
	if(nick == "" || password == ""){
		alert("Todos los campos obligatorios no han sido rellenados.");
		return false;
	}else{
		return true;
	}
}