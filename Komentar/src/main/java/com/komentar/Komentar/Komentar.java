package com.komentar.Komentar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Komentar {
	
	@GetMapping(value="/komentarmetoda")
	public String ispis() {
		return "ispis iz komentara";
	}

}
