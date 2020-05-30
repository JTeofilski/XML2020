package com.login.Login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
	
	@GetMapping(value="/loginmetoda")
	public String ispis() {
		return "ispis iz logina";
	}
}
