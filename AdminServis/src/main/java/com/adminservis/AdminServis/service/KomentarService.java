package com.adminservis.AdminServis.service;

import java.util.ArrayList;

import com.adminservis.AdminServis.model.Komentar;

public interface KomentarService {
	
	 Komentar findOne(long id);

	 void save (Komentar komentar);
	 
	 ArrayList<Komentar> findAll();

}
