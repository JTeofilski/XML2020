package com.pretraga.Pretraga.controller;

import java.math.BigInteger;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pretraga.Pretraga.model.Korpa;
import com.pretraga.Pretraga.model.Oglas;
import com.pretraga.Pretraga.model.RegistrovaniKorisnik;
import com.pretraga.Pretraga.repository.OglasRepository;
import com.pretraga.Pretraga.service.KorpaService;
import com.pretraga.Pretraga.service.OglasService;

@RestController
@RequestMapping(value = "/oglasi")
public class OglasController {

	@Autowired
	private OglasService oglasService;
	
	@Autowired
	private KorpaService korpaService;
	

	
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
	  		System.out.println("pretraga  " + java.time.LocalDateTime.now());
	  		ZoneId defaultZoneId = ZoneId.systemDefault();
	  		LocalDate sada = java.time.LocalDate.now();
	  		java.util.Date date = Date.from(sada.atStartOfDay(ZoneId.systemDefault()).toInstant());
	  		
	  		for(int i=0; i<oglasi.size(); i++) {
	  			if(oglasi.get(i).getAgent().getAdresa().equals(adresa)&&oglasi.get(i).getVoziloSlobodnoOd().compareTo(slobodnoOd)<=0&&oglasi.get(i).getVoziloSlobodnoDo().compareTo(slobodnoDo)>=0&&slobodnoOd.compareTo(slobodnoDo)<0){
	  				if(date.compareTo(slobodnoOd)<=2) {
	  				   System.out.println("izaberite ...");
	  				}else{
	  				   oglasiPretraga.add(oglasi.get(i));
	  			}
	  			}
	  			
	  		}
	  		
	  		return new ResponseEntity<List<Oglas>>(oglasiPretraga, HttpStatus.OK);
	  	}
	 @RequestMapping(value="/naprednaPretraga/{adresa}/{voziloSlobodnoOd}/{voziloSlobodnoDo}/{nazivMarke}/{nazivModela}/{nazivVrsteGoriva}/{nazivKlase}/{nazivTipaMenjaca}/{brojSedistaZaDecu}/{predjenaKilometraza}/{collisiondamageWaiver}", method=RequestMethod.GET)
	  	@ResponseBody
	  	public ResponseEntity<List<Oglas>> searchNapredno(@PathVariable("adresa") String adresa, @PathVariable("voziloSlobodnoOd") Date slobodnoOd, @PathVariable("voziloSlobodnoDo") Date slobodnoDo, @PathVariable("nazivMarke") String marka, @PathVariable("nazivModela") String model, @PathVariable("nazivVrsteGoriva") String gorivo, @PathVariable("nazivKlase") String klasa, @PathVariable("nazivTipaMenjaca") String menjac, @PathVariable("brojSedistaZaDecu") BigInteger sedista, @PathVariable("predjenaKilometraza") float kilometraza, @PathVariable("collisiondamageWaiver") boolean collision){
	  		List<Oglas> oglasi = oglasService.findAll();
	  		List<Oglas> oglasiPretraga = new ArrayList<Oglas>();
	  		System.out.println("broj sedista " + sedista);
	  		for(int i=0; i<oglasi.size(); i++) {
	  			if(oglasi.get(i).getAgent().getAdresa().equals(adresa)&&oglasi.get(i).getVoziloSlobodnoOd().compareTo(slobodnoOd)<=0&&oglasi.get(i).getVoziloSlobodnoDo().compareTo(slobodnoDo)>=0&&slobodnoOd.compareTo(slobodnoDo)<0&&oglasi.get(i).getVozilo().getNazivMarke().equals(marka)&&oglasi.get(i).getVozilo().getNazivModela().equals(model)&&oglasi.get(i).getVozilo().getNazivVrsteGoriva().equals(gorivo)&&oglasi.get(i).getVozilo().getNazivKlase().equals(klasa)&&oglasi.get(i).getVozilo().getBrojSedistaZaDecu().equals(sedista)&&oglasi.get(i).getVozilo().getPredjenaKilometraza()==kilometraza&&oglasi.get(i).getVozilo().isCollisiondamageWaiver()==collision){
	  				
	  				   oglasiPretraga.add(oglasi.get(i));
	  			
	  			}
	  			
	  		}
	  		
	  		return new ResponseEntity<List<Oglas>>(oglasiPretraga, HttpStatus.OK);
	  	}
		@RequestMapping(method=RequestMethod.GET, value = "/{id}")
		public ResponseEntity<Oglas> dobaviOglasPoId(@PathVariable("id") Long id){
			Oglas oglas = oglasService.findOne(id);	
			return new ResponseEntity<Oglas>(oglas, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.GET, value="/korpa/{id}/{korid}")
		public ResponseEntity<Set<Oglas>> izKorpe(@PathVariable("id") Long id,@PathVariable("korid") Long korid){
			Korpa korpa= korpaService.findOne(korid);
			//korpa.setIdentifikacioniBroj(korid);
			
			//Korpa korpa= korpaService.findOne((long)1);
			//RegistrovaniKorisnik rk=(RegistrovaniKorisnik) httpSession.getAttribute("ulogovan");
			System.out.println("korisnik cont: "+korid);
			if(id!=0) {
				
				Oglas oglas = oglasService.findOne(id);
				//korpa.addOglas(oglas);
				korpa.getOglas().add(oglas);
				korpaService.save(korpa);
			}
			Set<Oglas> oglasiIzKorpe= korpa.getOglas();
			return new ResponseEntity<Set<Oglas>>(oglasiIzKorpe, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, value="/korpa/{id}/{korid}")
		public ResponseEntity<Set<Oglas>> brisanje(@PathVariable("id") Long id,@PathVariable("korid") Long korid){
			Korpa korpa= korpaService.findOne(korid);
			//korpa.setIdentifikacioniBroj(korid);
			
			//Korpa korpa= korpaService.findOne((long)1);
			//RegistrovaniKorisnik rk=(RegistrovaniKorisnik) httpSession.getAttribute("ulogovan");
			System.out.println("korisnik cont: "+korid);
			if(id!=0) {
				
				Oglas oglas = oglasService.findOne(id);
				//korpa.addOglas(oglas);
				korpa.getOglas().remove(oglas);
				korpaService.save(korpa);
			}
			Set<Oglas> oglasiIzKorpe= korpa.getOglas();
			return new ResponseEntity<Set<Oglas>>(oglasiIzKorpe, HttpStatus.OK);
		}
		
}
