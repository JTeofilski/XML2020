//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.29 at 08:14:42 PM CEST 
//


package model;

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
 *         &lt;element name="kreatorPorukeID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="primalacPorukeID" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tekstPoruke" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="datumVremeKreiranja" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="zahtevZaIznajmljivanjeID" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "kreatorPorukeID",
    "primalacPorukeID",
    "tekstPoruke",
    "datumVremeKreiranja",
    "zahtevZaIznajmljivanjeID"
})
@XmlRootElement(name = "Poruka", namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
public class Poruka {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    protected long identifikacioniBroj;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    protected long kreatorPorukeID;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    protected long primalacPorukeID;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka", required = true)
    protected String tekstPoruke;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumVremeKreiranja;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    protected long zahtevZaIznajmljivanjeID;

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
     * Gets the value of the kreatorPorukeID property.
     * 
     */
    public long getKreatorPorukeID() {
        return kreatorPorukeID;
    }

    /**
     * Sets the value of the kreatorPorukeID property.
     * 
     */
    public void setKreatorPorukeID(long value) {
        this.kreatorPorukeID = value;
    }

    /**
     * Gets the value of the primalacPorukeID property.
     * 
     */
    public long getPrimalacPorukeID() {
        return primalacPorukeID;
    }

    /**
     * Sets the value of the primalacPorukeID property.
     * 
     */
    public void setPrimalacPorukeID(long value) {
        this.primalacPorukeID = value;
    }

    /**
     * Gets the value of the tekstPoruke property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTekstPoruke() {
        return tekstPoruke;
    }

    /**
     * Sets the value of the tekstPoruke property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTekstPoruke(String value) {
        this.tekstPoruke = value;
    }

    /**
     * Gets the value of the datumVremeKreiranja property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumVremeKreiranja() {
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
    public void setDatumVremeKreiranja(XMLGregorianCalendar value) {
        this.datumVremeKreiranja = value;
    }

    /**
     * Gets the value of the zahtevZaIznajmljivanjeID property.
     * 
     */
    public long getZahtevZaIznajmljivanjeID() {
        return zahtevZaIznajmljivanjeID;
    }

    /**
     * Sets the value of the zahtevZaIznajmljivanjeID property.
     * 
     */
    public void setZahtevZaIznajmljivanjeID(long value) {
        this.zahtevZaIznajmljivanjeID = value;
    }

}
