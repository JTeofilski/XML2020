package com.komentar.Komentar.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.komentar.Komentar.model.RegistrovaniKorisnik;

public interface RegistrovaniKorisnikService {

	Page<RegistrovaniKorisnik> findKorisnik(String criteria, Pageable pageable);

	RegistrovaniKorisnik findOne(Long id);
	
	RegistrovaniKorisnik getKorisnik(String email, String password);
	
	List<RegistrovaniKorisnik> findAll();
	
	RegistrovaniKorisnik save(RegistrovaniKorisnik korisnik);
	
	List<RegistrovaniKorisnik> save(List<RegistrovaniKorisnik> korisnici);
	
}
