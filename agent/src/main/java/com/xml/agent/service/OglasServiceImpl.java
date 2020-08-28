package com.xml.agent.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agent.model.Oglas;
import com.xml.agent.repository.OglasRepository;


@Transactional
@Service
public class OglasServiceImpl implements OglasService{

	@Autowired 
	private OglasRepository oglasRepository;
	
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
	public Oglas save(Oglas oglas) {
		// TODO Auto-generated method stub
		return oglasRepository.save(oglas);
	}

	@Override
	public List<Oglas> save(List<Oglas> oglasi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Oglas> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return oglasRepository.findAll(sort);
	}

	@Override
	public List<Oglas> findByAgentId(long id) {
		
		return oglasRepository.findByAgentIdentifikacioniBroj(id);
	}


}
