package com.xml.agent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xml.agent.model.ZahtevZaIznajmljivanje;
import com.xml.agent.repository.ZahtevZaIznajmljivanjeRepository;



@Transactional
@Service

public class ZahtevZaIznajmljivanjeServiceImpl implements ZahtevZaIznajmljivanjeService {

	@Autowired 
	private ZahtevZaIznajmljivanjeRepository repository;
	
	
	
	@Override
	public ZahtevZaIznajmljivanje save(ZahtevZaIznajmljivanje zahtev) {
		// TODO Auto-generated method stub
		return repository.save(zahtev);
	}



	@Override
	public List<ZahtevZaIznajmljivanje> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}



	@Override
	public ZahtevZaIznajmljivanje findOne(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}



	@Override
	public List<ZahtevZaIznajmljivanje> findByAgentId(long id) {
		return repository.findByAgentFirmaID(id);
	}
	
}
