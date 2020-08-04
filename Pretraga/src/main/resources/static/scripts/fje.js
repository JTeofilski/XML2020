function Korpafja(x){ 
	//window.location.href = "http://localhost:2020/pretragaapp/korpa/"+x; 
	
	var sesija= sessionStorage.getItem("attr");
	alert(sesija);
	window.location.href = "http://localhost:2020/pretragaapp/korpa.html?id="+x;
			 
}


function Fja(x){ 
	window.location.href = "http://localhost:2020/pretragaapp/detPrikaz.html?id="+x; 
			 
}
