package com.xml.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agent.model.Agent;
import com.xml.agent.service.AgentService;


@RestController
@RequestMapping(value = "/agenti")
public class AgentController {

	@Autowired
    private AgentService agentService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/svi")
	public ResponseEntity<List<Agent>> getUsers(){
		List<Agent> agenti = agentService.findAll();
		
		
		return new ResponseEntity<List<Agent>>(agenti, HttpStatus.OK);
	}
	@RequestMapping(method=RequestMethod.POST, value = "/logovanje", consumes="application/json")
	public ResponseEntity<Agent> logAgent(@RequestBody Agent agent){
	
		if( agentService.getAgent(agent.getEmail(), agent.getLozinka())==null){
			System.out.println("Pogresna kombinacija emaila i sifre!");
			return new ResponseEntity<>( agentService.getAgent(agent.getEmail(), agent.getLozinka()), HttpStatus.NOT_FOUND);
		}else 
		if(agentService.getAgent(agent.getEmail(), agent.getLozinka()).getStatus().equals("cekanje")) {
			System.out.println("Registracija od strane administratora jos nije izvrsena!");
			return new ResponseEntity<>( agentService.getAgent(agent.getEmail(), agent.getLozinka()), HttpStatus.NOT_FOUND);
		}
		
		System.out.println("Korisnik " +  agentService.getAgent(agent.getEmail(), agent.getLozinka()).getIme() + " se uspesno ulogovao!");
		return new ResponseEntity<>( agentService.getAgent(agent.getEmail(), agent.getLozinka()), HttpStatus.OK);
	}
	
}
