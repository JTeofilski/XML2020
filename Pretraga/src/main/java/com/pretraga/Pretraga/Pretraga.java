package com.pretraga.Pretraga;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pretraga {
	@GetMapping(value="/pretragametoda")
	public String ispis() {
		return "Ispis iz pretrage";
	}
}
