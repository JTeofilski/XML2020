package com.adminservis.AdminServis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminservis.AdminServis.model.MarkaVozila;
import com.adminservis.AdminServis.model.RegistrovaniKorisnik;
import com.adminservis.AdminServis.service.MarkaService;

@RestController
@RequestMapping(value = "/sifrarnik")
public class SifrarnikController {

	@Autowired
	private MarkaService markaService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/marke")
	public ResponseEntity<List<MarkaVozila>> sveMarke(){
		List<MarkaVozila> marke = markaService.findAll();
		
		
		return new ResponseEntity<List<MarkaVozila>>(marke, HttpStatus.OK);
	}
	
	@RequestMapping(value="obrisiMarku/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<MarkaVozila> remove(@PathVariable("id") Long id) {
	
		   MarkaVozila marka = markaService.delete(id);
		   
		return new ResponseEntity<MarkaVozila>(marka, HttpStatus.OK);
	}
}
