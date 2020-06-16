package com.adminservis.AdminServis.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminservis.AdminServis.model.Komentar;
import com.adminservis.AdminServis.repository.KomentarRepository;

import antlr.collections.List;

@Service
public class KomentarService {
	
	@Autowired
	private KomentarRepository repository;
	
	public Komentar findOne(long id) {
		return repository.findByIdentifikacioniBroj(id);
	}
	
	public Komentar update(long id) {
		Komentar k=repository.findByIdentifikacioniBroj(id);
		k.setStatusKomentara("odobren");
		return repository.save(k);
	}
	
	public ArrayList<Komentar> findAll(){
		ArrayList<Komentar> komentari=(ArrayList<Komentar>) repository.findAll();
		return komentari;
	}
	

}
