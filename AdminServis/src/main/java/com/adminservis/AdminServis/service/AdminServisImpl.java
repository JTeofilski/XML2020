package com.adminservis.AdminServis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adminservis.AdminServis.model.Administrator;
import com.adminservis.AdminServis.repository.AdminServisRepository;


@Transactional
@Service
public class AdminServisImpl implements AdminServisService{

	@Autowired
	private AdminServisRepository rep;
	
	@Override
	public Administrator findOne(Long id) {
		// TODO Auto-generated method stub
		return rep.findById(id).orElse(null);
	}

	@Override
	public Administrator save(Administrator admin) {
		// TODO Auto-generated method stub
		return rep.save(admin);
	}

	@Override
	public Administrator getAdmin(String email, String password) {
		// TODO Auto-generated method stub
		return rep.findByEmailAndLozinka(email, password);
	}

	
}
