package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.Vozilo;

public interface VoziloService {

	Vozilo save(Vozilo vozilo);

	List<Vozilo> findAll();
	
	Vozilo findOne(long id);
	
	Vozilo findByOglasId(long id);
}
