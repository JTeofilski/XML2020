package com.xml.agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agent.model.Agent;
import com.xml.agent.repository.AgentRepository;

@Service
public class AgentServiceImpl implements AgentService{

	@Autowired
	private AgentRepository r;
	@Override
	public Agent save(Agent agent) {
		// TODO Auto-generated method stub
		return r.save(agent);
	}
	@Override
	public List<Agent> findAll() {
		// TODO Auto-generated method stub
		return r.findAll();
	}
	@Override
	public Agent getAgent(String email, String password) {
		// TODO Auto-generated method stub
		return r.findByEmailAndLozinka(email, password);
	}

}
