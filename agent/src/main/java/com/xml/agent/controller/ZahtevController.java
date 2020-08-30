package com.xml.agent.controller;

import java.util.ArrayList;
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
import com.xml.agent.service.RezervisaniDatumiService;
import com.xml.agent.service.ZahtevZaIznajmljivanjeService;

@RestController
@RequestMapping(value = "/zahtevi")

public class ZahtevController {

	
	@Autowired
	private ZahtevZaIznajmljivanjeService zahtevService;
	
	@Autowired 
	private OglasService oglasService;
	
	@Autowired 
	private RezervisaniDatumiService rdService;
	
	
	
	
	
	
	@RequestMapping(method=RequestMethod.GET, value = "/{idAgenta}", consumes = "application/json", produces = "application/json")
	public  ResponseEntity<List<ZahtevZaIznajmljivanje>> agentoviZahtevi(@PathVariable("idAgenta") long idAgenta){
		List<ZahtevZaIznajmljivanje> zahtevi = new ArrayList<ZahtevZaIznajmljivanje>();
		for(ZahtevZaIznajmljivanje z:zahtevService.findByAgentId(idAgenta)) {
			System.out.println("status: "+z.getStatusIznajmljivanja());
			if(z.getStatusIznajmljivanja().equals("PENDING")) {
				zahtevi.add(z);
			}
		}
		return new ResponseEntity<List<ZahtevZaIznajmljivanje>>(zahtevi, HttpStatus.OK);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/odobri/{idZahteva}", consumes = "application/json")
	public  String odobriZahtev(@PathVariable("idZahteva") long idZahteva){
		
		ZahtevZaIznajmljivanje zahtev= zahtevService.findOne(idZahteva);
		
		
		for (Narudzbenica n:zahtev.getNarudzbenica()) {
			Oglas oglas= oglasService.findOne(n.getOglasId());
			
			List<RezervisaniDatumi> postojeci = rdService.findByOglasId(oglas.getIdentifikacioniBroj());
			//novi
			RezervisaniDatumi rd= new RezervisaniDatumi(n.getRentiranjeOd(),n.getRentiranjeDo(),oglas);
			
			//proci kroz listu postojecih datuma 
			
			for (RezervisaniDatumi p:postojeci) {
				if((p.getDatumOd().compareTo(rd.getDatumOd())*rd.getDatumOd().compareTo(p.getDatumDo())>=0)||(p.getDatumOd().compareTo(rd.getDatumDo())*rd.getDatumDo().compareTo(p.getDatumDo())>=0) ) {
					System.out.println("postoji vec taj datum u rezervacijama!");
					zahtev.setStatusIznajmljivanja("CANCELED");
					zahtevService.save(zahtev);	
					return "datum je vec rezervisan i zahtev ce biti otkazan";

				}
					
			}
		}
		
		// ako nijednom ne upadne u return znaci da su svi datumi ok
		for (Narudzbenica n:zahtev.getNarudzbenica()) {
				
			Oglas oglas= oglasService.findOne(n.getOglasId());
			RezervisaniDatumi rd= new RezervisaniDatumi(n.getRentiranjeOd(),n.getRentiranjeDo(),oglas);

			oglas.getRezervisaniDatumi().add(rd);
			oglasService.save(oglas);
		}
	
		
		zahtev.setStatusIznajmljivanja("PAID");
		zahtevService.save(zahtev);		
		return "svi datumi su ok";
		
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ZahtevZaIznajmljivanje> proslediNaMikroservis(){
		return zahtevService.findAll();
	}


	@RequestMapping(method=RequestMethod.GET, value = "/zaIzvestaj/{idAgenta}", consumes = "application/json", produces = "application/json")
	public  ResponseEntity<List<ZahtevZaIznajmljivanje>> agentoviZahteviZaIzvestaj(@PathVariable("idAgenta") long idAgenta){
		List<ZahtevZaIznajmljivanje> zahtevi = new ArrayList<ZahtevZaIznajmljivanje>();
		for(ZahtevZaIznajmljivanje z:zahtevService.findByAgentId(idAgenta)) {
			System.out.println("status: "+z.getStatusIznajmljivanja());
			if(z.getStatusIznajmljivanja().equals("PAID")) {
				zahtevi.add(z);
			}
		}
		return new ResponseEntity<List<ZahtevZaIznajmljivanje>>(zahtevi, HttpStatus.OK);
	
	}
	
}
