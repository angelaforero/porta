<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<liferay-portlet:actionURL name="action-client-data"
	var="actionClientData" />
<liferay-portlet:actionURL name="action-code-nip" var="actionCodeNIP" />
<div>
	<div class="d-flex padding-0">
		<%@ include file="/lg_lateral.jsp"%>

		<div id="general-content-container">
			<!-- COMPONENTE SUPERIOR DE NAVEGACION EN MOVIL -->
			<div class="mobile">
				<div class="d-flex justify-content-between bd-highlight mb-2">
					<div class="p-2 bd-highlight">
						<a href="https://www.telefonica.com/es/home"> <img
							src="<%=request.getContextPath()%>/images/flecha.jpg"
							class="header-mobile-flecha">
						</a>
					</div>
					<div class="p-2 bd-highlight"></div>
					<div class="p-2 bd-highlight">
						<img src="<%=request.getContextPath()%>/images/cerrar.jpg"
							class="header-mobile-cerrar">
					</div>
				</div>
			</div>
			<!-- ////////////////////////////////////////// -->
			<div class="header-band desk">
				<label class="header-text">Datos personales</label>
			</div>
			<form id="formQuestionClientData" action="${actionClientData}"
				onsubmit="return validateClientData();" method="POST">
				<div class="row row-separation content-space">
					<div class="col-md-12 col-sm-12">
						<h3 class="tittle">Cuéntanos sobre ti</h3>

						<div class="d-flex justify-content-between" style="width: 345px;">
							<label class="name-field">Nombres</label>
							<div id="xName"
								class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
								hidden="true"></div>
						</div>
						<div class="intermediate-space">
							<input class="field-input-form" type="text" id="name"
								name="<portlet:namespace/>name"
								placeholder="Ingresa tus nombres tal como en tu cédula">
							<div>
								<label class="name-field-validation" id="validationName"
									hidden="true">Este dato es obligatorio</label>
							</div>
						</div>
						<div class="d-flex justify-content-between" style="width: 345px;">
							<label class="name-field">Apellidos</label>
							<div id="xLastname"
								class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
								hidden="true"></div>
						</div>
						<div class="intermediate-space">
							<input class="field-input-form" type="text" id="lastname"
								name="<portlet:namespace/>lastname"
								placeholder="Ingresa tus apellidos tal como en tu cédula">
							<div>
								<label class="name-field-validation" id="validationLastname"
									hidden="true">Este dato es obligatorio</label>
							</div>
						</div>
						<div class="d-flex justify-content-between" style="width: 345px;">
							<label class="name-field">Número de cédula</label>
							<div id="xIDNumber"
								class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
								hidden="true"></div>
						</div>
						<div class="intermediate-space">
							<input class="field-input-form" type="number" maxlength="10"
								oninput="inValidationIDNumber('')" id="IDNumber"
								name="<portlet:namespace/>IDNumber">
							<div>
								<label class="name-field-validation" id="validationIDNumber"
									hidden="true">Ingresa un número de cédula válido</label>
							</div>
						</div>
						<div class="d-flex align-items-center">
							<div>
								<input class="check-class" type="checkbox" name="isNotOwner"
									value="Owner">
							</div>
							<div class="check-text">
								<label for="Owner">No soy el titular de la línea celular</label>
							</div>
						</div>
						<button class="continue-button mobile" type="submit" name="submit">Continuar</button>

					</div>
				</div>


				<!-- BARRA INFERIOR  -->
				<div class="d-flex justify-content-between footer-container desk">
					<div>
						<a href="${actionCodeNIP}">
							<button class="cancel-btn-squater d-flex align-items-center">
								<span
									class="icon-icono-flecha-izquierda-small font-size-200 icon-azul-movistar"></span>
								Cancelar
							</button>
						</a>
					</div>
					<div>
						<div class="my-auto d-flex bullet">
							<div class="rounded-circle bg-white circle-size-selected"></div>
							<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
							<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
							<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
							<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
						</div>
					</div>
					<div>
						<button
							class="continue-btn-squater d-flex align-items-center justify-content-end"
							type="submit" name="submit">
							<span>Continuar</span> <span
								class="icon-gris-movistar-1 font-size-200 icon-icono-flecha-derecha-small"></span>
						</button>
					</div>
				</div>
				<!-- ////////////////////////////////////////// -->
			</form>
		</div>

	</div>
</div>

<%@ include file="/generalValidations.jsp"%>
