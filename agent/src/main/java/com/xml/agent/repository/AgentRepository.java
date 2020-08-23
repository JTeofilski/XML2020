package com.xml.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agent.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long>{
 
	 Agent findByEmailAndLozinka(String email, String lozinka);
}
