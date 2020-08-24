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

function Ocena(ocena,korisnik, oglasId){
	var formData = JSON.stringify({
		  vrednostOcene:ocena,
		  kreatorOceneID:korisnik,
		 
         
          
      });
	$.ajax({
		url: "http://localhost:2020/ocenaapp/ocene/"+oglasId,
		type: "POST",
		data: formData,
		//saljemo json i ocekujemo json nazad
		contentType: "application/json",
		datatype: 'json',
		success: function(result){
			
			
		alert("uspesna ocena!")
		//window.location.href = "http://localhost:2020/pretragaapp/oglasi.html?id=" + result.identifikacioniBroj;	 
		}
	});

}

function Zvezdice(zahtevId,korisnikId,idOglasa){
	return '<fieldset class="rating">'
	+ '<input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars" onclick="Ocena(5,'+korisnikId+","+idOglasa+');"></label>'
	   + ' <input type="radio" id="star4half" name="rating" value="4 and a half" /><label class="half" for="star4half" title="Pretty good - 4.5 stars" onclick="Ocena(4.5,'+korisnikId+","+idOglasa+');"></label>'
	   +'  <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars" onclick="Ocena(4,'+korisnikId+","+idOglasa+');"></label>'
	   +' <input type="radio" id="star3half" name="rating" value="3 and a half" /><label class="half" for="star3half" title="Meh - 3.5 stars" onclick="Ocena(3.5,'+korisnikId+","+idOglasa+');"></label>'
	   +' <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars" onclick="Ocena(3,'+korisnikId+","+idOglasa+');"></label>'
	   +' <input type="radio" id="star2half" name="rating" value="2 and a half" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars" onclick="Ocena(2.5,'+korisnikId+","+idOglasa+');"></label>'
	   +' <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars" onclick="Ocena(2,'+korisnikId+","+idOglasa+');"></label>'
	   +' <input type="radio" id="star1half" name="rating" value="1 and a half" /><label class="half" for="star1half" title="Meh - 1.5 stars" onclick="Ocena(1.5,'+korisnikId+","+idOglasa+');"></label>'
	   +' <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star" onclick="Ocena(1,'+korisnikId+","+idOglasa+');"></label>'
	   +' <input type="radio" id="starhalf" name="rating" value="half" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars" onclick="Ocena(0.5,'+korisnikId+","+idOglasa+');"></label>'
	   +' </fieldset> '
}


function Komentar(idKorisnika, idOglasa, idNarudzbenice){
	
	console.log(idNarudzbenice);
	

	var labelaKomentar = document.createElement("LABEL");
	var textKomentar = document.createElement("TEXTAREA");
	var textLabeleKomentara = document.createTextNode("Tekst komentara:");   
	labelaKomentar.appendChild(textLabeleKomentara);
	textKomentar.setAttribute("id", "komentar");
	labelaKomentar.setAttribute("id", "idLabele");
	
	
	
	
	var prosledi=document.createElement("BUTTON");
	var textProsledi = document.createTextNode("Prosledi");   
	prosledi.appendChild(textProsledi);
	prosledi.setAttribute("id", "dugme");
	
	
	document.getElementById("n"+idNarudzbenice).appendChild(labelaKomentar);
	document.getElementById("n"+idNarudzbenice).appendChild(textKomentar);
	
	document.getElementById("n"+idNarudzbenice).appendChild(prosledi);
	
	
	prosledi.setAttribute("onclick", "ProslediKom("+idKorisnika+","+idOglasa+","+idNarudzbenice+")"); 


}

function ProslediKom(idKorisnika, idOglasa){
	
	var komentar=document.getElementById("komentar").value;
	
	
	var formData = JSON.stringify({
		kreatorKomentaraID:idKorisnika,
		tekstKomentara:komentar
         
          
      });
	 // console.log(formData);
	  $.ajax({
	        url: "http://localhost:2020/komentarapp/komentari/dodavanje/"+idOglasa, 
	   		type: "POST",
	   		data: formData,
	   		contentType: "application/json",
	   		datatype: 'json',
	    	   success: function(data){	   
	    		   alert("dodat komentar");
	    		   var dugme=document.getElementById("dugme");
	    		   dugme.parentNode.removeChild(dugme);
	    		   
	    		   var komentar=document.getElementById("komentar");
	    		   komentar.parentNode.removeChild(komentar);
	    		   
	    		   var labela=document.getElementById("idLabele");
	    		   labela.parentNode.removeChild(labela);
	    	   }	 
	    	   });
	
	
}

function Komentari(idOglasa, idKorisnika){
	window.location.href = "http://localhost:2020/komentarapp/komentari.html?id="+idOglasa+"&korid="+idKorisnika;

}