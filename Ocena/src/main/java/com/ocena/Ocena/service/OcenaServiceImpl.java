package com.ocena.Ocena.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ocena.Ocena.model.Ocena;
import com.ocena.Ocena.repository.OcenaRepository;

@Service
public class OcenaServiceImpl implements OcenaService {
	
	@Autowired
	private OcenaRepository repository;

	
	@Override
	public Ocena save (Ocena ocena) {
		
		return repository.save(ocena);
	}


	@Override
	public List<Ocena> findAll() {
		
		return repository.findAll();
	}

}
