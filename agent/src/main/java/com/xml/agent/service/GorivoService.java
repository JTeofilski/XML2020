package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.VrstaGoriva;


public interface GorivoService {

    VrstaGoriva findOne(Long id);
	
	VrstaGoriva delete(Long id);
	
	VrstaGoriva save(VrstaGoriva gorivo);
	
	List<VrstaGoriva> findAll();
	
}
