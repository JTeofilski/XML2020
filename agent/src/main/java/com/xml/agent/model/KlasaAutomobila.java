package com.xml.agent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class KlasaAutomobila {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long identifikacioniBroj;
	
	protected String klasa;

	public KlasaAutomobila() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KlasaAutomobila(String klasa) {
		super();
		this.klasa = klasa;
	}

	public Long getIdentifikacioniBroj() {
		return identifikacioniBroj;
	}

	public void setIdentifikacioniBroj(Long identifikacioniBroj) {
		this.identifikacioniBroj = identifikacioniBroj;
	}

	public String getKlasa() {
		return klasa;
	}

	public void setKlasa(String klasa) {
		this.klasa = klasa;
	}
	
}
