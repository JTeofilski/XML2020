package com.xml.agent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xml.agent.model.Narudzbenica;
import com.xml.agent.model.ZahtevZaIznajmljivanje;
import com.xml.agent.repository.NarudzbenicaRepository;
import com.xml.agent.repository.ZahtevZaIznajmljivanjeRepository;

//The task which you want to execute
@Component
public class ScheduledTasks {

	@Autowired
	private ZahtevZaIznajmljivanjeRepository zahRepo;
	
	@Autowired
	private NarudzbenicaRepository narRepo;

	@Scheduled(fixedRate = 30000) // update na 30 sec 
	public void dobaviIzMikroservisa() {
		
		// *** provera za narudzbenice 
		List<Narudzbenica> narudzbenice= narRepo.findAll();	
		
		String url = "http://localhost:2020/pretragaapp/narudzbenice/bazaAgent";
		
		RestTemplate restTemplate = new RestTemplate();
		Narudzbenica[] narudzbeniceMicro= restTemplate.getForObject(url, Narudzbenica[].class);
	
		// provera za update i delete
		for(Narudzbenica narudzbenica:narudzbenice) {
			boolean postoji=false;
			for(Narudzbenica narudzbenicaMicro:narudzbeniceMicro) {	
				

				if(narudzbenica.getIdentifikacioniBroj()==narudzbenicaMicro.getIdentifikacioniBroj()){
					postoji=true;	
					if(narudzbenica.getKorpaId()!=narudzbenicaMicro.getKorpaId()) {
						
						narudzbenica=narudzbenicaMicro;

						narRepo.save(narudzbenica);	
					}
				}
			}
			if(postoji==false) {
				narRepo.delete(narudzbenica);	
			}
		}
		// provera za dodavanje novih
		for(Narudzbenica narudzbenicaMicro:narudzbeniceMicro) {
			boolean postoji=false;
			for (Narudzbenica narudzbenica:narudzbenice) {
				if(narudzbenicaMicro.getIdentifikacioniBroj()==narudzbenica.getIdentifikacioniBroj()) {
					postoji=true;
				}
			}
			if(!postoji) {
				narRepo.save(narudzbenicaMicro);
			}
		}
		
		// *** kraj provere za narudzbenice
		
		// *** provera za zahteve
		
		List <ZahtevZaIznajmljivanje> zahtevi = zahRepo.findAll();
		
		url = "http://localhost:2020/zahtevzaiznajmljivanjeapp/zahtevi/bazaAgent";
	
		ZahtevZaIznajmljivanje[] zahteviMicro= restTemplate.getForObject(url, ZahtevZaIznajmljivanje[].class);
		
		// provera za update i delete
		
		for(ZahtevZaIznajmljivanje zahtev:zahtevi) {
			boolean postoji=false;
			for(ZahtevZaIznajmljivanje zahtevMicro:zahteviMicro) {	
				
				

				if(zahtev.getIdentifikacioniBroj()==zahtevMicro.getIdentifikacioniBroj()){
					postoji=true;	
					if(!zahtev.getStatusIznajmljivanja().toString().equals(zahtevMicro.getStatusIznajmljivanja().toString())) {				
						zahtev=zahtevMicro;
						zahRepo.save(zahtev);	
					}
				}
			}
			if(postoji==false) {
				zahRepo.delete(zahtev);	
			}
		}
		
		// provera za dodavanje novih
		for(ZahtevZaIznajmljivanje zahtevMicro:zahteviMicro) {
			boolean postoji=false;
			for (ZahtevZaIznajmljivanje zahtev:zahtevi) {
				if(zahtevMicro.getIdentifikacioniBroj()==zahtev.getIdentifikacioniBroj()) {
					postoji=true;
				}
			}
			if(!postoji) {
				zahRepo.save(zahtevMicro);
			}
		}
		
	}

		
	
}