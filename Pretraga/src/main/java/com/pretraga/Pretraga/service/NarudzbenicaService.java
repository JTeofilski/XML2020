package com.pretraga.Pretraga.service;

import java.util.List;

import com.pretraga.Pretraga.model.Narudzbenica;

public interface NarudzbenicaService {

	
	Narudzbenica findByIdentifikacioniBroj (long id);
	
	Narudzbenica save(Narudzbenica narudzbenica);
	
	List<Narudzbenica> findByKorpaId(long id);
}
