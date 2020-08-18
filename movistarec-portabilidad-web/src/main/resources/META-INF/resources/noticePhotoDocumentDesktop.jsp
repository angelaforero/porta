<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<liferay-portlet:actionURL name="action-process-detail" var="actionProcessDetail" />
<liferay-portlet:actionURL name="action-photo-document" var="actionPhotoDocument" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main_temporal.css" />

<div id="screen1" class="hidden-div">
	<div class="row">
		<div class="col-md-4 img-lateral desk">
			<img class="img-space" src="<%=PropsUtil.get("path.svg")%>/isologo-movistar.svg">
		</div>
		<div class="col-md-8 padding-0 border_gris">
			<form id="formNoticePhotoDocument" action="${actionPhotoDocument}" method="POST" onsubmit="return validateImgDocument();">
				<div class="header header-band2">
					<label class="header-text">
						<liferay-ui:message key="portabilidadweb.fotos.de.la.cedula"/>
					</label>
				</div>
				<div class="container-information-notice-document container_informacion">
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
					<div id="uploadFile"  class="row container-dashed">
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
								<div class="row">
									<div class="base-cuadro">
										<div class="img-document-front espacios_z1" id="img-document-front">
											<img class="image-preview-front__image img-vo drop-zone__prompt" src="<%=PropsUtil.get("path.svg")%>/icono-cedula-frontal.svg" alt="imagen icono cédula frontal">
											<input type="file" name="<portlet:namespace/>inpFileFront" id="inpFileFront" class="drop-zone__input" accept=".jpg,.png">
<!-- 											<div id="error"></div> -->
											<label class="text-validation" id="validationInputFront" hidden="true"><liferay-ui:message key="portabilidadweb.campo.obligatorio"/></label>
										</div>
										<div class="img-document-back espacios_z1" id="img-document-back">
											<img class="image-preview-back__image img-vo2" src="<%=PropsUtil.get("path.svg")%>/icono-cedula-posterior.svg" alt="imagen icono cédula posterior">
											<input type="file" name="<portlet:namespace/>inpFileBack" id="inpFileBack" class="drop-zone__input2" accept=".jpg,.png">
											<label class="text-validation" id="validationInputBack" hidden="true"><liferay-ui:message key="portabilidadweb.campo.obligatorio"/></label>
										</div>
									</div>	
									<div id="invalidFileM" class="base-cuadro hidden-div" style="flex-direction: column !important; margin: 20px;">
										<div class="d-flex justify-content-center">
											<img src="<%=PropsUtil.get("path.svg")%>/icono-proceso-fallido.svg" alt="imagen icono proceso fallido">
										</div>
										<div class="d-flex justify-content-center">
											<div class="text-tipo-archivo">
												<liferay-ui:message key="portabilidadweb.el.tipo.de.archivo.que.intentaste.subir.no.es.valido"/>
											</div>
										</div>
									</div>
								</div>
								<div class="buscar-archivo d-flex justify-content-center">
									<span id="btnFile" class="movistar-c-pointer" onclick="fileUpload();"><liferay-ui:message key="portabilidadweb.buscar.archivo"/></span>
								</div>
							</div>
						</div> 
			 		</div>
			 		
			 				<!-- Show Hidden -->
		 						<!-- Upload 2-->
								<div class="row container-dashed-upload hidden-div">
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
											<div class="base-cuadro-upload d-flex justify-content-center">
												<div class="cuadros"></div>
												<div class="cuadros"></div>
											</div>
										</div>
									</div> 
			 					</div>
			 					<!-- Fin Upload -->
			 					
			 					<!-- Uploaded 3-->
			 					<div class="row container-dashed hidden-div ">
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
											<div class="base-cuadro-upload d-flex justify-content-center">
												<div class="cuadros-subiendo">
													<div class="cuadros-subiendo-before">
														<div class="cargando-img"></div>
													</div>
													<div class="text-foto">
														<liferay-ui:message key="portabilidadweb.foto1.jpg"/>
													</div>
												</div>
												<div class="cuadros-subiendo">
													<div class="cuadros-subiendo-before">
														<div class="cargando-img"></div>
													</div>
													<div class="text-foto">
														<liferay-ui:message key="portabilidadweb.foto2.jpg"/>
													</div>
												</div>
											</div>
											<div class="d-flex justify-content-center">
												<div class="text-cargando">
													<liferay-ui:message key="portabilidadweb.cargando"/>
												</div>
											</div>
										</div>
									</div> 
			 					</div>
			 					<!-- Fin Uploaded -->
			 					
			 					<!-- InvalidFile 4-->
		 						<div id="invalidFile" class="row container-dashed hidden-div">
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
													<div class="espacios_z1">
														<img src="<%=PropsUtil.get("path.svg")%>/icono-proceso-fallido.svg" alt="imagen icono proceso fallido">
													</div>
												</div>
											</div>
											<div class="d-flex justify-content-center">
												<div class="text-tipo-archivo">
													<liferay-ui:message key="portabilidadweb.el.tipo.de.archivo.que.intentaste.subir.no.es.valido"/>
												</div>
											</div>
											<div class="buscar-archivo d-flex justify-content-center">
												<span id="btnFile" class="movistar-c-pointer" onclick="fileUpload();"><liferay-ui:message key="portabilidadweb.buscar.archivo"/></span>
											</div>
										</div>
									</div> 
			 					</div>
			 					<!-- Fin InvalidFile -->
			 					
			 					<!-- NumberError 5-->
			 					<div class="row container-dashed hidden-div">
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
											<div class="base-cuadro-upload d-flex justify-content-center">
												<div class="cuadros-subiendo">
													<img src="<%=PropsUtil.get("path.svg")%>/icono-plus-circle-small.svg" alt="imagen icono plus circle small" class="img-circle-error">
													<div class="sin-cargando-img"></div>
													<div class="text-foto">
														<liferay-ui:message key="portabilidadweb.foto1.jpg"/>
													</div>
												</div>
												
												<div class="cuadros-subiendo">
													<img src="<%=PropsUtil.get("path.svg")%>/icono-plus-circle-small.svg" alt="imagen icono plus circle small" class="img-circle-error">
													<div class="sin-cargando-img"></div>
													<div class="text-foto">
														<liferay-ui:message key="portabilidadweb.foto2.jpg"/>
													</div>
												</div>
											</div>
											<div class="buscar-archivo-error d-flex justify-content-center">
												<liferay-ui:message key="portabilidadweb.buscar.archivo"/>
											</div>
											<div class="text-tipo-archivo-error">
												<liferay-ui:message key="portabilidadweb.no.puedes.subir.mas.de.dos.archivos"/>
											</div>
										</div>
									</div> 
		 						</div>
			 					<!-- Fin NumberError -->
			 				<!-- Fin Show Hidden -->
