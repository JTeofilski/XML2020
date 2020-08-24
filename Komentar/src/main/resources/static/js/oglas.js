function proveriPolja(){
	if(document.forms['pretragaForma'].adresa === ""){
		document.forms['pretragaForma'].agresa.style.borderColor="red";
		document.getElementById('greskaLogovanje').innerHTML = "Unesite adresu na kojoj preuzimate vozilo.";
		document.getElementById('greskaLogovanje').style.color="#FF3333";
		event.preventDefault();
		return;
	}else if(document.forms['pretragaForma'].datumOd.value === ""){
		document.forms['pretragaForma'].datumOd.style.borderColor="red";
		document.getElementById('greskaLogovanje').innerHTML = "Unesite datum preuzimanja.";
		document.getElementById('greskaLogovanje').style.color="#FF3333";
		event.preventDefault();
		return;
	}
}