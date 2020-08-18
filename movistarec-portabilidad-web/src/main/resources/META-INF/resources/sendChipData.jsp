<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<liferay-portlet:actionURL name="action-send-chip-data"
	var="actionFormSendChipData" />


<div>
	<div class="d-flex padding-0">
		<%@ include file="/lg_lateral.jsp"%>

		<div id="general-content-container">
			<form id="formQuestionSendChipData"
				action="${actionFormSendChipData}"
				onsubmit="return validateSendChipData();" method="POST">

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
				<div class="scrollable">
					<div class="header-band desk">
						<label class="header-text">Envío del chip</label>
					</div>
					<!-- CONTENIDO -->


					<div class="row row-separation content-space">
						<div class="col-md-12 col-sm-12">

							<h3 class="tittle">¿A dónde enviamos tu chip?</h3>
						</div>
					</div>

					<div class="row row-separation content-space">
						<div class="col-md-12 col-sm-12">
							<!-- Provincia -->
							<div class="d-flex justify-content-between" style="width: 345px;">
								<label class="name-field">Provincia</label>
								<div id="xProvince"
									class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
									hidden="true"></div>
							</div>
							<div class="intermediate-space">
								<input class="field-input-form" type="text" id="province"
									name="<portlet:namespace/>province"
									placeholder="Ingresa las primeras letras de tu provincia">
								<div>
									<label class="name-field-validation" id="validationProvince"
										hidden="true">Este dato es obligatorio</label>
								</div>
							</div>

							<!-- Ciudad -->
							<div class="d-flex justify-content-between" style="width: 345px;">
								<label class="name-field">Ciudad</label>
								<div id="xCity"
									class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
									hidden="true"></div>
							</div>
							<div class="intermediate-space">
								<input class="field-input-form" type="text" id="city"
									name="<portlet:namespace/>city"
									placeholder="Ingresa las primeras letras de tu ciudad">
								<div>
									<label class="name-field-validation" id="validationCity"
										hidden="true">Este dato es obligatorio</label>
								</div>
							</div>

							<!-- Calle principal -->
							<div class="d-flex justify-content-between" style="width: 345px;">
								<label class="name-field">Calle principal</label>
								<div id="xPrincipalStreet"
									class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
									hidden="true"></div>
							</div>
							<div class="intermediate-space">
								<input class="field-input-form" type="text" id="principalStreet"
									name="<portlet:namespace/>principalStreet">
								<div>
									<label class="name-field-validation"
										id="validationPrincipalStreet" hidden="true">Este dato
										es obligatorio</label>
								</div>
							</div>
							<!-- Calle secundaria -->
							<div class="d-flex justify-content-between" style="width: 345px;">
								<label class="name-field">Calle secundaria</label>
								<div id="xSecondaryStreet"
									class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
									hidden="true"></div>
							</div>
							<div class="intermediate-space">
								<input class="field-input-form" type="text" id="secondaryStreet"
									name="<portlet:namespace/>secondaryStreet">
								<div>
									<label class="name-field-validation"
										id="validationSecondaryStreet" hidden="true">Este dato
										es obligatorio</label>
								</div>
							</div>

							<!-- Número de edificio, casa o conjunto -->
							<div class="d-flex justify-content-between" style="width: 345px;">
								<label class="name-field">Número de edificio, casa o
									conjunto</label>
								<div id="xBuildingNumber"
									class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
									hidden="true"></div>
							</div>
							<div class="intermediate-space">
								<input class="field-input-form" type="text" id="buildingNumber"
									name="<portlet:namespace/>buildingNumber">
								<div>
									<label class="name-field-validation"
										id="validationBuildingNumber" hidden="true">Este dato
										es obligatorio</label>
								</div>
							</div>

							<!-- Referencia -->
							<label class="name-field">Referencia</label>
							<div class="intermediate-space">
								<textarea class="name-field" id="reference"
									name="<portlet:namespace/>reference" name="textarea" rows="10"
									cols="50"
									placeholder="Ej. Edificio Uribe, Departamento 00, frente al Supermaxi."></textarea>
								<div>
									<label class="name-field-validation" id="validationReference"
										hidden="true">Este dato es obligatorio</label>
								</div>
							</div>

							<!-- Número de contacto -->
							<div class="d-flex justify-content-between" style="width: 345px;">
								<label class="name-field">Número de contacto</label>
								<div id="xContactNumber"
									class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
									hidden="true"></div>
							</div>
							<div class="intermediate-space">
								<input class="field-input-form" type="number" id="contactNumber"
									name="<portlet:namespace/>contactNumber">
								<div>
									<label class="name-field-validation"
										id="validationContactNumber" hidden="true">Este dato
										es obligatorio</label>
								</div>
							</div>


							<label class="confirm-text-3">Sólo te llamaremos si
								tenemos alguna duda con tu dirección</label>

							<div class="d-flex align-items-center">
								<div>
									<input class="check-class" type="checkbox"
										value="isNotOwnerRecieved"
										name="<portlet:namespace/>isNotOwnerRecieved">
								</div>
								<div class="check-text">
									<label for="Recieved">El chip lo recibirá otra persona</label>
								</div>
							</div>
						</div>
					</div>

					<button class="continue-button mobile" type="submit" name="submit">Continuar</button>
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