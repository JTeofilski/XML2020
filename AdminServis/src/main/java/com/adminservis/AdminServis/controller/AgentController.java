package com.adminservis.AdminServis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.adminservis.AdminServis.model.Agent;
import com.adminservis.AdminServis.model.RegistrovaniKorisnik;
import com.adminservis.AdminServis.service.AgentService;
import com.adminservis.AdminServis.service.RegistrovaniKorisnikService;

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
		
		return new ResponseEntity<Agent>(agent1, HttpStatus.OK);
	}
}
