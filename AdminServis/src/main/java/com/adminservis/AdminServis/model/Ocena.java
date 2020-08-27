package com.adminservis.AdminServis.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
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
 *         &lt;element name="vrednostOcene">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}positiveInteger">
 *               &lt;maxInclusive value="5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="kreatorOceneID" type="{http://www.w3.org/2001/XMLSchema}long"/>
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
    "vrednostOcene",
    "kreatorOceneID",
    "pomocnoPoljeZaOglas"
})
@XmlRootElement(name = "Ocena", namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
@Entity
public class Ocena {

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long identifikacioniBroj;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    protected double vrednostOcene;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
    protected long kreatorOceneID;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/ocenakomentarporuka")
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
    public void setIdentifikacioniBroj(long value) {
        this.identifikacioniBroj = value;
    }

    /**
     * Gets the value of the vrednostOcene property.
     * 
     */
    public double getVrednostOcene() {
        return vrednostOcene;
    }

    /**
     * Sets the value of the vrednostOcene property.
     * 
     */
    public void setVrednostOcene(double value) {
        this.vrednostOcene = value;
    }

    /**
     * Gets the value of the kreatorOceneID property.
     * 
     */
    public long getKreatorOceneID() {
        return kreatorOceneID;
    }

    /**
     * Sets the value of the kreatorOceneID property.
     * 
     */
    public void setKreatorOceneID(long value) {
        this.kreatorOceneID = value;
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
    public void setOglas(Oglas oglas) {
        this.oglas = oglas;
    }

	@Override
	public String toString() {
		return "Ocena [vrednostOcene=" + vrednostOcene + ", kreatorOceneID=" + kreatorOceneID + "]";
	}

}