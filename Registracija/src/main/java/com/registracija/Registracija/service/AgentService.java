package com.registracija.Registracija.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.registracija.Registracija.model.Agent;



public interface AgentService {

	Page<Agent> findAgent(String criteria, Pageable pageable);

	Agent findOne(Long id);
	
	Agent getAgent(String name);
	
	List<Agent> findAll();
	
	Agent save(Agent agent);
	
	List<Agent> save(List<Agent> agenti);
}
