package com.pretraga.Pretraga;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pretraga.Pretraga.model.Narudzbenica;
import com.pretraga.Pretraga.model.Oglas;
import com.pretraga.Pretraga.model.RezervisaniDatumi;
import com.pretraga.Pretraga.model.ZahtevZaIznajmljivanje;
import com.pretraga.Pretraga.repository.NarudzbenicaRepository;
import com.pretraga.Pretraga.repository.ZahtevZaIznajmljivanjeRepository;
import com.pretraga.Pretraga.service.OglasService;
import com.pretraga.Pretraga.service.RezervisaniDatumiService;

//The task which you want to execute
@Component
public class ScheduledTasks {

	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd:MM:yyyy HH:mm:ss");
	
	@Autowired
	private ZahtevZaIznajmljivanjeRepository repo;
	
	@Autowired
	private NarudzbenicaRepository narRepo;
	
	@Autowired
	private OglasService oglasService;
	
	@Autowired
	private RezervisaniDatumiService rezDatService;
	

	@Scheduled(fixedRate = 3600000) //1h
	public void reportCurrentTime() {

		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		
		
		List<ZahtevZaIznajmljivanje> zahtevi=repo.findAll();
		for(ZahtevZaIznajmljivanje zahtev:zahtevi) {
			//LocalDate date1 = new LocalDate(date);
			//LocalDate date2 = new LocalDate(zahtev.getVremeKreiranja());
			org.joda.time.DateTime x=  new DateTime(date);
			org.joda.time.DateTime y=  new DateTime(zahtev.getVremeKreiranja());
			

			if(Hours.hoursBetween(y, x).getHours()>22 && zahtev.getStatusIznajmljivanja()!="PENDING" && zahtev.getStatusIznajmljivanja()!="RESERVED") {
				//22 sata jer dodaje 2 sata na zahtev iz baze, ne znam zasto
				zahtev.setStatusIznajmljivanja("CANCELED");
				repo.save(zahtev);
				//System.out.println("razlika: " +Hours.hoursBetween(y, x).getHours());
			}

		}
		
	}
	
	@Scheduled(fixedRate = 30000) //1h
	public void dobaviIzAgenta() {
		
		List<Oglas> oglasi = oglasService.findAll(Sort.by(Sort.Direction.ASC, "identifikacioniBroj"));
		
		String url = "http://localhost:8099/oglasi";
		

		RestTemplate restTemplate = new RestTemplate();
		Oglas[] oglasiAgent= restTemplate.getForObject(url, Oglas[].class);
		
		// provera za update i delete
				for(Oglas oglas:oglasi) {
					boolean postoji=false;
					for(Oglas oglasAgent:oglasiAgent) {	
						if(oglas.getIdentifikacioniBroj()==oglasAgent.getIdentifikacioniBroj()){
							postoji=true;	
							if(oglas.getRezervisaniDatumi().size()<oglasAgent.getRezervisaniDatumi().size()) {
								for (RezervisaniDatumi rd:oglasAgent.getRezervisaniDatumi()) {
									if(!oglas.getRezervisaniDatumi().toString().contains(rd.toString())) {
										rd.setOglas(oglas);
										System.out.println("sacuva za id datuma: "+rd.getIdentifikacioniBroj());
										rezDatService.save(rd);
										
										

										
									}
								}
							}
							
						}
					}
					
				}
				
				
				
				List<ZahtevZaIznajmljivanje> zahtevi = repo.findAll();
				
				url = "http://localhost:8099/zahtevi";
				

				restTemplate = new RestTemplate();
				ZahtevZaIznajmljivanje[] zahteviAgent= restTemplate.getForObject(url, ZahtevZaIznajmljivanje[].class);
	
				for (ZahtevZaIznajmljivanje zahtev:zahtevi) {
					for (ZahtevZaIznajmljivanje zahtevAgent :zahteviAgent) {
						if(zahtev.getIdentifikacioniBroj()==zahtevAgent.getIdentifikacioniBroj()) {
							
							if(!zahtev.getStatusIznajmljivanja().toString().equals(zahtevAgent.getStatusIznajmljivanja().toString())) {				
								zahtev=zahtevAgent;
								repo.save(zahtev);	
							}
						}
					}
				}

	}
	
	
	
}