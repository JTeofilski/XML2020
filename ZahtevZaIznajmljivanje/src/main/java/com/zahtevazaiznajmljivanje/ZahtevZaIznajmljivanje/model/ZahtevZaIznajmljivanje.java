//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.29 at 08:14:42 PM CEST 
//


package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="identifikacioniBroj" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/oglas}Oglas" maxOccurs="unbounded"/>
 *         &lt;element name="registrovaniKorisnkID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="statusIznajmljivanja">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="PENDING|PAID|CANCELED"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="datumOD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="datumDO" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="bundle" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="ukupnaCena" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/izvestaj}Izvestaj"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "identifikacioniBroj",
    "registrovaniKorisnkID",
    "agentFirmaID",
    "statusIznajmljivanja",
    "datumOD",
    "datumDO",
    "bundle",
    "ukupnaCena",
    "narudzbenica",
    "vremeKreiranja"
})
@XmlRootElement(name = "ZahtevZaIznajmljivanje", namespace = "http://www.ftn.uns.ac.rs/zahtevzaiznajmljivanje")
@Entity
public class ZahtevZaIznajmljivanje {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtevzaiznajmljivanje")
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long identifikacioniBroj;
  
      
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtevzaiznajmljivanje")
    protected long registrovaniKorisnkID;
    
    protected long agentFirmaID;

    
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtevzaiznajmljivanje", required = true, defaultValue = "PENDING")
    protected String statusIznajmljivanja;
   // @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtevzaiznajmljivanje", required = true)
   // @XmlSchemaType(name = "dateTime")
    protected Date datumOD;
   // @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtevzaiznajmljivanje", required = true)
   // @XmlSchemaType(name = "dateTime")
    protected Date datumDO;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtevzaiznajmljivanje")
    protected boolean bundle;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/zahtevzaiznajmljivanje")
    protected float ukupnaCena;
    @XmlElement(name = "Izvestaj", namespace = "http://www.ftn.uns.ac.rs/izvestaj", required = true)
   // protected Izvestaj izvestaj;
    


    
    @OneToMany ( mappedBy = "zahtev")
    private Set<Narudzbenica> narudzbenica;
    
    
    
    public Set<Narudzbenica> getNarudzbenica() {
		return narudzbenica;
	}




    public java.util.Date vremeKreiranja;


	public java.util.Date getVremeKreiranja() {
		return vremeKreiranja;
	}







	public void setVremeKreiranja(java.util.Date vremeKreiranja) {
		this.vremeKreiranja = vremeKreiranja;
	}







	public void setNarudzbenica(Set<Narudzbenica> narudzbenica) {
		this.narudzbenica = narudzbenica;
	}







	public ZahtevZaIznajmljivanje() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    

	



	public ZahtevZaIznajmljivanje(long registrovaniKorisnkID, long agentFirmaID, String statusIznajmljivanja,
			Date datumOD, Date datumDO, boolean bundle, float ukupnaCena) {
		super();
		this.registrovaniKorisnkID = registrovaniKorisnkID;
		this.agentFirmaID = agentFirmaID;
		this.statusIznajmljivanja = statusIznajmljivanja;
		//this.datumOD = datumOD;
		//this.datumDO = datumDO;
		this.bundle = bundle;
		//this.ukupnaCena = ukupnaCena;
		
	}







	public ZahtevZaIznajmljivanje(long registrovaniKorisnkID, long agentFirmaID, String statusIznajmljivanja,
			boolean bundle, List<Narudzbenica> narudzbenica) {
		super();
		this.registrovaniKorisnkID = registrovaniKorisnkID;
		this.agentFirmaID = agentFirmaID;
		this.statusIznajmljivanja = statusIznajmljivanja;
		this.bundle = bundle;
		
	}







	/**
     * Gets the value of the identifikacioniBroj property.
     * 
     */
    public long getIdentifikacioniBroj() {
        return identifikacioniBroj;
    }

    /**
     * Sets the value of the identifikacioniBroj property.
     * 
     */
    

    /**
     * Gets the value of the oglas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oglas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOglas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Oglas }
     * 
     * 
     */
    

	/**
     * Gets the value of the registrovaniKorisnkID property.
     * 
     */
    public long getRegistrovaniKorisnkID() {
        return registrovaniKorisnkID;
    }

   

	/**
     * Sets the value of the registrovaniKorisnkID property.
     * 
     */
    public void setRegistrovaniKorisnkID(long value) {
        this.registrovaniKorisnkID = value;
    }

    /**
     * Gets the value of the statusIznajmljivanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusIznajmljivanja() {
        return statusIznajmljivanja;
    }

    /**
     * Sets the value of the statusIznajmljivanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusIznajmljivanja(String value) {
        this.statusIznajmljivanja = value;
    }

    /**
     * Gets the value of the datumOD property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getDatumOD() {
        return datumOD;
    }

    /**
     * Sets the value of the datumOD property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOD(Date value) {
        this.datumOD = value;
    }

    /**
     * Gets the value of the datumDO property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getDatumDO() {
        return datumDO;
    }

    /**
     * Sets the value of the datumDO property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDO(Date value) {
        this.datumDO = value;
    }

    /**
     * Gets the value of the bundle property.
     * 
     */
    public boolean isBundle() {
        return bundle;
    }

    /**
     * Sets the value of the bundle property.
     * 
     */
    public void setBundle(boolean value) {
        this.bundle = value;
    }

    /**
     * Gets the value of the ukupnaCena property.
     * 
     */
    public float getUkupnaCena() {
        return ukupnaCena;
    }

    /**
     * Sets the value of the ukupnaCena property.
     * 
     */
    public void setUkupnaCena(float value) {
        this.ukupnaCena = value;
    }







	public long getAgentFirmaID() {
		return agentFirmaID;
	}







	public void setAgentFirmaID(long agentFirmaID) {
		this.agentFirmaID = agentFirmaID;
	}

    
    
    
    /**
     * Gets the value of the izvestaj property.
     * 
     * @return
     *     possible object is
     *     {@link Izvestaj }
     *     
     
    public Izvestaj getIzvestaj() {
        return izvestaj;
    }
    
    */

    /**
     * Sets the value of the izvestaj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Izvestaj }
     *     
     
    public void setIzvestaj(Izvestaj value) {
        this.izvestaj = value;
    }
    */

}