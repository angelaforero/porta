<%@ include file="/init.jsp" %>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil" %>
<liferay-portlet:actionURL name="action-process-detail" var="actionProcessDetail" />
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main_temporal.css"/>
</head>
<body>
	<div id="screen1-mobile" class="container desk-mobile hidden-div">
		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">
				<div class="header">
					<a href="${actionProcessDetail}">
						<img src="<%=request.getContextPath()%>/images/flecha.jpg" class="flecha">
					</a>
					<img src="<%=request.getContextPath()%>/images/cerrar.jpg" class="cerrar">
				</div>
				<div class="contenido-camara-aviso">
					<img src="<%=PropsUtil.get("path.svg")%>/icono_camara.svg" class="imagen_camara">
					<div class="titulo-15"><b><liferay-ui:message key="portabilidadweb.necesitamos.fotos.de.tu.cedula"/></b></div>
					<p class="texto-15">
						<liferay-ui:message key="portabilidadweb.para.iniciar.la.solicitud.de.cambio.de.operadora"/>
						<liferay-ui:message key="portabilidadweb.necesitamos.fotos.de.frente.y.reverso"/>
					</p>
				</div>
				<div class="contenedor-botones-aviso-cedula">
					<button class="boton-continuar-aviso" onclick="showContinueMobile(2)"><liferay-ui:message key="portabilidadweb.continuar"/></button>
					<button class="boton-omitir-aviso"><liferay-ui:message key="portabilidadweb.omitir.por.ahora"/></button>
				</div>
			</div>
			<div class="col-sm"></div>
		</div>
	</div>
</body>
<%-- <script src="<%=request.getContextPath()%>/js/scriptCamara.js"></script> --%>
</html>