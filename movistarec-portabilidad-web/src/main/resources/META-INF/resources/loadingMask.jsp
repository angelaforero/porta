<%@ include file="/init.jsp"%>
<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main_temporal.css" />

<div class="">
	<div class="row">
		<div class="col-md-4 img-lateral desk">
			<img class="img-space" src="<%=PropsUtil.get("path.svg")%>/isologo-movistar.svg">
		</div>
		<div class="col-md-8 my-auto center-div border-div">
			<div class="loading"></div>
			<div class="text-center font-16px">
				Un momento por favor, estamos registrando tu solicitud.
			</div>
		</div>
	</div>
</div>

