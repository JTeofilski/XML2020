package com.xml.agent.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xml.agent.model.ModelVozila;
import com.xml.agent.repository.ModelRepository;

@Transactional
@Service
public class ModelServiceImpl implements ModelService{

	@Autowired
	private ModelRepository rep;
	
	@Override
	public ModelVozila findOne(Long id) {
		// TODO Auto-generated method stub
		return rep.findById(id).orElse(null);
	}

	@Override
	public ModelVozila delete(Long id) {
		ModelVozila model = rep.findById(id).orElse(null);
		if(model == null) {
			throw new IllegalArgumentException("Model ne postoji!");
		}
		rep.deleteById(id);
		return model;	
	}

	@Override
	public ModelVozila save(ModelVozila model) {
		// TODO Auto-generated method stub
		return rep.save(model);
	}

	@Override
	public List<ModelVozila> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
