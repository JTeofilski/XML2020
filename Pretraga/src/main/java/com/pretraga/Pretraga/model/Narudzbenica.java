package com.pretraga.Pretraga.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Narudzbenica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long identifikacioniBroj;
	
	private long oglasId;
	
	private long registrovaniKorisnikId;
	
	private long agentId;
	
	private long korpaId;
	
	private Date rentiranjeOd;
	
	private Date rentiranjeDo;
	
	private String markaVozila;
	
	private long cenovnikId;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="zahtev_id")
	@JsonIgnore
	private ZahtevZaIznajmljivanje zahtev;

	public Narudzbenica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Narudzbenica(long oglasid, long registrovaniKorisnikId, long agentId, long korpaId, Date rentiranjeOd,
			Date rentiranjeDo, String markaVozila, long cenovnikId) {
		super();
		this.oglasId = oglasid;
		this.registrovaniKorisnikId = registrovaniKorisnikId;
		this.agentId = agentId;
		this.korpaId = korpaId;
		this.rentiranjeOd = rentiranjeOd;
		this.rentiranjeDo = rentiranjeDo;
		this.markaVozila = markaVozila;
		this.cenovnikId=cenovnikId;
	}

	public long getCenovnikId() {
		return cenovnikId;
	}

	public void setCenovnikId(long cenovnikId) {
		this.cenovnikId = cenovnikId;
	}

	public long getOglasId() {
		return oglasId;
	}

	public void setOglasId(long oglasid) {
		this.oglasId = oglasid;
	}

	public long getRegistrovaniKorisnikId() {
		return registrovaniKorisnikId;
	}

	public void setRegistrovaniKorisnikId(long registrovaniKorisnikId) {
		this.registrovaniKorisnikId = registrovaniKorisnikId;
	}

	public long getAgentId() {
		return agentId;
	}

	public void setAgentId(long agentId) {
		this.agentId = agentId;
	}

	public long getKorpaId() {
		return korpaId;
	}

	public void setKorpaId(long korpaId) {
		this.korpaId = korpaId;
	}

	public Date getRentiranjeOd() {
		return rentiranjeOd;
	}

	public void setRentiranjeOd(Date rentiranjeOd) {
		this.rentiranjeOd = rentiranjeOd;
	}

	public Date getRentiranjeDo() {
		return rentiranjeDo;
	}

	public void setRentiranjeDo(Date rentiranjeDo) {
		this.rentiranjeDo = rentiranjeDo;
	}

	public String getMarkaVozila() {
		return markaVozila;
	}

	public void setMarkaVozila(String markaVozila) {
		this.markaVozila = markaVozila;
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

	@Override
	public String toString() {
		return "Narudzbenica [identifikacioniBroj=" + identifikacioniBroj + ", oglasId=" + oglasId
				+ ", registrovaniKorisnikId=" + registrovaniKorisnikId + ", agentId=" + agentId + ", korpaId=" + korpaId
				+ ", rentiranjeOd=" + rentiranjeOd + ", rentiranjeDo=" + rentiranjeDo + ", markaVozila=" + markaVozila
				+ ", cenovnikId=" + cenovnikId + ", zahtev=" + zahtev + "]";
	}
	
	
}
