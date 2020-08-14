package com.poruka.Poruka.service;

import java.util.List;

import com.poruka.Poruka.model.Poruka;


public interface PorukaService {

    Poruka findOne(Long id);
	
	List<Poruka> findAll();
	
	Poruka save(Poruka poruka);
}
