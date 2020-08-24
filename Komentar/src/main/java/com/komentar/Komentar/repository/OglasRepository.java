package com.komentar.Komentar.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.komentar.Komentar.model.Oglas;


public interface OglasRepository extends JpaRepository<Oglas, Long>{

	
	Oglas findByIdentifikacioniBroj (Long id);
	//List<Oglas> OrderByVoziloSlobodnoOd(List<Oglas> oglasi);
	//List<Oglas> findByVoziloSlobodnoOdCreatedBetween
}
