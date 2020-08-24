package com.komentar.Komentar.controller;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.komentar.Komentar.model.Komentar;
import com.komentar.Komentar.model.Oglas;
import com.komentar.Komentar.model.RegistrovaniKorisnik;
import com.komentar.Komentar.service.KomentarService;
import com.komentar.Komentar.service.OglasService;
import com.komentar.Komentar.service.RegistrovaniKorisnikService;

@RestController
@RequestMapping(value = "/komentari")
public class KomentarController {
	
	@Autowired 
	private KomentarService komentarService;
	
	@Autowired 
	private OglasService oglasService;
	
	@Autowired 
	private RegistrovaniKorisnikService regKorService;
	
	
	@RequestMapping(method=RequestMethod.POST, value = "/dodavanje/{idOglasa}", consumes="application/json")
	public ResponseEntity<Komentar> registrovanje(@RequestBody Komentar komentar, @PathVariable("idOglasa") long idOglasa){
		
		RegistrovaniKorisnik korisnik= regKorService.findOne(komentar.getKreatorKomentaraID());
		
		
		Komentar novi= new Komentar();
		novi.setKreatorKomentaraID(komentar.getKreatorKomentaraID());
		novi.setTekstKomentara(komentar.getTekstKomentara());
		novi.setStatusKomentara("CEKANJE");
		novi.setDatumVremeKreiranja( Calendar.getInstance().getTime());
		novi.setImeKorisnika(korisnik.getIme());
		
		komentarService.save(novi);
		
		Oglas oglas=oglasService.findOne(idOglasa);
		oglas.getKomentar().add(novi);
		oglasService.save(oglas);	
		
		
		return null;
		
	}

}
