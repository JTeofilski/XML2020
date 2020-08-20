package com.xml.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
}
