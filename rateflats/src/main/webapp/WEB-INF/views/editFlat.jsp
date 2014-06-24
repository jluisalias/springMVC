<!DOCTYPE html>

<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<html>
	<head>
		<title>Modificando una vivienda</title>
		<%@ include file="/WEB-INF/views/layouts/Style.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layouts/Title.jsp" %>
		<form:form 	id="editFlat" method="POST" commandName="flatToOpen" 
					modelAttribute="flat">
			<%@ include file="/WEB-INF/views/layouts/FlatForm.jsp" %>
		</form:form>
   </body>
</html>