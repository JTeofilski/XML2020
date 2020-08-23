package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.ZahtevZaIznajmljivanje;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.repository.ZahtevZaIznajmljivanjeRepository;

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
		return repository.findAll();
	}
	
}
