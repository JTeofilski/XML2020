package com.xml.agent.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.xml.agent.model.ZahtevZaIznajmljivanje;



public interface ZahtevZaIznajmljivanjeService {

	List<ZahtevZaIznajmljivanje> findAll();
	
	ZahtevZaIznajmljivanje findOne(Long id);
	
	ZahtevZaIznajmljivanje save(ZahtevZaIznajmljivanje zahtev);
	
	List<ZahtevZaIznajmljivanje> findByAgentId(long id);
}
