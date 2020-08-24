package com.komentar.Komentar.service;

import java.util.List;

import com.komentar.Komentar.model.Komentar;

public interface KomentarService {
	
	void save (Komentar komentar);
	
	List<Komentar> findByOglasId (long id);
}
