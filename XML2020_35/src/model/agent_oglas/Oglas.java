//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 07:55:18 PM CEST 
//


package model.agent_oglas;

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
 *         &amp;lt;element name="voziloID" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="voziloSlodobnoOd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&amp;gt;
 *         &amp;lt;element name="voziloSlobodnoDo" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&amp;gt;
 *         &amp;lt;element name="cenovnikID" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
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
    "voziloID",
    "voziloSlodobnoOd",
    "voziloSlobodnoDo",
    "cenovnikID"
})
@XmlRootElement(name = "Oglas")
public class Oglas {

    protected long voziloID;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar voziloSlodobnoOd;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar voziloSlobodnoDo;
    protected long cenovnikID;

    /**
     * Gets the value of the voziloID property.
     * 
     */
    public long getVoziloID() {
        return voziloID;
    }

    /**
     * Sets the value of the voziloID property.
     * 
     */
    public void setVoziloID(long value) {
        this.voziloID = value;
    }

    /**
     * Gets the value of the voziloSlodobnoOd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVoziloSlodobnoOd() {
        return voziloSlodobnoOd;
    }

    /**
     * Sets the value of the voziloSlodobnoOd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVoziloSlodobnoOd(XMLGregorianCalendar value) {
        this.voziloSlodobnoOd = value;
    }

    /**
     * Gets the value of the voziloSlobodnoDo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVoziloSlobodnoDo() {
        return voziloSlobodnoDo;
    }

    /**
     * Sets the value of the voziloSlobodnoDo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVoziloSlobodnoDo(XMLGregorianCalendar value) {
        this.voziloSlobodnoDo = value;
    }

    /**
     * Gets the value of the cenovnikID property.
     * 
     */
    public long getCenovnikID() {
        return cenovnikID;
    }

    /**
     * Sets the value of the cenovnikID property.
     * 
     */
    public void setCenovnikID(long value) {
        this.cenovnikID = value;
    }

}