package com.adminservis.AdminServis.service;

import java.util.List;

import com.adminservis.AdminServis.model.MarkaVozila;

public interface MarkaService {

	MarkaVozila findOne(Long id);
	
	MarkaVozila delete(Long id);
	
	MarkaVozila save(MarkaVozila marka);
	
	List<MarkaVozila> findAll();
}
