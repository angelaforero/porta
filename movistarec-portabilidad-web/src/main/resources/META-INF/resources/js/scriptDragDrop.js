
var container = document.querySelector(".container-dashed");
var inputFileFront = document.getElementById("inpFileFront");
var inputFileBack = document.getElementById("inpFileBack");
var uploadFile = document.getElementById("uploadFile");
var invalidFile = document.getElementById("invalidFile");
//Variables Img front
const previewContainerFront = document.getElementById("img-document-front")
const previewImageFront = previewContainerFront.querySelector(".image-preview-front__image");
const previewImageDefaultFront = previewContainerFront.querySelector(".img-vo");
//Variables Img Back
const previewContainerBack = document.getElementById("img-document-back")
const previewImageBack = previewContainerBack.querySelector(".image-preview-back__image");
const previewImageDefaultBack = previewContainerBack.querySelector(".img-vo2");

//Drog and Drop input front
document.querySelectorAll(".drop-zone__input").forEach((inputElement) => {
	
	const dropZoneElement = inputElement.closest(".img-document-front");
	dropZoneElement.addEventListener("click", (e) => {
		inputElement.click();
	})
	
	dropZoneElement.addEventListener("dragover", (e) => {
      e.preventDefault();
      dropZoneElement.classList.add("drop-zone--over");
      container.style.backgroundColor = '#019DF414';
    });
	
	["dragleave", "dragend"].forEach((type) => {
      dropZoneElement.addEventListener(type, (e) => {
        dropZoneElement.classList.remove("drop-zone--over");
        inputFileFront.style.display = 'none'
      });
    });
	
	dropZoneElement.addEventListener("drop", (e) => {
		
	      e.preventDefault();
	      if (e.dataTransfer.files.length) 
	      {
	    	  inputElement.files = e.dataTransfer.files;
	    	  for(const file of inputFileFront.files)
	    	  {
	      		var ext = file.name.substring(file.name.lastIndexOf('.')+1).toLowerCase();
	      		if ((ext == 'jpg') || (ext == 'png') && file.size < 2100000)
	      		{
	      			if(file) 
	      			{
	      	    		const reader = new FileReader();
	      	    		previewImageDefaultFront.style.display = "none";
	      	    		previewImageFront.style.display = "block";
	      	    		
	      	    		reader.addEventListener("load", function() {
	      	    			//console.log(this);
	      	    			previewImageFront.setAttribute("src", this. result);
	      	    		});
	      	    		
	      	    		reader.readAsDataURL(file);
	      	    	} else 
	      	    	{
	      	    		previewImageDefaultFront.style.display = null;
	      	    		previewImageFront.style.display = null;
	      	    		previewImageFront.setAttribute("src", "");
	      	    	}
	      		} else 
	      		{
	      			showInvalidFile();
	              	inputFileFront.value = "";
	            }
		      }
	      }
	      dropZoneElement.classList.remove("drop-zone--over");
	      container.style.backgroundColor = '#FFFFFF';
	    });
	
	inputElement.addEventListener("change", (e) => {
		
    	for(const file of inputFileFront.files)
    	{
    		var ext = file.name.substring(file.name.lastIndexOf('.')+1).toLowerCase();
    		if ((ext == 'jpg') || (ext == 'png') && file.size < 2100000)
    		{
    			if(file) 
    			{
    	    		const reader = new FileReader();
    	    		previewImageDefaultFront.style.display = "none";
    	    		previewImageFront.style.display = "block";
    	    		
    	    		reader.addEventListener("load", function() {
    	    			//console.log(this);
    	    			previewImageFront.setAttribute("src", this. result);
    	    		});
    	    		
    	    		reader.readAsDataURL(file);
    	    	} else 
    	    	{
    	    		previewImageDefaultFront.style.display = null;
    	    		previewImageFront.style.display = null;
    	    		previewImageFront.setAttribute("src", "");
    	    	}
            } else 
            {
            	showInvalidFile();
            	inputFileFront.value = "";
            }
    	}
	});
});

