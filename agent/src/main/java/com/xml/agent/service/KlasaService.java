package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.KlasaAutomobila;



public interface KlasaService {

    KlasaAutomobila findOne(Long id);
	
	KlasaAutomobila delete(Long id);
	
	KlasaAutomobila save(KlasaAutomobila klasa);
	
	List<KlasaAutomobila> findAll();
}
