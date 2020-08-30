package com.pretraga.Pretraga;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
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
import com.pretraga.Pretraga.model.Vozilo;
import com.pretraga.Pretraga.model.ZahtevZaIznajmljivanje;
import com.pretraga.Pretraga.repository.NarudzbenicaRepository;
import com.pretraga.Pretraga.repository.OglasRepository;
import com.pretraga.Pretraga.repository.ZahtevZaIznajmljivanjeRepository;
import com.pretraga.Pretraga.service.OglasService;
import com.pretraga.Pretraga.service.RezervisaniDatumiService;
import com.pretraga.Pretraga.service.VoziloService;

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
	private OglasRepository oglasRepo;
	
	@Autowired
	private RezervisaniDatumiService rezDatService;
	
	@Autowired
	private VoziloService voziloService;
	

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
		
		List<Vozilo> vozila = voziloService.findAll(Sort.by(Sort.Direction.ASC, "identifikacioniBroj"));
		
		List<Long> oglasiSort = new ArrayList<Long>();
		for(int i=0; i<oglasi.size(); i++) {
			oglasiSort.add(oglasi.get(i).getIdentifikacioniBroj());
			
		}
		
		List<Long> vozilaSort = new ArrayList<Long>();
		for(int i=0; i<vozila.size(); i++) {
			vozilaSort.add(vozila.get(i).getIdentifikacioniBroj());
			
		}
		
		String url = "http://localhost:8099/oglasi";
		
		String urlVozila = "http://localhost:8099/oglasi/vozila";
		

		RestTemplate restTemplate = new RestTemplate();
		Oglas[] oglasiAgent= restTemplate.getForObject(url, Oglas[].class);
		
		Vozilo[] vozilaAgent= restTemplate.getForObject(urlVozila, Vozilo[].class);
		
		// provera za update i delete
				for(Oglas oglas:oglasi) {
					boolean postoji=false;
					for(Oglas oglasAgent:oglasiAgent) {	
						if(oglas.getIdentifikacioniBroj()==oglasAgent.getIdentifikacioniBroj()){
							postoji=true;	
							if(oglas.getRezervisaniDatumi().size()<oglasAgent.getRezervisaniDatumi().size()) {
								for (RezervisaniDatumi rd:oglasAgent.getRezervisaniDatumi()) {
									if(oglas.getRezervisaniDatumi().toString().contains(rd.toString())==false) {
										RezervisaniDatumi rezd= new RezervisaniDatumi();
										rezd=rd;
										rezd.setOglas(oglas);
										System.out.println("sacuva za id datuma: "+rd.getIdentifikacioniBroj());
										rezDatService.save(rezd);
										
										

										
									}
								}
							}
							
						}
					}
					
				}
			/*	//provera za dodavanje novih vozila (pre samih oglasa)
				for(Vozilo voziloAgent:vozilaAgent) {
					boolean postoji1=false;
					for (Vozilo vozilo:vozila) {
						if(voziloAgent.getBrojSedistaZaDecu()==vozilo.getBrojSedistaZaDecu()) {
							if(voziloAgent.getNazivModela().equals(vozilo.getNazivModela())&&voziloAgent.getNazivTipaMenjaca().equals(vozilo.getNazivTipaMenjaca())) {
							if(voziloAgent.getOgranicenjeKilometraze()==vozilo.getOgranicenjeKilometraze()) {	
							
							
							postoji1=true;
							
							}
						}
					}
					}
					if(!postoji1) {
					System.out.println("dodaje novo vozilo "+ voziloAgent.getIdentifikacioniBroj());
						
						Vozilo v = new Vozilo();	
						v = voziloAgent;
						v.setIdentifikacioniBroj(Collections.max(vozilaSort)+1);
						voziloService.save(v);
					}
				}
				// provera za dodavanje novih oglasa
				for(Oglas oglasAgent:oglasiAgent) {
					boolean postoji1=false;
					for (Oglas oglas:oglasi) {
						if(oglasAgent.getVozilo().getNazivKlase().equals(oglas.getVozilo().getNazivKlase())) {
							postoji1=true;
						}
					}
					if(!postoji1) {
					System.out.println("dodaje novi oglas "+ oglasAgent.getIdentifikacioniBroj());
						Oglas o = new Oglas();
						
						o = oglasAgent;
						o.setIdentifikacioniBroj(Collections.max(oglasiSort)+1);
						//ne doda mu vozila...
						oglasRepo.save(o);
					}
				}
				
				*/
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