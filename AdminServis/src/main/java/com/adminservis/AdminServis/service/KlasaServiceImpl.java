package com.adminservis.AdminServis.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservis.AdminServis.model.KlasaAutomobila;
import com.adminservis.AdminServis.model.MarkaVozila;
import com.adminservis.AdminServis.repository.KlasaRepository;

@Transactional
@Service
public class KlasaServiceImpl implements KlasaService{

	@Autowired
	private KlasaRepository rep;
	
	@Override
	public KlasaAutomobila findOne(Long id) {
		// TODO Auto-generated method stub
		return rep.findById(id).orElse(null);
	}

	@Override
	public KlasaAutomobila delete(Long id) {
		KlasaAutomobila klasa = rep.findById(id).orElse(null);
		if(klasa == null) {
			throw new IllegalArgumentException("Klasa vozila ne postoji!");
		}
		rep.deleteById(id);
		return klasa;	
	}

	@Override
	public KlasaAutomobila save(KlasaAutomobila klasa) {
		// TODO Auto-generated method stub
		return rep.save(klasa);
	}

	@Override
	public List<KlasaAutomobila> findAll() {
		// TODO Auto-generated method stub
		return rep.findAll();
	}

}
