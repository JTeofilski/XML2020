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

function Zahtev(x){
	var brojac=0;
	for(i=0;i<x.length-1;i++){
		for( j=i+1; j<x.length; j++){
			if (x[i].agent.ime==x[j].agent.ime){
				brojac++;
			}
		}
	}
	console.log(brojac);
	if(brojac>0){
		if (confirm('Imate vise odlasa od istog agenta, da li zelite da napravite bundle?')) {
			  // Save it!
			  console.log('Potvrda bundla');
			  
			} else {
			  // Do nothing!
			  console.log('Salju se pojedinacni zahtevi');
			}
	}
}