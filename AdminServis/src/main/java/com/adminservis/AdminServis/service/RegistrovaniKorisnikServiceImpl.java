package com.adminservis.AdminServis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adminservis.AdminServis.model.RegistrovaniKorisnik;
import com.adminservis.AdminServis.repository.RegistrovaniKorisnikRepository;


@Transactional
@Service
public class RegistrovaniKorisnikServiceImpl implements RegistrovaniKorisnikService{

	@Autowired
	private RegistrovaniKorisnikRepository korisnikRepository;
	
	@Override
	public Page<RegistrovaniKorisnik> findKorisnik(String criteria, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistrovaniKorisnik findOne(Long id) {
		// TODO Auto-generated method stub
		return korisnikRepository.findById(id).orElse(null);
	}

	@Override
	public RegistrovaniKorisnik getKorisnik(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegistrovaniKorisnik> findAll() {
		// TODO Auto-generated method stub
		return korisnikRepository.findAll();
	}

	@Override
	public RegistrovaniKorisnik save(RegistrovaniKorisnik korisnik) {
		// TODO Auto-generated method stub
		return korisnikRepository.save(korisnik);
	}

	@Override
	public List<RegistrovaniKorisnik> save(List<RegistrovaniKorisnik> korisnici) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RegistrovaniKorisnik delete(Long id) {
		RegistrovaniKorisnik korisnik = korisnikRepository.findById(id).orElse(null);
		if(korisnik == null) {
			throw new IllegalArgumentException("Korisnik ne postoji!");
		}
		korisnikRepository.deleteById(id);
		return korisnik;	
		}

}
