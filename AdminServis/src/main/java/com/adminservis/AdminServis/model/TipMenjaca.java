package com.adminservis.AdminServis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipMenjaca {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long identifikacioniBroj;
	
	protected String menjac;

	public TipMenjaca() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipMenjaca(String menjac) {
		super();
		this.menjac = menjac;
	}

	public String getMenjac() {
		return menjac;
	}

	public void setMenjac(String menjac) {
		this.menjac = menjac;
	}

	public Long getIdentifikacioniBroj() {
		return identifikacioniBroj;
	}

	public void setIdentifikacioniBroj(Long identifikacioniBroj) {
		this.identifikacioniBroj = identifikacioniBroj;
	}
	
}
