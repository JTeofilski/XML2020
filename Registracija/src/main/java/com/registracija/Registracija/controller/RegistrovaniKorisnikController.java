package com.registracija.Registracija.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.registracija.Registracija.model.Korpa;
import com.registracija.Registracija.model.RegistrovaniKorisnik;
import com.registracija.Registracija.service.RegistrovaniKorisnikService;

@RestController
@RequestMapping(value = "/korisnici")
public class RegistrovaniKorisnikController {

	@Autowired
	private RegistrovaniKorisnikService korisnikService;
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/registracija", consumes="application/json")
	public String registrovanje(@RequestBody RegistrovaniKorisnik korisnik, HttpSession httpSession){
	
		RegistrovaniKorisnik userSaved = new RegistrovaniKorisnik();
		userSaved.setIme(korisnik.getIme());
		userSaved.setPrezime(korisnik.getPrezime());
		userSaved.setEmail(korisnik.getEmail());
		userSaved.setKorisnickoIme(korisnik.getKorisnickoIme());
		userSaved.setLozinka(korisnik.getLozinka());
		userSaved.setAdresa(korisnik.getAdresa());
		userSaved.setStatus("cekanje");
		
		korisnikService.save(userSaved);
		Korpa korpa= new Korpa();
		System.out.println("id korisnika: "+userSaved.getIdentifikacioniBroj());
		korpa.setIdentifikacioniBroj(userSaved.getIdentifikacioniBroj());
		userSaved.setKorpa(korpa);
		korisnikService.save(userSaved);
		httpSession.setAttribute("ulogovan", userSaved);
		//return new ResponseEntity<>( userSaved, HttpStatus.OK);
		return "redirect:/pretragaapp/narudzbenice/1/1";
	}
	@RequestMapping(method=RequestMethod.POST, value = "/logovanje", consumes="application/json")
	public ResponseEntity<RegistrovaniKorisnik> logUser(@RequestBody RegistrovaniKorisnik user){
	
		if( korisnikService.getKorisnik(user.getEmail(), user.getLozinka())==null){
			System.out.println("Pogresna kombinacija emaila i sifre!");
			return new ResponseEntity<>( korisnikService.getKorisnik(user.getEmail(), user.getLozinka()), HttpStatus.NOT_FOUND);
		}
		
		System.out.println("Korisnik " +  korisnikService.getKorisnik(user.getEmail(), user.getLozinka()).getIme() + " se uspesno ulogovao!");
		return new ResponseEntity<>( korisnikService.getKorisnik(user.getEmail(), user.getLozinka()), HttpStatus.OK);
	}
}
