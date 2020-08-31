package com.xml.agent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agent.model.Vozilo;
import com.xml.agent.repository.VoziloRepository;

@Transactional
@Service
public class VoziloServiceImpl implements VoziloService{

	@Autowired
	private VoziloRepository rep;
	
	@Override
	public Vozilo save(Vozilo vozilo) {
		// TODO Auto-generated method stub
		return rep.save(vozilo);
	}

	@Override
	public List<Vozilo> findAll() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

	@Override
	public Vozilo findOne(long id) {
		
		return rep.getOne(id);
	}

	@Override
	public Vozilo findByOglasId(long id) {
		
		return rep.findByOglasiIdentifikacioniBroj(id);
	}

}
