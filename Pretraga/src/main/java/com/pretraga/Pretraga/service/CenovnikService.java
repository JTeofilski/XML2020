package com.pretraga.Pretraga.service;
import java.util.List;

import com.pretraga.Pretraga.model.Agent;
import com.pretraga.Pretraga.model.Cenovnik;
public interface CenovnikService {

	Cenovnik findOne(Long id);
	Cenovnik save(Cenovnik cenovnik);
	List<Cenovnik> findAll();
}
