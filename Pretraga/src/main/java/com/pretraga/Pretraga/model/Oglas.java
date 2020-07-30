//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.29 at 08:14:42 PM CEST 
//


package com.pretraga.Pretraga.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/vozilo}Vozilo"/>
 *         &lt;element name="voziloSlodobnoOd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="voziloSlobodnoDo" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/cenovnik}Cenovnik"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/ocenakomentarporuka}Ocena" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/ocenakomentarporuka}Komentar" maxOccurs="unbounded" minOccurs="0"/>
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
    "vozilo",
    "voziloSlodobnoOd",
    "voziloSlobodnoDo",
    "cenovnik",
    "ocena",
    "komentar"
})
@XmlRootElement(name = "Oglas", namespace = "http://www.ftn.uns.ac.rs/oglas")
@Entity
public class Oglas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected long identifikacioniBroj;
	
    
  //  @XmlElement(namespace = "http://www.ftn.uns.ac.rs/oglas", required = true)
   // @XmlSchemaType(name = "dateTime")
   // protected XMLGregorianCalendar voziloSlodobnoOd;
  //  @XmlElement(namespace = "http://www.ftn.uns.ac.rs/oglas", required = true)
   // @XmlSchemaType(name = "dateTime")
   // protected XMLGregorianCalendar voziloSlobodnoDo;
   // @XmlElement(name = "Cenovnik", namespace = "http://www.ftn.uns.ac.rs/cenovnik", required = true)
   // protected Cenovnik cenovnik;
   // @XmlElement(name = "Ocena", namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
   // protected List<Ocena> ocena;
   // @XmlElement(name = "Komentar", namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
   // protected List<Komentar> komentar;
    
    
    @XmlElement(name = "Vozilo", namespace = "http://www.ftn.uns.ac.rs/vozilo", required = true)
    @ManyToOne
    protected Vozilo vozilo;
    
    @ManyToOne
    protected Agent agent;
    
    

    public Oglas(long identifikacioniBroj, Vozilo vozilo, Agent agent, XMLGregorianCalendar voziloSlodobnoOd,
			XMLGregorianCalendar voziloSlobodnoDo, Cenovnik cenovnik) {
		super();
		this.identifikacioniBroj = identifikacioniBroj;
		this.vozilo = vozilo;
		this.agent = agent;
		//this.voziloSlodobnoOd = voziloSlodobnoOd;
		//this.voziloSlobodnoDo = voziloSlobodnoDo;
		//this.cenovnik = cenovnik;
	}
    
    

	public Oglas() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
     * Gets the value of the vozilo property.
     * 
     * @return
     *     possible object is
     *     {@link Vozilo }
     *     
     */
    public Vozilo getVozilo() {
        return vozilo;
    }

    /**
     * Sets the value of the vozilo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Vozilo }
     *     
     */
    public void setVozilo(Vozilo value) {
        this.vozilo = value;
    }



	public Agent getAgent() {
		return agent;
	}



	public void setAgent(Agent agent) {
		this.agent = agent;
	}

    
    /**
     * Gets the value of the voziloSlodobnoOd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     
    public XMLGregorianCalendar getVoziloSlodobnoOd() {
        return voziloSlodobnoOd;
    }
*/
    /**
     * Sets the value of the voziloSlodobnoOd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
    
    public void setVoziloSlodobnoOd(XMLGregorianCalendar value) {
        this.voziloSlodobnoOd = value;
    }
 */
    /**
     * Gets the value of the voziloSlobodnoDo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
    
    public XMLGregorianCalendar getVoziloSlobodnoDo() {
        return voziloSlobodnoDo;
    }
 */
    /**
     * Sets the value of the voziloSlobodnoDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     
    public void setVoziloSlobodnoDo(XMLGregorianCalendar value) {
        this.voziloSlobodnoDo = value;
    }
*/
    /**
     * Gets the value of the cenovnik property.
     * 
     * @return
     *     possible object is
     *     {@link Cenovnik }
     *     
     
    public Cenovnik getCenovnik() {
        return cenovnik;
    }
    */

    /**
     * Sets the value of the cenovnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link Cenovnik }
     *     
     
    public void setCenovnik(Cenovnik value) {
        this.cenovnik = value;
    }
    */

    /**
     * Gets the value of the ocena property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ocena property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOcena().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Ocena }
     * 
     * 
     
    public List<Ocena> getOcena() {
        if (ocena == null) {
            ocena = new ArrayList<Ocena>();
        }
        return this.ocena;
    }
    */

    /**
     * Gets the value of the komentar property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the komentar property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKomentar().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Komentar }
     * 
     * 
     
    public List<Komentar> getKomentar() {
        if (komentar == null) {
            komentar = new ArrayList<Komentar>();
        }
        return this.komentar;
    }
*/
}
