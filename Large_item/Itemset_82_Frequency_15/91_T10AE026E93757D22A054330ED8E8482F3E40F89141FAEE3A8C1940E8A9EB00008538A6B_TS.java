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
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TS complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TS"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="V"&gt;
 *         &lt;simpleType&gt;
 *           &lt;union memberTypes=" {http://www.w3.org/2001/XMLSchema}dateTime {http://www.w3.org/2001/XMLSchema}date {http://www.w3.org/2001/XMLSchema}gYear {http://www.w3.org/2001/XMLSchema}gYearMonth {http://www.w3.org/2001/XMLSchema}time"&gt;
 *           &lt;/union&gt;
 *         &lt;/simpleType&gt;
 *       &lt;/attribute&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TS")
public final class TS {

    @XmlAttribute(name = "V")
    private final String v;

    public TS(final String v) {
        this.v = v;
    }

    /**
     * Used by JAX-B
     * 
     */
    protected TS() {
        this.v = null;
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

    public static TS.TSBuilder TSBuilder() {
        return new TS.TSBuilder();
    }

    public static class TSBuilder {

        private String v;

        public TS.TSBuilder withV(final String v) {
            this.v = v;
            return this;
        }

        public TS build() {
            return new TS(v);
        }

    }

}
