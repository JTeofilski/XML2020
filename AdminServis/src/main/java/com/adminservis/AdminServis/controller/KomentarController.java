package com.adminservis.AdminServis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.adminservis.AdminServis.model.Komentar;
import com.adminservis.AdminServis.service.KomentarService;


@RestController
@RequestMapping("/komentari")
public class KomentarController {
	
	@Autowired
	private KomentarService service;
	
	@GetMapping
	public ModelAndView findAll() {
		List<Komentar> komentari=service.findAll();
		return new ModelAndView("adminKomentari","komentari", komentari);
		
	}
	
	

}
