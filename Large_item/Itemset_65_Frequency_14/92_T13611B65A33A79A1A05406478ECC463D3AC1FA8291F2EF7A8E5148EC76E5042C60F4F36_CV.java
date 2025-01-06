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
 * <p>Java class for CV complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CV"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="V" type="{http://www.w3.org/2001/XMLSchema}token" /&gt;
 *       &lt;attribute name="S" type="{http://www.kith.no/xmlstds}oid" /&gt;
 *       &lt;attribute name="DN" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *       &lt;attribute name="OT" type="{http://www.w3.org/2001/XMLSchema}string" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CV")
public final class CV {

    @XmlAttribute(name = "V")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "token")
    private final String v;
    @XmlAttribute(name = "S")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private final String s;
    @XmlAttribute(name = "DN")
    private final String dn;
    @XmlAttribute(name = "OT")
    private final String ot;

    public CV(final String v, final String s, final String dn, final String ot) {
        this.v = v;
        this.s = s;
        this.dn = dn;
        this.ot = ot;
    }

    /**
     * Used by JAX-B
     * 
     */
    protected CV() {
        this.v = null;
        this.s = null;
        this.dn = null;
        this.ot = null;
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
     * Gets the value of the s property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getS() {
        return s;
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

    /**
     * Gets the value of the ot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOT() {
        return ot;
    }

    public static CV.CVBuilder CVBuilder() {
        return new CV.CVBuilder();
    }

    public static class CVBuilder {

        private String v;
        private String s;
        private String dn;
        private String ot;

        public CV.CVBuilder withV(final String v) {
            this.v = v;
            return this;
        }

        public CV.CVBuilder withS(final String s) {
            this.s = s;
            return this;
        }

        public CV.CVBuilder withDn(final String dn) {
            this.dn = dn;
            return this;
        }

        public CV.CVBuilder withOt(final String ot) {
            this.ot = ot;
            return this;
        }

        public CV build() {
            return new CV(v, s, dn, ot);
        }

    }

}
