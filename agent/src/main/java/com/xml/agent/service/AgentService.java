package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.Agent;

public interface AgentService {
	List<Agent> findAll();
	Agent findOne(Long id);
	Agent save(Agent agent);
	Agent getAgent(String email, String password);
}
