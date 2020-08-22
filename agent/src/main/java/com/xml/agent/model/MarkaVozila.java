package com.xml.agent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MarkaVozila {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long identifikacioniBroj;
	
	protected String marka;

	public MarkaVozila() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MarkaVozila(String marka) {
		super();
		this.marka = marka;
	}

	public Long getIdentifikacioniBroj() {
		return identifikacioniBroj;
	}

	public void setIdentifikacioniBroj(Long identifikacioniBroj) {
		this.identifikacioniBroj = identifikacioniBroj;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}
	
}
