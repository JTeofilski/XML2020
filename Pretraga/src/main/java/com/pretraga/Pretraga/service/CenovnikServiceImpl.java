package com.pretraga.Pretraga.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pretraga.Pretraga.model.Cenovnik;
import com.pretraga.Pretraga.repository.CenovnikRepository;

@Transactional
@Service
public class CenovnikServiceImpl implements CenovnikService{

	@Autowired
	private CenovnikRepository rep;
	
	@Override
	public Cenovnik findOne(Long id) {
		// TODO Auto-generated method stub
		return rep.findById(id).orElse(null);
	}

	@Override
	public Cenovnik save(Cenovnik cenovnik) {
		// TODO Auto-generated method stub
		return rep.save(cenovnik);
	}

}
