
<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>


<div class="row padding-0" style="height: 100%">
	<div class="col-md-12 col-sm-12">
		<div class="d-flex align-items-start flex-column"
			style="height: 244px">
			<!-- IMAGEN SUPERIOR HEADER -->
			<img class="mobile"
				src="<%=PropsUtil.get("path.svg")%>/AF_Movistar_Fondos Graficos_RGB-1.png">
			<img class="desk img-fluid"
				src="<%=PropsUtil.get("path.svg")%>/bg-header-movistar.png">
		</div>
		<!-- CONTENIDO -->
		<div class="d-flex justify-content-center intermediate-space">
			<img src="<%=PropsUtil.get("path.svg")%>/Logo-Movistar_44x44.svg">
		</div>

		<div class="d-flex justify-content-center intermediate-space">
			<h3 class="tittle">¡Bienvenido a Movistar!</h3>
		</div>

		<div class="d-flex justify-content-center intermediate-space">
			<div class="border-welcome-box">
				<label class="confirm-text-5 text-center">Ya hiciste todo,
					ahora solo queda nuestra parte.<br> ¡Te vamos a llamar para
					informarte sobre el proceso de cambio de operadora!
				</label>
			</div>

		</div>

		<div class="d-flex justify-content-center intermediate-space">

			<label class="confirm-text-5"> Si tienes alguna duda sobre el
				proceso, contáctate a nuestro canal de WhatsApp</label>
		</div>

		<div class="d-flex justify-content-center intermediate-space">
			<a href="https://wa.me/0999000177"><button
					class="whatsapp-button" type="submit" name="submit">
					<img src="<%=PropsUtil.get("path.svg")%>/icono-whatsapp.svg">
					<span>Escríbenos</span>
				</button></a>

		</div>

		<div class="d-flex align-items-end flex-column" style="height: 122px">
			<!-- IMAGEN INFERIOR FOOTER -->
			<img class="desk img-fluid"
				src="<%=PropsUtil.get("path.svg")%>/bg-footer-movistar.png">
		</div>

	</div>
</div>


