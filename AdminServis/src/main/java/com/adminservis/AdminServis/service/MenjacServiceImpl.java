package com.adminservis.AdminServis.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservis.AdminServis.model.TipMenjaca;
import com.adminservis.AdminServis.model.TipMenjaca;
import com.adminservis.AdminServis.repository.MenjacRepository;

@Transactional
@Service
public class MenjacServiceImpl implements MenjacService{

	@Autowired
	private MenjacRepository rep;
	
	@Override
	public TipMenjaca findOne(Long id) {
		// TODO Auto-generated method stub
		return rep.findById(id).orElse(null);
	}

	@Override
	public TipMenjaca delete(Long id) {
		TipMenjaca menjac = rep.findById(id).orElse(null);
		if(menjac == null) {
			throw new IllegalArgumentException("Menjac ne postoji!");
		}
		rep.deleteById(id);
		return menjac;	
	}

	@Override
	public TipMenjaca save(TipMenjaca menjac) {
		// TODO Auto-generated method stub
		return rep.save(menjac);
	}

	@Override
	public List<TipMenjaca> findAll() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

}
