<!DOCTYPE html>

<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<html>
	<head>
		<title>Lista de resultados</title>
		<%@ include file="/WEB-INF/views/layouts/Style.jsp" %>
	</head>
	<body>
		<%@ include file="/WEB-INF/views/layouts/Title.jsp" %>
		<div id="list_result">
			<label>Ranking de viviendas</label>
			<table id="table_list">
				<tr>
					<th>DIRECCIÓN </th> <th></th> <th></th>
					<th>DISTANCIA AL TRABAJO</th>
					<th>SUPERFICIE</th>
					<th>PRECIO</th>
					<th>VALORACIÓN SUBJETIVA</th>
					<th>CALIFICACIÓN</th>
				</tr>
				<c:forEach items="${flats}" var="flat">
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
							<a href="/rateflats/deleteFlat?id=${flat.id}" id="logo_delete"></a>
						</td>
						<td class="right"><label><c:out value="${flat.distanceToWork}"/> metros</label></td>
						<td class="right"><label><c:out value="${flat.areaSize}"/> m<span class="superindex">2</span></label></td>
						<td class="right"><label><c:out value="${flat.priceByMonth}"/> euros</label></td>
						<td class="right"><label><c:out value="${flat.myRating}"/></label></td>
						<td class="right_em"><label><c:out value="${flat.finalRating}"/></label></td>
					</tr>
				</c:forEach>
			</table>
			<input value="Volver" type="button" onclick="history.go(-1);" />
		</div>
   </body>
</html>