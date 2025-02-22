/*const tieneSoporteUserMedia = () =>
    !!(navigator.getUserMedia || (navigator.mozGetUserMedia || navigator.mediaDevices.getUserMedia) || navigator.webkitGetUserMedia || navigator.msGetUserMedia)
const _getUserMedia = (...arguments) =>
    (navigator.getUserMedia || (navigator.mozGetUserMedia || navigator.mediaDevices.getUserMedia) || navigator.webkitGetUserMedia || navigator.msGetUserMedia).apply(navigator, arguments);
// Declaramos elementos en el Dom
const $video = document.querySelector("#video"),
$canvas = document.querySelector("#canvas"),
$boton = document.querySelector("#boton"),
$listaDeDispositivos = document.querySelector("#listaDeDispositivos");

const limpiarSelect = () => {
    for(let x = $listaDeDispositivos.options.length; x > 0; x--)
    $listaDeDispositivos.remove(x);
}

const obtenerDispositivos = () => navigator
    .mediaDevices
    .enumerateDevices();



// La función que es llamada después de que ya se dieron los permisos
// Lo que hace es llenar el select con los dispositivos obtenidos
const llenarSelectConDispositivosDisponibles = () => {

    limpiarSelect();
    obtenerDispositivos()
        .then(dispositivos => {
            const dispositivosDeVideo = [];
            dispositivos.forEach(dispositivo => {
                const tipo = dispositivo.kind;
                if (tipo === "videoinput") {
                    dispositivosDeVideo.push(dispositivo);
                }
            });

            // Vemos si encontramos algún dispositivo, y en caso de que si,
			// entonces llamamos a la función
            if (dispositivosDeVideo.length > 0) {
                // Llenar el select
                dispositivosDeVideo.forEach(dispositivo => {
                    const option = document.createElement('option');
                    option.value = dispositivo.deviceId;
                    option.text = dispositivo.label;
                    $listaDeDispositivos.appendChild(option);
                });
            }
        });
}



(function (){
    if(!tieneSoporteUserMedia()){
        alert("lo siento. tu navegador no soporta esta caracteristica");
        $estado.innerHTML = "Parece que no soporta es";
        return;
    }

    let stream;
    obtenerDispositivos()
        .then(dispositivos => {
            const dispositivosDeVideo = [];
            dispositivos.forEach(dispositivo => {
                const tipo = dispositivo.kind;
                if (tipo === "videoinput") {
                    dispositivosDeVideo.push(dispositivo);
                }
            });
            if (dispositivosDeVideo.length > 0) {
                mostrarStream(dispositivosDeVideo[0].deviceId);
            }
        });

        const mostrarStream = idDeDispositivo => {
            _getUserMedia({
                    video: {
                        // Justo aquí indicamos cuál dispositivo usar
                        deviceId: idDeDispositivo,
                    }
                },
                (streamObtenido) => {
                    // Aquí ya tenemos permisos, ahora sí llenamos el select,
                    // pues si no, no nos daría el nombre de los dispositivos
                    llenarSelectConDispositivosDisponibles();
        
                    // Escuchar cuando seleccionen otra opción y entonces llamar
					// a esta función
                    $listaDeDispositivos.onchange = () => {
                        // Detener el stream
                        if (stream) {
                            stream.getTracks().forEach(function(track) {
                                track.stop();
                            });
                        }
                        // Mostrar el nuevo stream con el dispositivo
						// seleccionado
                        mostrarStream($listaDeDispositivos.value);
                    }
        
                    // Simple asignación
                    stream = streamObtenido;
        
                    // Mandamos el stream de la cámara al elemento de vídeo
                    $video.srcObject = stream;
                    $video.play();

                    // Escuchar el click del botón para tomar la foto
                    $boton.addEventListener("click", function() {

                        // Pausar reproducción
                        $video.pause();

                        // Obtener contexto del canvas y dibujar sobre él
                        let contexto = $canvas.getContext("2d");
                        $canvas.width = $video.videoWidth;
                        $canvas.height = $video.videoHeight;
                        contexto.drawImage($video, 0, 0, $canvas.width, $canvas.height);

                        let foto = $canvas.toDataURL(); // Esta es la foto, en
														// base 64

                        let enlace = document.createElement('a'); // Crear un
																	// <a>
                        enlace.download = "foto_parzibyte.me.png";
                        enlace.href = foto;
                        enlace.click();
                        // Reanudar reproducción
                        $video.play();
                    });
        
                    
                }, (error) => {
                    console.log("Permiso denegado o error: ", error);
                    $estado.innerHTML = "No se puede acceder a la cámara, o no diste permiso.";
                });
        }
        
})();*/