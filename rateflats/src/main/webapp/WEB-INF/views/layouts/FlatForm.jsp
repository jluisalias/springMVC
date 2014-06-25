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
		<textarea id="comments" name="comments"><c:out value="${model.flat.comments}"/></textarea>
	</p>
	<p>
		<form:label path="isCommunityIncluded">¿Comunidad incluida?: </form:label>
		<input 	id="isCommunityIncluded" name="isCommunityIncluded" value="true" 
				type="checkbox" ${model.flat.isCommunityIncluded ? 'checked' : null}>
	</p>
	
	<p>
		<form:label path="isWaterIncluded">¿Agua incluida?: </form:label>
		<input 	id="isWaterIncluded" name="isWaterIncluded" value="true" 
				type="checkbox" ${model.flat.isWaterIncluded ? 'checked' : null}>
	</p>
	<p>
		<form:label path="isPermittedAContractOfSixMonths">¿Permite contrato de 6 meses?: </form:label>
		<input 	id="isPermittedAContractOfSixMonths" name="isPermittedAContractOfSixMonths" value="true" 
				type="checkbox" ${model.flat.isPermittedAContractOfSixMonths ? 'checked' : null}>
	</p>
	<p>
		<input class ="buttonAlone" type="submit" value="Aceptar"/>
	</p>
</fieldset>