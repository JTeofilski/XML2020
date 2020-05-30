package com.ocena.Ocena;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Ocena {
	
	@GetMapping(value="/ocenametoda")
	public String ispis() {
		return "ispis is ocene";
	}

}
