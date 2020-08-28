package com.xml.agent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agent.model.Oglas;


public interface OglasRepository extends JpaRepository<Oglas, Long>{

	
	Oglas findByIdentifikacioniBroj (Long id);
	
	List<Oglas> findByAgentIdentifikacioniBroj(Long id);
	
}
