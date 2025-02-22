<%@ include file="/init.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main_temporal.css"/>
</head>
<body>
	<div id="screen3-mobile" class="container hidden-div">
		<div class="row">
			<div class="col-sm"></div>
			<div class="col-sm">
				<div class="centrar_con_flex">
					<div class="ajustar-top-bottom">
						<liferay-ui:message key="portabilidadweb.confirmar.foto"/>
					</div>
				</div>
				<div class="centrar_con_flex border-camara-confirmar-anverso"></div>
				<div class="centrar_con_flex">
					<div class="text-camara-anverso">
						<liferay-ui:message key="portabilidadweb.asegurate.de.que.los.textos.se.lean.correctamente"/>
					</div>
				</div>
				<div class="contenedor-botones-anverso">
					<button class="boton-confirmar-foto" onclick="showContinueMobile(4)"><liferay-ui:message key="portabilidadweb.confirmar.foto"/></button>
					<button class="boton-volver-tomar" onclick="showContinueMobile(2)"><liferay-ui:message key="portabilidadweb.volver.a.tomar"/></button>
				</div>
			</div>
			<div class="col-sm"></div>
		</div>
	</div>
</body>
</html>