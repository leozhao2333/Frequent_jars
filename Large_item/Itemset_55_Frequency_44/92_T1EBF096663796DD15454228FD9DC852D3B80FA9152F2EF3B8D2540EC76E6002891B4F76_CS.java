//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.12.22 at 09:42:06 AM CET 
//


package no.kith.xmlstds;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for CS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="V" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="DN" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CS")
public final class CS {

    @XmlAttribute(name = "V")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    private final String v;
    @XmlAttribute(name = "DN")
    private final String dn;

    public CS(final String v, final String dn) {
        this.v = v;
        this.dn = dn;
    }

    /**
     * Used by JAX-B
     * 
     */
    protected CS() {
        this.v = null;
        this.dn = null;
    }

    /**
     * Gets the value of the v property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getV() {
        return v;
    }

    /**
     * Gets the value of the dn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDN() {
        return dn;
    }

    public static CS.CSBuilder CSBuilder() {
        return new CS.CSBuilder();
    }

    public static class CSBuilder {

        private String v;
        private String dn;

        public CS.CSBuilder withV(final String v) {
            this.v = v;
            return this;
        }

        public CS.CSBuilder withDn(final String dn) {
            this.dn = dn;
            return this;
        }

        public CS build() {
            return new CS(v, dn);
        }

    }

}
