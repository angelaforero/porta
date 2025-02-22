const video = document.getElementById('video');
const snap = document.getElementById("snap");
const canvas = document.getElementById('canvas');
const errorMsgElement = document.querySelector('span#errorMsg');

const constraints = {
	audio : false,
	video : {
		width : 320,
		height : 200
	}
};

// Acceso a la webcam
async function init() {
	try {
		const stream = await
		navigator.mediaDevices.getUserMedia(constraints);
		handleSuccess(stream);
	} catch (e) {
		errorMsgElement.innerHTML = `navigator.getUserMedia error:${e.toString()}`;
	}
}
// Correcto!
function handleSuccess(stream) {
	window.stream = stream;
	video.srcObject = stream;
}
// Load init
init();
// Dibuja la imagen
var context = canvas.getContext('2d');
snap.addEventListener("click", function() {
	context.drawImage(video, 0, 0, 100, 63);
});

//Guarda la imagen
function guardarImagen(canvas) {
	var datosCanvas = canvas.toDataURL();
	document.getElementById("").src = datosCanvas;
}