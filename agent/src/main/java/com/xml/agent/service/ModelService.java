package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.ModelVozila;


public interface ModelService {

    ModelVozila findOne(Long id);
	
	ModelVozila delete(Long id);
	
	ModelVozila save(ModelVozila model);
	
	List<ModelVozila> findAll();

}
