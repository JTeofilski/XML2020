//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 07:59:12 PM CEST 
//


package model.obican_korisnik_pretraga;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for TVrstaGoriva complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="TVrstaGoriva"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="nazivVrsteGoriva" type="{http://www.w3.org/2001/XMLSchema}string"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TVrstaGoriva", propOrder = {
    "nazivVrsteGoriva"
})
public class TVrstaGoriva {

    @XmlElement(required = true)
    protected String nazivVrsteGoriva;

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

}