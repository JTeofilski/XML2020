package com.pretraga.Pretraga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pretraga.Pretraga.model.Narudzbenica;
import com.pretraga.Pretraga.repository.NarudzbenicaRepository;

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


	@Override
	public List<Narudzbenica> findByKorpaId(long id) {
	
		return repository.findAllByKorpaId(id);
	}


	@Override
	public void remove(Narudzbenica narudzbenica) {
		repository.delete(narudzbenica);
	}

}
