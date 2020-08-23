package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.service;

import java.util.List;

import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.ZahtevZaIznajmljivanje;

public interface ZahtevZaIznajmljivanjeService {

	
	ZahtevZaIznajmljivanje save(ZahtevZaIznajmljivanje zahtev);
	
	List<ZahtevZaIznajmljivanje> findAll();
}
