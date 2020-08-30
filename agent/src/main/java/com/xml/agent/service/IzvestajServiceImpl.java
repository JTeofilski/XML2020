package com.xml.agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agent.model.Izvestaj;
import com.xml.agent.repository.IzvestajRepository;

@Service
public class IzvestajServiceImpl implements IzvestajService {
	
	@Autowired
	private IzvestajRepository repository;

	@Override
	public void save(Izvestaj izvestaj) {
		repository.save(izvestaj);
	}

	@Override
	public List <Izvestaj> findAll() {	
		return repository.findAll();
	}

}
