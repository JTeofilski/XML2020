//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 07:53:23 PM CEST 
//


package model.ocena_komentar_poruka;

import javax.xml.datatype.XMLGregorianCalendar;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="identifikacioniBroj" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="kreatorKomentaraID" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="tekstKomentara" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="datumVremeKreiranja" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&amp;gt;
 *         &amp;lt;element name="statusKomentara"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;pattern value="odobren|neodobren"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "identifikacioniBroj",
    "kreatorKomentaraID",
    "tekstKomentara",
    "datumVremeKreiranja",
    "statusKomentara"
})
@XmlRootElement(name = "Komentar")
public class Komentar {

    protected long identifikacioniBroj;
    protected long kreatorKomentaraID;
    @XmlElement(required = true)
    protected String tekstKomentara;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumVremeKreiranja;
    @XmlElement(required = true)
    protected String statusKomentara;

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

}
