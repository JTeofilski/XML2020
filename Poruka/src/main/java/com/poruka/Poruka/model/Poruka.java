package com.poruka.Poruka.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Poruka {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long identifikacioniBroj;
	
	protected String text;

	@ManyToOne
	protected ZahtevZaIznajmljivanje zahtev;
	
	public Poruka() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Poruka(String text, ZahtevZaIznajmljivanje zahtev) {
		super();
		this.text = text;
		this.zahtev = zahtev;
	}

	

	public ZahtevZaIznajmljivanje getZahtev() {
		return zahtev;
	}

	public void setZahtev(ZahtevZaIznajmljivanje zahtev) {
		this.zahtev = zahtev;
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
	
}
