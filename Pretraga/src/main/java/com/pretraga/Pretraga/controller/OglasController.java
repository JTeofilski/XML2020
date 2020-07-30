package com.pretraga.Pretraga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pretraga.Pretraga.model.Oglas;
import com.pretraga.Pretraga.service.OglasService;

@RestController
@RequestMapping(value = "/oglasi")
public class OglasController {

	@Autowired
	private OglasService oglasService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/sviOglasi")
	public ResponseEntity<List<Oglas>> getAds(){
		List<Oglas> oglasi = oglasService.findAll();
		
		
		return new ResponseEntity<List<Oglas>>(oglasi, HttpStatus.OK);
	}
}
