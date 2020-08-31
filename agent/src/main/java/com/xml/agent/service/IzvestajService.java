package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.Izvestaj;

public interface IzvestajService {

	void save (Izvestaj izvestaj);
	
	List<Izvestaj> findAll();
	
	List<Izvestaj> findByIdAgenta(long id);
	
	List<Izvestaj> findByIdVozila(long id);
}
