package com.komentar.Komentar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.komentar.Komentar.model.Komentar;
import com.komentar.Komentar.repository.KomentarRepository;

@Service
public class KomentarServiceImpl implements KomentarService {

	@Autowired
	private KomentarRepository komentarRepo;

	@Override
	public void save(Komentar komentar) {
		komentarRepo.save(komentar);
	}

	@Override
	public List<Komentar> findByOglasId(long id) {
		return komentarRepo.findByOglasIdentifikacioniBroj(id);
	}
	
	
}
