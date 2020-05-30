package com.poruka.Poruka;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Poruka {
	
	@GetMapping(value="/porukametoda")
	public String ispis() {
		return "ispis iz poruke";
		
	}

}
