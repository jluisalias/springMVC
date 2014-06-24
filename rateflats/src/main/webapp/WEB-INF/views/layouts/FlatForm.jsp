<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<fieldset>
	<legend> Datos de la vivienda</legend>
	<p>
		<form:label path="nameOfStreetandNumber">Dirección: </form:label>
		<form:input path="nameOfStreetandNumber" value="${model.flat.nameOfStreetandNumber}" />
	</p>
	<p>
		<form:label path="distanceToWork">Distancia al trabajo (m): </form:label>
		<form:input path="distanceToWork" value="${model.flat.distanceToWork}" />
	</p>
	<p>
		<form:label path="priceByMonth">Precio del alquiler: </form:label>
		<form:input path="priceByMonth" value="${model.flat.priceByMonth}" />
	</p>
	<p>
		<form:label path="areaSize">Superficie (m<span
				class="superindex">2 </span>): </form:label>
		<form:input path="areaSize" value="${model.flat.areaSize}" />
	</p>
	<p>
		<form:label path="url">Dirección web: </form:label>
		<form:input path="url" value="${model.flat.url}" />
	</p>
	<p>
		<form:label path="myRating">Valoración personal (0-10): </form:label>
		<form:input path="myRating" value="${model.flat.myRating}" />
	</p>
	<p>
		<form:label path="comments">Comentarios: </form:label>
		<form:textarea path="comments" value="${model.flat.comments}"></form:textarea>
	</p>
	<p>
		<form:label path="isCommunityIncluded">¿Comunidad incluida?: </form:label>
		<form:checkbox path="isCommunityIncluded" value="${model.flat.isCommunityIncluded}"/>
	</p>
	<p>
		<form:label path="isWaterIncluded">¿Agua incluida?: </form:label>
		<form:checkbox path="isWaterIncluded" value="${model.flat.isWaterIncluded}" />
	</p>
	<p>
		<form:label path="isPermittedAContractOfSixMonths">¿Permite contrato de 6 meses?: </form:label>
		<form:checkbox path="isPermittedAContractOfSixMonths" value="${model.flat.isPermittedAContractOfSixMonths}" />
	</p>
	<p>
		<input class ="buttonAlone" type="submit" value="Aceptar"/>
	</p>
</fieldset>