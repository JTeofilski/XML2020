package com.ocena.Ocena.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ocena.Ocena.model.Ocena;
import com.ocena.Ocena.model.Oglas;
import com.ocena.Ocena.repository.OglasRepository;
import com.ocena.Ocena.service.OcenaService;


@RestController
@RequestMapping(value = "/ocene")
public class OcenaController {

	@Autowired
	private OcenaService service;
	
	@Autowired 
	private OglasRepository oglasrepo;
	
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json", value = "/{oglasId}")
	public ResponseEntity<Ocena> novaOcena (@RequestBody Ocena ocena, @PathVariable long oglasId ){
		
		Oglas oglas=oglasrepo.findByIdentifikacioniBroj(oglasId);
		oglas.getOcena().add(ocena);
		ocena.setOglas(oglas);
		service.save(ocena);
		oglasrepo.save(oglas);
		
		return new ResponseEntity<>( ocena, HttpStatus.OK);
		
	}
}
