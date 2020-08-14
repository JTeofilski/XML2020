package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.Narudzbenica;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.repository.NarudzbenicaRepository;

@Transactional
@Service
public class NarudzbenicaServiceImpl implements NarudzbenicaService{
	
	
	@Autowired
	private NarudzbenicaRepository repository;
	

	@Override
	public Narudzbenica findByIdentifikacioniBroj(long id) {
		
		return repository.findByIdentifikacioniBroj(id);
	}


	@Override
	public Narudzbenica save(Narudzbenica narudzbenica) {
		
		return repository.save(narudzbenica);
	}


	
}
