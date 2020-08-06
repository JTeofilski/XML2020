package com.pretraga.Pretraga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pretraga.Pretraga.model.Agent;
import com.pretraga.Pretraga.repository.AgentRepository;

@Transactional
@Service
public class AgentServiceImpl implements AgentService{

	@Autowired
	private AgentRepository agentRepository;
	
	@Override
	public Page<Agent> findAgent(String criteria, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agent findOne(Long id) {
		// TODO Auto-generated method stub
		return agentRepository.findById(id).orElse(null);
	}

	@Override
	public Agent getAgent(String name) {
		// TODO Auto-generated method stub
		return (Agent) agentRepository.findByAdresa(name);
	}

	@Override
	public List<Agent> findAll() {
		// TODO Auto-generated method stub
		return agentRepository.findAll();
	}

	@Override
	public Agent save(Agent agent) {
		// TODO Auto-generated method stub
		return agentRepository.save(agent);
	}

	@Override
	public List<Agent> save(List<Agent> agenti) {
		// TODO Auto-generated method stub
		return null;
	}

}
