package com.pretraga.Pretraga.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pretraga.Pretraga.model.Oglas;
import com.pretraga.Pretraga.service.OglasService;

@RestController
@RequestMapping(value = "/oglas")
public class DetaljanPrikazController {
	
	@Autowired
	private OglasService oglasService;
	
	@RequestMapping(method=RequestMethod.GET, value = "/{id}")
	public ResponseEntity<Oglas> dobaviOglasPoId(@PathVariable("id") Long id){
		Oglas oglas = oglasService.findOne(id);	
		System.out.println(id);
		return new ResponseEntity<Oglas>(oglas, HttpStatus.OK);
	}

}
