
<%@ include file="/init.jsp"%>

<script type="text/javascript">
	<!-- CLASE PARA VALIDACIONES EN FRONT DEL NUMERO DE TELEFONO CELULAR PhoneIncome-->
	const formCellphone = document.getElementById('formQuestionCellphone');
	formCellphone.addEventListener("change", () => {
	    document.getElementById('submitBtnPhoneIncome').disabled = !formCellphone.checkValidity();
	    document.getElementById("formQuestionCellphone").className="submitted";
	}); 
	
	function inValidationCellphone(val) {
		var val = document.forms["formQuestionCellphone"]["<portlet:namespace/>cellphone"].value;
		if(val.length<10){
			document.getElementById("validationCellphone").hidden = false;
			document.getElementById("xCellphone").hidden = false;
			var elem = document.getElementById('cellphone');
			elem.className ="invalid";
		}
	} 
	
	function validate() {
		var val = document.forms["formQuestionCellphone"]["<portlet:namespace/>cellphone"].value;
		var res = isValidPhone(val);
		if (res == undefined || res == false) {
			document.getElementById("validationCellphone").hidden = false;
			document.getElementById("xCellphone").hidden = false; 
			res = false;
			dlTrackEvent('Movistar Libre - Validación de celular', 'ingreso de datos', 'usuario no identificado')
		} else {
			res = true;
			dlTrackEvent('Movistar Libre - Validación de celular', 'ingreso de datos', 'usuario identificado')
		}
		return res;
	}
	
	<!-- CLASE PARA VALIDACIONES Y ESTILOS EN FRONT LA ELECCION DE OPERADOR TelephoneOperator-->
	var OperatorSelected;
	/*Desktop*/
	function enableCustomerType(value) {
		var elem = document.getElementById('customerTypeDiv');
		elem.style["visibility"] = "visible";
		elem.style["max-height"] = "200px";

		var squater = document.getElementById(value);
		squater.style["border"] = "2px solid #019DF4";

		var divClaro = document.getElementById('Claro');
		var divCNT = document.getElementById('CNT');
		var divTuenti = document.getElementById('Tuenti');
		var divAkiMovil = document.getElementById('AkiMovil');
		var divMaxiplus = document.getElementById('Maxiplus');
		OperatorSelected = value;
		switch (value) {
		case 'Claro':
			divCNT.style["border"] = "1px solid #d3d4d3";
			divTuenti.style["border"] = "1px solid #d3d4d3";
			divAkiMovil.style["border"] = "1px solid #d3d4d3";
			divMaxiplus.style["border"] = "1px solid #d3d4d3";
			break;
		case 'CNT':
			divClaro.style["border"] = "1px solid #d3d4d3";
			divTuenti.style["border"] = "1px solid #d3d4d3";
			divAkiMovil.style["border"] = "1px solid #d3d4d3";
			divMaxiplus.style["border"] = "1px solid #d3d4d3";
			break;
		case 'Tuenti':
			divClaro.style["border"] = "1px solid #d3d4d3";
			divCNT.style["border"] = "1px solid #d3d4d3";
			divAkiMovil.style["border"] = "1px solid #d3d4d3";
			divMaxiplus.style["border"] = "1px solid #d3d4d3";
			break;
		case 'AkiMovil':
			divClaro.style["border"] = "1px solid #d3d4d3";
			divTuenti.style["border"] = "1px solid #d3d4d3";
			divCNT.style["border"] = "1px solid #d3d4d3";
			divMaxiplus.style["border"] = "1px solid #d3d4d3";
			break;
		case 'Maxiplus':
			divClaro.style["border"] = "1px solid #d3d4d3";
			divTuenti.style["border"] = "1px solid #d3d4d3";
			divAkiMovil.style["border"] = "1px solid #d3d4d3";
			divCNT.style["border"] = "1px solid #d3d4d3";
			break;
		default:
			console.log('Not Operator selected');
		}

	}

	/*Desktop*/
	function divCustomerType(value) {
		var div = document.getElementById(value);
		div.style["border"] = "2px solid #019DF4";

		const formTelephoneOperator = document
				.getElementById('formQuestionTelephoneOperator');
		document.getElementById('submitBtnTelephoneOperator').disabled = !formTelephoneOperator
				.checkValidity();
		document.getElementById("formQuestionTelephoneOperator").className = "submitted";
		dlTrackEvent('Movistar Libre - operadora - linea',OperatorSelected , value)
		if (value != "prepago") {
			var divNotSelected = document.getElementById('prepago');
			divNotSelected.style["border"] = "1px solid #d3d4d3";
		} else {
			var divNotSelected = document.getElementById('pospago');
			divNotSelected.style["border"] = "1px solid #d3d4d3";
		}
	}

	/*mobile*/
	function divCustomerTypeMobile(value) {
		var div = document.getElementById(value);
		div.style["border"] = "2px solid #019DF4";

		const formTelephoneOperator = document
				.getElementById('formQuestionTelephoneOperatorMobile');
		document.getElementById('submitBtnTelephoneOperatorMobile').disabled = !formTelephoneOperator
				.checkValidity();
		document.getElementById("formQuestionTelephoneOperatorMobile").className = "submitted";
		dlTrackEvent('Movistar Portabilidad - operadora - linea',OperatorSelected , value)
		
		
		if (value != "prepagoMobile") {
			var divNotSelected = document.getElementById('prepagoMobile');
			divNotSelected.style["border"] = "1px solid #d3d4d3";
		} else {
			var divNotSelected = document.getElementById('pospagoMobile');
			divNotSelected.style["border"] = "1px solid #d3d4d3";
		}
	}
	
	
	
	<!-- CLASE PARA VALIDACIONES EN FRONT DEL FORMULARIO ClientData-->
	function inValidationIDNumber(val) {
		var val = document.forms["formQuestionClientData"]["<portlet:namespace/>IDNumber"].value;
		if (val.length < 10) {
			document.getElementById("validationIDNumber").hidden = false;
			document.getElementById("xIDNumber").hidden = false;
			var elem = document.getElementById('IDNumber');
			elem.className = "invalid";
		}
	}

	function validateClientData() {
		var name = document.forms["formQuestionClientData"]["<portlet:namespace/>name"].value;
		var lastname = document.forms["formQuestionClientData"]["<portlet:namespace/>lastname"].value;
		var IDNumber = document.forms["formQuestionClientData"]["<portlet:namespace/>IDNumber"].value;

		console.log("name" + name);
		console.log("lastname" + lastname);
		console.log("IDNumber" + IDNumber);

		var result = false;

		if (name.length == 0) {
			document.getElementById("validationName").hidden = false;
			document.getElementById("xName").hidden = false;
			var elem = document.getElementById('name');
			elem.className = "invalid";
		} else if (lastname.length == 0) {
			document.getElementById("validationLastname").hidden = false;
			document.getElementById("xLastname").hidden = false;
			var elem = document.getElementById('lastname');
			elem.className = "invalid";
		} else if (IDNumber.length == 0) {
			document.getElementById("validationIDNumber").hidden = false;
			document.getElementById("xIDNumber").hidden = false;
			var elem = document.getElementById('IDNumber');
			elem.className = "invalid";
		} else {
			var res = isValidId(IDNumber);
			console.log("VALIDATIO IDNumber" + res);
			if (res == undefined || res == false) {
				document.getElementById("validationIDNumber").hidden = false;
				document.getElementById("xIDNumber").hidden = false;
				var elem = document.getElementById('IDNumber');
				elem.className = "invalid";
				result = false;
			} else {
				result = true;
			}
		}

		return result;
	}
	
	
	<!-- CLASE PARA VALIDACIONES EN FRONT DEL FORMULARIO SendChipData-->
	function validateSendChipData() {
		console.log("VALIDACION FORMULARIO");
		var province = document.forms["formQuestionSendChipData"]["<portlet:namespace/>province"].value;
		var city = document.forms["formQuestionSendChipData"]["<portlet:namespace/>city"].value;
		var principalStreet = document.forms["formQuestionSendChipData"]["<portlet:namespace/>principalStreet"].value;
		var secondaryStreet = document.forms["formQuestionSendChipData"]["<portlet:namespace/>secondaryStreet"].value;
		var buildingNumber = document.forms["formQuestionSendChipData"]["<portlet:namespace/>buildingNumber"].value;
		var contactNumber = document.forms["formQuestionSendChipData"]["<portlet:namespace/>contactNumber"].value;

		var v = 0;
		province.length == 0 ? enableError('province') : v++;
		city.length == 0 ? enableError('city') : v++;
		principalStreet.length == 0 ? enableError('principalStreet') : v++;
		secondaryStreet.length == 0 ? enableError('secondaryStreet') : v++;
		buildingNumber.length == 0 ? enableError('buildingNumber') : v++;
		contactNumber.length == 0 ? enableError('contactNumber') : v++;

		console.log("validaciones:::" + v);
		if (v == 6) {
			dlTrackEvent('Movistar Libre - envio de chip', province, city)
			return true;
		} else {
			return false;
		}
	}

	function enableError(parameter) {
		var capitalizeParameter = parameter.charAt(0).toUpperCase()
				+ parameter.slice(1);
		document.getElementById("validation" + capitalizeParameter).hidden = false;
		document.getElementById("x" + capitalizeParameter).hidden = false;
		var elem = document.getElementById(parameter);
		elem.className = "invalid";
	}

	function cleanSendChipData(field) {
		setClassInput('province');
		setClassInput('city');
		setClassInput('principalStreet');
		setClassInput('secondaryStreet');
		setClassInput('buildingNumber');
		setClassInput('contactNumber');

	}

	function setClassInput(field) {
		var capitalizeParameter = field.charAt(0).toUpperCase()
				+ parameter.slice(1);
		document.getElementById("validation" + capitalizeParameter).hidden = true;
		document.getElementById("x" + capitalizeParameter).hidden = true;
		var elem = document.getElementById(parameter);
		elem.className = "name-field";

	}
	
	
</script>