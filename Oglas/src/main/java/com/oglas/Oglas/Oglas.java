package com.oglas.Oglas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Oglas {
	
	@GetMapping(value="/oglasmetoda")
	public String ispis() {
		return "Ispis iz oglasa";
	}
}