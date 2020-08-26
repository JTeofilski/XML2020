package com.poruka.Poruka.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.poruka.Poruka.model.ZahtevZaIznajmljivanje;


public interface ZahtevZaIznajmljivanjeService {

	List<ZahtevZaIznajmljivanje> findAll();
	
	ZahtevZaIznajmljivanje findOne(Long id);
	
	ZahtevZaIznajmljivanje save(ZahtevZaIznajmljivanje zahtev);
}
