package com.agent.Agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


import com.agent.Agent.model.Oglas;
import com.agent.Agent.service.AgentService;


@RestController
@RequestMapping("/oglasi")
public class AgentController {

	@Autowired
	private AgentService service;

	@PostMapping("/dodaj")
	public ResponseEntity<Oglas> update(@RequestBody Oglas oglas) {
		Oglas noviOglas = oglas;
		noviOglas.setAgentID(1);
		noviOglas.setCenovnikID(1);
		noviOglas.setVoziloID(1);
		service.dodavanje(noviOglas);
		return new ResponseEntity<Oglas>(noviOglas, HttpStatus.OK);
	}
	
	@GetMapping("/nadji")
	public ResponseEntity<List<Oglas>> findAll(){
		return new ResponseEntity<List<Oglas>>(service.findAll(), HttpStatus.OK);
	}
}
