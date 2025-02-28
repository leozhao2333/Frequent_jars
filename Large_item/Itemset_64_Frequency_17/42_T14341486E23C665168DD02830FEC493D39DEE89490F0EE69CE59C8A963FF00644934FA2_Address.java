//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.12.22 at 09:46:08 AM CET 
//


package no.kith.xmlstds.felleskomponent1;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import no.kith.xmlstds.CS;


/**
 * Adresseopplysninger.
 * 
 * <p>Java class for Address complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Address"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Type" type="{http://www.kith.no/xmlstds}CS" minOccurs="0"/&gt;
 *         &lt;element name="StreetAdr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="PostalCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="City" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Postbox" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="County" type="{http://www.kith.no/xmlstds}CS" minOccurs="0"/&gt;
 *         &lt;element name="Country" type="{http://www.kith.no/xmlstds}CS" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Address", propOrder = {
    "type",
    "streetAdr",
    "postalCode",
    "city",
    "postbox",
    "county",
    "country"
})
public final class Address {

    @XmlElement(name = "Type")
    private final CS type;
    @XmlElement(name = "StreetAdr")
    private final String streetAdr;
    @XmlElement(name = "PostalCode")
    private final String postalCode;
    @XmlElement(name = "City")
    private final String city;
    @XmlElement(name = "Postbox")
    private final String postbox;
    @XmlElement(name = "County")
    private final CS county;
    @XmlElement(name = "Country")
    private final CS country;

    public Address(final CS type, final String streetAdr, final String postalCode, final String city, final String postbox, final CS county, final CS country) {
        this.type = type;
        this.streetAdr = streetAdr;
        this.postalCode = postalCode;
        this.city = city;
        this.postbox = postbox;
        this.county = county;
        this.country = country;
    }

    /**
     * Used by JAX-B
     * 
     */
    protected Address() {
        this.type = null;
        this.streetAdr = null;
        this.postalCode = null;
        this.city = null;
        this.postbox = null;
        this.county = null;
        this.country = null;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link CS }
     *     
     */
    public CS getType() {
        return type;
    }

    /**
     * Gets the value of the streetAdr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetAdr() {
        return streetAdr;
    }

    /**
     * Gets the value of the postalCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the value of the postbox property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostbox() {
        return postbox;
    }

    /**
     * Gets the value of the county property.
     * 
     * @return
     *     possible object is
     *     {@link CS }
     *     
     */
    public CS getCounty() {
        return county;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link CS }
     *     
     */
    public CS getCountry() {
        return country;
    }

    public static Address.AddressBuilder addressBuilder() {
        return new Address.AddressBuilder();
    }

    public static class AddressBuilder {

        private CS type;
        private String streetAdr;
        private String postalCode;
        private String city;
        private String postbox;
        private CS county;
        private CS country;

        public Address.AddressBuilder withType(final CS type) {
            this.type = type;
            return this;
        }

        public Address.AddressBuilder withStreetAdr(final String streetAdr) {
            this.streetAdr = streetAdr;
            return this;
        }

        public Address.AddressBuilder withPostalCode(final String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address.AddressBuilder withCity(final String city) {
            this.city = city;
            return this;
        }

        public Address.AddressBuilder withPostbox(final String postbox) {
            this.postbox = postbox;
            return this;
        }

        public Address.AddressBuilder withCounty(final CS county) {
            this.county = county;
            return this;
        }

        public Address.AddressBuilder withCountry(final CS country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(type, streetAdr, postalCode, city, postbox, county, country);
        }

    }

}
