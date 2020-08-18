<%@ include file="/init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.PropsUtil"%>

<liferay-portlet:actionURL name="action-code-nip" var="actionCodeNIP" />

<!-- <script type="text/javascript">
var continueSubmit = true;


JQ = {
        onReady: function() {
                    
             const counter = document.getElementById( 'counter' )
             setTimeout( () => {
                 counter.value = 4
                 setTimeout( () => {
                     counter.value = 3
                     setTimeout( () => {
                         counter.value = 2
                         setTimeout( () => {
                             counter.value = 1
                             setTimeout( () => {
                                 counter.value = 'X'
                                 counter.disabled = false
                                 if(continueSubmit){
                                     $('#formCounter #<portlet:namespace/>verPromo').val(false);
                                     $("#formCounter").submit();    
                                 }                                 
                             }, 1000)
                         }, 1000)
                     }, 1000)
                 }, 1000)
             }, 1000 )
             
             $('.freemium-web-view').on('click', '#formBackground', function() {
                 continueSubmit = false;
                 $('#formCounter #<portlet:namespace/>verPromo').val(true);
                 $('#formCounter').submit();    
            });
             
             $('.freemium-web-view').on('click', '#<portlet:namespace/>verPromo', function() {
                 $('#formCounter #<portlet:namespace/>verPromo').val(false);
                 $('#formCounter').submit();    
            });


        }
    };
    $(document).ready(JQ.onReady);


</script> -->



<div style="heigth: 100%">
	<div class="d-flex padding-0">
		<%@ include file="/lg_lateral.jsp"%>

		<div id="content-lateral content-space">
			<!-- COMPONENTE SUPERIOR DE NAVEGACION EN MOVIL -->
			<div class="mobile">
				<div class="d-flex justify-content-between bd-highlight mb-2">
					<div class="p-2 bd-highlight">
						<a href="https://www.telefonica.com/es/home"> <img
							src="<%=request.getContextPath()%>/images/flecha.jpg"
							class="header-mobile-flecha">
						</a>
					</div>
					<div class="p-2 bd-highlight"></div>
					<div class="p-2 bd-highlight">
						<img src="<%=request.getContextPath()%>/images/cerrar.jpg"
							class="header-mobile-cerrar">
					</div>
				</div>
			</div>
			<!-- ////////////////////////////////////////// -->

			<div class="row row-separation content-space desk">
				<div class="col-md-1">
					<a href="https://www.telefonica.com/es/"><img
						src="<%=PropsUtil.get("path.svg")%>/icono-flecha-izquierda-small.svg"></a>
				</div>
				<div class="col-md-2">
					<a href="https://www.telefonica.com/es/"> <label
						class="return-style">Volver</label>
					</a>
				</div>
				<div class="col-md-9"></div>
			</div>

			<div class="row row-separation content-space">
				<div class="col-md-12 col-sm-12">
					<form id="formQuestionCodeNIP" name="formQuestionCodeNIP"
						action="${actionCodeNIP}" method="POST"
						onsubmit="return validate();">
						<h3 class="tittle">Ingresa el código que enviamos a tu
							celular</h3>
						<div class="d-flex justify-content-between intermediate-space">
							<label class="subtittle">Revisa tus mensajes de texto.
								Necesitamos validar tu celular con ese código para poder
								avanzar.</label>
						</div>
						<div class="d-flex digit-box">
							<input required id="digit1"
								class="digit d-flex justify-content-center text-center"
								oninput="inValidationDigit('d1')" type="number" maxlength="1"
								name="<portlet:namespace/>digit1"> <input required
								id="digit2"
								class="digit d-flex justify-content-center text-center"
								oninput="inValidationDigit('d2')" type="number" maxlength="1"
								name="<portlet:namespace/>d2"> <input required
								id="digit3"
								class="digit d-flex justify-content-center text-center"
								oninput="inValidationDigit('d3')" type="number" maxlength="1"
								name="<portlet:namespace/>d3"> <input required
								id="digit4"
								class="digit d-flex justify-content-center text-center"
								oninput="inValidationDigit('d4')" type="number" maxlength="1"
								name="<portlet:namespace/>d4">
						</div>
						<div class="d-flex justify-content-center counter-box"
							onclick="dlTrackEvent('Movistar Libre - Validar con codigo', 'reenvia codigo', 'reenviar codigo sms')">
							<label class="counter">Reenviar código en <span id="time">00</span>s
								<img class="box-icon"
								src="<%=PropsUtil.get("path.svg")%>/icon-reload.svg">
							</label>
						</div>

						<button class="cancel-button desk"
							href="https://www.telefonica.com/es/">Cancelar</button>
						<button id="submitBtnCodeNIP"
							onclick="dlTrackEvent('Movistar Libre - Validar con codigo', 'ingreso de datos', 'código válido')"
							class="continue-button submitBtnCodeNIP" type="submit"
							name="submit" disabled>Continuar</button>
					</form>
				</div>
			</div>
		</div>

	</div>
</div>


<script type="text/javascript">

function inValidationDigit(val) {
	console.log('digito introduccido'+val);
	var d1 = document.getElementById('digit1');
	var d2 = document.getElementById('digit2');
	var d3 = document.getElementById('digit3');
	var d4 = document.getElementById('digit4');
	
	if(val=='d1'){
		d1.className = "valid-digit";
	} else if(val=='d2'){
		d2.className = "valid-digit";
	} else if(val=='d3'){
		d3.className = "valid-digit";
	} else if(val=='d4'){
		d4.className = "valid-digit";
	} else {
		
	} 
} 

<!-- CLASE PARA VALIDACIONES EN FRONT DEL NIP-->
const formCellphone = document.getElementById('formQuestionCodeNIP');
formCellphone.addEventListener("change", () => {
    document.getElementById('submitBtnCodeNIP').disabled = !formCellphone.checkValidity();
    document.getElementById("formQuestionCodeNIP").className="submitted";
});  

function startTimer(duration, display) {
    var timer = duration, minutes, seconds;
    setInterval(function () {
        minutes = parseInt(timer / 60, 10);
        seconds = parseInt(timer % 60, 10);

        minutes = minutes < 10 ? "0" + minutes : minutes;
        seconds = seconds < 10 ? "0" + seconds : seconds;

        display.textContent = minutes + ":" + seconds;

        if (--timer < 0) {
            timer = duration;
        }
    }, 1000);
}

/* window.onload = function () {
    var fiveMinutes = 30,
        display = document.querySelector('#time');
    startTimer(fiveMinutes, display);
}
 */
window.addEventListener("load", function(event) {
	 var fiveMinutes = 30,
     display = document.querySelector('#time');
 	 startTimer(fiveMinutes, display);
}, false)
	
</script>
