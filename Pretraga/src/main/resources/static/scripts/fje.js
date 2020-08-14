function Korpafja(x,korid,voziloSlobodnoOd,voziloSlobodnoDo){ 
	//window.location.href = "http://localhost:2020/pretragaapp/korpa/"+x; 
	//var d=voziloSlobodnoOd.toString().replace(/ /g, '-');

	window.location.href = "http://localhost:2020/pretragaapp/korpa.html?id="+x+"&korid="+korid+"&rezOd="+voziloSlobodnoOd+"&rezDo="+voziloSlobodnoDo;
			 
}


function Fja(x){ 
	window.location.href = "http://localhost:2020/pretragaapp/detPrikaz.html?id="+x; 
			 
}

function Brisanjefja(x,korid){ 
	 $.ajax({
	        url: "http://localhost:2020/pretragaapp/narudzbenice/"+x+"/"+korid, 
	   		type: "DELETE",
	   		contentType: "application/json",
	   		datatype: 'json',
	    	   success: function(data){	   
	    		   window.location.href = "http://localhost:2020/pretragaapp/korpa.html?id="+0+"&korid="+korid;
	    		   }	 
	    	   });
}

function Zahtev(x, korid){
	var brojac=0;
	for(i=0;i<x.length-1;i++){
		for( j=i+1; j<x.length; j++){
			if (x[i].agentId==x[j].agentId){
				brojac++;
			}
		}
	}
	
	if(brojac>0){
		if (confirm('Imate vise odlasa od istog agenta, da li zelite da napravite bundle?')) {
			  // Save it!
			  
			 
			  var formData = JSON.stringify(x);
			 // console.log(formData);
			  $.ajax({
			        url: "http://localhost:2020/zahtevzaiznajmljivanjeapp/zahtevi/kreiranje/"+true+"/"+korid, 
			   		type: "POST",
			   		data: formData,
			   		contentType: "application/json",
			   		datatype: 'json',
			    	   success: function(data){	   
			    		   window.location.href = "http://localhost:2020/pretragaapp/oglasi.html?id="+korid;
			    	   }	 
			    	   });
		
			  
			} else {
			  // Do nothing!
			 // console.log('Salju se pojedinacni zahtevi');
				var formData = JSON.stringify(x);
				 // console.log(formData);
				  $.ajax({
				        url: "http://localhost:2020/zahtevzaiznajmljivanjeapp/zahtevi/kreiranje/"+false+"/"+korid, 
				   		type: "POST",
				   		data: formData,
				   		contentType: "application/json",
				   		datatype: 'json',
				    	   success: function(data){	   
				    		   window.location.href = "http://localhost:2020/pretragaapp/oglasi.html?id="+korid;
				    	   }	 
				    	   });
			}
	}
	else {
		var formData = JSON.stringify(x);
		 // console.log(formData);
		  $.ajax({
		        url: "http://localhost:2020/zahtevzaiznajmljivanjeapp/zahtevi/kreiranje/"+false+"/"+korid, 
		   		type: "POST",
		   		data: formData,
		   		contentType: "application/json",
		   		datatype: 'json',
		    	   success: function(data){	   
		    		   window.location.href = "http://localhost:2020/pretragaapp/oglasi.html?id="+korid;
		    	   }	 
		    	   });
		
	}

}