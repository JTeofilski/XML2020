package com.registracija.Registracija.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.registracija.Registracija.model.Agent;
import com.registracija.Registracija.model.Korpa;
import com.registracija.Registracija.model.RegistrovaniKorisnik;
import com.registracija.Registracija.service.AgentService;

@RestController
@RequestMapping(value = "/agenti")
public class AgentController {

	@Autowired
	private AgentService agentService;
	
	@RequestMapping(method=RequestMethod.POST, value = "/registracija", consumes="application/json")
	public ResponseEntity<Agent> registrovanje(@RequestBody Agent agent){
	
		Agent agentSaved = new Agent();
		agentSaved.setIme(agent.getIme());
		agentSaved.setPrezime(agent.getPrezime());
		agentSaved.setEmail(agent.getEmail());
		agentSaved.setKorisnickoIme(agent.getKorisnickoIme());
		agentSaved.setLozinka(agent.getLozinka());
		agentSaved.setAdresa(agent.getAdresa());
		agentSaved.setStatus("cekanje");
		agentSaved.setPoslovniMaticniBroj(0);
		
		agentService.save(agentSaved);
		
		return new ResponseEntity<>(agentSaved, HttpStatus.OK);
	}
}
