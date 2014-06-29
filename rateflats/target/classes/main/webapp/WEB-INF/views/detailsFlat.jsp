<!DOCTYPE html>

<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<html>
	<head>
		<title>Detalles de vivienda</title>
		<%@ include file="/WEB-INF/views/layouts/Style.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layouts/Title.jsp" %>
		<div class="container">
			<div id="rating"><c:out value="${model.flat.finalRating}"/></div>
			<div id="address">Dirección: <c:out value="${model.flat.nameOfStreetandNumber}"/></div>
			<div id="line_1"><div class="line_1A">Superficie: 
			<c:out value="${model.flat.areaSize}"/>m<span class="superindex">2 </span></div>
			<div class="line_1B">Distancia al trabajo: 
			<c:out value="${model.flat.distanceToWork}"/>m</div></div>
			<div id="comments_box">COMENTARIOS - <c:out value="${model.flat.comments}"/></div>
			<div id="url_box">Dirección web: <a href="<c:out value="${model.flat.url}"/>"><c:out value="${model.flat.url}"/></a> </div>
			<div id="price"><c:out value="${model.flat.priceByMonth}"/> euros al mes</div>
			<div class="three_buttons">
				<input value="Volver" type="button" onclick="history.go(-1);" />
				<input onclick="window.location='/rateflats/editFlat?id=${model.flat.id}';" value="Editar" type="button"/>
				<input onclick="window.location='/rateflats/deleteFlat?id=${model.flat.id}';" value="Eliminar" type="button"/>				
			</div>
			
		</div>
	</body>
</html>