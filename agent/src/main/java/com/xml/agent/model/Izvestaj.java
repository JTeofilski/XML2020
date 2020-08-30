package com.xml.agent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Izvestaj {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
	protected long identifikacioniBroj;
	
	protected long idAgenta;
	
	protected long idVozila;
	
	protected int brKilometara;
	
	protected String dodatneInformacije;

	public Izvestaj(long idAgenta, long idVozila, int brKilometara, String dodatneInformacije) {
		super();
		this.idAgenta = idAgenta;
		this.idVozila = idVozila;
		this.brKilometara = brKilometara;
		this.dodatneInformacije = dodatneInformacije;
	}

	public Izvestaj() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdAgenta() {
		return idAgenta;
	}

	public void setIdAgenta(long idAgenta) {
		this.idAgenta = idAgenta;
	}

	public long getIdVozila() {
		return idVozila;
	}

	public void setIdVozila(long idVozila) {
		this.idVozila = idVozila;
	}

	public int getBrKilometara() {
		return brKilometara;
	}

	public void setBrKilometara(int brKilometara) {
		this.brKilometara = brKilometara;
	}

	public String getDodatneInformacije() {
		return dodatneInformacije;
	}

	public void setDodatneInformacije(String dodatneInformacije) {
		this.dodatneInformacije = dodatneInformacije;
	}

	public long getIdentifikacioniBroj() {
		return identifikacioniBroj;
	}

	
}
