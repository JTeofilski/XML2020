package com.pretraga.Pretraga.controller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
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
		
		if(id!=0&&rezOd!="0"&&rezDo!="0") {
		Oglas oglas=oglasService.findOne(id);
		String rezervisanDatumOdS=rezOd.substring(6)+"-"+rezOd.substring(4,6)+"-"+rezOd.substring(0,4);
		String rezervisanDatumDoS=rezDo.substring(6)+"-"+rezDo.substring(4,6)+"-"+rezDo.substring(0,4);

		
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
		java.sql.Date sqlRezervisanoOd = null;
		java.util.Date dateOd;
		java.sql.Date sqlRezervisanoDo = null;
		java.util.Date dateDo;
		try {
			dateOd = sdf1.parse(rezervisanDatumOdS);
			sqlRezervisanoOd = new java.sql.Date(dateOd.getTime()); 
			
			dateDo = sdf1.parse(rezervisanDatumDoS);
			sqlRezervisanoDo = new java.sql.Date(dateDo.getTime()); 		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Narudzbenica narudzbenica= new Narudzbenica();
		narudzbenica.setAgentId(oglas.getAgent().getIdentifikacioniBroj());
		narudzbenica.setKorpaId(korpa.getIdentifikacioniBroj());
		narudzbenica.setCenovnikId(oglas.getCenovnik().getIdentifikacioniBroj());
		narudzbenica.setMarkaVozila(oglas.getVozilo().getNazivMarke());
		narudzbenica.setOglasId(oglas.getIdentifikacioniBroj());
		narudzbenica.setRegistrovaniKorisnikId(korid);
		narudzbenica.setRentiranjeOd(sqlRezervisanoOd);
		narudzbenica.setRentiranjeDo(sqlRezervisanoDo);
		service.save(narudzbenica);
		}
		List<Narudzbenica> narudzbenice=service.findByKorpaId(korid);
		
		return new ResponseEntity<List<Narudzbenica>>(narudzbenice, HttpStatus.OK);
	}
	
	

	@RequestMapping(method=RequestMethod.DELETE, value="/{id}/{korid}")
	public ResponseEntity<List<Narudzbenica>> brisanje(@PathVariable("id") Long id,@PathVariable("korid") Long korid){
		
		if(id!=0) {
			
			Narudzbenica narudzbenica=service.findByIdentifikacioniBroj(id);
			service.remove(narudzbenica);
		}
		List<Narudzbenica> narudzbenice=service.findByKorpaId(korid);
		return new ResponseEntity<List<Narudzbenica>>(narudzbenice, HttpStatus.OK);
	}
	

}
