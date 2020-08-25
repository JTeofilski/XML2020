function OdobriKomentar(id){
	 $.ajax({
	        url: "http://localhost:2020/adminservisapp/komentari/odobri/"+id, 
	   		type: "GET",
	   		contentType: "application/json",
	   		datatype: 'json',
	    	   success: function(data){	   
	    		  window.location.href= "http://localhost:2020/adminservisapp/komentari.html";
	    	   }
	    	   });
	
}