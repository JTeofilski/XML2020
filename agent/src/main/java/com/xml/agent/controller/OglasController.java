package com.xml.agent.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xml.agent.model.Cenovnik;
import com.xml.agent.model.Oglas;
import com.xml.agent.model.Vozilo;
import com.xml.agent.service.AgentService;
import com.xml.agent.service.CenovnikService;
import com.xml.agent.service.OglasService;
import com.xml.agent.service.VoziloService;

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
	
	@PostMapping("/file-upload")
	@ResponseBody
	public ResponseEntity<String> fileUpload(MultipartFile file) {
	    try {
	    	 String uri = ServletUriComponentsBuilder.fromCurrentContextPath()
	                 .path("/slike/")
	                 .toUriString();

	        // upload directory - change it to your own
	        //String UPLOAD_DIR = "C:\\Users\\Violeta\\git\\XML2020\\xml3\\agent\\src\\main\\resources\\static\\slike";

	        // create a path from file name
	       // Path path = Paths.get(uri + "/");

	        // save the file to `UPLOAD_DIR`
	        // make sure you have permission to write
	       // Files.write(uri, file.getBytes());
	      //  Resource item = (Resource) file.getResource();
	      //  File uploadedFile = new File(uri);
	        //Path filepath = Paths.get(path.toString(), file.getOriginalFilename());
	        //ClassPathResource res = new ClassPathResource("slike/" + file.getOriginalFilename());   
	        
	       // ClassLoader classLoader = getClass().getClassLoader();
	       // String UPLOAD_DIR = "../resurces/static/slike";
	       // File f = file.getResource().getFile();
	        
	        //Path filepath = Paths.get(file1.toString());
	    	// upload directory - change it to your own
	         String UPLOAD_DIR = "src/resources/static/slike";

	         // create a path from file name
	         Path path = Paths.get(UPLOAD_DIR, file.getOriginalFilename());

	         // save the file to `UPLOAD_DIR`
	         // make sure you have permission to write
	        // Files.write(path, file.getBytes());
//System.out.println(path);
	        
	        
	         byte[] bytes = file.getBytes(); 

             //bytes to string conversion
             String fileToStr = new String(bytes, "UTF-8");
             System.out.println(fileToStr);                    
             String name=file.getOriginalFilename(); 

             String ext=name.substring(name.lastIndexOf("."),name.length()); 
             String fileName = ""+System.currentTimeMillis()+ext; 


           
			
			String rpath= path.toString(); //path forstoring the file
             System.out.println(rpath); 
             File filea=new File(rpath); 
             if(!filea.exists()){ 
                             filea.mkdirs(); 
             } 

             

             FileOutputStream fos= new FileOutputStream(filea); 
             fos.write(bytes); 
             fos.close(); 
	    }
	    catch (Exception ex) {
	        ex.printStackTrace();
	        return new ResponseEntity<>("Invalid file format!!", HttpStatus.BAD_REQUEST);
	    }

	    return new ResponseEntity<>("File uploaded!!", HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/dodajOglas/{file}/{agent}/{cenovnik}/{voziloSlobodnoOd}/{voziloSlobodnoDo}/{collisiondamageWaiver}")
	public ResponseEntity<Oglas> addAd(@RequestParam("file") MultipartFile file, @RequestBody Vozilo vozilo, @PathVariable("agent") Long id1,@PathVariable("cenovnik") Long id, @PathVariable("voziloSlobodnoOd") Date date1, @PathVariable("voziloSlobodnoDo") Date date2, @PathVariable("collisiondamageWaiver") boolean collision) throws IOException{
		// upload directory - change it to your own
        String UPLOAD_DIR = "/slike";

        // create a path from file name
        Path path = Paths.get(UPLOAD_DIR, file.getOriginalFilename());

        // save the file to `UPLOAD_DIR`
        // make sure you have permission to write
        Files.write(path, file.getBytes());
		
		
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
}
