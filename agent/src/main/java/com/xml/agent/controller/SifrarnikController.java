package com.xml.agent.controller;

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
import com.xml.agent.model.MarkaVozila;
import com.xml.agent.model.ModelVozila;
import com.xml.agent.model.VrstaGoriva;
import com.xml.agent.service.GorivoService;
import com.xml.agent.service.MarkaService;
import com.xml.agent.service.ModelService;

@RestController
@RequestMapping(value = "/sifrarnik")
public class SifrarnikController {

	@Autowired
	private MarkaService markaService;

	@Autowired
	private ModelService modelService;
	
	@Autowired
	private GorivoService gorivoService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/marke")
	public ResponseEntity<List<MarkaVozila>> sveMarke(){
		List<MarkaVozila> marke = markaService.findAll();
		
		
		return new ResponseEntity<List<MarkaVozila>>(marke, HttpStatus.OK);
	}
	
	@RequestMapping(value="obrisiMarku/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<MarkaVozila> remove(@PathVariable("id") Long id) {
	
		   MarkaVozila marka = markaService.delete(id);
		   
		return new ResponseEntity<MarkaVozila>(marka, HttpStatus.OK);
	}
	@RequestMapping(value="obrisiModel/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ModelVozila> removeModel(@PathVariable("id") Long id) {
	
		  ModelVozila model = modelService.delete(id);
		   
		return new ResponseEntity<ModelVozila>(model, HttpStatus.OK);
	}
	@RequestMapping(value="obrisiGorivo/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<VrstaGoriva> removeFuel(@PathVariable("id") Long id) {
	
		  VrstaGoriva gorivo = gorivoService.delete(id);
		   
		return new ResponseEntity<VrstaGoriva>(gorivo, HttpStatus.OK);
	}
	@RequestMapping(value="dodajMarku", method=RequestMethod.POST)
	public ResponseEntity<MarkaVozila> add(@RequestBody MarkaVozila marka) {
	
		   MarkaVozila marka1 = new MarkaVozila();
		   marka1 = marka;
		   markaService.save(marka1);
		 
		return new ResponseEntity<MarkaVozila>(marka1, HttpStatus.OK);
	}
	@RequestMapping(value="dodajModel", method=RequestMethod.POST)
	public ResponseEntity<ModelVozila> addModel(@RequestBody ModelVozila model) {
	
		   ModelVozila model1 = new ModelVozila();
		   model1 = model;
		   modelService.save(model1);
		 
		return new ResponseEntity<ModelVozila>(model1, HttpStatus.OK);
	}
	@RequestMapping(value="dodajGorivo", method=RequestMethod.POST)
	public ResponseEntity<VrstaGoriva> addFuel(@RequestBody VrstaGoriva gorivo) {
	
		  VrstaGoriva gorivo1 = new VrstaGoriva();
		  gorivo1 = gorivo;
		  gorivoService.save(gorivo1);
		 
		return new ResponseEntity<VrstaGoriva>(gorivo1, HttpStatus.OK);
	}
}
