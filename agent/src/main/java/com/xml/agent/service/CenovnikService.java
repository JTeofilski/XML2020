package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.Cenovnik;
import com.xml.agent.model.VrstaGoriva;

public interface CenovnikService {

	Cenovnik findOne(Long id);
	
	List<Cenovnik> findAll();
}
