
package no.nav.tjeneste.virksomhet.arbeidsforhold.v3.informasjon.arbeidsforhold;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;
import no.nav.tjeneste.virksomhet.arbeidsforhold.v3.informasjon.finnarbeidsforholdprarbeidsgiver.ArbeidsforholdStatusFilter;


/**
 * <p>Java class for Kodeverdi complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Kodeverdi">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="kodeRef" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Kodeverdi", propOrder = {
    "value"
})
@XmlSeeAlso({
    ArbeidsforholdStatusFilter.class,
    Landkoder.class,
    Arbeidsforholdstyper.class,
    Skipsregistre.class,
    Skipstyper.class,
    Avloenningstyper.class,
    PermisjonsOgPermitteringsBeskrivelse.class,
    Yrker.class,
    Fartsomraader.class,
    Regelverker.class,
    Arbeidstidsordninger.class
})
public class Kodeverdi {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "kodeRef")
    @XmlSchemaType(name = "anyURI")
    protected String kodeRef;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the kodeRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKodeRef() {
        return kodeRef;
    }

    /**
     * Sets the value of the kodeRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKodeRef(String value) {
        this.kodeRef = value;
    }

}
