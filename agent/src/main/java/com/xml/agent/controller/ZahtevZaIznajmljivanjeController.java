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

import com.xml.agent.model.ZahtevZaIznajmljivanje;
import com.xml.agent.service.ZahtevZaIznajmljivanjeService;



@RestController
@RequestMapping(value = "/zahtevi")
public class ZahtevZaIznajmljivanjeController {

	@Autowired
	private ZahtevZaIznajmljivanjeService service;
	
	@RequestMapping(method=RequestMethod.POST, value = "/kreiraj", consumes = "application/json")
	public  ZahtevZaIznajmljivanje kreiranjeZahteva(@RequestBody ZahtevZaIznajmljivanje zahtev){
		service.save(zahtev);
	
	return zahtev;
	}
}
