<!DOCTYPE html>

<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<html>
	<head>
		<title>¿Está seguro de querer borrar la vivienda?</title>
		<%@ include file="/WEB-INF/views/layouts/Style.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layouts/Title.jsp" %>
		<form:form 	id="deleteFlat" method="POST" commandName="flatToDelete" 
					modelAttribute="flat">
			<fieldset>
				<div class="invisible">
					<form:input path="id" value="${model.flat.id}" />
				</div>
				<p>
					<label>¿Está seguro de querer borrar la vivienda en :
					<c:out value="${model.flat.nameOfStreetandNumber}"></c:out>? </label>
				</p>
				<p>
					<input class ="buttonAlone" type="submit" value="Aceptar"/>
				</p>
			</fieldset>
		</form:form>
   </body>
</html>