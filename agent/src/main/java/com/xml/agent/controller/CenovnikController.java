package com.xml.agent.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	@RequestMapping(value="dodajCenovnik", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Cenovnik> addCenovnik(@RequestBody Cenovnik cenovnik) {
	List<Cenovnik> cenovnici = service.findAll();
	Cenovnik cenovnik1 = new Cenovnik();
		  cenovnik1.setCenaZaDan(cenovnik.getCenaZaDan());
		  cenovnik1.setCenaViseOd30(cenovnik.getCenaViseOd30());
		  cenovnik1.setCenaPoKilometruZaOgranicenuKilometrazu(cenovnik.getCenaPoKilometruZaOgranicenuKilometrazu());
		  cenovnik1.setCenaCDW(cenovnik.getCenaCDW());
		 
		  List<Long> cenovniciSort = new ArrayList<Long>();
		  for(int i=0; i<cenovnici.size(); i++) {
			  cenovniciSort.add(cenovnici.get(i).getIdentifikacioniBroj());
			  
		  }
		  
		  cenovnik1.setIdentifikacioniBroj(Collections.max(cenovniciSort)+1);
		  
		  service.save(cenovnik1);
		  
		  final String uri = "http://localhost:2020/pretragaapp/cenovnici/dodajSaAgenta";
			 
			ObjectMapper mapper= new ObjectMapper();
			String json = null;
			
			try {
				json= mapper.writeValueAsString(cenovnik1);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>(json,headers);
			restTemplate.postForObject(uri, entity, Cenovnik.class);
		 
		return new ResponseEntity<Cenovnik>(cenovnik1, HttpStatus.OK);
	}
}
