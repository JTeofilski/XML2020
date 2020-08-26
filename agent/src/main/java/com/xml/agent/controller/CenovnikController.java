package com.xml.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xml.agent.model.Cenovnik;
import com.xml.agent.model.KlasaAutomobila;
import com.xml.agent.repository.CenovnikRepository;
import com.xml.agent.service.CenovnikService;

@RestController
@RequestMapping(value = "/cenovnici")
public class CenovnikController {

	@Autowired
	private CenovnikService service;
	
	@Autowired
	private CenovnikRepository rep;
	
	@RequestMapping(method=RequestMethod.GET, value = "/sviCenovnici")
	public ResponseEntity<List<Cenovnik>> getCenovnivi(){
		List<Cenovnik> cenovnici = service.findAll();
		
		
		return new ResponseEntity<List<Cenovnik>>(cenovnici, HttpStatus.OK);
	}
	@RequestMapping(value="dodajCenovnik", method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Cenovnik> addCenovnik(@RequestBody Cenovnik cenovnik) {
	List<Cenovnik> cenovnici = service.findAll();
	Cenovnik cenovnik1 = new Cenovnik();
		  cenovnik1.setCenaZaDan(cenovnik.getCenaZaDan());
		  cenovnik1.setCenaViseOd30(cenovnik.getCenaViseOd30());
		  cenovnik1.setCenaPoKilometruZaOgranicenuKilometrazu(cenovnik.getCenaPoKilometruZaOgranicenuKilometrazu());
		  cenovnik1.setCenaCDW(cenovnik.getCenaCDW());
		  cenovnik1.setIdentifikacioniBroj(cenovnici.size()+2);
		  service.save(cenovnik1);
		 
		return new ResponseEntity<Cenovnik>(cenovnik1, HttpStatus.OK);
	}
}
