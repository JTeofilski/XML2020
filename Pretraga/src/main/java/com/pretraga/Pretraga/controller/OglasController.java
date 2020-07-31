package com.pretraga.Pretraga.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pretraga.Pretraga.model.Oglas;
import com.pretraga.Pretraga.repository.OglasRepository;
import com.pretraga.Pretraga.service.OglasService;

@RestController
@RequestMapping(value = "/oglasi")
public class OglasController {

	@Autowired
	private OglasService oglasService;
	
	@Autowired
	private OglasRepository oglasRepository;
	
	@RequestMapping(method=RequestMethod.GET, value = "/sviOglasi")
	public ResponseEntity<List<Oglas>> getAds(){
		List<Oglas> oglasi = oglasService.findAll();
		
		
		return new ResponseEntity<List<Oglas>>(oglasi, HttpStatus.OK);
	}
	 @RequestMapping(value="/pretraga/{adresa}/{voziloSlobodnoOd}/{voziloSlobodnoDo}", method=RequestMethod.GET)
	  	@ResponseBody
	  	public ResponseEntity<List<Oglas>> search(@PathVariable("adresa") String adresa, @PathVariable("voziloSlobodnoOd") Date slobodnoOd, @PathVariable("voziloSlobodnoDo") Date slobodnoDo){
	  		List<Oglas> oglasi = oglasService.findAll();
	  		List<Oglas> oglasiPretraga = new ArrayList<Oglas>();
	  		System.out.println("pretraga  " + java.time.LocalDate.now());
	  		for(int i=0; i<oglasi.size(); i++) {
	  			if(oglasi.get(i).getAgent().getAdresa().equals(adresa)&&oglasi.get(i).getVoziloSlobodnoOd().compareTo(slobodnoOd)<=0&&oglasi.get(i).getVoziloSlobodnoDo().compareTo(slobodnoDo)>=0&&slobodnoOd.compareTo(slobodnoDo)<0){
	  				oglasiPretraga.add(oglasi.get(i));
	  			}
	  			
	  		}
	  		
	  		return new ResponseEntity<List<Oglas>>(oglasiPretraga, HttpStatus.OK);
	  	}
}
