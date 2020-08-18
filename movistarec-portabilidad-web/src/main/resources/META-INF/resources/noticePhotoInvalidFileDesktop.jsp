<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main_temporal.css" />

<div id="screen4" class="hidden-div">
	<div class="row">
		<div class="col-md-4 img-lateral desk">
			<img class="img-space" src="<%=PropsUtil.get("path.svg")%>/isologo-movistar.svg">
		</div>
		<div class="col-md-8 padding-0">
			<div class="header header-band">
				<label class="header-text">
					<liferay-ui:message key="portabilidadweb.fotos.de.la.cedula"/>
				</label>
			</div>
			<div class="container-information-notice-document">
				<div class="title-main2">
					<liferay-ui:message key="portabilidadweb.necesitamos.fotos.de.tu.cedula"/>
				</div>
				<div class="instrucciones">
	    			<div class="base-texto-notice-document">
	    				<p class="texto-notice-document">
	    					<liferay-ui:message key="portabilidadweb.para.hacer.el.tramite.de.cambio.de.operadora.necesitamos.foto.de.tu.cedula"/>
	    				</p>
	    			</div>
    			</div>
				<div class="row container-dashed">
					<div class="col-md-12">
						<div class="ajustar-contenido">
							<div class="d-flex justify-content-center">
								<div class="text-front-back">
									<liferay-ui:message key="portabilidadweb.frontal.y.posterior"/>
								</div>
							</div>
							<div class="d-flex justify-content-center">
								<div class="text-subir-archivos">
									<liferay-ui:message key="portabilidadweb.arrastra.o.sube.uno.o.dos.archivos.pdf.png.o.jpg"/>
								</div>
							</div>
							<div class="row d-flex justify-content-center">
								<div class="base-cuadro">
									<img src="<%=PropsUtil.get("path.svg")%>/icono-proceso-fallido.svg" alt="imagen icono proceso fallido">
								</div>
							</div>
							<div class="d-flex justify-content-center">
								<div class="text-tipo-archivo">
									<liferay-ui:message key="portabilidadweb.el.tipo.de.archivo.que.intentaste.subir.no.es.valido"/>
								</div>
							</div>
							<div class="buscar-archivo d-flex justify-content-center">
								<liferay-ui:message key="portabilidadweb.buscar.archivo"/>
							</div>
						</div>
					</div> 
		 		</div>
		 		<div class="base-boton-notice-desktop">
		            <button class="boton cancelar desk">
		            	<liferay-ui:message key="portabilidadweb.omitir.por.ahora"/>
		            </button>
	   			</div>
   			</div>
   			<!-- Barra inferior -->
			<div class="d-flex justify-content-between footer-container desk">
				<div>
					<button class="cancel-btn-squater d-flex align-items-center" onclick="showContinue(3)">
						<span class="icon-icono-flecha-izquierda-small font-size-200 icon-azul-movistar"></span>
						<liferay-ui:message key="portabilidadweb.cancelar"/>
					</button>
				</div>
				<div class="my-auto d-flex bullet">
					<div class="rounded-circle circle-size movistar-color-blue"></div>
					<div class="rounded-circle bg-white circle-size-selected"></div>
					<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
					<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
					<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
				</div>
				<div>
					<button class="continue-btn-squater d-flex align-items-center justify-content-end" type="submit" name="submit" onclick="showContinue(5)">
						<span><liferay-ui:message key="portabilidadweb.continuar"/></span> 
						<span class="icon-gris-movistar-1 font-size-200 icon-icono-flecha-derecha-small"></span>
					</button>
				</div>
			</div>
			<!-- Fin barra inferior -->
		</div>
	</div>
</div>

