package com.adminservis.AdminServis.service;

import java.util.List;

import com.adminservis.AdminServis.model.MarkaVozila;
import com.adminservis.AdminServis.model.VrstaGoriva;

public interface GorivoService {

    VrstaGoriva findOne(Long id);
	
	VrstaGoriva delete(Long id);
	
	VrstaGoriva save(VrstaGoriva gorivo);
	
	List<VrstaGoriva> findAll();
	
}
