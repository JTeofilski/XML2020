package com.pretraga.Pretraga.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pretraga.Pretraga.model.Korpa;
import com.pretraga.Pretraga.model.Oglas;
import com.pretraga.Pretraga.repository.KorpaRepository;
import com.pretraga.Pretraga.repository.OglasRepository;

@Transactional
@Service
public class OglasServiceImpl implements OglasService{

	@Autowired 
	private OglasRepository oglasRepository;
	@Autowired
	private KorpaRepository korpaRepository;
	
	@Override
	public Page<Oglas> findOglas(String criteria, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Oglas findOne(Long id) {
		// TODO Auto-generated method stub
		return oglasRepository.findById(id).orElse(null);
	}

	@Override
	public Oglas getOglas(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Oglas> findAll() {
		// TODO Auto-generated method stub
		return oglasRepository.findAll();
	}

	@Override
	public Oglas save(Oglas oglas) {
		// TODO Auto-generated method stub
		return oglasRepository.save(oglas);
	}

	@Override
	public List<Oglas> save(List<Oglas> oglasi) {
		// TODO Auto-generated method stub
		return null;
	}


}
