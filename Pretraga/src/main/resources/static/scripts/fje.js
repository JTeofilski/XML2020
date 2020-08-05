function Korpafja(x,korid){ 
	//window.location.href = "http://localhost:2020/pretragaapp/korpa/"+x; 
	
	
	window.location.href = "http://localhost:2020/pretragaapp/korpa.html?id="+x+"&korid="+korid;
			 
}


function Fja(x){ 
	window.location.href = "http://localhost:2020/pretragaapp/detPrikaz.html?id="+x; 
			 
}

function Brisanjefja(x,korid){ 
	 $.ajax({
	        url: "http://localhost:2020/pretragaapp/oglasi/korpa/"+x+"/"+korid, 
	   		type: "DELETE",
	   		contentType: "application/json",
	   		datatype: 'json',
	    	   success: function(data){	   
	    		   window.location.href = "http://localhost:2020/pretragaapp/korpa.html?id="+0+"&korid="+korid;
	    		   }	 
	    	   });
}
