package com.xml.agent.service;

import java.util.List;

import com.xml.agent.model.Narudzbenica;


public interface NarudzbenicaService {

	
	Narudzbenica findByIdentifikacioniBroj (long id);
	
	Narudzbenica save(Narudzbenica narudzbenica);
	
	List<Narudzbenica> findByKorpaId(long id);
	
	void remove(Narudzbenica narudzbenica);
	
	List<Narudzbenica> findAll();
}
