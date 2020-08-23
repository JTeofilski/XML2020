package com.xml.agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agent.model.Narudzbenica;
import com.xml.agent.repository.NarudzbenicaRepository;


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


	@Override
	public List<Narudzbenica> findAll() {
		return repository.findAll();
	}

}
