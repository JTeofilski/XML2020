package com.adminservis.AdminServis.service;

import java.util.List;

import com.adminservis.AdminServis.model.Cenovnik;

public interface CenovnikService {

	Cenovnik findOne(Long id);
	Cenovnik save(Cenovnik cenovnik);
	List<Cenovnik> findAll();
}
