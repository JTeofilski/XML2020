package com.adminservis.AdminServis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminservis.AdminServis.model.RegistrovaniKorisnik;
import com.adminservis.AdminServis.service.RegistrovaniKorisnikService;

@RestController
@RequestMapping(value = "/korisnici")
public class RegistrovaniKorisnikKontroler {

	@Autowired
    private RegistrovaniKorisnikService korisnikService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/sviRegistrovani")
	public ResponseEntity<List<RegistrovaniKorisnik>> getUsers(){
		List<RegistrovaniKorisnik> korisnici = korisnikService.findAll();
		
		
		return new ResponseEntity<List<RegistrovaniKorisnik>>(korisnici, HttpStatus.OK);
	}
	@RequestMapping(value="obrisi/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<RegistrovaniKorisnik> remove(@PathVariable("id") Long id) {
		RegistrovaniKorisnik korisnik = korisnikService.delete(id);
		
		return new ResponseEntity<RegistrovaniKorisnik>(korisnik, HttpStatus.OK);
	}
	@RequestMapping(value="blokiraj/{id}", method=RequestMethod.PUT)
	public ResponseEntity<RegistrovaniKorisnik> block(@PathVariable("id") Long id) {
		RegistrovaniKorisnik korisnik = korisnikService.findOne(id);
		korisnik.setStatus("blokiran");
		korisnikService.save(korisnik);
		
		return new ResponseEntity<RegistrovaniKorisnik>(korisnik, HttpStatus.OK);
	}
	@RequestMapping(value="aktiviraj/{id}", method=RequestMethod.PUT)
	public ResponseEntity<RegistrovaniKorisnik> activate(@PathVariable("id") Long id) {
		RegistrovaniKorisnik korisnik = korisnikService.findOne(id);
		korisnik.setStatus("aktivan");
		korisnikService.save(korisnik);
		
		return new ResponseEntity<RegistrovaniKorisnik>(korisnik, HttpStatus.OK);
	}
}
