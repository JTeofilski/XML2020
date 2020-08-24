package com.komentar.Komentar.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.komentar.Komentar.model.Oglas;



public interface OglasService {

	Page<Oglas> findOglas(String criteria, Pageable pageable);

	Oglas findOne(Long id);
	
	Oglas getOglas(String name);
	
	List<Oglas> findAll(Sort sort);
	
	Oglas save(Oglas oglas);
	
	List<Oglas> save(List<Oglas> oglasi);
	
	
}
