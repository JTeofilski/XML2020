package com.ocena.Ocena.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.29 at 08:14:42 PM CEST 
//




import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
 *         &lt;element name="kreatorKomentaraID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tekstKomentara" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datumVremeKreiranja" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="statusKomentara">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;pattern value="odobren|neodobren"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="pomocnoPoljeZaOglas" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "kreatorKomentaraID",
    "tekstKomentara",
    "datumVremeKreiranja",
    "statusKomentara",
    "pomocnoPoljeZaOglas"
})
@XmlRootElement(name = "Komentar", namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
@Entity
public class Komentar {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    protected long identifikacioniBroj;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    protected long kreatorKomentaraID;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka", required = true)
    protected String tekstKomentara;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka", required = true)
    @XmlSchemaType(name = "dateTime")
    protected Date datumVremeKreiranja;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka", required = true)
    protected String statusKomentara;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    
    protected String imeKorisnika;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="oglas_id")
	@JsonIgnore  
    protected Oglas oglas;

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
     * Gets the value of the kreatorKomentaraID property.
     * 
     */
    public long getKreatorKomentaraID() {
        return kreatorKomentaraID;
    }

    /**
     * Sets the value of the kreatorKomentaraID property.
     * 
     */
    public void setKreatorKomentaraID(long value) {
        this.kreatorKomentaraID = value;
    }

    /**
     * Gets the value of the tekstKomentara property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTekstKomentara() {
        return tekstKomentara;
    }

    /**
     * Sets the value of the tekstKomentara property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTekstKomentara(String value) {
        this.tekstKomentara = value;
    }

    /**
     * Gets the value of the datumVremeKreiranja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public Date getDatumVremeKreiranja() {
        return datumVremeKreiranja;
    }

    /**
     * Sets the value of the datumVremeKreiranja property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumVremeKreiranja(Date value) {
        this.datumVremeKreiranja = value;
    }

    /**
     * Gets the value of the statusKomentara property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusKomentara() {
        return statusKomentara;
    }

    /**
     * Sets the value of the statusKomentara property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusKomentara(String value) {
        this.statusKomentara = value;
    }

    /**
     * Gets the value of the pomocnoPoljeZaOglas property.
     * 
     */
    public Oglas getOglas() {
        return oglas;
    }

    /**
     * Sets the value of the pomocnoPoljeZaOglas property.
     * 
     */
    public void setOglas(Oglas value) {
        this.oglas = value;
    }

	public String getImeKorisnika() {
		return imeKorisnika;
	}

	public void setImeKorisnika(String imeKorisnika) {
		this.imeKorisnika = imeKorisnika;
	}

	public Komentar(long kreatorKomentaraID, String tekstKomentara, Date datumVremeKreiranja, String statusKomentara,
			String imeKorisnika, Oglas oglas) {
		super();
		this.kreatorKomentaraID = kreatorKomentaraID;
		this.tekstKomentara = tekstKomentara;
		this.datumVremeKreiranja = datumVremeKreiranja;
		this.statusKomentara = statusKomentara;
		this.imeKorisnika = imeKorisnika;
		this.oglas = oglas;
	}

	public Komentar() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Komentar [kreatorKomentaraID=" + kreatorKomentaraID + ", tekstKomentara=" + tekstKomentara
				+ ", datumVremeKreiranja=" + datumVremeKreiranja + ", statusKomentara=" + statusKomentara
				+ ", imeKorisnika=" + imeKorisnika + "]";
	}

}