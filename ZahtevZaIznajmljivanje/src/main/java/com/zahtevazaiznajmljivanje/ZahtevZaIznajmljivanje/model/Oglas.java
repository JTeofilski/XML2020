//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.29 at 08:14:42 PM CEST 
//


package com.zahtevazaiznajmljivanje.ZahtevZaIznajmljivanje.model;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
    
    // @XmlElement(namespace = "http://www.ftn.uns.ac.rs/oglas", required = true)
    // @XmlSchemaType(name = "dateTime")
    // protected java.sql.Date voziloSlobodnoOd;
   // protected XMLGregorianCalendar voziloSlodobnoOd;
   // @XmlElement(namespace = "http://www.ftn.uns.ac.rs/oglas", required = true)
   // @XmlSchemaType(name = "dateTime")
    //protected java.sql.Date voziloSlobodnoDo;
    @XmlElement(name = "Cenovnik", namespace = "http://www.ftn.uns.ac.rs/cenovnik", required = true)
    @ManyToOne
     protected Cenovnik cenovnik;
    @XmlElement(name = "Ocena", namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    @OneToMany(mappedBy = "oglas",fetch = FetchType.EAGER)
    protected Set<Ocena> ocena;
   
    @XmlElement(name = "Komentar", namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "oglas_id")
    protected Set<Komentar> komentar;
    
    
    @XmlElement(name = "Vozilo", namespace = "http://www.ftn.uns.ac.rs/vozilo", required = true)
    @ManyToOne
    protected Vozilo vozilo;
    
    @ManyToOne
    protected Agent agent;
    
    
    
    
    
    @OneToMany (
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
   @JoinColumn(name = "oglas")
    public Set<RezervisaniDatumi> rezervisaniDatumi;
    
    
    
   /* private final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    
   // private final SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
     
    private java.sql.Date parseDate(String date) {
        try {
            return new Date(DATE_FORMAT.parse(date).getTime());
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }
    }*/

   
    
    

	public Oglas() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Oglas(Cenovnik cenovnik, Vozilo vozilo, Agent agent,
			Set<RezervisaniDatumi> rezervisaniDatumi, Set<Ocena> ocena) {
		super();
		this.cenovnik = cenovnik;
		this.vozilo = vozilo;
		this.agent = agent;
		this.rezervisaniDatumi = rezervisaniDatumi;
		this.ocena=ocena;
		
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

    public Cenovnik getCenovnik() {
		return cenovnik;
	}



	public void setCenovnik(Cenovnik cenovnik) {
		this.cenovnik = cenovnik;
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

	/*
	public java.sql.Date getVoziloSlobodnoOd() {
		return voziloSlobodnoOd;
	}

	public void setVoziloSlobodnoOd(java.sql.Date voziloSlobodnoOd) {
		this.voziloSlobodnoOd = voziloSlobodnoOd;
	}



	public java.sql.Date getVoziloSlobodnoDo() {
		return voziloSlobodnoDo;
	}



	public void setVoziloSlobodnoDo(java.sql.Date voziloSlobodnoDo) {
		this.voziloSlobodnoDo = voziloSlobodnoDo;
	}

	*/

	public long getIdentifikacioniBroj() {
		return identifikacioniBroj;
	}






	public Set<RezervisaniDatumi> getRezervisaniDatumi() {
		if(rezervisaniDatumi==null) {
			rezervisaniDatumi=new HashSet<RezervisaniDatumi>();
		}
		return rezervisaniDatumi;
	}



	public void setRezervisaniDatumi(Set<RezervisaniDatumi> rezervisaniDatumi) {
		this.rezervisaniDatumi = rezervisaniDatumi;
	}



	public Set<Ocena> getOcena() {
		return ocena;
	}



	public void setOcena(Set<Ocena> ocena) {
		this.ocena = ocena;
	}



	public Set<Komentar> getKomentar() {
		if(komentar.equals(null))
			return new HashSet<Komentar>();
		else
			return komentar;
	}



	public void setKomentar(Set<Komentar> komentar) {
		this.komentar = komentar;
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

   
   

}
