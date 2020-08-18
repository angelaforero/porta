<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<liferay-portlet:actionURL name="action-terms-conditions"
	var="actionTermsAndConditions" />
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

			<!-- CONTENIDO -->
			<form id="formQuestion" action="${actionTermsAndConditions}"
				method="POST">
				<div class="header-band desk">
					<label class="header-text">Confirmación</label>
				</div>

				<div class="row row-separation content-space">
					<div class="col-md-12 col-sm-12">
						<div class="intermediate-space">
							<h3 class="tittle">Acepta los Términos y Condiciones</h3>
						</div>
						<div class="intermediate-space">
							<label class="subtittle">Lorem Ipsum is simply dummy text
								of the printing and typesetting industry.</label>
						</div>


						<div class="d-flex align-items-center">
							<div>
								<input class="check-class" type="checkbox"
									name="isNotOwnerRecieved" value="Recieved">
							</div>
							<div class="check-text">
								<label class="terms-text">He leído los <a
									class="text-link"
									href="<%=request.getContextPath()%>/files/pdf.pdf"
									target="_blank">Términos y condiciones</a> del contrato de
									portabilidad.
								</label>
							</div>
						</div>

						<div class="d-flex align-items-center terms-box">
							<div>
								<input class="check-class" type="checkbox"
									name="isNotOwnerRecieved" value="Recieved">
							</div>
							<div class="check-text">
								<label class="terms-text">Acepto la <a class="text-link"
									href="<%=request.getContextPath()%>/files/pdf.pdf"
									target="_blank">Política de privacidad</a> de Movistar Ecuador.
								</label>
							</div>
						</div>


						<div class="intermediate-space">
							<button class="continue-button mobile" type="submit"  onclick="dlTrackEvent('Movistar Libre - Solicitud finalizada', 'click', 'Solicitud finalizada')"
								name="submit">Continuar</button>
							<button class="continue-button desk" type="submit" name="submit">Aceptar
								y enviar solicitud</button>
						</div>
					</div>
				</div>

			</form>
		</div>

	</div>
</div>


