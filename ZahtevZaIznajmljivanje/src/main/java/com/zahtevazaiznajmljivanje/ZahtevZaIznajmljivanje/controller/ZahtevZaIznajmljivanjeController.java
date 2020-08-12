package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.ZahtevZaIznajmljivanje;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.Agent;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.Oglas;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.service.ZahtevZaIznajmljivanjeService;


@RestController
@RequestMapping(value = "/zahtevi")
public class ZahtevZaIznajmljivanjeController {

	
	@Autowired
	private ZahtevZaIznajmljivanjeService zahtevService;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value = "kreiranje/{bundle}", consumes="application/json")
	public ResponseEntity <ZahtevZaIznajmljivanje> kreiranjeZahteva(@PathVariable("bundle") boolean bundle, @RequestBody List<Oglas> oglasi){
		ArrayList<Agent> agenti = new ArrayList<>();
		ZahtevZaIznajmljivanje z = null;
		ArrayList<Agent> agentiNovo = new ArrayList<>();
		if(bundle==true) {
			for (int i=0;i<oglasi.size();i++) {
				  agenti.add(oglasi.get(i).getAgent()); //stavlja sve agente u posebnu listu
			}
			
			for(int j=0; j<agenti.size(); j++) {
				
				
				if(agentiNovo.size()==0){
					agentiNovo.add(agenti.get(j));
					
				}
				
			
				    if(!agentiNovo.contains(agenti.get(j))) {
						//algoritam za trazenje duplikata...mozda moze ovako
						agentiNovo.add(agenti.get(j));
					
				
					
				}
			}
			for(int i=0; i<agentiNovo.size(); i++) {
			System.out.println("agent novo id " + agentiNovo.get(i).getIdentifikacioniBroj());
			}
			List<List<Oglas>> setovi = new ArrayList<List<Oglas>>();
			List<ZahtevZaIznajmljivanje> zahtevi = new ArrayList<ZahtevZaIznajmljivanje>();
			for(int i=0; i<agentiNovo.size(); i++) {
				System.out.println("ima li necega "  + agentiNovo.get(i).getIme());
				List<Oglas> list = new ArrayList<Oglas>(); 
			    //ova lista posle mora da se konvertuje u set
				setovi.add(list);
				ZahtevZaIznajmljivanje zahtev = new ZahtevZaIznajmljivanje();
				
			    zahtevi.add(zahtev);
			} //za svakog agenta pravi njegove posebne zahteve i liste u koje ce posle staviti oglase
			//posle se pristupa zahtev.get(k), gde je k broj agenta u listi 
			
			for (int i=0;i<oglasi.size();i++) {
				//z= new ZahtevZaIznajmljivanje();
				for(int k=0; k<agentiNovo.size(); k++) {
				//for (int j=1;j<oglasi.size();j++) {
					if(oglasi.get(i).getAgent().equals(agentiNovo.get(k))) {
						if(zahtevi.get(k).getOglasi()== null) {
							//Set<Oglas> set = new HashSet<>();
							setovi.get(k).add(oglasi.get(i));
							Set<Oglas> targetSet = new HashSet<>(setovi.get(k));//konvertujem listu u set
							zahtevi.get(k).setOglasi(targetSet); //dodaju se bas u zahtev agenta k	
						}
						else {
							System.out.println("isti agenti");
							zahtevi.get(k).getOglasi().add(oglasi.get(i));			
							oglasi.remove(i);
						
						}
					}
				//}
				}
				//z.getOglasi().add(oglasi.get(i));
				//z.setAgentFirmaID(oglasi.get(i).getAgent().getIdentifikacioniBroj());
				//z.setStatusIznajmljivanja("PENDING");
				for(int m=0; m<zahtevi.size(); m++) {
				zahtevService.save(zahtevi.get(m));
				}
			}
		}
		else {
			
			for (int i=0;i<oglasi.size();i++) {
				z = new ZahtevZaIznajmljivanje();
				if(z.getOglasi()== null) {
					Set<Oglas> set = new HashSet<>();
					set.add(oglasi.get(i));
					z.setOglasi(set);	
					z.setAgentFirmaID(oglasi.get(i).getAgent().getIdentifikacioniBroj());
					z.setStatusIznajmljivanja("PENDING");
					zahtevService.save(z);
				}
			
			}
			
		}
		
		
		
		return  new ResponseEntity<ZahtevZaIznajmljivanje>(z, HttpStatus.OK);
	}
}
