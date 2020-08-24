package com.xml.agent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agent.model.Cenovnik;
import com.xml.agent.repository.CenovnikRepository;

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

}
