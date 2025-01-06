
package no.nav.tjeneste.virksomhet.arbeidsfordeling.v1.feil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for ForretningsmessigUnntak complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ForretningsmessigUnntak">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="feilkilde" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="feilaarsak" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="feilmelding" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="tidspunkt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForretningsmessigUnntak", propOrder = {
    "feilkilde",
    "feilaarsak",
    "feilmelding",
    "tidspunkt"
})
@XmlSeeAlso({
    UgyldigInput.class
})
public abstract class ForretningsmessigUnntak {

    @XmlElement(required = true)
    protected String feilkilde;
    @XmlElement(required = true)
    protected String feilaarsak;
    @XmlElement(required = true)
    protected String feilmelding;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tidspunkt;

    /**
     * Gets the value of the feilkilde property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeilkilde() {
        return feilkilde;
    }

    /**
     * Sets the value of the feilkilde property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeilkilde(String value) {
        this.feilkilde = value;
    }

    /**
     * Gets the value of the feilaarsak property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeilaarsak() {
        return feilaarsak;
    }

    /**
     * Sets the value of the feilaarsak property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeilaarsak(String value) {
        this.feilaarsak = value;
    }

    /**
     * Gets the value of the feilmelding property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeilmelding() {
        return feilmelding;
    }

    /**
     * Sets the value of the feilmelding property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeilmelding(String value) {
        this.feilmelding = value;
    }

    /**
     * Gets the value of the tidspunkt property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTidspunkt() {
        return tidspunkt;
    }

    /**
     * Sets the value of the tidspunkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTidspunkt(XMLGregorianCalendar value) {
        this.tidspunkt = value;
    }

}
