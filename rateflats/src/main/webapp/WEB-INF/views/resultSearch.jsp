<!DOCTYPE html>

<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<html>
	<head>
		<title>Resultado de la b�squeda</title>
		<%@ include file="/WEB-INF/views/layouts/Style.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layouts/Title.jsp" %>
		<label>Resultado de la b�squeda</label>
		<div class="table" id="table_search">
			<c:forEach items="${model.flats}" var="flat">
				<div class="row">
					<div class="cell">
						<a class="action" href="/rateflats/detailsFlat?id=${flat.id}" >
							<c:out value="${flat.nameOfStreetandNumber}"/>
						</a>
						
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
		<input action="action" value="Volver" type="button" class="buttonAlone" onclick="history.go(-1);" />
	</body>
</html>