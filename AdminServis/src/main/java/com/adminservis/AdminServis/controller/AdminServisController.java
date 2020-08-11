package com.adminservis.AdminServis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminservis.AdminServis.model.RegistrovaniKorisnik;
import com.adminservis.AdminServis.model.TKorisnik;
import com.adminservis.AdminServis.service.AdminServisService;
import com.adminservis.AdminServis.service.RegistrovaniKorisnikService;


@RestController
@RequestMapping(value = "/korisnici")
public class AdminServisController {
	
	
	/*@PutMapping("/update")
    public TKorisnik updateTKorisnik(@RequestBody TKorisnik korisnik){
        return service.updateTKorisnik(korisnik);
    }*/
	
}
