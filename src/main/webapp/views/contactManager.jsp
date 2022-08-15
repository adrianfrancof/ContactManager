<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<script type="text/javascript">    
	var idSelect = 0;
	/*  submitFormAction('/contactManager/addContact', 'post') */
    function submitFormAction(action, method){
        document.getElementById("frmAcciones").action = action;
        document.getElementById("frmAcciones").method = method;
        document.getElementById("frmAcciones").submit();
    }
    function deleteRow(id){
        idSelect = id;
        window.location.href = "/contactManager/deleteContact/?id=" + idSelect;
    }
</script>
</head>
<body>
	<!--BARRA DE NAVEGACION-->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container">
			<a class="navbar-brand" href="/contactManager/">Contact Manager</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/contactManager/">Home</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!--SECCION FORMULARIO-->
	<section class="container mt-5 p-5 bg-dark text-light">
		<div class="mb-3">
			<h2>Formulario de contacto</h2>
		</div>
		<form:form id="frmAcciones" modelAttribute="contact">
			<div class="mb-3">
				<label for="exampleInputName" class="form-label">Nombre</label> 
				<input
					type="text" 
					class="form-control" 
					id="exampleInputName"
					name="nombre" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputLastName" class="form-label">Apellido
					Paterno</label> 
				<input 
					type="text" 
					class="form-control"
					id="exampleInputLastName" 
					name="apellidoPaterno" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputLastName" class="form-label">Apellido
					Materno</label> 
				<input 
					type="text" 
					class="form-control"
					id="exampleInputLastName" 
					name="apellidoMaterno" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputdirection" class="form-label">Direccion</label>
				<input 
					type="text" 
					class="form-control" 
					id="exampleInputDirection"
					name="direccion" required>
			</div>
			<div class="mb-3">
				<label for="exampleInputdirection" class="form-label">Telefono</label>
				<input 
					type="text" 
					class="form-control" 
					id="exampleInputDirection"
					name="telefono" required>
			</div>
			<div class="mb-3 ms-auto">
				<button type="submit" class="btn btn-primary" value="Agregar" onclick="submitFormAction('/contactManager/addContact', 'post')">Agregar</button>
				<!-- <a type="button" class="btn btn-primary" value="Eliminar" onclick="deleteRow()">Eliminar</a>-->
		 		<button type="reset" class="btn btn-primary" value="Limpiar">Limpiar</button>
		 	</div>
		</form:form>
	</section>
	<!--SECCION LISTA-->
	<section class="container mt-5">
		<div class="mb-3">
			<h2>Lista de contactos</h2>
		</div>
		<table class="table table-dark">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Apellido Paterno</th>
					<th>Apellido Materno</th>
					<th>Direccion</th>
					<th>Telefono</th>
					<th>Eliminar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listaContact}" var="contact">
					<tr>
						<td>${contact.id}</td>
						<td>${contact.nombre}</td>
						<td>${contact.apellidoPaterno}</td>
						<td>${contact.apellidoMaterno}</td>
						<td>${contact.direccion}</td>
						<td>${contact.telefono}</td>
						<td><a 
							type="button" 
							id="optSelectRow${contact.id}"
							name="optSelectRow" 
							class="btn btn-primary" 
							value="Eliminar"
							onclick="deleteRow(${contact.id})">Eliminar
							</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</section>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.5/dist/umd/popper.min.js"
		integrity="sha384-Xe+8cL9oJa6tN/veChSP7q+mnSPaj5Bcu9mPX5F5xIGE0DVittaqT5lorf0EI7Vk"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.min.js"
		integrity="sha384-kjU+l4N0Yf4ZOJErLsIcvOU2qSb74wXpOhqTvwVx3OElZRweTnQ6d31fXEoRD1Jy"
		crossorigin="anonymous"></script>
</body>
</html>