package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZahtevZaIznajmljivanje {
	@GetMapping(value="/zahtevzaiznajmljivanjemetoda")
	public String ispis() {
		return "Ispis iz zahteva za iznajmljivanje";
	}
	

}
