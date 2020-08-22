package com.xml.agent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agent.model.MarkaVozila;
import com.xml.agent.repository.MarkaRepository;



@Transactional
@Service
public class MarkaServiceImpl implements MarkaService{

	@Autowired
	private MarkaRepository repository;
	
	@Override
	public List<MarkaVozila> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public MarkaVozila findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public MarkaVozila delete(Long id) {
		MarkaVozila marka = repository.findById(id).orElse(null);
		if(marka == null) {
			throw new IllegalArgumentException("Marka ne postoji!");
		}
		repository.deleteById(id);
		return marka;	
		
	}

	@Override
	public MarkaVozila save(MarkaVozila marka) {
		// TODO Auto-generated method stub
		return repository.save(marka);
	}

}
