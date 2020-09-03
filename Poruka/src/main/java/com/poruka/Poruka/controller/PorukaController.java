package com.poruka.Poruka.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	
	@RequestMapping(method=RequestMethod.POST, value = "/posaljiPoruku/{id}", consumes="application/json", produces="application/json")
	public ResponseEntity<Poruka> posalji(@RequestBody Poruka por, @PathVariable("id") Long idZahteva){
	    Poruka poruka = new Poruka();
	    ZahtevZaIznajmljivanje zahtev = zahtevService.findOne(idZahteva);
		poruka.setText(por.getText());
		poruka.setZahtev(zahtev);
		
		
		List<Poruka> postojecePoruke = new ArrayList<Poruka>();
	    postojecePoruke = porukaService.findAll();
		List<Long> ids = new ArrayList<>();
		for(int i=0; i<postojecePoruke.size(); i++) {
			
			ids.add(postojecePoruke.get(i).getIdentifikacioniBroj());
		}
		
		if(postojecePoruke.size()>0) {
		poruka.setIdentifikacioniBroj(Collections.max(ids)+1);
		}else {
			poruka.setIdentifikacioniBroj(1);
		}
		
		
		porukaService.save(poruka);
		
		 final String uri = "http://localhost:8099/poruke/porukaSaservisa";
		 
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
			
		return new ResponseEntity<>( poruka, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST, value = "porukaSaAgenta", consumes="application/json", produces="application/json")
	public ResponseEntity<Poruka> addPorukaSaAgenta(@RequestBody Poruka por){
		  Poruka poruka = por;
		 
		    List<Poruka> postojecePoruke = new ArrayList<Poruka>();
		    postojecePoruke = porukaService.findAll();
			List<Long> ids = new ArrayList<>();
			for(int i=0; i<postojecePoruke.size(); i++) {
				
				ids.add(postojecePoruke.get(i).getIdentifikacioniBroj());
			}
			
			if(postojecePoruke.size()>0) {
			poruka.setIdentifikacioniBroj(Collections.max(ids)+1);
			}else {
				poruka.setIdentifikacioniBroj(1);
			}
			porukaService.save(poruka);
		
		return new ResponseEntity<Poruka>(poruka, HttpStatus.OK);
	}
}
