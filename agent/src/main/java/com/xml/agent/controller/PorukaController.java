package com.xml.agent.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agent.model.Cenovnik;
import com.xml.agent.model.Poruka;
import com.xml.agent.model.ZahtevZaIznajmljivanje;
import com.xml.agent.service.PorukaService;
import com.xml.agent.service.ZahtevZaIznajmljivanjeService;

@RestController
@RequestMapping(value = "/poruke")
public class PorukaController {

	@Autowired
	private PorukaService service;
	
	@Autowired
	private ZahtevZaIznajmljivanjeService zservice;
	
	@RequestMapping(method=RequestMethod.GET, value = "/svePoruke/{id}")
	public ResponseEntity<List<Poruka>> getPoruke(@PathVariable("id") Long id){
		List<Poruka> poruke = service.findAll();
		
		List<Poruka> porukeAgenta = new ArrayList<Poruka>();
		
		for(int i=0; i<poruke.size(); i++) {
			if(poruke.get(i).getZahtev().getAgentFirmaID()==id) {
				porukeAgenta.add(poruke.get(i));
				
			}
			
		}
		
		return new ResponseEntity<List<Poruka>>(porukeAgenta, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST, value = "/dodajPoruku/{id}")
	public ResponseEntity<Poruka> addPoruka(@RequestBody Poruka por, @PathVariable("id") Long idPoruka1){
		  Poruka poruka = new Poruka();
		  Poruka por1= service.findOne(idPoruka1);
		  List<Poruka> poruke = service.findAll();
		    ZahtevZaIznajmljivanje zahtev = zservice.findOne(por1.getZahtev().getIdentifikacioniBroj());
			poruka.setText(por.getText());
			poruka.setZahtev(zahtev);
			poruka.setIdentifikacioniBroj(poruke.size()+3);
			service.save(poruka);
		
		return new ResponseEntity<Poruka>(poruka, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET, value = "/poruka/{id}")
	public ResponseEntity<Poruka> getPoruka(@PathVariable("id") Long idPoruka){
		  Poruka poruka = service.findOne(idPoruka);
		
		return new ResponseEntity<Poruka>(poruka, HttpStatus.OK);
	}
}
