<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<liferay-portlet:actionURL name="action-telephone-operator"
	var="actionFormTelephoneOperator" />

<div>
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

			<!--  NAVEGACION EN DESKTOP -->
			<div class="row row-separation desk">
				<div class="col-md-1">
					<a href="javascript: history.go(-1)"> <img
						src="<%=PropsUtil.get("path.svg")%>/icono-flecha-izquierda-small.svg">
					</a>
				</div>
				<div class="col-md-2">
					<label class="return-style">Volver</label>
				</div>
				<div class="col-md-9"></div>
			</div>

			<div class="row row-separation desk">
				<!--  MAQUETACION PARA DESKTOP-->
				<div class="col-md-12">
					<form id="formQuestionTelephoneOperator"
						name="formQuestionTelephoneOperator"
						action="${actionFormTelephoneOperator}" method="POST">
						<h3 class="tittle">¿Qué operadora y tipo de línea tienes
							actualmente?</h3>
						<div class="d-flex flex-row">

							<div id="Claro" class="row column-box-style">
								<div class="col-md-12 ">
									<div>
										<input class="radio-class" type="radio" id="operator"
											value="Claro" name="<portlet:namespace/>operator"
											onclick="enableCustomerType('Claro')">
									</div>
									<div>
										<img src="<%=PropsUtil.get("path.svg")%>/logo-claro.svg">
									</div>
									<div class="box-location" style="bottom: -1px">
										<label class="column-box-title">Claro</label>
									</div>
								</div>
							</div>

							<div id="CNT" class="row column-box-style">
								<div class="col-md-12 ">
									<div>
										<input class="radio-class" type="radio" id="operator"
											value="CNT" name="<portlet:namespace/>operator"
											onclick="enableCustomerType('CNT')">
									</div>
									<div>
										<img src="<%=PropsUtil.get("path.svg")%>/logo-cnt.svg">
									</div>
									<div class="box-location" style="bottom: -20px">
										<label class="column-box-title">CNT</label>
									</div>
								</div>
							</div>

							<div id="Tuenti" class="row column-box-style">
								<div class="col-md-12 ">
									<div>
										<input class="radio-class" type="radio" id="operator"
											value="Tuenti" name="<portlet:namespace/>operator"
											onclick="enableCustomerType('Tuenti')">
									</div>
									<div>
										<img src="<%=PropsUtil.get("path.svg")%>/logo-tuenti.svg">
									</div>
									<div class="box-location" style="bottom: -28px">
										<label class="column-box-title">Tuenti</label>
									</div>
								</div>
							</div>

							<div id="AkiMovil" class="row column-box-style">
								<div class="col-md-12 ">
									<div>
										<input class="radio-class" type="radio" id="operator"
											value="AkiMovil" name="<portlet:namespace/>operator"
											onclick="enableCustomerType('AkiMovil')">
									</div>
									<div>
										<img src="<%=PropsUtil.get("path.svg")%>/logo-aki-movil.png">
									</div>
									<div class="box-location" style="bottom: -3px">
										<label class="column-box-title">AkiMovil</label>
									</div>
								</div>
							</div>

							<div id="Maxiplus" class="row column-box-style">
								<div class="col-md-12 ">
									<div>
										<input class="radio-class" type="radio" id="operator"
											value="Maxiplus" name="<portlet:namespace/>operator"
											onclick="enableCustomerType('Maxiplus')">
									</div>
									<div>
										<img src="<%=PropsUtil.get("path.svg")%>/logo-maxiplus.png">
									</div>
									<div class="box-location" style="bottom: -3px">
										<label class="column-box-title">Maxiplus</label>
									</div>
								</div>
							</div>
						</div>

						<div id="customerTypeDiv" class="d-flex flex-row"
							style="visibility: hidden; max-height: 0;">
							<div id="prepago"
								class="d-flex justify-content-around box-customer-type">
								<div>
									<input class="box-radio-btn radio-class" type="radio"
										id="customerType" value="prepago"
										name="<portlet:namespace/>customerType"
										onclick="divCustomerType('prepago')">
								</div>
								<div>
									<div>
										<img class="box-icon"
											src="<%=PropsUtil.get("path.svg")%>/icono-prepago-outlined.svg">
									</div>
								</div>
								<div class="box-text-align">
									<p class="box-tittle">Prepago</p>
									<label class="box-subtittle">Hago recargas</label>
								</div>
							</div>



							<div id="pospago"
								class="d-flex justify-content-around  box-customer-type">
								<div>
									<input class="box-radio-btn radio-class" type="radio"
										id="customerType" value="pospago"
										name="<portlet:namespace/>customerType"
										onclick="divCustomerType('pospago')">
								</div>
								<div>
									<div>
										<img class="box-icon"
											src="<%=PropsUtil.get("path.svg")%>/icono-pospago-outlined.svg">
									</div>
								</div>
								<div class="box-text-align">
									<p class="box-tittle">Pospago</p>
									<label class="box-subtittle">Recibo una factura mensual</label>
								</div>
							</div>
						</div>

						<button class="cancel-button"
							onClick="history.go(-1); return false;">Cancelar</button>
						<!--  dlTrackEvent Registeresd on javascript validation-->
						<button id="submitBtnTelephoneOperator" class="continue-button"
							type="submit" name="submit" disabled>Continuar</button>
					</form>
				</div>
			</div>

			<!--  MAQUETACION PARA MOVIL-->
			<div class="row row-separation mobile">
				<div class="col-sm-12">
					<form id="formQuestionTelephoneOperatorMobile"
						name="formQuestionTelephoneOperatorMobile"
						action="${actionFormTelephoneOperator}" method="POST">
						<h3 class="tittle">¿Qué operadora y tipo de línea tienes
							actualmente?</h3>
						<label class="name-field">Operadora</label>

						<div class="d-flex justify-content-between intermediate-space">
							<select class="field-select-form"
								name="<portlet:namespace/>operator" id="operator" required>
								<option selected>Selecciona tu operadora actual</option>
								<option value="Claro">Claro</option>
								<option value="CNT">CNT</option>
								<option value="Tuenti">Tuenti</option>
								<option value="AkiMovil">AkiMovil</option>
								<option value="Maxiplus">Maxiplus</option>
							</select>
						</div>

						<div class="d-flex justify-content-between intermediate-space">
							<div id="prepagoMobile" class="column column-box-style-custom">
								<input type="radio" id="customerType" value="prepago"
									name="<portlet:namespace/>customerType"
									onclick="divCustomerTypeMobile('prepagoMobile')"><br>
								<img
									src="<%=PropsUtil.get("path.svg")%>/icono-prepago-outlined.svg">
								<br> <label class="column-box-title">Prepago</label>
								<p>Hago recargas</p>
							</div>
							<div id="pospagoMobile" class="column column-box-style-custom">
								<input type="radio" id="customerType" value="pospago"
									name="<portlet:namespace/>customerType"
									onclick="divCustomerTypeMobile('pospagoMobile')"><br>
								<img
									src="<%=PropsUtil.get("path.svg")%>/icono-pospago-outlined.svg">
								<br> <label class="column-box-title">Pospago</label>
								<p>
									Recibo una factura <br> mensual
								</p>
							</div>
						</div>
						<!--  dlTrackEvent Registeresd on javascript validation-->
						<button id="submitBtnTelephoneOperatorMobile"
							class="continue-button" type="submit" name="submit" disabled>Continuar</button>
					</form>
				</div>
			</div>

		</div>
	</div>
</div>

<%@ include file="/generalValidations.jsp"%>
