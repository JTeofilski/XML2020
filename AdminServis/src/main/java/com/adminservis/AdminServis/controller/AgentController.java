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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.adminservis.AdminServis.model.Agent;
import com.adminservis.AdminServis.model.RegistrovaniKorisnik;
import com.adminservis.AdminServis.service.AgentService;
import com.adminservis.AdminServis.service.RegistrovaniKorisnikService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/agenti")
public class AgentController {

	@Autowired
    private AgentService agentService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/sviAgenti")
	public ResponseEntity<List<Agent>> getUsers(){
		List<Agent> agenti = agentService.findAll();
		
		
		return new ResponseEntity<List<Agent>>(agenti, HttpStatus.OK);
	}
	@RequestMapping(value="registruj/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Agent> block(@PathVariable("id") Long id, @RequestBody Agent agent) {
		Agent agent1 = agentService.findOne(id);
		agent1.setIme(agent.getIme());
		agent1.setPrezime(agent.getPrezime());
		agent1.setPoslovniMaticniBroj(agent.getPoslovniMaticniBroj());
		agent1.setStatus("registrovan");
		agentService.save(agent1);
		
	/*	final String uri = "http://localhost:8090//" + id + "/" + id1 + "/"  + collision;
		 
		ObjectMapper mapper= new ObjectMapper();
		String json = null;
		
		try {
			json= mapper.writeValueAsString(oglas.getVozilo());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	   RestTemplate restTemplate = new RestTemplate();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<String> entity = new HttpEntity<String>(json,headers);
		restTemplate.postForObject(uri, entity, Vozilo.class);*/
		return new ResponseEntity<Agent>(agent1, HttpStatus.OK);
	}
}
