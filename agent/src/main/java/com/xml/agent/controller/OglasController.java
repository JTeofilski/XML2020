package com.xml.agent.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xml.agent.model.Cenovnik;
import com.xml.agent.model.Komentar;
import com.xml.agent.model.Narudzbenica;
import com.xml.agent.model.Ocena;
import com.xml.agent.model.Oglas;
import com.xml.agent.model.RezervisaniDatumi;
import com.xml.agent.model.Vozilo;
import com.xml.agent.model.ZahtevZaIznajmljivanje;
import com.xml.agent.service.AgentService;
import com.xml.agent.service.CenovnikService;
import com.xml.agent.service.OglasService;
import com.xml.agent.service.RezervisaniDatumiService;
import com.xml.agent.service.VoziloService;
import com.xml.agent.service.ZahtevZaIznajmljivanjeService;


@RestController
@RequestMapping(value = "/oglasi")
public class OglasController {

	@Autowired
	private OglasService oglasService;
	
	@Autowired
	private CenovnikService cenovnik;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private VoziloService voziloService;
	
	@Autowired
	private RezervisaniDatumiService rezDatumiService;
	
	@Autowired
	private ZahtevZaIznajmljivanjeService zahtevService;
	
	@RequestMapping(method=RequestMethod.POST, value = "/dodajOglas/{agent}/{cenovnik}/{voziloSlobodnoOd}/{voziloSlobodnoDo}/{collisiondamageWaiver}")
	public ResponseEntity<Oglas> addAd(@RequestBody Vozilo vozilo, @PathVariable("agent") Long id1,@PathVariable("cenovnik") Long id, @PathVariable("voziloSlobodnoOd") Date date1, @PathVariable("voziloSlobodnoDo") Date date2, @PathVariable("collisiondamageWaiver") boolean collision) throws URISyntaxException{
		// upload directory - change it to your own
        String UPLOAD_DIR = "/slike";

        // create a path from file name
       // Path path = Paths.get(UPLOAD_DIR, file.getOriginalFilename());

        // save the file to `UPLOAD_DIR`
        // make sure you have permission to write
        //Files.write(path, file.getBytes());
		
		
		Oglas oglasNovi = new Oglas();
		Cenovnik cenovnik1 = cenovnik.findOne(id);
		oglasNovi.setCenovnik(cenovnik1);
		oglasNovi.setVozilo(vozilo);
		oglasNovi.setAgent(agentService.findOne(id1));
		
		vozilo.setSlike("slike/crno_mece1.jpg;slike/crno_mece.jpg");
		voziloService.save(vozilo);
		oglasService.save(oglasNovi);
		
		
		 final String uri = "http://localhost:2020/pretragaapp/oglasi/dodajOglas/" + id1 + "/" + id + "/"  + collision;
		 
			ObjectMapper mapper= new ObjectMapper();
			String json = null;
			
			try {
				json= mapper.writeValueAsString(vozilo);
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		   RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			HttpEntity<String> entity = new HttpEntity<String>(json,headers);
			restTemplate.postForObject(uri, entity, Vozilo.class);
			
		return new ResponseEntity<>( oglasNovi, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Oglas>> dobaviSve()
	{
		return new ResponseEntity<List<Oglas>>(oglasService.findAll(Sort.by(Sort.Direction.ASC, "identifikacioniBroj")), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="/{id}" )
	public ResponseEntity<List<Oglas>> dobaviZaAgenta(@PathVariable("id") long idAgenta){
		return new  ResponseEntity<List<Oglas>>(oglasService.findByAgentId(idAgenta), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="/vozila" )
	public ResponseEntity<List<Vozilo>> dobaviZaMS(){
		return new  ResponseEntity<List<Vozilo>>(voziloService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="/rezervacija/{datumOd}/{datumDo}/{oglasId}" )
	public void rezervisi(@PathVariable("datumOd") Date datumOd, @PathVariable("datumDo") Date datumDo, @PathVariable("oglasId") long oglasId){
		Oglas oglas= oglasService.findOne(oglasId);
		RezervisaniDatumi rd= new RezervisaniDatumi(datumOd, datumDo, oglas);
		rezDatumiService.save(rd);
		
		List<ZahtevZaIznajmljivanje> zahtevi = zahtevService.findAll();
		
		for (ZahtevZaIznajmljivanje zahtev:zahtevi) {
			if(zahtev.getStatusIznajmljivanja().equals("PENDING")) {
				for (Narudzbenica narudzbenica : zahtev.getNarudzbenica()) {
					if((narudzbenica.getRentiranjeOd().compareTo(rd.getDatumOd())*rd.getDatumOd().compareTo(narudzbenica.getRentiranjeDo())>=0)||(narudzbenica.getRentiranjeOd().compareTo(rd.getDatumDo())*rd.getDatumDo().compareTo(narudzbenica.getRentiranjeDo())>=0)) {
						zahtev.setStatusIznajmljivanja("CANCELED");
						zahtevService.save(zahtev);
						return;
					}
				}
			}
		}
		
		
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value ="/statistika/{idAgenta}" )
	public ResponseEntity<String> brKomentara(@PathVariable("idAgenta") long idAgenta){
		
		List<Oglas> oglasi= oglasService.findByAgentId(idAgenta);
		int brKom=0;
		String odgovor="";
		for(Oglas o:oglasi) {
			int brKomTemp=o.getKomentar().size();
			if(brKomTemp>brKom) {
				Vozilo vozilo= voziloService.findByOglasId(o.getIdentifikacioniBroj());
				brKom=brKomTemp;
				odgovor="Max komentara ima "+vozilo.getNazivMarke()+":"+brKom;
			}
		}
		return new ResponseEntity<String>(odgovor, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value ="/statistika/ocena/{idAgenta}" )
	public ResponseEntity<String> brOcena(@PathVariable("idAgenta") long idAgenta){
		
		List<Oglas> oglasi= oglasService.findByAgentId(idAgenta);
		double ocena=0;
		String odgovor="";
		for(Oglas o:oglasi) {
			double ocenaTemp=0;
			for (Ocena oc:o.getOcena()) {
				ocenaTemp=+ oc.getVrednostOcene();
			}
			ocenaTemp=+ocenaTemp/o.getOcena().size();
			
			if(ocenaTemp>ocena) {
				Vozilo vozilo= voziloService.findByOglasId(o.getIdentifikacioniBroj());
				ocena=ocenaTemp;
				odgovor="Max ocenu ima "+vozilo.getNazivMarke()+":"+ocena;
			}
		}
		return new ResponseEntity<String>(odgovor, HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.GET, value ="/komentari/{oglasId}" )
	public ResponseEntity<Set<Komentar>> dobaviKomentare(@PathVariable("oglasId") long oglasId){
		Oglas oglas= oglasService.findOne(oglasId);
		
		return new  ResponseEntity<Set<Komentar>>(oglas.getKomentar(), HttpStatus.OK);
	}
		
}
