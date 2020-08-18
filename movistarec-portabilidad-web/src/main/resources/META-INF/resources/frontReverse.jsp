<%@ include file="/init.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main_temporal.css"/>
</head>
<body>
	<div id="screen5-mobile" class="container hidden-div">
		<div class="row">
		 	<div class="col-sm"></div>
			<div class="col-sm fondo-camara-reverso">
				<div class="ajustar-top">
					<div class="centrar_con_flex">
						<div class="msgToast-reverso">
							<liferay-ui:message key="portabilidadweb.ubica.el.reverso.de.tu.cedula.dentro.del.recuerdo.senalado"/>
						</div>
					</div>
					<div class="centrar_con_flex border-camara-reverso">
						<video id="video" playsinline autoplay></video>
					</div>
					<div class="group_border_camara">
						<div class="border-camara-left-front-reverso"></div>
						<div class="border-camara-right-front-reverso"></div>
					</div>
					<div class="group_text">
						<div class="text-camara-frontal"><liferay-ui:message key="portabilidadweb.cara.posterior"/></div>
						<div class="text-camara-posterior"><liferay-ui:message key="portabilidadweb.cara.frontal"/></div>
					</div>
					<div class="centrar_con_flex">
						<div class="hijo">
							<div class="boton-camara" id="snap" onclick="showContinueMobile(6)"></div>
						</div>
					</div>
				</div>
			</div>
		 	<div class="col-sm"></div>
		</div>
	</div>
</body>
<%-- <script src="<%=request.getContextPath()%>/js/scriptCamara.js"></script> --%>
</html>