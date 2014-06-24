<!DOCTYPE html>

<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<html>
	<head>
		<title>Resultado de la búsqueda</title>
		<%@ include file="/WEB-INF/views/layouts/Style.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layouts/Title.jsp" %>
		<div id="search_result">
			<label>Resultado de la búsqueda</label>
			<table id="table_search">
				<tr>
					<th>DIRECCIÓN </th> <th></th> <th></th>
				</tr>
				<c:forEach items="${model.flats}" var="flat">
					<tr class="row_search">
						<td class="cell">
							<a class="action" href="/rateflats/detailsFlat?id=${flat.id}" >
								<c:out value="${flat.nameOfStreetandNumber}"/>
							</a>
						</td>
						<td class="edit_delete">
							<a href="/rateflats/editFlat?id=${flat.id}" id="logo_edit"></a>
						</td>
						<td class="edit_delete">
							<a href="/rateflats" id="logo_delete"></a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<input value="Volver" type="button" onclick="history.go(-1);" />
		</div>
	</body>
</html>