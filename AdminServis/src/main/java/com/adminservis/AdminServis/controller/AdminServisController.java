package com.adminservis.AdminServis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminservis.AdminServis.model.Administrator;
import com.adminservis.AdminServis.service.AdminServisService;


@RestController
@RequestMapping(value = "/admini")
public class AdminServisController {
	
	@Autowired
	private AdminServisService adminService;
	
	/*@PutMapping("/update")
    public TKorisnik updateTKorisnik(@RequestBody TKorisnik korisnik){
        return service.updateTKorisnik(korisnik);
    }*/
	
	@RequestMapping(method=RequestMethod.POST, value = "/logovanje", consumes="application/json")
	public ResponseEntity<Administrator> logAdmin(@RequestBody Administrator admin){
	
		if( adminService.getAdmin(admin.getEmail(), admin.getLozinka())==null){
			System.out.println("Pogresna kombinacija emaila i sifre!");
			return new ResponseEntity<>( adminService.getAdmin(admin.getEmail(), admin.getLozinka()), HttpStatus.NOT_FOUND);
		}
		
		System.out.println("Korisnik " +  adminService.getAdmin(admin.getEmail(), admin.getLozinka()).getIme() + " se uspesno ulogovao!");
		return new ResponseEntity<>( adminService.getAdmin(admin.getEmail(), admin.getLozinka()), HttpStatus.OK);
	}
}
