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