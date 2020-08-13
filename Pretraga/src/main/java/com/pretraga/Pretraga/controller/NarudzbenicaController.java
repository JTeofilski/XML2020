package com.pretraga.Pretraga.controller;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pretraga.Pretraga.model.Korpa;
import com.pretraga.Pretraga.model.Narudzbenica;
import com.pretraga.Pretraga.model.Oglas;
import com.pretraga.Pretraga.service.KorpaService;
import com.pretraga.Pretraga.service.NarudzbenicaService;
import com.pretraga.Pretraga.service.OglasService;

@RestController
@RequestMapping(value = "/narudzbenice")
public class NarudzbenicaController {
	
	@Autowired 
	private NarudzbenicaService service;
	
	@Autowired 
	private KorpaService korpaService;
	
	@Autowired 
	private OglasService oglasService;
	
	
	
	
	
	@RequestMapping(method=RequestMethod.GET, value="/{id}/{korid}/{rezOd}/{rezDo}")
	public ResponseEntity <List<Narudzbenica>> uKorpu(@PathVariable("id") Long id,@PathVariable("korid") Long korid,@PathVariable("rezOd") String rezOd,@PathVariable("rezDo") String rezDo){
		Korpa korpa= korpaService.findOne(korid);
		Oglas oglas=oglasService.findOne(id);
		String s=rezOd.substring(0,4)+"/"+rezOd.substring(4,6)+"/"+rezOd.substring(6);
		System.out.println(s);

		Narudzbenica narudzbenica= new Narudzbenica();
		narudzbenica.setAgentId(oglas.getAgent().getIdentifikacioniBroj());
		narudzbenica.setKorpaId(korpa.getIdentifikacioniBroj());
		narudzbenica.setMarkaVozila(oglas.getVozilo().getNazivMarke());
		narudzbenica.setOglasId(oglas.getIdentifikacioniBroj());
		narudzbenica.setRegistrovaniKorisnikId(korid);
		//narudzbenica.setRentiranjeOd(rezOd);
		//narudzbenica.setRentiranjeDo(rezDo);
		service.save(narudzbenica);
		
		List<Narudzbenica> narudzbenice=service.findByKorpaId(korid);
		
		return new ResponseEntity<List<Narudzbenica>>(narudzbenice, HttpStatus.OK);
	}
	

}
