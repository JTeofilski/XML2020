package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.Cenovnik;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.repository.CenovnikRepository;

@Transactional
@Service
public class CenovnikServiceImpl implements CenovnikService {
	
	@Autowired
	private CenovnikRepository repository;

	@Override
	public Cenovnik findByIdentifikacioniBroj(long id) {
		
		return repository.findByIdentifikacioniBroj(id);
	}

}
