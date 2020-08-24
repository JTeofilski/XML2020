package com.xml.agent.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

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
import com.xml.agent.model.Cenovnik;
import com.xml.agent.model.Oglas;
import com.xml.agent.model.Vozilo;
import com.xml.agent.service.AgentService;
import com.xml.agent.service.CenovnikService;
import com.xml.agent.service.OglasService;
import com.xml.agent.service.VoziloService;

@RestController
@RequestMapping(value = "/oglasi")
public class OglasController {

	@Autowired
	private OglasService oglasService;
	
	@Autowired
	private CenovnikService cenovnik;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private VoziloService voziloService;
	
	@RequestMapping(method=RequestMethod.POST, value = "/dodajOglas/{agent}/{cenovnik}/{voziloSlobodnoOd}/{voziloSlobodnoDo}/{collisiondamageWaiver}", consumes="application/json")
	public ResponseEntity<Oglas> addAd(@RequestBody Vozilo vozilo, @PathVariable("agent") Long id1,@PathVariable("cenovnik") Long id, @PathVariable("voziloSlobodnoOd") Date date1, @PathVariable("voziloSlobodnoDo") Date date2, @PathVariable("collisiondamageWaiver") boolean collision){
	
		Oglas oglasNovi = new Oglas();
		Cenovnik cenovnik1 = cenovnik.findOne(id);
		oglasNovi.setCenovnik(cenovnik1);
		oglasNovi.setVozilo(vozilo);
		oglasNovi.setAgent(agentService.findOne(id1));
		vozilo.setSlike("slike/crno_mece1.jpg;slike/crno_mece.jpg");
		voziloService.save(vozilo);
		oglasService.save(oglasNovi);
		
		 final String uri = "http://localhost:2020/pretragaapp/oglasi/dodajOglas/" + id1 + "/" + id + "/"  + collision;
			ObjectMapper mapper= new ObjectMapper();
			String json = null;
			
			try {
				json= mapper.writeValueAsString(vozilo);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>(json,headers);
			restTemplate.postForObject(uri, entity, Vozilo.class);
	    
		return new ResponseEntity<>( oglasNovi, HttpStatus.OK);
	}
}
