package com.adminservis.AdminServis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservis.AdminServis.model.Administrator;
import com.adminservis.AdminServis.repository.AdminServisRepository;


public interface AdminServisService {
	
	Administrator findOne(Long id);
	Administrator save(Administrator admin);
	Administrator getAdmin(String email, String password);

}
