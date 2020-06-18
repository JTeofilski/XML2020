package com.agent.Agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agent.Agent.model.Oglas;
import com.agent.Agent.repository.AgentRepository;

@Service
public class AgentService {
	
	@Autowired 
	private AgentRepository agentrepository;

	public Oglas dodavanje(Oglas noviOglas) {
		return agentrepository.save(noviOglas);
	}
	
	public List<Oglas> findAll() {
		return agentrepository.findAll();
		
	}
	
}
