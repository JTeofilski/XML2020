package com.registracija.Registracija;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Registracija {
	
	@GetMapping(value="/registracijametoda")
	public String ispis() {
		return "ispis iz registracije";
	}
	

}
