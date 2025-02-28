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
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for TN complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TN"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://www.kith.no/xmlstds}ED"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="{http://www.kith.no/xmlstds}REF" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute ref="{http://www.kith.no/xmlstds}COMPN"/&gt;
 *       &lt;attribute ref="{http://www.kith.no/xmlstds}IC"/&gt;
 *       &lt;attribute ref="{http://www.kith.no/xmlstds}ICA"/&gt;
 *       &lt;attribute ref="{http://www.kith.no/xmlstds}NULL"/&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TN", propOrder = {
    "ref"
})
public final class TN
    extends ED
{

    @XmlElement(name = "REF", namespace = "http://www.kith.no/xmlstds")
    private final URL ref;
    @XmlAttribute(name = "COMPN", namespace = "http://www.kith.no/xmlstds")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private final String compn;
    @XmlAttribute(name = "IC", namespace = "http://www.kith.no/xmlstds")
    private final byte[] ic;
    @XmlAttribute(name = "ICA", namespace = "http://www.kith.no/xmlstds")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private final String ica;
    @XmlAttribute(name = "NULL", namespace = "http://www.kith.no/xmlstds")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    private final String _null;

    public TN(final String mt, final URL ref, final String compn, final byte[] ic, final String ica, final String _null) {
        super(mt);
        this.ref = ref;
        this.compn = compn;
        this.ic = ic;
        this.ica = ica;
        this._null = _null;
    }

    /**
     * Used by JAX-B
     * 
     */
    protected TN() {
        super(null);
        this.ref = null;
        this.compn = null;
        this.ic = null;
        this.ica = null;
        this._null = null;
    }

    /**
     * Gets the value of the ref property.
     * 
     * @return
     *     possible object is
     *     {@link URL }
     *     
     */
    public URL getREF() {
        return ref;
    }

    /**
     * Gets the value of the compn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCOMPN() {
        return compn;
    }

    /**
     * Gets the value of the ic property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getIC() {
        return ic;
    }

    /**
     * Gets the value of the ica property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getICA() {
        if (ica == null) {
            return "SHA-1";
        } else {
            return ica;
        }
    }

    /**
     * Gets the value of the null property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNULL() {
        return _null;
    }

    public static TN.TNBuilder TNBuilder() {
        return new TN.TNBuilder();
    }

    public static class TNBuilder {

        private URL ref;
        private String compn;
        private byte[] ic;
        private String ica;
        private String _null;
        private String mt;

        public TN.TNBuilder withRef(final URL ref) {
            this.ref = ref;
            return this;
        }

        public TN.TNBuilder withCompn(final String compn) {
            this.compn = compn;
            return this;
        }

        public TN.TNBuilder withIc(final byte[] ic) {
            this.ic = ic;
            return this;
        }

        public TN.TNBuilder withIca(final String ica) {
            this.ica = ica;
            return this;
        }

        public TN.TNBuilder with_null(final String _null) {
            this._null = _null;
            return this;
        }

        public TN.TNBuilder withMt(final String mt) {
            this.mt = mt;
            return this;
        }

        public TN build() {
            return new TN(mt, ref, compn, ic, ica, _null);
        }

    }

}
