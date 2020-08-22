package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.TipMenjaca;


public interface MenjacService {

    TipMenjaca findOne(Long id);
	
	TipMenjaca delete(Long id);
	
	TipMenjaca save(TipMenjaca menjac);
	
	List<TipMenjaca> findAll();
}
