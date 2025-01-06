
package no.nav.tjeneste.virksomhet.behandleforsendelse.v1.feil;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jvnet.jaxb2_commons.lang.Equals2;
import org.jvnet.jaxb2_commons.lang.EqualsStrategy2;
import org.jvnet.jaxb2_commons.lang.HashCode2;
import org.jvnet.jaxb2_commons.lang.HashCodeStrategy2;
import org.jvnet.jaxb2_commons.lang.JAXBEqualsStrategy;
import org.jvnet.jaxb2_commons.lang.JAXBHashCodeStrategy;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;
import org.jvnet.jaxb2_commons.locator.util.LocatorUtils;


/**
 * <p>Java class for ForretningsmessigUnntak complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ForretningsmessigUnntak"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="feilkilde" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="feilaarsak" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="feilmelding" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tidspunkt" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
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
    WSDokumentmottakKanIkkeGjennomfoeres.class
})
public abstract class WSForretningsmessigUnntak implements Equals2, HashCode2
{

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

    public int hashCode(ObjectLocator locator, HashCodeStrategy2 strategy) {
        int currentHashCode = 1;
        {
            String theFeilkilde;
            theFeilkilde = this.getFeilkilde();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "feilkilde", theFeilkilde), currentHashCode, theFeilkilde, (this.feilkilde!= null));
        }
        {
            String theFeilaarsak;
            theFeilaarsak = this.getFeilaarsak();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "feilaarsak", theFeilaarsak), currentHashCode, theFeilaarsak, (this.feilaarsak!= null));
        }
        {
            String theFeilmelding;
            theFeilmelding = this.getFeilmelding();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "feilmelding", theFeilmelding), currentHashCode, theFeilmelding, (this.feilmelding!= null));
        }
        {
            XMLGregorianCalendar theTidspunkt;
            theTidspunkt = this.getTidspunkt();
            currentHashCode = strategy.hashCode(LocatorUtils.property(locator, "tidspunkt", theTidspunkt), currentHashCode, theTidspunkt, (this.tidspunkt!= null));
        }
        return currentHashCode;
    }

    public int hashCode() {
        final HashCodeStrategy2 strategy = JAXBHashCodeStrategy.INSTANCE;
        return this.hashCode(null, strategy);
    }

    public boolean equals(ObjectLocator thisLocator, ObjectLocator thatLocator, Object object, EqualsStrategy2 strategy) {
        if ((object == null)||(this.getClass()!= object.getClass())) {
            return false;
        }
        if (this == object) {
            return true;
        }
        final WSForretningsmessigUnntak that = ((WSForretningsmessigUnntak) object);
        {
            String lhsFeilkilde;
            lhsFeilkilde = this.getFeilkilde();
            String rhsFeilkilde;
            rhsFeilkilde = that.getFeilkilde();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "feilkilde", lhsFeilkilde), LocatorUtils.property(thatLocator, "feilkilde", rhsFeilkilde), lhsFeilkilde, rhsFeilkilde, (this.feilkilde!= null), (that.feilkilde!= null))) {
                return false;
            }
        }
        {
            String lhsFeilaarsak;
            lhsFeilaarsak = this.getFeilaarsak();
            String rhsFeilaarsak;
            rhsFeilaarsak = that.getFeilaarsak();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "feilaarsak", lhsFeilaarsak), LocatorUtils.property(thatLocator, "feilaarsak", rhsFeilaarsak), lhsFeilaarsak, rhsFeilaarsak, (this.feilaarsak!= null), (that.feilaarsak!= null))) {
                return false;
            }
        }
        {
            String lhsFeilmelding;
            lhsFeilmelding = this.getFeilmelding();
            String rhsFeilmelding;
            rhsFeilmelding = that.getFeilmelding();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "feilmelding", lhsFeilmelding), LocatorUtils.property(thatLocator, "feilmelding", rhsFeilmelding), lhsFeilmelding, rhsFeilmelding, (this.feilmelding!= null), (that.feilmelding!= null))) {
                return false;
            }
        }
        {
            XMLGregorianCalendar lhsTidspunkt;
            lhsTidspunkt = this.getTidspunkt();
            XMLGregorianCalendar rhsTidspunkt;
            rhsTidspunkt = that.getTidspunkt();
            if (!strategy.equals(LocatorUtils.property(thisLocator, "tidspunkt", lhsTidspunkt), LocatorUtils.property(thatLocator, "tidspunkt", rhsTidspunkt), lhsTidspunkt, rhsTidspunkt, (this.tidspunkt!= null), (that.tidspunkt!= null))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object object) {
        final EqualsStrategy2 strategy = JAXBEqualsStrategy.INSTANCE;
        return equals(null, null, object, strategy);
    }

    public WSForretningsmessigUnntak withFeilkilde(String value) {
        setFeilkilde(value);
        return this;
    }

    public WSForretningsmessigUnntak withFeilaarsak(String value) {
        setFeilaarsak(value);
        return this;
    }

    public WSForretningsmessigUnntak withFeilmelding(String value) {
        setFeilmelding(value);
        return this;
    }

    public WSForretningsmessigUnntak withTidspunkt(XMLGregorianCalendar value) {
        setTidspunkt(value);
        return this;
    }

}