<!-- 			 		<div class="base-boton-notice-desktop"> -->
<%-- 			 			<a href="${actionPhotoDocument}"> --%>
<!-- 				            <button class="boton cancelar desk"> -->
<!-- 				            	<liferay-ui:message key="portabilidadweb.omitir.por.ahora"/> -->
<!-- 			            	</button> -->
<!-- 		            	</a> -->
<!-- 		   			</div> -->
	   			</div>
				<!-- Barra inferior -->
				<div class="d-flex justify-content-between footer-container2 desk">
					<div>
						<a href="${actionProcessDetail}">
							<button class="cancel-btn-squater d-flex align-items-center">
								<span class="icon-icono-flecha-izquierda-small font-size-200 icon-azul-movistar ajust-flecha-izquierda-small"></span>
								<liferay-ui:message key="portabilidadweb.cancelar"/>
							</button>
						</a>
					</div>
					<div class="my-auto d-flex bullet">
						<div class="rounded-circle circle-size movistar-color-blue"></div>
						<div class="rounded-circle bg-white circle-size-selected"></div>
						<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
						<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
						<div class="rounded-circle bg-gris-movistar-1 circle-size"></div>
					</div>
					<div>
<%-- 						<a href="${actionPhotoDocument}"> --%>
							<button class="continue-btn-squater d-flex align-items-center justify-content-end" type="submit" name="submit"  onclick="dlTrackEvent('Movistar Libre - Toma de Foto', 'click', 'Fotografía exitosa')">
								<span class="name_bottom"><liferay-ui:message key="portabilidadweb.continuar"/></span> 
								<span class="icon-gris-movistar-1 font-size-200 icon-icono-flecha-derecha-small ajust-flecha-derecha-small"></span>
							</button>
<!-- 						</a>	 -->
					</div>
				</div>
				<!-- Fin barra inferior -->
			</form>
		</div>
	</div>
</div>
<script src="<%=request.getContextPath()%>/js/scriptDragDrop.js"></script>


