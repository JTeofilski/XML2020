//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 07:59:12 PM CEST 
//


package model.obican_korisnik_pretraga;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;extension base="{http://www.ftn.uns.ac.rs/korisnici}TKorisnik"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element name="status"&amp;gt;
 *           &amp;lt;simpleType&amp;gt;
 *             &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *               &amp;lt;pattern value="aktivan|blokiran|uklonjen"/&amp;gt;
 *             &amp;lt;/restriction&amp;gt;
 *           &amp;lt;/simpleType&amp;gt;
 *         &amp;lt;/element&amp;gt;
 *         &amp;lt;element name="oglasID" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="3" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="ocenaID" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="komentarID" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="porukaID" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="zahtevZaIznajmljivanjeID" type="{http://www.w3.org/2001/XMLSchema}long" maxOccurs="unbounded" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "status",
    "oglasID",
    "ocenaID",
    "komentarID",
    "porukaID",
    "zahtevZaIznajmljivanjeID"
})
@XmlRootElement(name = "RegistrovaniKorisnik", namespace = "http://www.ftn.uns.ac.rs/korisnici")
public class RegistrovaniKorisnik
    extends TKorisnik
{

    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnici", required = true)
    protected String status;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnici", type = Long.class)
    protected List<Long> oglasID;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnici", type = Long.class)
    protected List<Long> ocenaID;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnici", type = Long.class)
    protected List<Long> komentarID;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnici", type = Long.class)
    protected List<Long> porukaID;
    @XmlElement(namespace = "http://www.ftn.uns.ac.rs/korisnici", type = Long.class)
    protected List<Long> zahtevZaIznajmljivanjeID;

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the oglasID property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the oglasID property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getOglasID().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getOglasID() {
        if (oglasID == null) {
            oglasID = new ArrayList<Long>();
        }
        return this.oglasID;
    }

    /**
     * Gets the value of the ocenaID property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the ocenaID property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getOcenaID().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getOcenaID() {
        if (ocenaID == null) {
            ocenaID = new ArrayList<Long>();
        }
        return this.ocenaID;
    }

    /**
     * Gets the value of the komentarID property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the komentarID property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getKomentarID().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getKomentarID() {
        if (komentarID == null) {
            komentarID = new ArrayList<Long>();
        }
        return this.komentarID;
    }

    /**
     * Gets the value of the porukaID property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the porukaID property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getPorukaID().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getPorukaID() {
        if (porukaID == null) {
            porukaID = new ArrayList<Long>();
        }
        return this.porukaID;
    }

    /**
     * Gets the value of the zahtevZaIznajmljivanjeID property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the zahtevZaIznajmljivanjeID property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getZahtevZaIznajmljivanjeID().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link Long }
     * 
     * 
     */
    public List<Long> getZahtevZaIznajmljivanjeID() {
        if (zahtevZaIznajmljivanjeID == null) {
            zahtevZaIznajmljivanjeID = new ArrayList<Long>();
        }
        return this.zahtevZaIznajmljivanjeID;
    }

}
