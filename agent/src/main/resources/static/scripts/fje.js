function OdobriZahtev(idZahteva, idAgenta){
	console.log(idZahteva);
	 $.ajax({
	        url: "http://localhost:8099/zahtevi/odobri/"+idZahteva, 
	   		type: "GET",
	   		contentType: "application/json",
	   		datatype: 'json',
	    	   success: function(data){
	    		   if (data.includes("otkazan")){
	    			   alert(data);
		    		   window.location.href = "http://localhost:8099/zahtevi.html?id="+idAgenta;

	    		   }

	    	   }
	    		   
	 });	 	
}


function Rezervacija(){
	var vozilo = document.getElementById("vozila");
	var oglasId = vozilo.options[vozilo.selectedIndex].value;
	
	var datumOd = document.getElementById("datumOd").value;
	var datumDo = document.getElementById("datumDo").value;
	 $.ajax({
	        url: "http://localhost:8099/oglasi/rezervacija/"+datumOd+"/"+datumDo+"/"+oglasId, 
	   		type: "GET",
	   		contentType: "application/json",
	   		datatype: 'json',
	    	   success: function(data){
	    		   
	    		   console.log("Uspesno");
	    	   }
	    		   
	 });	 	

}


function Izvestaj(idAgenta, idOglasa, idNarudzbenice){
	console.log(idNarudzbenice);
	

	var labelaBrKilometara = document.createElement("LABEL");
	var textKilometri = document.createElement("TEXTAREA");
	var textLabeleKm = document.createTextNode("Broj kilometara:");   
	labelaBrKilometara.appendChild(textLabeleKm);
	textKilometri.setAttribute("id", "kilometri");
	labelaBrKilometara.setAttribute("id", "labelaKilometri");
	
	var labelaIzvestaj = document.createElement("LABEL");
	var textIzvestaj = document.createElement("TEXTAREA");
	var textLabeleIzvestaj = document.createTextNode("Dodatne informacije:");   
	labelaIzvestaj.appendChild(textLabeleIzvestaj);
	textIzvestaj.setAttribute("id", "izvestaj");
	labelaIzvestaj.setAttribute("id", "labelaIzvestaj");

	
	
	
	var prosledi=document.createElement("BUTTON");
	var textProsledi = document.createTextNode("Prosledi");   
	prosledi.appendChild(textProsledi);
	prosledi.setAttribute("id", "dugme");
	
	
	document.getElementById("n"+idNarudzbenice).appendChild(labelaBrKilometara);
	document.getElementById("n"+idNarudzbenice).appendChild(textKilometri);
	
	document.getElementById("n"+idNarudzbenice).appendChild(labelaIzvestaj);
	document.getElementById("n"+idNarudzbenice).appendChild(textIzvestaj);
	
	document.getElementById("n"+idNarudzbenice).appendChild(prosledi);
	
	
	prosledi.setAttribute("onclick", "ProslediIzvestaj("+idAgenta+","+idOglasa+","+idNarudzbenice+")"); 

}


function ProslediIzvestaj (idAgenta, idOglasa, idNarudzbenice ){
	
var kilometri=document.getElementById("kilometri").value;
var izvestaj=document.getElementById("izvestaj").value;

	
	var formData = JSON.stringify({
		idAgenta:idAgenta,
		brKilometara:kilometri,
		dodatneInformacije:izvestaj    
      });
	
	 $.ajax({
	        url: "http://localhost:8099/izvestaji/"+idOglasa, 
	   		type: "POST",
	   		data: formData,
	   		contentType: "application/json",
	   		datatype: 'json',
	    	   success: function(data){	   
	    		   alert("dodat izvestaj");
	    		   var dugme=document.getElementById("kilometri");
	    		   dugme.parentNode.removeChild(dugme);
	    		   
	    		   var komentar=document.getElementById("izvestaj");
	    		   komentar.parentNode.removeChild(komentar);
	    		   
	    		   var labela=document.getElementById("labelaIzvestaj");
	    		   labela.parentNode.removeChild(labela);
	    		   
	    		   var labelaKm=document.getElementById("labelaKilometri");
	    		   labelaKm.parentNode.removeChild(labelaKm);
	    	   }	 
	    	   });
	
	
	
}