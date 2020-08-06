package com.pretraga.Pretraga.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.pretraga.Pretraga.model.Vozilo;

public interface VoziloService {

	Page<Vozilo> findVozilo(String criteria, Pageable pageable);

	Vozilo findOne(Long id);
	
	Vozilo getVozilo(String name);
	
	List<Vozilo> findAll(Sort sort);
	
	Vozilo save(Vozilo vozilo);
	
	List<Vozilo> save(List<Vozilo> vozila);
}
