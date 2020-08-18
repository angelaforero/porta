<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<liferay-portlet:actionURL name="action-phone-income"
	var="actionPhoneIncome" />

<div style="heigth: 100%">

	<div class="d-flex padding-0">
		<%@ include file="/lg_lateral.jsp"%>
		<div class="content-lateral content-space">
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
			<div class="row row-separation desk">
				<div class="col-md-1">
					<a href="https://www.telefonica.com/es/"><img
						src="<%=PropsUtil.get("path.svg")%>/icono-flecha-izquierda-small.svg"></a>
				</div>
				<div class="col-md-2">
					<a href="https://www.telefonica.com/es/"> <label
						class="return-style">Volver</label>
					</a>
				</div>
				<div class="col-md-9"></div>
			</div>
			<div class="row row-separation">
				<div class="col-md-12 col-sm-12">
					<form id="formQuestionCellphone" name="formQuestionCellphone"
						action="${actionPhoneIncome}" method="POST"
						onsubmit="return validate();">
						<h3 class="tittle">Ingresa tu número de celular</h3>

						<div class="d-flex justify-content-between" style="width: 345px;">
							<label class="name-field">Número de celular</label>
							<div id="xCellphone" class="icon-icono-cerrar-modal-small font-size-100 icon-magenta-movistar" hidden="true"></div>
						</div>

						<div class="intermediate-space">
							<input id="cellphone" class="field-input-form"
								oninput="inValidationCellphone('')" minlength="10" type="number"
								maxlength="10" name="<portlet:namespace/>cellphone" required>
							<div>
								<label class="name-field-validation" id="validationCellphone"
									hidden="true" name="validationCellphone">Debes
									completar tu número celular para continuar</label>
							</div>

						</div>
						<button class="cancel-button desk"
							href="https://www.telefonica.com/es/">Cancelar</button>
						<button id="submitBtnPhoneIncome" class="continue-button"
							type="submit" name="submit" disabled>Continuar</button>
					</form>
				</div>
			</div>
		</div>
	</div>

</div>
<%@ include file="/generalValidations.jsp"%>
