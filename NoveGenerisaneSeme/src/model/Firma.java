//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.07.29 at 08:14:42 PM CEST 
//


package model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adresa" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="telefon" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="poslovniMaticniBroj" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/oglas}Oglas" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/izvestaj}Izvestaj" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/ocenakomentarporuka}Komentar" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.ftn.uns.ac.rs/ocenakomentarporuka}Poruka" maxOccurs="unbounded" minOccurs="0"/>
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
    "naziv",
    "adresa",
    "telefon",
    "poslovniMaticniBroj",
    "oglas",
    "izvestaj",
    "komentar",
    "poruka"
})
@XmlRootElement(name = "Firma")
public class Firma {

    @XmlElement(required = true)
    protected String naziv;
    @XmlElement(required = true)
    protected String adresa;
    @XmlElement(required = true)
    protected String telefon;
    @XmlElement(required = true)
    protected String poslovniMaticniBroj;
    @XmlElement(name = "Oglas", namespace = "http://www.ftn.uns.ac.rs/oglas")
    protected List<Oglas> oglas;
    @XmlElement(name = "Izvestaj", namespace = "http://www.ftn.uns.ac.rs/izvestaj")
    protected List<Izvestaj> izvestaj;
    @XmlElement(name = "Komentar", namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    protected List<Komentar> komentar;
    @XmlElement(name = "Poruka", namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    protected List<Poruka> poruka;

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaziv(String value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresa(String value) {
        this.adresa = value;
    }

    /**
     * Gets the value of the telefon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Sets the value of the telefon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelefon(String value) {
        this.telefon = value;
    }

    /**
     * Gets the value of the poslovniMaticniBroj property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoslovniMaticniBroj() {
        return poslovniMaticniBroj;
    }

    /**
     * Sets the value of the poslovniMaticniBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoslovniMaticniBroj(String value) {
        this.poslovniMaticniBroj = value;
    }

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
    public List<Oglas> getOglas() {
        if (oglas == null) {
            oglas = new ArrayList<Oglas>();
        }
        return this.oglas;
    }

    /**
     * Gets the value of the izvestaj property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the izvestaj property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIzvestaj().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Izvestaj }
     * 
     * 
     */
    public List<Izvestaj> getIzvestaj() {
        if (izvestaj == null) {
            izvestaj = new ArrayList<Izvestaj>();
        }
        return this.izvestaj;
    }

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
     */
    public List<Komentar> getKomentar() {
        if (komentar == null) {
            komentar = new ArrayList<Komentar>();
        }
        return this.komentar;
    }

    /**
     * Gets the value of the poruka property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the poruka property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPoruka().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Poruka }
     * 
     * 
     */
    public List<Poruka> getPoruka() {
        if (poruka == null) {
            poruka = new ArrayList<Poruka>();
        }
        return this.poruka;
    }

}
