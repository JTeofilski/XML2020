package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.controller;

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
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.Oglas;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.service.ZahtevZaIznajmljivanjeService;


@RestController
@RequestMapping(value = "/zahtevi")
public class ZahtevZaIznajmljivanjeController {

	
	@Autowired
	private ZahtevZaIznajmljivanjeService zahtevService;
	
	
	
	@RequestMapping(method=RequestMethod.POST, value = "kreiranje/{bundle}", consumes="application/json")
	public ResponseEntity <ZahtevZaIznajmljivanje> kreiranjeZahteva(@PathVariable("bundle") boolean bundle, @RequestBody List<Oglas> oglasi){
		
		ZahtevZaIznajmljivanje z = null;
		if(bundle==true) {
			
			for (int i=0;i<oglasi.size();i++) {
				z= new ZahtevZaIznajmljivanje();
			
				for (int j=1;j<oglasi.size();j++) {
					if(oglasi.get(i).getAgent().getIme().equals(oglasi.get(j).getAgent().getIme())) {
						if(z.getOglasi()== null) {
							Set<Oglas> set = new HashSet<>();
							set.add(oglasi.get(j));
							z.setOglasi(set);	
						}
						else {
							System.out.println("isti agenti");
							z.getOglasi().add(oglasi.get(j));			
							oglasi.remove(j);
						
						}
					}
				}
				z.getOglasi().add(oglasi.get(i));
				z.setAgentFirmaID(oglasi.get(i).getAgent().getIdentifikacioniBroj());
				z.setStatusIznajmljivanja("PENDING");
				zahtevService.save(z);
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
