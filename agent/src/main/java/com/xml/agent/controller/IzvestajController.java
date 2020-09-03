package com.xml.agent.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xml.agent.model.Izvestaj;
import com.xml.agent.model.Oglas;
import com.xml.agent.model.Vozilo;
import com.xml.agent.service.IzvestajService;
import com.xml.agent.service.OglasService;
import com.xml.agent.service.VoziloService;


@RestController
@RequestMapping(value = "/izvestaji")

public class IzvestajController {

	@Autowired
	private IzvestajService izvestajService;
	
	@Autowired
	private OglasService oglasService;
	
	@Autowired 
	private VoziloService voziloService;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/{idOglasa}", consumes="application/json")
	public ResponseEntity<Izvestaj> noviIzvestaj(@RequestBody Izvestaj izvestaj, @PathVariable("idOglasa") long idOglasa){
		Oglas oglas=oglasService.findOne(idOglasa);
		
		izvestaj.setIdVozila(oglas.getVozilo().getIdentifikacioniBroj());
		izvestajService.save(izvestaj);
		
		oglas.getVozilo().setPredjenaKilometraza(oglas.getVozilo().getPredjenaKilometraza()+izvestaj.getBrKilometara());  
		oglasService.save(oglas);
		int km = izvestaj.getBrKilometara();
		 final String uri = "http://localhost:2020/pretragaapp/oglasi/izmeniOglas/" + km;
		 
		 ObjectMapper mapper= new ObjectMapper();
			String json = null;
			
			try {
				json= mapper.writeValueAsString(oglas);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>(json,headers);
			restTemplate.postForObject(uri, entity, Oglas.class);
			
		return new ResponseEntity<Izvestaj>(izvestaj, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="/statistika/{idAgenta}" )
	public ResponseEntity<String> statistikaZaKm(@PathVariable("idAgenta") long idAgenta){
		
		String odgovor="";
		List<Izvestaj> izvestaji= izvestajService.findByIdAgenta(idAgenta);
		
		ArrayList<Long> voziloId =new ArrayList<Long>();
		
		for(Izvestaj i:izvestaji) {
			if(!voziloId.contains(i.getIdVozila())) {
				voziloId.add(i.getIdVozila());
			}
		}
		System.out.println("svi id vozila: "+voziloId.toString());
		
		double brKilometara=0;
		
		for(long vid:voziloId) {
			double brKilometaraTemp=0;
			List<Izvestaj> vozila=izvestajService.findByIdVozila(vid);
			for(Izvestaj brkm:vozila) {
				brKilometaraTemp+=brkm.getBrKilometara();
			}
			System.out.println("br kmTemp:" +brKilometaraTemp);
			
			if(brKilometaraTemp>brKilometara) {
				brKilometara=brKilometaraTemp;
				Vozilo vozilo=voziloService.findOne(vid);
				odgovor="Max km ima "+vozilo.getNazivMarke()+":"+brKilometara;
			}
		}
		return new ResponseEntity<String>(odgovor, HttpStatus.OK);
		
		
	}
	
	
}
	
