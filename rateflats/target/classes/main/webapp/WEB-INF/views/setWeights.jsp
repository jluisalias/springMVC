<!DOCTYPE html>

<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<html>
	<head>
		<title>Cambiando pesos de las valoraciones</title>
		<%@ include file="/WEB-INF/views/layouts/Style.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layouts/Title.jsp" %>
		<form:form 	id="setWeights" method="POST" commandName="setWeights" 
					modelAttribute="calculator">
			<fieldset>
				<legend>Seleccionar pesos</legend>
				<p><form:label path="areaWeight">Peso de la superficie: </form:label>
				<form:input path="areaWeight" /></p>
				<p><form:label path="distanceWeight">Peso de la distancia al trabajo: </form:label>
				<form:input path="distanceWeight" /></p>
				<p><form:label path="priceWeight">Peso del precio: </form:label>
				<form:input path="priceWeight" /></p>
				<p><form:label path="rateWeight">Peso de la nota personal: </form:label>
				<form:input path="rateWeight"/></p>
				
				<input class ="buttonAlone" type="submit" value="Cambiar"/>
			</fieldset>
       </form:form>
   </body>
</html>