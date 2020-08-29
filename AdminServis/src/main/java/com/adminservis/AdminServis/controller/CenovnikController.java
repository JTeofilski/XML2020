package com.adminservis.AdminServis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminservis.AdminServis.model.Cenovnik;
import com.adminservis.AdminServis.service.CenovnikService;

@RestController
@RequestMapping("/cenovnici")
public class CenovnikController {

	@Autowired
	private CenovnikService cenovnikService;
	
	@RequestMapping(method=RequestMethod.GET, value="/bazaAdminCenovnik")
	public List<Cenovnik> proslediAgentu(){
		List<Cenovnik> cenovnici =cenovnikService.findAll();
		return cenovnici;
	
	}

}
