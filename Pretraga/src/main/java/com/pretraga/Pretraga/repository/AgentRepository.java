package com.pretraga.Pretraga.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pretraga.Pretraga.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long>{

	Agent findByAdresa(String adresa);
}
