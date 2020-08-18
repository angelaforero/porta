<%@ include file="/init.jsp"%>
<div id="desktop" class="d-none d-md-block">
<%@ include file="/noticePhotoDocumentDesktop.jsp"%>
</div>
<div id="mobile" class="d-block d-md-none">
<%@ include file="/noticePhotoDocument.jsp"%>
<%@ include file="/frontCamera.jsp"%>
<%@ include file="/frontCameraConfirm.jsp"%>
<%@ include file="/reverseCamera.jsp"%>
<%@ include file="/frontReverse.jsp"%>
<%@ include file="/reverseCameraConfirm.jsp"%>
</div>

<script>
$(document).ready(function() {
	var desktop = $("#screen1").show();
	var mobile = $("#screen1-mobile").show();
});
</script>
<script src="<%=request.getContextPath()%>/js/scriptBlockNoneDiv.js"></script>
<script src="<%=request.getContextPath()%>/js/scriptBlockNoneDivMobile.js"></script>