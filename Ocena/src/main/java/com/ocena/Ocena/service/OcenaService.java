package com.ocena.Ocena.service;

import java.util.List;

import com.ocena.Ocena.model.Ocena;

public interface OcenaService {
	
	Ocena save (Ocena ocena);
	
	List<Ocena> findAll();

}
