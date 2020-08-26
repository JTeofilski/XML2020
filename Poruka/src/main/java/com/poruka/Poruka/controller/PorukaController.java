package com.poruka.Poruka.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poruka.Poruka.model.Poruka;
import com.poruka.Poruka.model.ZahtevZaIznajmljivanje;
import com.poruka.Poruka.service.PorukaService;
import com.poruka.Poruka.service.ZahtevZaIznajmljivanjeService;

@RestController
@RequestMapping(value = "/poruke")
public class PorukaController {

	@Autowired
	private PorukaService porukaService;
	
	@Autowired
	private ZahtevZaIznajmljivanjeService zahtevService;
	
	@RequestMapping(method=RequestMethod.POST, value = "/posaljiPoruku/{id}", consumes="application/json")
	public ResponseEntity<Poruka> posalji(@RequestBody Poruka por, @PathVariable("id") Long idZahteva){
	    Poruka poruka = new Poruka();
	    ZahtevZaIznajmljivanje zahtev = zahtevService.findOne(idZahteva);
		poruka.setText(por.getText());
		poruka.setZahtev(zahtev);
		porukaService.save(poruka);
		return new ResponseEntity<>( poruka, HttpStatus.OK);
	}
}
