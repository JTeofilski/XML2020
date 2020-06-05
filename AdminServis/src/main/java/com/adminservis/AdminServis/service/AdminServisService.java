package com.adminservis.AdminServis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservis.AdminServis.model.TKorisnik;
import com.adminservis.AdminServis.repository.AdminServisRepository;

@Service
public class AdminServisService {
	
	@Autowired
    private  AdminServisRepository repository;
	
	
	public TKorisnik updateTKorisnik(TKorisnik k) {
		
		TKorisnik korisnik=repository.findById(k.getId());
		System.out.println(k.getStatus());
		korisnik.setStatus(k.getStatus());
		return repository.save(korisnik);
		
	}

}
