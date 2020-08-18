//Variables
var canvas = document.getElementById("canvas");
let btnVolverIntentar = document.getElementById('btnVolverIntentar');
var btnContinue = document.getElementById('btnContinue');
var ctx = canvas.getContext("2d");
var cw = canvas.width = 500,
  cx = cw / 2;
var ch = canvas.height = 200,
  cy = ch / 2;

var dibujar = false;
var factorDeAlisamiento = 5;
var puntos = [];
ctx.lineJoin = "round";

canvas.addEventListener('mousedown', function(evt) {
  dibujar = true;
}, false);

canvas.addEventListener('mouseup', function(evt) {
  redibujarTrazado();
}, false);

canvas.addEventListener("mouseout", function(evt) {
  redibujarTrazado();
}, false);
//Clean canvas
btnVolverIntentar.addEventListener("click", function(){
    ctx.clearRect(0, 0, cw, ch);
    puntos.length = 0;
    ctx.beginPath();
},false);

canvas.addEventListener("mousemove", function(evt) {
  if (dibujar) {
    var m = oMousePos(canvas, evt);
    puntos.push(m);
    ctx.lineTo(m.x, m.y);
    ctx.stroke();
  }
}, false);

function reducirArray(n, elArray) {
  var nuevoArray = [];
  nuevoArray[0] = elArray[0];
  for (var i = 1; i < elArray.length; i++) {
    if (i % n == 0) {
      nuevoArray[nuevoArray.length] = elArray[i];
    }
  }
  nuevoArray[nuevoArray.length - 1] = elArray[elArray.length - 1];
  return nuevoArray;
}

function calcularPuntoDeControl(a, b) {
  var pc = {}
  pc.x = (a.x + b.x) / 2;
  pc.y = (a.y + b.y) / 2;
  return pc;
}

function alisarTrazado(ry) {
  if (ry.length > 1) {
    var ultimoPunto = ry.length - 1;
    ctx.beginPath();
    ctx.moveTo(ry[0].x, ry[0].y);
    for (i = 1; i < ry.length - 2; i++) {
      var pc = calcularPuntoDeControl(ry[i], ry[i + 1]);
      ctx.quadraticCurveTo(ry[i].x, ry[i].y, pc.x, pc.y);
    }
    ctx.quadraticCurveTo(ry[ultimoPunto - 1].x, ry[ultimoPunto - 1].y, ry[ultimoPunto].x, ry[ultimoPunto].y);
    ctx.stroke();
  }
}

function redibujarTrazado() {
  dibujar = false;
  ctx.clearRect(0, 0, cw, ch);
  var nuevoArray = reducirArray(factorDeAlisamiento, puntos);
  alisarTrazado(nuevoArray);
}

function oMousePos(canvas, evt) {
  var ClientRect = canvas.getBoundingClientRect();
  return { //objeto
    x: Math.round(evt.clientX - ClientRect.left),
    y: Math.round(evt.clientY - ClientRect.top)
  }
}

function capcha_filled () {
    allowSubmit = true;
}

function capcha_expired () {
    allowSubmit = false;
}

btnContinue.addEventListener("click", function(e){
    console.log("validando firma");
    var googleResponse = document.querySelector('.g-recaptcha');
    googleResponse = grecaptcha.getResponse();
    var isEmpty = function(ctx) {
    	var data = ctx.getImageData(0,0, canvas.width, canvas.height).data;
    	return !Array.prototype.some.call(data, function(p) {
        	return p>0;
        });
    }
    
    if(isEmpty(ctx))
    {
    	document.getElementById("validationCanvas").hidden = false;
    } 
    else if (googleResponse.length == 0) 
    {
    	document.getElementById("validationRecaptcha").hidden = false;
    }
    else
    {
    	console.log("firmado");
    	document.getElementById("validationCanvas").hidden = true;
    	document.getElementById("validationRecaptcha").hidden = true;
    	return true;
    }
    e.preventDefault();   
},false);


