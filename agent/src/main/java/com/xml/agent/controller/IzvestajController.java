package com.xml.agent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agent.model.Izvestaj;
import com.xml.agent.model.Oglas;
import com.xml.agent.service.IzvestajService;
import com.xml.agent.service.OglasService;

@RestController
@RequestMapping(value = "/izvestaji")

public class IzvestajController {

	@Autowired
	private IzvestajService izvestajService;
	
	@Autowired
	private OglasService oglasService;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/{idOglasa}", consumes="application/json")
	public ResponseEntity<Izvestaj> noviIzvestaj(@RequestBody Izvestaj izvestaj, @PathVariable("idOglasa") long idOglasa){
		Oglas oglas=oglasService.findOne(idOglasa);
		
		izvestaj.setIdVozila(oglas.getVozilo().getIdentifikacioniBroj());
		izvestajService.save(izvestaj);
		return new ResponseEntity<Izvestaj>(izvestaj, HttpStatus.OK);
	}
}
	
