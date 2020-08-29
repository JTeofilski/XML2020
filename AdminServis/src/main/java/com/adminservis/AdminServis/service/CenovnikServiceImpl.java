package com.adminservis.AdminServis.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservis.AdminServis.model.Cenovnik;
import com.adminservis.AdminServis.repository.CenovnikRepository;


@Transactional
@Service
public class CenovnikServiceImpl implements CenovnikService{

	@Autowired
	private CenovnikRepository rep;
	
	@Override
	public List<Cenovnik> findAll() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

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
