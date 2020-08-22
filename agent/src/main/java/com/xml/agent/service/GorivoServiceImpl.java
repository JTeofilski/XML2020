package com.xml.agent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agent.model.VrstaGoriva;
import com.xml.agent.repository.GorivoRepository;


@Transactional
@Service
public class GorivoServiceImpl implements GorivoService{

	@Autowired
	private GorivoRepository rep;
	
	@Override
	public VrstaGoriva findOne(Long id) {
		// TODO Auto-generated method stub
		return rep.findById(id).orElse(null);
	}

	@Override
	public VrstaGoriva delete(Long id) {
		VrstaGoriva gorivo = rep.findById(id).orElse(null);
		if(gorivo == null) {
			throw new IllegalArgumentException("Vrsta goriva ne postoji!");
		}
		rep.deleteById(id);
		return gorivo;	
	}

	@Override
	public VrstaGoriva save(VrstaGoriva gorivo) {
		// TODO Auto-generated method stub
		return rep.save(gorivo);
	}

	@Override
	public List<VrstaGoriva> findAll() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

}
