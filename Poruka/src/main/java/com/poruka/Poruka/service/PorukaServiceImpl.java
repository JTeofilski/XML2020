package com.poruka.Poruka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.poruka.Poruka.model.Poruka;
import com.poruka.Poruka.repository.PorukaRepository;

@Transactional
@Service
public class PorukaServiceImpl implements PorukaService{
    
	@Autowired
	private PorukaRepository porukaRepository;
	
	@Override
	public Poruka findOne(Long id) {
		// TODO Auto-generated method stub
		return porukaRepository.findById(id).orElse(null);
	}

	@Override
	public List<Poruka> findAll() {
		// TODO Auto-generated method stub
		return porukaRepository.findAll();
	}

	@Override
	public Poruka save(Poruka poruka) {
		// TODO Auto-generated method stub
		return porukaRepository.save(poruka);
	}

}
