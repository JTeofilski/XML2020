function OdobriZahtev(idZahteva){
	 $.ajax({
	        url: "http://localhost:8099/zahtevi/odobri"+idZahteva, 
	   		type: "GET",
	   		contentType: "application/json",
	   		datatype: 'json',
	    	   success: function(data){	
	    	   
	    	   }
	 });
}