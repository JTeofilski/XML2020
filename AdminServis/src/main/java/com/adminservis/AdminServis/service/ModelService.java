package com.adminservis.AdminServis.service;

import java.util.List;

import com.adminservis.AdminServis.model.ModelVozila;

public interface ModelService {

    ModelVozila findOne(Long id);
	
	ModelVozila delete(Long id);
	
	ModelVozila save(ModelVozila model);
	
	List<ModelVozila> findAll();

}
