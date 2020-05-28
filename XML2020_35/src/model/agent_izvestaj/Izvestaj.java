//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 07:54:14 PM CEST 
//


package model.agent_izvestaj;

import java.math.BigInteger;
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
 *         &amp;lt;element name="brojPredjenihKilometara" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/&amp;gt;
 *         &amp;lt;element name="slodobanTekst" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *         &amp;lt;element name="agentID" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="voziloID" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
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
    "brojPredjenihKilometara",
    "slodobanTekst",
    "agentID",
    "voziloID"
})
@XmlRootElement(name = "Izvestaj")
public class Izvestaj {

    protected long identifikacioniBroj;
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger brojPredjenihKilometara;
    @XmlElement(required = true)
    protected String slodobanTekst;
    protected long agentID;
    protected long voziloID;

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
     * Gets the value of the brojPredjenihKilometara property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBrojPredjenihKilometara() {
        return brojPredjenihKilometara;
    }

    /**
     * Sets the value of the brojPredjenihKilometara property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBrojPredjenihKilometara(BigInteger value) {
        this.brojPredjenihKilometara = value;
    }

    /**
     * Gets the value of the slodobanTekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSlodobanTekst() {
        return slodobanTekst;
    }

    /**
     * Sets the value of the slodobanTekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSlodobanTekst(String value) {
        this.slodobanTekst = value;
    }

    /**
     * Gets the value of the agentID property.
     * 
     */
    public long getAgentID() {
        return agentID;
    }

    /**
     * Sets the value of the agentID property.
     * 
     */
    public void setAgentID(long value) {
        this.agentID = value;
    }

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

}
