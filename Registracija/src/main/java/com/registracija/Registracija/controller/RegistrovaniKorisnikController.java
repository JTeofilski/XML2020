package com.registracija.Registracija.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.registracija.Registracija.model.RegistrovaniKorisnik;
import com.registracija.Registracija.service.RegistrovaniKorisnikService;

@RestController
@RequestMapping(value = "/korisnici")
public class RegistrovaniKorisnikController {

	@Autowired
	private RegistrovaniKorisnikService korisnikService;
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/registracija", consumes="application/json")
	public ResponseEntity<RegistrovaniKorisnik> registrovanje(@RequestBody RegistrovaniKorisnik korisnik, HttpSession httpSession){
	
		RegistrovaniKorisnik userSaved = new RegistrovaniKorisnik();
		userSaved.setIme(korisnik.getIme());
		userSaved.setPrezime(korisnik.getPrezime());
		userSaved.setEmail(korisnik.getEmail());
		userSaved.setKorisnickoIme(korisnik.getKorisnickoIme());
		userSaved.setLozinka(korisnik.getLozinka());
		userSaved.setAdresa(korisnik.getAdresa());
		userSaved.setStatus("ulogovan");
		korisnikService.save(userSaved);
		
		httpSession.setAttribute("ulogovan", userSaved);
		return new ResponseEntity<>( userSaved, HttpStatus.OK);
	}
}
