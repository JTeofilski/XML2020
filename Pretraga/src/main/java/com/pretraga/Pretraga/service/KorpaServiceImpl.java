package com.pretraga.Pretraga.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pretraga.Pretraga.model.Korpa;
import com.pretraga.Pretraga.model.Oglas;
import com.pretraga.Pretraga.repository.KorpaRepository;
import com.pretraga.Pretraga.repository.OglasRepository;

@Transactional
@Service
public class KorpaServiceImpl implements KorpaService {
	
	@Autowired
	private KorpaRepository repository;

	
	@Override
	public Korpa findOne(Long id) {
		return repository.findByIdentifikacioniBroj(id);
	}


	@Override
	public Korpa save(Korpa korpa) {	
		return repository.save(korpa);
	}
	
	

	

}
