package com.pretraga.Pretraga.service;

import com.pretraga.Pretraga.model.Korpa;
import com.pretraga.Pretraga.model.Oglas;

public interface KorpaService {
	
	
	Korpa findOne(Long id);
	
	Korpa save(Korpa korpa);
	
	

}
