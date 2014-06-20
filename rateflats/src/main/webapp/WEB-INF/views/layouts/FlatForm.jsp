<%@ include file="/WEB-INF/views/layouts/Header.jsp" %>

<fieldset>
	<legend> Datos de la vivienda</legend>
	<p>
		<form:label path="nameOfStreetandNumber">Dirección: </form:label>
		<form:input path="nameOfStreetandNumber" />
	</p>
	<p>
		<form:label path="distanceToWork">Distancia al trabajo (m): </form:label>
		<form:input path="distanceToWork" />
	</p>
	<p>
		<form:label path="priceByMonth">Precio del alquiler: </form:label>
		<form:input path="priceByMonth" />
	</p>
	<p>
		<form:label path="areaSize">Superficie (m<span
				class="superindex">2 </span>): </form:label>
		<form:input path="areaSize" />
	</p>
	<p>
		<form:label path="url">Dirección web: </form:label>
		<form:input path="url" />
	</p>
	<p>
		<form:label path="myRating">Valoración personal (0-10): </form:label>
		<form:input path="myRating" />
	</p>
	<p>
		<form:label path="comments">Comentarios: </form:label>
		<form:textarea path="comments" />
	</p>
	<p>
		<form:label path="isCommunityIncluded">¿Comunidad incluida?: </form:label>
		<form:checkbox path="isCommunityIncluded" value="¿Comunidad?"/>
	</p>
	<p>
		<form:label path="isWaterIncluded">¿Agua incluida?: </form:label>
		<form:checkbox path="isWaterIncluded" value="¿Agua?" />
	</p>
	<p>
		<form:label path="isPermittedAContractOfSixMonths">¿Permite contrato de 6 meses?: </form:label>
		<form:checkbox path="isPermittedAContractOfSixMonths" value="¿Contrato de 6 meses?" />
	</p>
	<p>
		<input class ="buttonAlone" type="submit" value="Aceptar"/>
	</p>
</fieldset>