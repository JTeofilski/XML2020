package com.poruka.Poruka.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Poruka {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long identifikacioniBroj;
	
	protected String text;
	
	protected long korisnik;
	
	protected long agent;

	public Poruka() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Poruka(String text, long korisnik, long agent) {
		super();
		this.text = text;
		this.korisnik = korisnik;
		this.agent = agent;
	}

	public long getIdentifikacioniBroj() {
		return identifikacioniBroj;
	}

	public void setIdentifikacioniBroj(long identifikacioniBroj) {
		this.identifikacioniBroj = identifikacioniBroj;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(long korisnik) {
		this.korisnik = korisnik;
	}

	public long getAgent() {
		return agent;
	}

	public void setAgent(long agent) {
		this.agent = agent;
	}
	
}
