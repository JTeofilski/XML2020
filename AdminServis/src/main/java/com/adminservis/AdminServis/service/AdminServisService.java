package com.adminservis.AdminServis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservis.AdminServis.model.Administrator;
import com.adminservis.AdminServis.repository.AdminServisRepository;

@Service
public class AdminServisService {
	
	@Autowired
    private  AdminServisRepository repository;
	
	
	public Administrator updateTKorisnik(Administrator k) {
		
	//	Administrator korisnik=repository.findById(k.getId());
	//	System.out.println(k.getStatus());
	//	korisnik.setStatus(k.getStatus());
		return repository.save(k);
		
	}

}
