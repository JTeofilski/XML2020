//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.29 at 08:14:42 PM CEST 
//


package com.xml.agent.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="klasaVozila" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nazivKlase" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nazivMarke" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nazivModela" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nazivVrsteGoriva" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nazivTipaMenjaca" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="slika" type="{http://www.w3.org/2001/XMLSchema}base64Binary" maxOccurs="unbounded"/>
 *         &lt;element name="predjenaKilometraza" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="brojSedistaZaDecu" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="ogranicenjeKilometraze" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="collisiondamageWaiver" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "klasaVozila",
    "nazivKlase",
    "nazivMarke",
    "nazivModela",
    "nazivVrsteGoriva",
    "nazivTipaMenjaca",
    "slika",
    "predjenaKilometraza",
    "brojSedistaZaDecu",
    "ogranicenjeKilometraze",
    "collisiondamageWaiver",
    "oglasi"
})
@XmlRootElement(name = "Vozilo", namespace = "http://www.ftn.uns.ac.rs/vozilo")
@Entity
public class Vozilo {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo")
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long identifikacioniBroj;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo", required = true)
    protected String klasaVozila;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo", required = true)
    protected String nazivKlase;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo", required = true)
    protected String nazivMarke;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo", required = true)
    protected String nazivModela;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo", required = true)
    protected String nazivVrsteGoriva;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo", required = true)
    protected String nazivTipaMenjaca;
    //@XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo", required = true)
    protected String slike;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo")
    protected float predjenaKilometraza;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo", required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brojSedistaZaDecu;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo")
    protected float ogranicenjeKilometraze;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/vozilo")
    protected boolean collisiondamageWaiver;
    
    
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/oglas")
    @OneToMany(mappedBy="vozilo")
    protected Set<Oglas> oglasi= new HashSet<Oglas>();
    
   
	public Vozilo(long identifikacioniBroj, String klasaVozila, String nazivKlase, String nazivMarke,
			String nazivModela, String nazivVrsteGoriva, String nazivTipaMenjaca, List<byte[]> slika,
			float predjenaKilometraza, BigInteger brojSedistaZaDecu, float ogranicenjeKilometraze,
			boolean collisiondamageWaiver, Set<Oglas> oglasi) {
		super();
		this.identifikacioniBroj = identifikacioniBroj;
		this.klasaVozila = klasaVozila;
		this.nazivKlase = nazivKlase;
		this.nazivMarke = nazivMarke;
		this.nazivModela = nazivModela;
		this.nazivVrsteGoriva = nazivVrsteGoriva;
		this.nazivTipaMenjaca = nazivTipaMenjaca;
	//	this.slika = slika;
		this.predjenaKilometraza = predjenaKilometraza;
		this.brojSedistaZaDecu = brojSedistaZaDecu;
		this.ogranicenjeKilometraze = ogranicenjeKilometraze;
		this.collisiondamageWaiver = collisiondamageWaiver;
		this.oglasi = oglasi;
	}
	
	

	public Vozilo() {
		super();
		// TODO Auto-generated constructor stub
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
     * Gets the value of the klasaVozila property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKlasaVozila() {
        return klasaVozila;
    }

    /**
     * Sets the value of the klasaVozila property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKlasaVozila(String value) {
        this.klasaVozila = value;
    }

    /**
     * Gets the value of the nazivKlase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivKlase() {
        return nazivKlase;
    }

    /**
     * Sets the value of the nazivKlase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivKlase(String value) {
        this.nazivKlase = value;
    }

    /**
     * Gets the value of the nazivMarke property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivMarke() {
        return nazivMarke;
    }

    /**
     * Sets the value of the nazivMarke property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivMarke(String value) {
        this.nazivMarke = value;
    }

    /**
     * Gets the value of the nazivModela property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivModela() {
        return nazivModela;
    }

    /**
     * Sets the value of the nazivModela property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivModela(String value) {
        this.nazivModela = value;
    }

    /**
     * Gets the value of the nazivVrsteGoriva property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivVrsteGoriva() {
        return nazivVrsteGoriva;
    }

    /**
     * Sets the value of the nazivVrsteGoriva property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivVrsteGoriva(String value) {
        this.nazivVrsteGoriva = value;
    }

    /**
     * Gets the value of the nazivTipaMenjaca property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivTipaMenjaca() {
        return nazivTipaMenjaca;
    }

    /**
     * Sets the value of the nazivTipaMenjaca property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivTipaMenjaca(String value) {
        this.nazivTipaMenjaca = value;
    }

    /**
     * Gets the value of the slika property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the slika property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSlika().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * byte[]
     * 
     
    public List<byte[]> getSlika() {
        if (slika == null) {
            slika = new ArrayList<byte[]>();
        }
        return this.slika;
    }
*/
    /**
     * Gets the value of the predjenaKilometraza property.
     * 
     */
    public float getPredjenaKilometraza() {
        return predjenaKilometraza;
    }

    /**
     * Sets the value of the predjenaKilometraza property.
     * 
     */
    public void setPredjenaKilometraza(float value) {
        this.predjenaKilometraza = value;
    }

    /**
     * Gets the value of the brojSedistaZaDecu property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojSedistaZaDecu() {
        return brojSedistaZaDecu;
    }

    /**
     * Sets the value of the brojSedistaZaDecu property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojSedistaZaDecu(BigInteger value) {
        this.brojSedistaZaDecu = value;
    }

    /**
     * Gets the value of the ogranicenjeKilometraze property.
     * 
     */
    public float getOgranicenjeKilometraze() {
        return ogranicenjeKilometraze;
    }

    /**
     * Sets the value of the ogranicenjeKilometraze property.
     * 
     */
    public void setOgranicenjeKilometraze(float value) {
        this.ogranicenjeKilometraze = value;
    }

    /**
     * Gets the value of the collisiondamageWaiver property.
     * 
     */
    public boolean isCollisiondamageWaiver() {
        return collisiondamageWaiver;
    }

    /**
     * Sets the value of the collisiondamageWaiver property.
     * 
     */
    public void setCollisiondamageWaiver(boolean value) {
        this.collisiondamageWaiver = value;
    }



	public String getSlike() {
		return slike;
	}



	public void setSlike(String slike) {
		this.slike = slike;
	}

}
