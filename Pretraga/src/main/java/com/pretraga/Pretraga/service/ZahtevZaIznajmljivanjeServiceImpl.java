package com.pretraga.Pretraga.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pretraga.Pretraga.repository.*;
import com.pretraga.Pretraga.model.*;

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
	
}
