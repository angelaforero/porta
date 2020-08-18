<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<liferay-portlet:actionURL name="action-who-recieves-chip"
	var="actionWhoRecievesChip" />


<div>

	<div class="d-flex padding-0">
		<%@ include file="/lg_lateral.jsp"%>
		<div class="general-content-container">
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

			<!-- CONTENIDO -->
			<div class="header-band desk">
				<label class="header-text">Envío del chip</label>
			</div>
			<form id="formQuestionWhoRecievesChip"
				action="${actionWhoRecievesChip}" method="POST">
				<div class="row content-space">
					<div class="col-md-12 col-sm-12">

						<h3 class="tittle">¿Quién va a recibir el chip?</h3>

						<label class="confirm-text-5">La persona que autorizas
							necesita presentar su cédula para recibir tu chip.</label>

						<div class="d-flex justify-content-between" style="width: 345px;">
							<label class="name-field">Nombres</label>
							<div id="xAuthorizedPersonName"
								class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
								hidden="true"></div>
						</div>
						<div class="intermediate-space">
							<input class="field-input-form" type="text"
								id="authorizedPersonName"
								name="<portlet:namespace/>authorizedPersonName"
								placeholder="Nombres de la persona autorizada">
							<div>
								<label class="name-field-validation"
									id="validationAuthorizedPersonName" hidden="true">Este
									dato es obligatorio</label>
							</div>
						</div>

						<div class="d-flex justify-content-between" style="width: 345px;">
							<label class="name-field">Apellidos</label>
							<div id="xAuthorizedPersonLastname"
								class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
								hidden="true"></div>
						</div>
						<div class="intermediate-space">
							<input class="field-input-form" type="text"
								id="authorizedPersonLastname"
								name="<portlet:namespace/>authorizedPersonLastname"
								placeholder="Apellidos de la persona autorizada">
							<div>
								<label class="name-field-validation"
									id="validationAuthorizedPersonLastname" hidden="true">Este
									dato es obligatorio</label>
							</div>
						</div>

						<div class="d-flex justify-content-between" style="width: 345px;">
							<label class="name-field">Número de cédula</label>
							<div id="xAuthorizedPersonIDNumber"
								class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
								hidden="true"></div>
						</div>
						<div class="intermediate-space">
							<input class="field-input-form" type="text"
								id="authorizedPersonIDNumber"
								name="<portlet:namespace/>authorizedPersonIDNumber"
								placeholder="Cédula de la persona autorizada">
							<div>
								<label class="name-field-validation"
									id="validationAuthorizedPersonIDNumber" hidden="true">Este
									dato es obligatorio</label>
							</div>
						</div>

						<div class="d-flex justify-content-between" style="width: 345px;">
							<label class="name-field">Número de contacto</label>
							<div id="xAuthorizedPersonContactNumber"
								class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar"
								hidden="true"></div>
						</div>

						<div class="intermediate-space">
							<input class="field-input-form" type="text" minlength="10"
								type="number" id="authorizedPersonContactNumber"
								name="<portlet:namespace/>authorizedPersonContactNumber">
							<div>
								<label class="name-field-validation"
									id="validationAuthorizedPersonContactNumber" hidden="true">Debes
									completar tu número celular para continuar</label>
							</div>
						</div>

						<button class="continue-button mobile" type="submit" name="submit">Continuar</button>
					</div>
				</div>

				<!-- BARRA INFERIOR  -->
				<div class="desk d-flex justify-content-between footer-container">
					<div>
						<button class="cancel-btn-squater d-flex align-items-center">
							<span
								class="icon-icono-flecha-izquierda-small font-size-200 icon-azul-movistar"></span>
							Cancelar
						</button>
					</div>
					<div>
						<div class="my-auto d-flex bullet">
							<div class="rounded-circle circle-size movistar-color-blue"></div>
							<div class="rounded-circle circle-size movistar-color-blue"></div>
							<div class="rounded-circle circle-size movistar-color-blue"></div>
							<div class="rounded-circle bg-white circle-size-selected"></div>
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
				<!-- ///////////////////////////////////////// -->


			</form>
		</div>

	</div>

</div>



<%@ include file="/init.jsp"%>

<script type="text/javascript">
<!-- CLASE PARA VALIDACIONES EN FRONT DEL FORMULARIO ClientData-->
	/* function inValidationRecieveChip(val) {
		var val = document.forms["formQuestionClientData"]["<portlet:namespace/>IDNumber"].value;
		if (val.length < 10) {
			document.getElementById("validationIDNumber").hidden = false;
			document.getElementById("xIDNumber").hidden = false;
			var elem = document.getElementById('IDNumber');
			elem.className = "invalid";
		}
	}

	function validateWhoRecievesChip() {
		var name = document.forms["formQuestionClientData"]["<portlet:namespace/>name"].value;
		var lastname = document.forms["formQuestionClientData"]["<portlet:namespace/>lastname"].value;
		var IDNumber = document.forms["formQuestionClientData"]["<portlet:namespace/>IDNumber"].value;

		console.log("name" + name);
		console.log("lastname" + lastname);
		console.log("IDNumber" + IDNumber);

		var result = false;

		if (name.length == 0) {
			document.getElementById("validationName").hidden = false;
			document.getElementById("xName").hidden = false;
			var elem = document.getElementById('name');
			elem.className = "invalid";
		} else if (lastname.length == 0) {
			document.getElementById("validationLastname").hidden = false;
			document.getElementById("xLastname").hidden = false;
			var elem = document.getElementById('lastname');
			elem.className = "invalid";
		} else if (IDNumber.length == 0) {
			document.getElementById("validationIDNumber").hidden = false;
			document.getElementById("xIDNumber").hidden = false;
			var elem = document.getElementById('IDNumber');
			elem.className = "invalid";
		} else {
			var res = isValidId(IDNumber);
			console.log("VALIDATIO IDNumber" + res);
			if (res == undefined || res == false) {
				document.getElementById("validationIDNumber").hidden = false;
				document.getElementById("xIDNumber").hidden = false;
				var elem = document.getElementById('IDNumber');
				elem.className = "invalid";
				result = false;
			} else {
				result = true;
			}
		}

		return result;
	} */
</script>
