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
import com.xml.agent.model.Cenovnik;
import com.xml.agent.model.Komentar;
import com.xml.agent.model.Narudzbenica;
import com.xml.agent.model.Ocena;
import com.xml.agent.model.Oglas;
import com.xml.agent.model.ZahtevZaIznajmljivanje;
import com.xml.agent.repository.CenovnikRepository;
import com.xml.agent.repository.KomentarRepository;
import com.xml.agent.repository.NarudzbenicaRepository;
import com.xml.agent.repository.OcenaRepository;
import com.xml.agent.repository.OglasRepository;
import com.xml.agent.repository.ZahtevZaIznajmljivanjeRepository;

//The task which you want to execute
@Component
public class ScheduledTasks {

	@Autowired
	private ZahtevZaIznajmljivanjeRepository zahRepo;
	
	@Autowired
	private NarudzbenicaRepository narRepo;
	
	@Autowired
	private OcenaRepository ocenaRepo;
	
	@Autowired 
	private OglasRepository oglasRepo;
	
	@Autowired 
	private KomentarRepository komentarRepo;
	
	@Autowired 
	private CenovnikRepository cenovnikRepo;
	

	@Scheduled(fixedRate = 30000) // update na 30 sec 
	public void dobaviIzMikroservisa() {
		
		
		/*
		
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
			System.out.println("dodaje novu narudzbenicu "+narudzbenicaMicro.getIdentifikacioniBroj());
				Narudzbenica n=new Narudzbenica();
				n=narudzbenicaMicro;
				n.setIdentifikacioniBroj(narudzbenicaMicro.getIdentifikacioniBroj());
				
				narRepo.save(n);
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
					System.out.println("Usao u iste zahteve!");
					postoji=true;
					//status zahteva se menja kad se kupi sa agenta a ne mikroservisa
					//if(!zahtev.getStatusIznajmljivanja().toString().equals(zahtevMicro.getStatusIznajmljivanja().toString())) {				
						//zahtev=zahtevMicro;
						//zahRepo.save(zahtev);	
					//}
				}
			}
			if(postoji==false) {
				System.out.println("Brise");

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
				System.out.println("dodaje nov "+zahtevMicro.getIdentifikacioniBroj());
				ZahtevZaIznajmljivanje z=new ZahtevZaIznajmljivanje();
				z=zahtevMicro;
				z.setIdentifikacioniBroj(zahtevMicro.getIdentifikacioniBroj());
				zahRepo.save(z);
			}
		}
		
		//preko oglasa dobavljam ocene, komentare 
		
		List <Oglas> oglasi = oglasRepo.findAll();

		url = "http://localhost:2020/pretragaapp/oglasi/bazaAgent";

		Oglas[] oglasiMikro= restTemplate.getForObject(url, Oglas[].class);

		
		for(Oglas oglas:oglasi) {
			boolean postoji=false;
			for(Oglas oglasMikro:oglasiMikro) {	
				if(oglas.getIdentifikacioniBroj()==oglasMikro.getIdentifikacioniBroj()){
					postoji=true;	
					if(oglas.getOcena().size()!=oglasMikro.getOcena().size()) {
						for (Ocena o:oglasMikro.getOcena()) {
							if(!oglas.getOcena().toString().contains(o.toString())) {
								o.setOglas(oglas);
								System.out.println("sacuva za id ocene: "+o.getIdentifikacioniBroj());
								ocenaRepo.save(o);
								
								

								
							}
						}
					}
					
					if(oglas.getKomentar().size()!=oglasMikro.getKomentar().size()) {
						for (Komentar k:oglasMikro.getKomentar()) {
							if(!oglas.getKomentar().toString().contains(k.toString())) {
								k.setOglas(oglas);
								System.out.println("sacuva za id ocene: "+k.getIdentifikacioniBroj());
								komentarRepo.save(k);
								
								

								
							}
						}
					}
					
				}
			}
		}	
		*/
		
		// *** provera za cenovnike
				List<Cenovnik> cenovnici= cenovnikRepo.findAll();	
				
				String url1 = "http://localhost:2020/adminservisapp/cenovnici/bazaAdminCenovnik";
				
				RestTemplate restTemplate1 = new RestTemplate();
				Cenovnik[] cenovniciMicro = restTemplate1.getForObject(url1, Cenovnik[].class);
			
				// provera za update i delete
				for(Cenovnik cenovnik:cenovnici) {
					boolean postojiC=false;
					for(Cenovnik cenovnikMicro:cenovniciMicro) {	
						

						if(cenovnik.getIdentifikacioniBroj()==cenovnikMicro.getIdentifikacioniBroj()){
							postojiC=true;	
							
						}
					}
					if(postojiC==false) {
						cenovnikRepo.delete(cenovnik);	
					}
				}
				// provera za dodavanje novih
				for(Cenovnik cenovnikMicro:cenovniciMicro) {
					boolean postoji1=false;
					for (Cenovnik cenovnik:cenovnici) {
						if(cenovnikMicro.getIdentifikacioniBroj()==cenovnik.getIdentifikacioniBroj()) {
							postoji1=true;
						}
					}
					if(!postoji1) {
					System.out.println("dodaje novi cenovnik "+ cenovnikMicro.getIdentifikacioniBroj());
						Cenovnik c= new Cenovnik();
						c=cenovnikMicro;
						c.setIdentifikacioniBroj(cenovnikMicro.getIdentifikacioniBroj());
						
						cenovnikRepo.save(c);
					}
				}
				
				// *** kraj provere za cenovnike
				
				
	}

	}	
	