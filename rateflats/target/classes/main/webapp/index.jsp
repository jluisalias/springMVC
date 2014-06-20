<!DOCTYPE html>

<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<html>
	<head>
		<title>Bienvenidos a la aplicación de valoración de pisos</title>
		<%@ include file="/WEB-INF/views/layouts/Style.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layouts/Title.jsp" %>
		<form id="index" method="GET" action="/rateflats/searchFlat">
			<fieldset>
				<legend>Acciones</legend>
				<p> <a class="action" href="/rateflats/newFlat">Agregar nueva vivienda</a> </p>
				<p> <a class="action" href="/rateflats/setWeights">Establecer pesos de las valoraciones</a> </p>
				<p> <a class="action" href="/rateflats/listFlats">Listar viviendas</a> </p>
				<p> <label for="searchInput">Búsqueda de vivienda: </label>
				<input id="searchInput" type="text" value="---Nombre del piso---" onclick="this.value=''"/>
				<input type="submit" value="Buscar"/></p>
			</fieldset>
		</form>
	</body>
</html>
