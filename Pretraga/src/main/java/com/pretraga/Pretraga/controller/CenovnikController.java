package com.pretraga.Pretraga.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pretraga.Pretraga.model.Cenovnik;
import com.pretraga.Pretraga.service.CenovnikService;

@RestController
@RequestMapping(value = "/cenovnici")
public class CenovnikController {

	@Autowired
	private CenovnikService cenovnikService;
	
	@RequestMapping(method=RequestMethod.POST, value = "/dodajSaAgenta", consumes="application/json", produces="application/json")
	public ResponseEntity<Cenovnik> prenosSaAgenta(@RequestBody Cenovnik cenovnik){
	
		Cenovnik cenovnik1 = cenovnik;
		List<Cenovnik> postojeciCenovnici = new ArrayList<Cenovnik>();
		postojeciCenovnici = cenovnikService.findAll();
		List<Long> ids = new ArrayList<>();
		for(int i=0; i<postojeciCenovnici.size(); i++) {
			
			ids.add(postojeciCenovnici.get(i).getIdentifikacioniBroj());
		}
		
		if(postojeciCenovnici.size()>0) {
		cenovnik1.setIdentifikacioniBroj(Collections.max(ids)+1);
		}else {
			cenovnik1.setIdentifikacioniBroj(1);
		}
		cenovnikService.save(cenovnik1);
		
		return new ResponseEntity<>(cenovnik1, HttpStatus.OK);
	}
}