//Drog and Drop input back
document.querySelectorAll(".drop-zone__input2").forEach((inputElement2) => {
	
	const dropZoneElement2 = inputElement2.closest(".img-document-back");
	dropZoneElement2.addEventListener("click", (e) => {
		inputElement2.click();
	})
	
	dropZoneElement2.addEventListener("dragover", (e) => {
      e.preventDefault();
      dropZoneElement2.classList.add("drop-zone--over");
      container.style.backgroundColor = '#019DF414';
    });
	
	["dragleave", "dragend"].forEach((type) => {
      dropZoneElement2.addEventListener(type, (e) => {
        dropZoneElement2.classList.remove("drop-zone--over");
      });
    });
	
	dropZoneElement2.addEventListener("drop", (e) => {
		
	      e.preventDefault();
	      /*if (e.dataTransfer.files.length) {
	        inputElement.files = e.dataTransfer.files;
	        updateThumbnail(dropZoneElement, e.dataTransfer.files[0]);
	      }*/
	      if (e.dataTransfer.files.length) 
	      {
	    	  inputElement2.files = e.dataTransfer.files;
	    	  for(const fileBack of inputFileBack.files)
	    	  {
	      		var ext2 = fileBack.name.substring(fileBack.name.lastIndexOf('.')+1).toLowerCase();
	      		if ((ext2 == 'jpg') || (ext2 == 'png') && fileBack.size < 2100000)
	      		{
	      			if(fileBack) 
	      			{
	      	    		const readerBack = new FileReader();
	      	    		previewImageDefaultBack.style.display = "none";
	      	    		previewImageBack.style.display = "block";
	      	    		
	      	    		readerBack.addEventListener("load", function() {
	      	    			//console.log(this);
	      	    			previewImageBack.setAttribute("src", this. result);
	      	    		});
	      	    		
	      	    		readerBack.readAsDataURL(fileBack);
	      	    	} else 
	      	    	{
	      	    		previewImageDefaultBack.style.display = null;
	      	    		previewImageBack.style.display = null;
	      	    		previewImageBack.setAttribute("src", "");
	      	    	}
	      		} else 
	      		{
	      			showInvalidFile();
	              	inputFileBack.value = "";
	      		}
  			 }
	      }
	      dropZoneElement2.classList.remove("drop-zone--over");
	      container.style.backgroundColor = '#FFFFFF';
	    });
	
	inputElement2.addEventListener("change", (e) => {
		
		for(const fileBack of inputFileBack.files)
    	{
    		var ext2 = fileBack.name.substring(fileBack.name.lastIndexOf('.')+1).toLowerCase();
    		if ((ext2 == 'jpg') || (ext2 == 'png') && fileBack.size < 2100000)
    		{
    			if(fileBack) 
    			{
    	    		const readerBack = new FileReader();
    	    		previewImageDefaultBack.style.display = "none";
    	    		previewImageBack.style.display = "block";
    	    		
    	    		readerBack.addEventListener("load", function() {
    	    			//console.log(this);
    	    			previewImageBack.setAttribute("src", this. result);
    	    		});
    	    		
    	    		readerBack.readAsDataURL(fileBack);
    	    	} else 
    	    	{
    	    		previewImageDefaultBack.style.display = null;
    	    		previewImageBack.style.display = null;
    	    		previewImageBack.setAttribute("src", "");
    	    	}
            } else 
            {
            	showInvalidFile();
            	inputFileBack.value = "";
            }
    	}
    	
	});
});


//btn onclik 'buscar-archivo'
const fileUpload = () => {
	
	var banderilla = 0;
    if (inputFileFront.value == "") 
    {
    	banderilla = 1;
    	showUploadFile();
    	inputFileFront.click();
    }
    else if (inputFileBack.value == "") 
    {
    	banderilla = 2;
    	showUploadFile();
    	inputFileBack.click();
    } 
    
    //console.log(banderilla);
    	
    //Change input front
    inputFileFront.addEventListener("change", function(){
    	
    	for(const file of inputFileFront.files)
    	{
    		var ext = file.name.substring(file.name.lastIndexOf('.')+1).toLowerCase();
    		if ((ext == 'jpg') || (ext == 'png') && file.size < 2100000)
    		{
    			if(file) 
    			{
    	    		const reader = new FileReader();
    	    		previewImageDefaultFront.style.display = "none";
    	    		previewImageFront.style.display = "block";
    	    		
    	    		reader.addEventListener("load", function() {
    	    			//console.log(this);
    	    			previewImageFront.setAttribute("src", this. result);
    	    		});
    	    		
    	    		reader.readAsDataURL(file);
    	    	} else 
    	    	{
    	    		previewImageDefaultFront.style.display = null;
    	    		previewImageFront.style.display = null;
    	    		previewImageFront.setAttribute("src", "");
    	    	}
            } else 
            {
            	showInvalidFile();
            	inputFileFront.value = "";
            }
    	}
    });
    
    //Change input back
    inputFileBack.addEventListener("change", function(){
    	
    	for(const fileBack of inputFileBack.files)
    	{
    		var ext2 = fileBack.name.substring(fileBack.name.lastIndexOf('.')+1).toLowerCase();
    		if ((ext2 == 'jpg') || (ext2 == 'png') && fileBack.size < 2100000)
    		{
    			if(fileBack) 
    			{
    	    		const readerBack = new FileReader();
    	    		previewImageDefaultBack.style.display = "none";
    	    		previewImageBack.style.display = "block";
    	    		
    	    		readerBack.addEventListener("load", function() {
    	    			//console.log(this);
    	    			previewImageBack.setAttribute("src", this. result);
    	    		});
    	    		
    	    		readerBack.readAsDataURL(fileBack);
    	    	} else 
    	    	{
    	    		previewImageDefaultBack.style.display = null;
    	    		previewImageBack.style.display = null;
    	    		previewImageBack.setAttribute("src", "");
    	    	}
            } else 
            {
            	showInvalidFile();
            	inputFileBack.value = "";
            }
    	}
    });
}

//Show and hidden, upload and invalid file
function showUploadFile(){
	invalidFile.style.display = 'none' ? 'none' : null;
	uploadFile.style.display = 'block' ? 'block' : null;
}

function showInvalidFile(){
	invalidFile.style.display = 'block' ? 'block' : null;
	uploadFile.style.display = 'none' ? 'none' : null;
}

//Validate document img
function  validateImgDocument() {
	
	var fileFront = document.getElementById("inpFileFront").value;
	var fileBack = document.getElementById("inpFileBack").value;
	
	if(fileFront === null || fileFront === '' || fileFront === 0){
		document.getElementById("validationInputFront").hidden = false;
		var elem = document.getElementById('img-document-front');
		elem.className = "invalidate-error";
		return false;
	} 
	
	if(fileBack === null || fileBack === '' || fileBack === 0){
		document.getElementById("validationInputBack").hidden = false;
		var elem = document.getElementById('img-document-back');
		elem.className = "invalidate-error";
		return false;
	}
		return true;
}