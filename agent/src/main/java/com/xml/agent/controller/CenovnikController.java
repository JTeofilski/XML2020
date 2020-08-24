package com.xml.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agent.model.Cenovnik;
import com.xml.agent.service.CenovnikService;

@RestController
@RequestMapping(value = "/cenovnici")
public class CenovnikController {

	@Autowired
	private CenovnikService service;
	
	@RequestMapping(method=RequestMethod.GET, value = "/sviCenovnici")
	public ResponseEntity<List<Cenovnik>> getCenovnivi(){
		List<Cenovnik> cenovnici = service.findAll();
		
		
		return new ResponseEntity<List<Cenovnik>>(cenovnici, HttpStatus.OK);
	}
}
