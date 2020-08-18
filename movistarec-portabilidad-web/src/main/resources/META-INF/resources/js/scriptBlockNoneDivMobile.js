function showContinueMobile(idButton) {
	    var screenOneMobile = document.getElementById('screen1-mobile');
	    var screenTwoMobile = document.getElementById('screen2-mobile');
	    var screenThreeMobile = document.getElementById('screen3-mobile');
	    var screenFourMobile = document.getElementById('screen4-mobile');
	    var screenFiveMobile = document.getElementById('screen5-mobile');
	    var screenSixMobile = document.getElementById('screen6-mobile');
	    
	    switch (idButton) {
	        case 1:
	            screenOneMobile.style.display = 'block';
	            screenTwoMobile.style.display = 'none';
	            screenThreeMobile.style.display = 'none';
	            screenFourMobile.style.display = 'none';
	            screenFiveMobile.style.display = 'none';
	            screenFiveMobile.style.display = 'none';
	            break;

	        case 2:
	            screenOneMobile.style.display = 'none';
	            screenTwoMobile.style.display = 'block';
	            screenThreeMobile.style.display = 'none';
	            screenFourMobile.style.display = 'none';
	            screenFiveMobile.style.display = 'none';
	            screenSixMobile.style.display = 'none';
	            break;

	        case 3:
	            screenOneMobile.style.display = 'none';
	            screenTwoMobile.style.display = 'none';
	            screenThreeMobile.style.display = 'block';
	            screenFourMobile.style.display = 'none';
	            screenFiveMobile.style.display = 'none';
	            screenSixMobile.style.display = 'none';
	            break;

	        case 4:
	            screenOneMobile.style.display = 'none';
	            screenTwoMobile.style.display = 'none';
	            screenThreeMobile.style.display = 'none';
	            screenFourMobile.style.display = 'block';
	            screenFiveMobile.style.display = 'none';
	            screenSixMobile.style.display = 'none';
	            break;

	        case 5:
	            screenOneMobile.style.display = 'none';
	            screenTwoMobile.style.display = 'none';
	            screenThreeMobile.style.display = 'none';
	            screenFourMobile.style.display = 'none';
	            screenFiveMobile.style.display = 'block';
	            screenSixMobile.style.display = 'none';
	            break;
	            
	        case 6:
	            screenOneMobile.style.display = 'none';
	            screenTwoMobile.style.display = 'none';
	            screenThreeMobile.style.display = 'none';
	            screenFourMobile.style.display = 'none';
	            screenFiveMobile.style.display = 'none';
	            screenSixMobile.style.display = 'block';
	            break;

	        default:
	            alert("hay un problema: No existe la pantalla.")
	    }
	}
