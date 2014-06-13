<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
	<head>
		<title>Formularios con Spring MVC</title>
	</head>
	<body>
		<h2>Datos introducidos</h2>
		<table>
			<tr>
				<td>Nombre: </td>
				<td>${name}</td>
			</tr>
			<tr>
				<td>Edad: </td>
				<td>${age}</td>
			</tr>
			<tr>
				<td>ID: </td>
				<td>${id}</td>
			</tr>
		</table>
	</body>
</html>