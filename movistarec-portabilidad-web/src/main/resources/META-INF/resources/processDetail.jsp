<%@page import="javax.portlet.RenderRequest"%>
<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>
<liferay-portlet:actionURL name="action-process-detail" var="actionProcessDetail" />
<liferay-portlet:actionURL name="action-phone-income" var="actionPhoneIncome" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main_temporal.css" />
<%
	String title 		= (String) request.getAttribute("descripcion-portabilidad-titulo");
	String subTitle1	= (String) request.getAttribute("descripcion-portabilidad-s1");
	String subTitle2	= (String) request.getAttribute("descripcion-portabilidad-s2");
	String subTitle3	= (String) request.getAttribute("descripcion-portabilidad-s3");
	String subTitle4	= (String) request.getAttribute("descripcion-portabilidad-s4");
%>
<div class="">
	<div class="row">
		<div class="col-md-4 img-lateral desk">
			<img class="img-space" src="<%=PropsUtil.get("path.svg")%>/isologo-movistar.svg">
		</div>
		<div class="col-md-8">
			<div class="header desk-header movil-header">
				<a href="${actionPhoneIncome}">
					<img src="<%=request.getContextPath()%>/images/flecha.jpg" class="flecha">
				</a>
				<img src="<%=request.getContextPath()%>/images/cerrar.jpg" class="cerrar">
			</div>
			<div class="container-information">
				<form id="formQuestionClientData" action="${actionProcessDetail}" method="POST">
					<div class="title-main">
						<!-- <liferay-ui:message key="portabilidadweb.estas.iniciando.el.proceso.de" />
						<liferay-ui:message key="portabilidadweb.cambio.de.operadora" />  -->
						<%=title%>
					</div>
					<div class="instrucciones">
		    			<div class="imagen">
		    				<img src="<%=PropsUtil.get("path.svg")%>/aprobado.svg" alt="imagen aprobado" class="imagen_aprobado">
		    			</div>
		    			<div class="base_texto">
		    				<p class="texto">
		    				<%=subTitle1%>
<%-- 		    				<input name="<portlet:namespace/>name" label="course.name" type="text"> --%>
	<!-- 	    					<liferay-ui:message key="portabilidadweb.operadora.dejara.de.cobrarte.de.manera" /> -->
	<!-- 							<liferay-ui:message key="portabilidadweb.automatica.en.cuanto.se.haga.el.cambio" /> -->
		    				</p>
		    			</div>
	    			</div>
	    			<div class="instrucciones">
		    			<div class="imagen">
		    				<img src="<%=PropsUtil.get("path.svg")%>/aprobado.svg" alt="imagen aprobado" class="imagen_aprobado">
		    			</div>
		    			<div class="base_texto">
		    				<p class="texto">
		    				<%=subTitle2%>
<!-- 		    					<liferay-ui:message key="portabilidadweb.no.tienes.que.darte.de.baja.de.operadora.ni.modificar.tu.plan" /> -->
		    				</p>
		    			</div>
	    			</div>
	    			<div class="instrucciones">
		    			<div class="imagen">
		    				<img src="<%=PropsUtil.get("path.svg")%>/aprobado.svg" alt="imagen aprobado" class="imagen_aprobado">
		    			</div>
		    			<div class="base_texto">
		    				<p class="texto">
		    				<%=subTitle3%>
<!-- 		    					<liferay-ui:message key="portabilidadweb.el.proceso.tarda.aproximadamente" /> -->
		    				</p>
		    			</div>
	    			</div>
	    			<div class="instrucciones">
		    			<div class="imagen">
		    				<img src="<%=PropsUtil.get("path.svg")%>/aprobado.svg" alt="imagen aprobado" class="imagen_aprobado">
		    			</div>
		    			<div class="base_texto">
		    				<p class="texto">
		    				<%=subTitle4%>
<!-- 		    					<liferay-ui:message key="portabilidadweb.te.pediremos.algunos.datos.incluyendo.fotos.de.tu.cedula.todos.son.requeridos.para.realizar.el.proceso" />  -->
		    				</p>
		    			</div>
	    			</div>
	    			<div class="base-boton-desktop">
	    				<a href="${actionPhoneIncome}">
		                	<button class="boton cancelar desk"><liferay-ui:message key="portabilidadweb.cancelar" /></button>
		    			</a>
<%-- 		    			<a href="${actionProcessDetail}"> --%>
		    				<button class="boton" type="submit"><liferay-ui:message key="portabilidadweb.continuar" /></button>
<!-- 		    			</a> -->
	    			</div>
	    		</form>	
			</div>
		</div>
	</div>
</div>

