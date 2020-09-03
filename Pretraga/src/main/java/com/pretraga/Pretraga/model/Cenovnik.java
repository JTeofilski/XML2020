//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.29 at 08:14:42 PM CEST 
//


package com.pretraga.Pretraga.model;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

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
 *         &lt;element name="cenaZaDan" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="cenaViseOd30" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="cenaPoKilometruZaOgranicenuKilometrazu" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="cenaCDW" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
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
    "cenaZaDan",
    "cenaViseOd30",
    "cenaPoKilometruZaOgranicenuKilometrazu",
    "cenaCDW",
    "oglasi"
})
@XmlRootElement(name = "Cenovnik", namespace = "http://www.ftn.uns.ac.rs/cenovnik")
@Entity
public class Cenovnik {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/cenovnik")
    @Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long identifikacioniBroj;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/cenovnik", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger cenaZaDan;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/cenovnik")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger cenaViseOd30;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/cenovnik")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger cenaPoKilometruZaOgranicenuKilometrazu;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/cenovnik")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger cenaCDW;

    @OneToMany(mappedBy = "cenovnik")
    @JsonIgnore
    protected Set<Oglas> oglasi= new HashSet<Oglas>();
    
    
    public Cenovnik(BigInteger cenaZaDan, BigInteger cenaViseOd30,
			BigInteger cenaPoKilometruZaOgranicenuKilometrazu, BigInteger cenaCDW, Set<Oglas> oglasi) {
		super();
		//this.identifikacioniBroj = identifikacioniBroj;
		this.cenaZaDan = cenaZaDan;
		this.cenaViseOd30 = cenaViseOd30;
		this.cenaPoKilometruZaOgranicenuKilometrazu = cenaPoKilometruZaOgranicenuKilometrazu;
		this.cenaCDW = cenaCDW;
		this.oglasi = oglasi;
	}
    public Cenovnik(BigInteger cenaZaDan, BigInteger cenaViseOd30,
			BigInteger cenaPoKilometruZaOgranicenuKilometrazu, Set<Oglas> oglasi) {
		super();
		//this.identifikacioniBroj = identifikacioniBroj;
		this.cenaZaDan = cenaZaDan;
		this.cenaViseOd30 = cenaViseOd30;
		this.cenaPoKilometruZaOgranicenuKilometrazu = cenaPoKilometruZaOgranicenuKilometrazu;
		//this.cenaCDW = cenaCDW;
		this.oglasi = oglasi;
	}
    

	public Cenovnik() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Set<Oglas> getOglasi() {
		return oglasi;
	}



	public void setOglasi(Set<Oglas> oglasi) {
		this.oglasi = oglasi;
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
    public void setIdentifikacioniBroj(long value) {
        this.identifikacioniBroj = value;
    }

    /**
     * Gets the value of the cenaZaDan property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCenaZaDan() {
        return cenaZaDan;
    }

    /**
     * Sets the value of the cenaZaDan property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCenaZaDan(BigInteger value) {
        this.cenaZaDan = value;
    }

    /**
     * Gets the value of the cenaViseOd30 property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCenaViseOd30() {
        return cenaViseOd30;
    }

    /**
     * Sets the value of the cenaViseOd30 property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCenaViseOd30(BigInteger value) {
        this.cenaViseOd30 = value;
    }

    /**
     * Gets the value of the cenaPoKilometruZaOgranicenuKilometrazu property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCenaPoKilometruZaOgranicenuKilometrazu() {
        return cenaPoKilometruZaOgranicenuKilometrazu;
    }

    /**
     * Sets the value of the cenaPoKilometruZaOgranicenuKilometrazu property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCenaPoKilometruZaOgranicenuKilometrazu(BigInteger value) {
        this.cenaPoKilometruZaOgranicenuKilometrazu = value;
    }

    /**
     * Gets the value of the cenaCDW property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCenaCDW() {
        return cenaCDW;
    }

    /**
     * Sets the value of the cenaCDW property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCenaCDW(BigInteger value) {
        this.cenaCDW = value;
    }

}
