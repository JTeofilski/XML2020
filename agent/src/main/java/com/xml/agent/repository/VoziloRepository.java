package com.xml.agent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xml.agent.model.Vozilo;

public interface VoziloRepository extends JpaRepository<Vozilo, Long>{

	Vozilo findByOglasiIdentifikacioniBroj(long id);
}
