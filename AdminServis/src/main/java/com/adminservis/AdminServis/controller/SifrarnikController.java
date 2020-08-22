package com.adminservis.AdminServis.controller;

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

import com.adminservis.AdminServis.model.MarkaVozila;
import com.adminservis.AdminServis.model.ModelVozila;
import com.adminservis.AdminServis.model.RegistrovaniKorisnik;
import com.adminservis.AdminServis.model.VrstaGoriva;
import com.adminservis.AdminServis.service.GorivoService;
import com.adminservis.AdminServis.service.MarkaService;
import com.adminservis.AdminServis.service.ModelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	@RequestMapping(method=RequestMethod.GET, value = "/modeli")
	public ResponseEntity<List<ModelVozila>> sviModeli(){
		List<ModelVozila> modeli = modelService.findAll();
		
		return new ResponseEntity<List<ModelVozila>>(modeli, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.GET, value = "/goriva")
	public ResponseEntity<List<VrstaGoriva>> sveVrsteGoriva(){
		List<VrstaGoriva> goriva = gorivoService.findAll();
		
		return new ResponseEntity<List<VrstaGoriva>>(goriva, HttpStatus.OK);
	}
	
	@RequestMapping(value="obrisiMarku/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<MarkaVozila> remove(@PathVariable("id") Long id) {
	
		   MarkaVozila marka = markaService.delete(id);
		   
		   final String uri = "http://localhost:8099/sifrarnik/obrisiMarku/" + id;
			
			
			
		   RestTemplate restTemplate = new RestTemplate();
			
			
			
			restTemplate.delete(uri);
		   
		return new ResponseEntity<MarkaVozila>(marka, HttpStatus.OK);
	}
	
	@RequestMapping(value="obrisiModel/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<ModelVozila> removeModel(@PathVariable("id") Long id) {
	
		   ModelVozila model = modelService.delete(id);
		   
		   final String uri = "http://localhost:8099/sifrarnik/obrisiModel/" + id;
			
			
			
		   RestTemplate restTemplate = new RestTemplate();
			
			
			
			restTemplate.delete(uri);
		   
		return new ResponseEntity<ModelVozila>(model, HttpStatus.OK);
	}
	@RequestMapping(value="obrisiGorivo/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<VrstaGoriva> removeFuel(@PathVariable("id") Long id) {
	
		   VrstaGoriva gorivo = gorivoService.delete(id);
		   
		   final String uri = "http://localhost:8099/sifrarnik/obrisiGorivo/" + id;
			
			
			
		   RestTemplate restTemplate = new RestTemplate();
			
			
			
			restTemplate.delete(uri);
		   
		return new ResponseEntity<VrstaGoriva>(gorivo, HttpStatus.OK);
	}
	
	@RequestMapping(value="dodajMarku", method=RequestMethod.POST)
	public ResponseEntity<MarkaVozila> add(@RequestBody MarkaVozila marka) {
	
		   MarkaVozila marka1 = new MarkaVozila();
		   marka1 = marka;
		   markaService.save(marka1);
		   
		   final String uri = "http://localhost:8099/sifrarnik/dodajMarku";
			ObjectMapper mapper= new ObjectMapper();
			String json = null;
			
			try {
				json= mapper.writeValueAsString(marka1);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>(json,headers);
			MarkaVozila answer = restTemplate.postForObject(uri, entity, MarkaVozila.class);
		return new ResponseEntity<MarkaVozila>(marka1, HttpStatus.OK);
	}
	@RequestMapping(value="dodajModel", method=RequestMethod.POST)
	public ResponseEntity<ModelVozila> addModel(@RequestBody ModelVozila model) {
	
		  ModelVozila model1 = new ModelVozila();
		  model1 = model;
		   modelService.save(model1);
		   
		   final String uri = "http://localhost:8099/sifrarnik/dodajModel";
			ObjectMapper mapper= new ObjectMapper();
			String json = null;
			
			try {
				json= mapper.writeValueAsString(model1);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>(json,headers);
			MarkaVozila answer = restTemplate.postForObject(uri, entity, MarkaVozila.class);
		return new ResponseEntity<ModelVozila>(model1, HttpStatus.OK);
	}
	@RequestMapping(value="dodajGorivo", method=RequestMethod.POST)
	public ResponseEntity<VrstaGoriva> addFuel(@RequestBody VrstaGoriva gorivo) {
	
		  VrstaGoriva gorivo1 = new VrstaGoriva();
		  gorivo1 =gorivo;
		  gorivoService.save(gorivo1);
		   
		   final String uri = "http://localhost:8099/sifrarnik/dodajGorivo";
			ObjectMapper mapper= new ObjectMapper();
			String json = null;
			
			try {
				json= mapper.writeValueAsString(gorivo1);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>(json,headers);
			VrstaGoriva answer = restTemplate.postForObject(uri, entity, VrstaGoriva.class);
		return new ResponseEntity<VrstaGoriva>(gorivo1, HttpStatus.OK);
	}
}
