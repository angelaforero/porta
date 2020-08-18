function showContinue(idButton) {
	    var screen1 = document.getElementById('screen1');
	    var screen2 = document.getElementById('screen2');
	    var screen3 = document.getElementById('screen3');
	    var screen4 = document.getElementById('screen4');
	    var screen5 = document.getElementById('screen5');

	    switch (idButton) {
	        case 1:
	            screen1.style.display = 'block' ? 'block' : null;
	            screen2.style.display = 'none' ? 'none' : null;
	            screen3.style.display = 'none' ? 'none' : null;
	            screen4.style.display = 'none' ? 'none' : null;
	            screen5.style.display = 'none' ? 'none' : null;
	            break;

	        case 2:
	            screen1.style.display = 'none' ? 'none' : null;
	            screen2.style.display = 'block' ? 'block' : null;
	            screen3.style.display = 'none' ? 'none' : null;
	            screen4.style.display = 'none' ? 'none' : null;
	            screen5.style.display = 'none' ? 'none' : null;
	            break;

	        case 3:
	            screen1.style.display = 'none' ? 'none' : null;
	            screen2.style.display = 'none' ? 'none' : null;
	            screen3.style.display = 'block' ? 'block' : null;
	            screen4.style.display = 'none' ? 'none' : null;
	            screen5.style.display = 'none' ? 'none' : null;
	            break;

	        case 4:
	            screen1.style.display = 'none' ? 'none' : null;
	            screen2.style.display = 'none' ? 'none' : null;
	            screen3.style.display = 'none' ? 'none' : null;
	            screen4.style.display = 'block' ? 'block' : null;
	            screen5.style.display = 'none' ? 'none' : null;
	            break;

	        case 5:
	            screen1.style.display = 'none' ? 'none' : null;
	            screen2.style.display = 'none' ? 'none' : null;
	            screen3.style.display = 'none' ? 'none' : null;
	            screen4.style.display = 'none' ? 'none' : null;
	            screen5.style.display = 'block' ? 'block' : null;
	            break;
            
	        default:
	            alert("hay un problema: No existe la pantalla.")
	    }
	}
