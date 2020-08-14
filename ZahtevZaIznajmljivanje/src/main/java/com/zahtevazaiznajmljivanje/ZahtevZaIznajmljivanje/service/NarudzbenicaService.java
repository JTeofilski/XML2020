package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.service;

import java.util.List;

import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.Narudzbenica;


public interface NarudzbenicaService {

	
	Narudzbenica findByIdentifikacioniBroj (long id);
	
	Narudzbenica save(Narudzbenica narudzbenica);
	
	
}
