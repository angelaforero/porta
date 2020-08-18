<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<liferay-portlet:actionURL name="action-client-data" var="actionClientData" />
<liferay-portlet:actionURL name="action-attach-signature" var="actionAttachSignature" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main_temporal.css" />

<div class="">
	<div class="row">
		<div class="col-md-4 img-lateral desk">
			<img class="img-space"
				src="<%=PropsUtil.get("path.svg")%>/isologo-movistar.svg">
		</div>
		<div class="col-md-8 padding-0 border_gris">
			<div class="header header-band2 desk">
				<label class="header-text">
					<liferay-ui:message key="portabilidadweb.adjuntar.firma"/>
				</label>
			</div>
			<div class="header desk-header movil-header">
				<img src="<%=request.getContextPath()%>/images/flecha.jpg" class="flecha">
				<img src="<%=request.getContextPath()%>/images/cerrar.jpg" class="cerrar">
			</div>
			<div class="container-information-notice-document">
				<form id="formFirm" action="${actionAttachSignature}" method="POST">
					<div class="inverso">
						<div class="title-main2">
							<liferay-ui:message key="portabilidadweb.adjuntar.tu.firma"/>
						</div>
						<div class="instrucciones">
							<div class="base-texto-notice-document">
								<p class="texto-notice-document d-none d-md-block">
									<liferay-ui:message key="portabilidadweb.usa.el.puntero.del.mouse.para.firmar.en.el.espacio.en.blanco"/>
								</p>
								<p class="texto-notice-document d-block d-md-none">
									<liferay-ui:message key="portabilidadweb.usa.tu.dedo.para.firmar.en.el.espacio.en.blanco"/>
								</p>
							</div>
						</div>
						<div class="row container-dashed-firm">
							<div class="col-md-12">
								<div class="ajustar-contenido">
									<canvas id="canvas"></canvas>
								</div>
							</div>
						</div>
						<label class="text-validation" id="validationCanvas" hidden="true"><liferay-ui:message key="portabilidadweb.campo.obligatorio"/></label>
						<div class="base-boton-firm-desktop">
			                <button type="button" class="boton-volver-intentar-firm" id="btnVolverIntentar">
			                	<div class="text-volver-intentar-firm ">
			                		<liferay-ui:message key="portabilidadweb.volver.a.intentar"/>
			                	</div>
		                	</button>
		<%--                 	<a href="${actionAttachSignature}"> --%>
			    				<button class="boton-confirmar-firm">
			    					<div class="text-confirmar-firm">
			    						<liferay-ui:message key="portabilidadweb.confirmar"/>
			    					</div>
			   					</button>
		<!--    					</a> -->
		    			</div>
		    			<div class="base-recaptcha">
		    				<div class="g-recaptcha" data-sitekey="6LevBLcZAAAAAIfwb4BigkAvWWQ8JOeKE0ohFwfI" data-callback="capcha_filled" data-expired-callback="capcha_expired"></div>
		    				<label class="text-validation" id="validationRecaptcha" hidden="true"><liferay-ui:message key="portabilidadweb.campo.obligatorio"/></label>
		    			</div>
		    			<div class="base-boton-firm desk-header">
		    				<a href="${actionAttachSignature}">
			    				<button class="boton-continuar-firm" onclick="dlTrackEvent('Movistar Libre - Toma de Firma', 'click', 'Firma exitosa')">
					            	<liferay-ui:message key="portabilidadweb.continuar"/>
				            	</button>
			            	</a>
		    			</div>
					</div>
				<!-- Barra inferior -->
					<div class="d-flex justify-content-between footer-container3 alinear_footer desk">
						<div>
							<a href="${actionClientData}">
								<button class="cancel-btn-squater d-flex align-items-center">
									<span class="icon-icono-flecha-izquierda-small font-size-200 icon-azul-movistar ajust-flecha-izquierda-small"></span>
									<liferay-ui:message key="portabilidadweb.cancelar"/>
								</button>
							</a>
						</div>
						<div class="my-auto d-flex bullet">
							<div class="rounded-circle circle-size movistar-color-blue"></div>
							<div class="rounded-circle circle-size movistar-color-blue"></div>
							<div class="rounded-circle bg-white circle-size-selected"></div>
							<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
							<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
						</div>
						<div>
<%-- 							<a href="${actionAttachSignature}"> --%>
								<button id="btnContinue" class="continue-btn-squater d-flex align-items-center justify-content-end" type="submit" name="submit" onclick="dlTrackEvent('Movistar Libre - Toma de Firma', 'click', 'Firma exitosa')">
									<span><liferay-ui:message key="portabilidadweb.continuar"/></span> 
									<span class="icon-gris-movistar-1 font-size-200 icon-icono-flecha-derecha-small ajust-flecha-derecha-small2 "></span>
								</button>
<!-- 							</a> -->
						</div>
					</div>
				<!-- Fin barra inferior -->
				</form>
			</div>
		</div>
	</div>
</div>
<script src="https://www.google.com/recaptcha/api.js"></script>
<script src="<%=request.getContextPath()%>/js/scriptDrawFirm.js"></script>

