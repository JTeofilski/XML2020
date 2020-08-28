package com.xml.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xml.agent.model.Narudzbenica;
import com.xml.agent.model.Oglas;
import com.xml.agent.model.RezervisaniDatumi;
import com.xml.agent.model.ZahtevZaIznajmljivanje;
import com.xml.agent.service.OglasService;
import com.xml.agent.service.ZahtevZaIznajmljivanjeService;

@RestController
@RequestMapping(value = "/zahtevi")

public class ZahtevController {

	
	@Autowired
	private ZahtevZaIznajmljivanjeService zahtevService;
	
	@Autowired 
	private OglasService oglasService;
	
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.GET, value = "/{idAgenta}", consumes = "application/json", produces = "application/json")
	public  ResponseEntity<List<ZahtevZaIznajmljivanje>> agentoviZahtevi(@PathVariable("idAgenta") long idAgenta){
		
		return new ResponseEntity<List<ZahtevZaIznajmljivanje>>(zahtevService.findByAgentId(idAgenta), HttpStatus.OK);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/odobri{idZahteva}", consumes = "application/json", produces = "application/json")
	public  ResponseEntity<List<ZahtevZaIznajmljivanje>> odobriZahtev(@PathVariable("idZahteva") long idZahteva){
		
		ZahtevZaIznajmljivanje zahtev= zahtevService.findOne(idZahteva);
		zahtev.setStatusIznajmljivanja("PAID");
		
		
		for (Narudzbenica n:zahtev.getNarudzbenica()) {
			Oglas oglas= oglasService.findOne(n.getOglasId());
			RezervisaniDatumi rd= new RezervisaniDatumi(n.getRentiranjeOd(),n.getRentiranjeDo(),oglas);
			
			oglas.getRezervisaniDatumi().add(rd);
			oglasService.save(oglas);
		}
		
		
		zahtevService.save(zahtev);		
		return null;
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ZahtevZaIznajmljivanje> proslediNaMikroservis(){
		return zahtevService.findAll();
	}


	
}
