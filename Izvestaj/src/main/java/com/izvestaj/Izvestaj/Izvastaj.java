package com.izvestaj.Izvestaj;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Izvastaj {
	
	@GetMapping(value="/izvestajmetoda")
	public String ispis() {
		return "Ispis iz izvestaja";
	}
	
}
