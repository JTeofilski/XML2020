package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.Cenovnik;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.Narudzbenica;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model.Oglas;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.service.CenovnikService;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.service.NarudzbenicaService;
import com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.service.ZahtevZaIznajmljivanjeService;


@RestController
@RequestMapping(value = "/zahtevi")
public class ZahtevZaIznajmljivanjeController {

	
	@Autowired
	private ZahtevZaIznajmljivanjeService zahtevService;
	
	@Autowired
	private NarudzbenicaService narServ;
	
	@Autowired
	private CenovnikService cenServ;
	
	

	@RequestMapping(method=RequestMethod.POST, value = "kreiranje/{bundle}/{korid}", consumes="application/json")
	public ResponseEntity <ZahtevZaIznajmljivanje> kreiranjeZahteva(@PathVariable("bundle") boolean bundle,@PathVariable("korid") long korid, @RequestBody List<Narudzbenica> narudzbenice){
		ArrayList<Long> agenti = new ArrayList<>();
		ZahtevZaIznajmljivanje z = null;
		ArrayList<Long> agentiNovo = new ArrayList<>();
		if(bundle==true) {
			for (int i=0;i<narudzbenice.size();i++) {
				  agenti.add(narudzbenice.get(i).getAgentId()); //stavlja sve agente u posebnu listu
			}
			
			for(int j=0; j<agenti.size(); j++) {			
				if(agentiNovo.isEmpty()){
					agentiNovo.add(agenti.get(j));	
					System.out.println("agent prvi put prazan");
				}
				else {		
				    if(!agentiNovo.contains(agenti.get(j))) {
						//algoritam za trazenje duplikata...mozda moze ovako
						agentiNovo.add(agenti.get(j));
					
				    }
					
				}
			}
			for(int i=0; i<agentiNovo.size(); i++) {
			System.out.println("agent novo id " + agentiNovo.get(i));
			}
			
			
			List<List<Narudzbenica>> setovi = new ArrayList<List<Narudzbenica>>();
			List<ZahtevZaIznajmljivanje> zahtevi = new ArrayList<ZahtevZaIznajmljivanje>();
			for(int i=0; i<agentiNovo.size(); i++) {
				System.out.println("ima li necega "  + agentiNovo.get(i));
				List<Narudzbenica> list = new ArrayList<Narudzbenica>(); 
			    //ova lista posle mora da se konvertuje u set
				setovi.add(list);
				ZahtevZaIznajmljivanje zahtev = new ZahtevZaIznajmljivanje();
				
			    zahtevi.add(zahtev);
			} //za svakog agenta pravi njegove posebne zahteve i liste u koje ce posle staviti oglase
			//posle se pristupa zahtev.get(k), gde je k broj agenta u listi 
			
			for (int i=0;i<narudzbenice.size();i++) {
				//z= new ZahtevZaIznajmljivanje();
				for(int k=0; k<agentiNovo.size(); k++) {
					if(narudzbenice.get(i).getAgentId()==(agentiNovo.get(k))) {
						Cenovnik cenovnik=cenServ.findByIdentifikacioniBroj(narudzbenice.get(i).getCenovnikId());

						if(zahtevi.get(k).getNarudzbenica()== null) {
							//Set<Oglas> set = new HashSet<>();
							setovi.get(k).add(narudzbenice.get(i));
							Set<Narudzbenica> targetSet = new HashSet<>(setovi.get(k));//konvertujem listu u set

							zahtevi.get(k).setNarudzbenica(targetSet); //dodaju se bas u zahtev agenta k	
							zahtevi.get(k).setAgentFirmaID(narudzbenice.get(i).getAgentId());
							zahtevi.get(k).setStatusIznajmljivanja("PENDING");
							zahtevi.get(k).setBundle(bundle);
							zahtevi.get(k).setRegistrovaniKorisnkID(korid);
							zahtevi.get(k).setUkupnaCena(zahtevi.get(k).getUkupnaCena()+(ChronoUnit.DAYS.between(LocalDate.parse(narudzbenice.get(i).getRentiranjeOd().toString()),LocalDate.parse(narudzbenice.get(i).getRentiranjeDo().toString()))+1)*cenovnik.getCenaZaDan().floatValue());
						}
						else {
							System.out.println("isti agenti");
							zahtevi.get(k).getNarudzbenica().add(narudzbenice.get(i));			
							zahtevi.get(k).setUkupnaCena(zahtevi.get(k).getUkupnaCena()+(ChronoUnit.DAYS.between(LocalDate.parse(narudzbenice.get(i).getRentiranjeOd().toString()),LocalDate.parse(narudzbenice.get(i).getRentiranjeDo().toString()))+1)*cenovnik.getCenaZaDan().floatValue());

						}
					}
				
				}
				
			}
			for(int m=0; m<zahtevi.size(); m++) {
				System.out.println("iznad zahtevi save");
				zahtevService.save(zahtevi.get(m));
				
				for (Narudzbenica nar:zahtevi.get(m).getNarudzbenica()) {
					Narudzbenica temp= narServ.findByIdentifikacioniBroj(nar.getIdentifikacioniBroj());
					System.out.println(temp.getIdentifikacioniBroj());
					temp.setZahtev(zahtevi.get(m));
					temp.setKorpaId(0);
					narServ.save(temp);
				}
				
				}
		}
		else {
			System.out.println("odvojeni zahtevi");
			for (int i=0;i<narudzbenice.size();i++) {
				z = new ZahtevZaIznajmljivanje();
				if(z.getNarudzbenica()== null) {
					Set<Narudzbenica> set = new HashSet<>();
					Cenovnik cenovnik=cenServ.findByIdentifikacioniBroj(narudzbenice.get(i).getCenovnikId());
					set.add(narudzbenice.get(i));
					z.setNarudzbenica(set);	
					z.setAgentFirmaID(narudzbenice.get(i).getAgentId());
					z.setStatusIznajmljivanja("PENDING");
					z.setBundle(bundle);
					z.setRegistrovaniKorisnkID(korid);
					
					long dani=ChronoUnit.DAYS.between(LocalDate.parse(narudzbenice.get(i).getRentiranjeOd().toString()),LocalDate.parse(narudzbenice.get(i).getRentiranjeDo().toString()));
					//System.out.println(dani);
					z.setUkupnaCena((dani+1)*cenovnik.getCenaZaDan().floatValue()); //za isti datum racuna 0, a mi vrv kao jedan dan?
					
					
					zahtevService.save(z);
					//narudzbenice.get(i).setZahtev(z);
					for (Narudzbenica nar:z.getNarudzbenica()) {
						Narudzbenica temp= narServ.findByIdentifikacioniBroj(nar.getIdentifikacioniBroj());
						System.out.println(temp.getIdentifikacioniBroj());
						temp.setZahtev(z);
						temp.setKorpaId(0);
						narServ.save(temp);
					}
					
					
				}
			
			}
			
		
		
		
		
		}
		return  new ResponseEntity<ZahtevZaIznajmljivanje>(z, HttpStatus.OK);
	}
	
}
