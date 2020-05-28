//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0-M3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.05.28 at 08:05:38 PM CEST 
//


package model.vozilo;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the model.vozilo package. 
 * &lt;p&gt;An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Vozilo_QNAME = new QName("http://www.ftn.uns.ac.rs/vozilo", "Vozilo");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: model.vozilo
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TVozilo }
     * 
     */
    public TVozilo createTVozilo() {
        return new TVozilo();
    }

    /**
     * Create an instance of {@link TKlasaVozila }
     * 
     */
    public TKlasaVozila createTKlasaVozila() {
        return new TKlasaVozila();
    }

    /**
     * Create an instance of {@link TMarkaVozila }
     * 
     */
    public TMarkaVozila createTMarkaVozila() {
        return new TMarkaVozila();
    }

    /**
     * Create an instance of {@link TModelVozila }
     * 
     */
    public TModelVozila createTModelVozila() {
        return new TModelVozila();
    }

    /**
     * Create an instance of {@link TVrstaGoriva }
     * 
     */
    public TVrstaGoriva createTVrstaGoriva() {
        return new TVrstaGoriva();
    }

    /**
     * Create an instance of {@link TTipMenjaca }
     * 
     */
    public TTipMenjaca createTTipMenjaca() {
        return new TTipMenjaca();
    }

    /**
     * Create an instance of {@link TSlika }
     * 
     */
    public TSlika createTSlika() {
        return new TSlika();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TVozilo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link TVozilo }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.ftn.uns.ac.rs/vozilo", name = "Vozilo")
    public JAXBElement<TVozilo> createVozilo(TVozilo value) {
        return new JAXBElement<TVozilo>(_Vozilo_QNAME, TVozilo.class, null, value);
    }

}
