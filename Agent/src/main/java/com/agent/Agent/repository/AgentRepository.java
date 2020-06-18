package com.agent.Agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agent.Agent.model.Oglas;



public interface AgentRepository extends JpaRepository<Oglas, Long> {

	  Oglas findById(long id);
}
