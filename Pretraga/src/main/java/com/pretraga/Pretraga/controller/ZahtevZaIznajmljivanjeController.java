package com.pretraga.Pretraga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pretraga.Pretraga.model.ZahtevZaIznajmljivanje;
import com.pretraga.Pretraga.service.ZahtevZaIznajmljivanjeService;


@RestController
@RequestMapping(value = "/zahtevi")
public class ZahtevZaIznajmljivanjeController {

	@Autowired
	private ZahtevZaIznajmljivanjeService zahtevService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/sviZahtevi")
	public ResponseEntity<List<ZahtevZaIznajmljivanje>> getRequests(){
		
		List<ZahtevZaIznajmljivanje> zahtevi = zahtevService.findAll();
		
		return new ResponseEntity<List<ZahtevZaIznajmljivanje>>(zahtevi, HttpStatus.OK);
	}
}
