package com.adminservis.AdminServis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.adminservis.AdminServis.model.TKorisnik;
import com.adminservis.AdminServis.service.AdminServisService;


@RestController
public class AdminServisController {
	
	@Autowired
    private AdminServisService service;
	
	@PutMapping("/update")
    public TKorisnik updateTKorisnik(@RequestBody TKorisnik korisnik){
        return service.updateTKorisnik(korisnik);
    }
	
}
