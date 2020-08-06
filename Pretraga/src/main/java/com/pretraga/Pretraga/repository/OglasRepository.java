package com.pretraga.Pretraga.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pretraga.Pretraga.model.Oglas;

public interface OglasRepository extends JpaRepository<Oglas, Long>{

	
	Oglas findByIdentifikacioniBroj (Long id);
	List<Oglas> findByVoziloSlobodnoOdAndVoziloSlobodnoDoOrderByVoziloSlobodnoOd(Date date1, Date date2);
	List<Oglas> findByVoziloSlobodnoOd(Date date);
	List<Oglas> findByVoziloSlobodnoDo(Date date);
}
