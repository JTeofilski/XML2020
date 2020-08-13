package com.registracija.Registracija.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;


@Entity
public class Korpa {
	
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long identifikacioniBroj;
	
	@OneToOne(mappedBy = "korpa")
    protected RegistrovaniKorisnik registrovaniKorisnik;
	
	

	public Korpa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Korpa(RegistrovaniKorisnik registrovaniKorisnik) {
		super();
		this.registrovaniKorisnik = registrovaniKorisnik;
	}

	public RegistrovaniKorisnik getRegistrovaniKorisnik() {
		return registrovaniKorisnik;
	}

	public void setRegistrovaniKorisnik(RegistrovaniKorisnik registrovaniKorisnik) {
		this.registrovaniKorisnik = registrovaniKorisnik;
	}


	public Long getIdentifikacioniBroj() {
		return identifikacioniBroj;
	}

	public void setIdentifikacioniBroj(Long identifikacioniBroj) {
		this.identifikacioniBroj = identifikacioniBroj;
	}

	

}
