package com.xml.agent.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VrstaGoriva {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long identifikacioniBroj;
	
	protected String gorivo;

	public VrstaGoriva() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VrstaGoriva(String gorivo) {
		super();
		this.gorivo = gorivo;
	}

	public Long getIdentifikacioniBroj() {
		return identifikacioniBroj;
	}

	public void setIdentifikacioniBroj(Long identifikacioniBroj) {
		this.identifikacioniBroj = identifikacioniBroj;
	}

	public String getGorivo() {
		return gorivo;
	}

	public void setGorivo(String gorivo) {
		this.gorivo = gorivo;
	}
	
}
