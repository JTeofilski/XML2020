package com.adminservis.AdminServis.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RezervisaniDatumi {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long identifikacioniBroj;
	
	@Column
	protected Date datumOd;
	
	@Column
	protected Date datumDo;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name="oglas")
	@JsonIgnore
	public Oglas oglas;

	public RezervisaniDatumi( Date datumOd, Date datumDo, Oglas oglas) {
		super();
		this.datumOd = datumOd;
		this.datumDo = datumDo;
		this.oglas = oglas;
	}

	public RezervisaniDatumi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getDatumOd() {
		return datumOd;
	}

	public void setDatumOd(Date datumOd) {
		this.datumOd = datumOd;
	}

	public Date getDatumDo() {
		return datumDo;
	}

	public void setDatumDo(Date datumDo) {
		this.datumDo = datumDo;
	}

	public Oglas getOglas() {
		return oglas;
	}

	public void setOglas(Oglas oglas) {
		this.oglas = oglas;
	}

	
	

}
