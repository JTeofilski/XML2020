package com.pretraga.Pretraga.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pretraga.Pretraga.model.Agent;

public interface AgentRepository extends JpaRepository<Agent, Long>{

	@Query("SELECT a FROM Agent a WHERE adresa like %?1%")
	List<Agent> findByAdresa(String adresa);
}
