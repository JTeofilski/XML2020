package com.adminservis.AdminServis.service;

import java.util.List;

import com.adminservis.AdminServis.model.KlasaAutomobila;


public interface KlasaService {

    KlasaAutomobila findOne(Long id);
	
	KlasaAutomobila delete(Long id);
	
	KlasaAutomobila save(KlasaAutomobila klasa);
	
	List<KlasaAutomobila> findAll();
}
