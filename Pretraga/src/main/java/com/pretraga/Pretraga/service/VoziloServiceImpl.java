package com.pretraga.Pretraga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.netflix.discovery.converters.Auto;
import com.pretraga.Pretraga.model.Vozilo;
import com.pretraga.Pretraga.repository.VoziloRepository;

public class VoziloServiceImpl implements VoziloService{
  @Autowired
  private VoziloRepository voziloRepository;
  
	@Override
	public Page<Vozilo> findVozilo(String criteria, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vozilo findOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vozilo getVozilo(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vozilo> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return voziloRepository.findAll(sort);
	}

	@Override
	public Vozilo save(Vozilo vozilo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vozilo> save(List<Vozilo> vozila) {
		// TODO Auto-generated method stub
		return null;
	}

}
