package com.xml.agent.service;

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

}
