package com.xml.agent.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agent.model.Narudzbenica;
import com.xml.agent.model.ZahtevZaIznajmljivanje;
import com.xml.agent.service.NarudzbenicaService;
import com.xml.agent.service.ZahtevZaIznajmljivanjeService;



@RestController
@RequestMapping(value = "/baza")
public class SinhronizacijaController {

	@Autowired
	private ZahtevZaIznajmljivanjeService zahtevService;
	
	@Autowired 
	private NarudzbenicaService narudzbenicaService;
	
	/*
	@RequestMapping(method=RequestMethod.POST, value = "/zahtev", consumes = "application/json", produces = "application/json")
	public  ZahtevZaIznajmljivanje kreiranjeZahteva(@RequestBody ZahtevZaIznajmljivanje zahtev){
		zahtevService.save(zahtev);
	
	return zahtev;
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/narudzbenica", consumes = "application/json", produces = "application/json")
	public Narudzbenica narudzbenica(@RequestBody Narudzbenica narudzbenica) {
		
		narudzbenicaService.save(narudzbenica);		
		
		return narudzbenica;	
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/narudzbenice", consumes = "application/json", produces = "application/json")
	public String narudzbenice(@RequestBody List<Narudzbenica> narudzbeniceMicro) {
		
		List<Narudzbenica> narudzbenice= narudzbenicaService.findAll();
		
		for(Narudzbenica narudzbenica:narudzbenice) {
			boolean postoji=false;
			for(Narudzbenica narudzbenicaMicro:narudzbeniceMicro) {		
				if((narudzbenica.getIdentifikacioniBroj()==narudzbenicaMicro.getIdentifikacioniBroj())&&(narudzbenica!=narudzbenicaMicro)) {
					postoji=true;
					narudzbenica=narudzbenicaMicro;
					narudzbenicaService.save(narudzbenica);	
					
				}
			}
			if(!postoji) {
				narudzbenicaService.remove(narudzbenica);	
			}
		}
		
		
		return "proslo";

	}
	
	*/
	
}
