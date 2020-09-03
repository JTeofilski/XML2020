package com.xml.agent.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	@RequestMapping(method=RequestMethod.POST, value = "/dodajPoruku/{id}", consumes="application/json", produces="application/json")
	public ResponseEntity<Poruka> addPoruka(@RequestBody Poruka por, @PathVariable("id") Long idPoruka1){
		  Poruka poruka = new Poruka();
		  Poruka por1= service.findOne(idPoruka1);
		  List<Poruka> poruke = service.findAll();
		    ZahtevZaIznajmljivanje zahtev = zservice.findOne(por1.getZahtev().getIdentifikacioniBroj());
			poruka.setText(por.getText());
			poruka.setZahtev(zahtev);

			List<Poruka> postojecePoruke = new ArrayList<Poruka>();
		    postojecePoruke = service.findAll();
			List<Long> ids = new ArrayList<>();
			for(int i=0; i<postojecePoruke.size(); i++) {
				
				ids.add(postojecePoruke.get(i).getIdentifikacioniBroj());
			}
			
			if(postojecePoruke.size()>0) {
			poruka.setIdentifikacioniBroj(Collections.max(ids)+1);
			}else {
				poruka.setIdentifikacioniBroj(1);
			}
			
			
			
			service.save(poruka);
		
			final String uri = "http://localhost:2020/pretragaapp/porukaSaAgenta";
			 
			ObjectMapper mapper= new ObjectMapper();
			String json = null;
			
			try {
				json= mapper.writeValueAsString(poruka);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>(json,headers);
			restTemplate.postForObject(uri, entity, Poruka.class);
			
		return new ResponseEntity<Poruka>(poruka, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST, value = "porukaSaservisa", consumes="application/json", produces="application/json")
	public ResponseEntity<Poruka> addPorukaSaMS(@RequestBody Poruka por){
		  Poruka poruka = por;
		 
		    List<Poruka> postojecePoruke = new ArrayList<Poruka>();
		    postojecePoruke = service.findAll();
			List<Long> ids = new ArrayList<>();
			for(int i=0; i<postojecePoruke.size(); i++) {
				
				ids.add(postojecePoruke.get(i).getIdentifikacioniBroj());
			}
			
			if(postojecePoruke.size()>0) {
			poruka.setIdentifikacioniBroj(Collections.max(ids)+1);
			}else {
				poruka.setIdentifikacioniBroj(1);
			}
			service.save(poruka);
		
		return new ResponseEntity<Poruka>(poruka, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET, value = "/poruka/{id}")
	public ResponseEntity<Poruka> getPoruka(@PathVariable("id") Long idPoruka){
		  Poruka poruka = service.findOne(idPoruka);
		
		return new ResponseEntity<Poruka>(poruka, HttpStatus.OK);
	}
}
