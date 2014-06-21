<!DOCTYPE html>

<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<html>
	<head>
		<title>Resultado de la búsqueda</title>
		<%@ include file="/WEB-INF/views/layouts/Style.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layouts/Title.jsp" %>
		<label>Resultado de la búsqueda</label>
		<div class="table" id="table_search">
			<c:forEach items="${model.flats}" var="flat">
				<div class="row">
					<div class="cell">
						<c:out value="${flat.nameOfStreetandNumber}"/>
					</div>
					<div class="cell">
						<a href="" class="delete">
					</div>
					<div class="cell">
						<a href="" class="edit">
					</div>
				</div>
    		</c:forEach>
		</div>
		
	</body>
</html>