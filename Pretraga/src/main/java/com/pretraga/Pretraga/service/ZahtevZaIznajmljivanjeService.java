package com.pretraga.Pretraga.service;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.pretraga.Pretraga.model.Oglas;
import com.pretraga.Pretraga.model.ZahtevZaIznajmljivanje;
import com.pretraga.Pretraga.service.*;

public interface ZahtevZaIznajmljivanjeService {

	List<ZahtevZaIznajmljivanje> findAll();
	
	ZahtevZaIznajmljivanje save(ZahtevZaIznajmljivanje zahtev);
}
