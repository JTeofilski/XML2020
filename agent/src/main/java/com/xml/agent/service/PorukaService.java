package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.Poruka;



public interface PorukaService {

    Poruka findOne(Long id);
	
	List<Poruka> findAll();
	
	Poruka save(Poruka poruka);
}
