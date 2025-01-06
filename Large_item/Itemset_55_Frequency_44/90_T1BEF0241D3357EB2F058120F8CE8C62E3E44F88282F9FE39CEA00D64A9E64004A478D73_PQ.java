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
 * <p>Java class for PQ complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PQ"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="V" type="{http://www.w3.org/2001/XMLSchema}double" /&gt;
 *       &lt;attribute name="U" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PQ")
public final class PQ {

    @XmlAttribute(name = "V")
    private final Double v;
    @XmlAttribute(name = "U")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    private final String u;

    public PQ(final Double v, final String u) {
        this.v = v;
        this.u = u;
    }

    /**
     * Used by JAX-B
     * 
     */
    protected PQ() {
        this.v = null;
        this.u = null;
    }

    /**
     * Gets the value of the v property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getV() {
        return v;
    }

    /**
     * Gets the value of the u property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getU() {
        return u;
    }

    public static PQ.PQBuilder PQBuilder() {
        return new PQ.PQBuilder();
    }

    public static class PQBuilder {

        private Double v;
        private String u;

        public PQ.PQBuilder withV(final Double v) {
            this.v = v;
            return this;
        }

        public PQ.PQBuilder withU(final String u) {
            this.u = u;
            return this;
        }

        public PQ build() {
            return new PQ(v, u);
        }

    }

}
