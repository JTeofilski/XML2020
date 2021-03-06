//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 08:09:20 PM CEST 
//


package model.zahtev_za_iznajmljivanje;

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
 *         &amp;lt;element name="oglasID" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="registrovaniKorisnkID" type="{http://www.w3.org/2001/XMLSchema}long"/&amp;gt;
 *         &amp;lt;element name="statusIznajmljivanja"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;pattern value="PENDING|PAID|CANCELED"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="datumOD" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&amp;gt;
 *         &amp;lt;element name="datumDO" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&amp;gt;
 *         &amp;lt;element name="bundle" type="{http://www.w3.org/2001/XMLSchema}boolean"/&amp;gt;
 *         &amp;lt;element name="cena" type="{http://www.w3.org/2001/XMLSchema}float"/&amp;gt;
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
    "oglasID",
    "registrovaniKorisnkID",
    "statusIznajmljivanja",
    "datumOD",
    "datumDO",
    "bundle",
    "cena"
})
@XmlRootElement(name = "ZahtevZaIznajmljivanje")
public class ZahtevZaIznajmljivanje {

    protected long identifikacioniBroj;
    protected long oglasID;
    protected long registrovaniKorisnkID;
    @XmlElement(required = true, defaultValue = "PENDING")
    protected String statusIznajmljivanja;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumOD;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar datumDO;
    protected boolean bundle;
    protected float cena;

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
     * Gets the value of the oglasID property.
     * 
     */
    public long getOglasID() {
        return oglasID;
    }

    /**
     * Sets the value of the oglasID property.
     * 
     */
    public void setOglasID(long value) {
        this.oglasID = value;
    }

    /**
     * Gets the value of the registrovaniKorisnkID property.
     * 
     */
    public long getRegistrovaniKorisnkID() {
        return registrovaniKorisnkID;
    }

    /**
     * Sets the value of the registrovaniKorisnkID property.
     * 
     */
    public void setRegistrovaniKorisnkID(long value) {
        this.registrovaniKorisnkID = value;
    }

    /**
     * Gets the value of the statusIznajmljivanja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusIznajmljivanja() {
        return statusIznajmljivanja;
    }

    /**
     * Sets the value of the statusIznajmljivanja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusIznajmljivanja(String value) {
        this.statusIznajmljivanja = value;
    }

    /**
     * Gets the value of the datumOD property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumOD() {
        return datumOD;
    }

    /**
     * Sets the value of the datumOD property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumOD(XMLGregorianCalendar value) {
        this.datumOD = value;
    }

    /**
     * Gets the value of the datumDO property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDatumDO() {
        return datumDO;
    }

    /**
     * Sets the value of the datumDO property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDatumDO(XMLGregorianCalendar value) {
        this.datumDO = value;
    }

    /**
     * Gets the value of the bundle property.
     * 
     */
    public boolean isBundle() {
        return bundle;
    }

    /**
     * Sets the value of the bundle property.
     * 
     */
    public void setBundle(boolean value) {
        this.bundle = value;
    }

    /**
     * Gets the value of the cena property.
     * 
     */
    public float getCena() {
        return cena;
    }

    /**
     * Sets the value of the cena property.
     * 
     */
    public void setCena(float value) {
        this.cena = value;
    }

}
