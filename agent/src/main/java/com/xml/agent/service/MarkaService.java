package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.MarkaVozila;


public interface MarkaService {

	MarkaVozila findOne(Long id);
	
	MarkaVozila delete(Long id);
	
	MarkaVozila save(MarkaVozila marka);
	
	List<MarkaVozila> findAll();
}
