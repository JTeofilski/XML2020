package com.adminservis.AdminServis.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adminservis.AdminServis.model.Komentar;
import com.adminservis.AdminServis.service.KomentarService;


@RestController
@RequestMapping("/komentari")
public class KomentarController {
	
	@Autowired
	private KomentarService service;
	
	@GetMapping
	public ResponseEntity<List<Komentar>> naCekanju() {
		List<Komentar> komentari=new ArrayList<Komentar>();
		for(Komentar k:service.findAll())
			if(k.getStatusKomentara().equals("CEKANJE"))
				komentari.add(k);
		return new ResponseEntity<List<Komentar>> (komentari, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/odobri/{id}")
	public ResponseEntity<List<Komentar>> update(@PathVariable int id) {
		Komentar komentar= service.findOne(id);
		komentar.setStatusKomentara("ODOBREN");
		service.save(komentar);
		List<Komentar> komentari=service.findAll();
		return new ResponseEntity<List<Komentar>> (komentari, HttpStatus.OK);
		
	}
	
	

}
