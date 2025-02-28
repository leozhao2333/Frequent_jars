/*-
 * ========================LICENSE_START=================================
 * d16b-edifact-binding
 * %%
 * Copyright (C) 2020 - 2024 Smooks
 * %%
 * Licensed under the terms of the Apache License Version 2.0, or
 * the GNU Lesser General Public License version 3.0 or later.
 * 
 * SPDX-License-Identifier: Apache-2.0 OR LGPL-3.0-or-later
 * 
 * ======================================================================
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * ======================================================================
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 * =========================LICENSE_END==================================
 */
//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.04.17 at 06:20:44 PM UTC 
//


package org.smooks.edifact.binding.d16b;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DIM-Dimensions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DIM-Dimensions"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="E6145" type="{http://www.ibm.com/dfdl/edi/un/edifact/D16B}E6145-DimensionTypeCodeQualifier"/&gt;
 *         &lt;element name="C211" type="{http://www.ibm.com/dfdl/edi/un/edifact/D16B}C211-Dimensions"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DIM-Dimensions", propOrder = {
    "e6145",
    "c211"
})
public class DIMDimensions {

    @XmlElement(name = "E6145", required = true)
    protected String e6145;
    @XmlElement(name = "C211", required = true)
    protected C211Dimensions c211;

    /**
     * Gets the value of the e6145 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getE6145() {
        return e6145;
    }

    /**
     * Sets the value of the e6145 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setE6145(String value) {
        this.e6145 = value;
    }

    /**
     * Gets the value of the c211 property.
     * 
     * @return
     *     possible object is
     *     {@link C211Dimensions }
     *     
     */
    public C211Dimensions getC211() {
        return c211;
    }

    /**
     * Sets the value of the c211 property.
     * 
     * @param value
     *     allowed object is
     *     {@link C211Dimensions }
     *     
     */
    public void setC211(C211Dimensions value) {
        this.c211 = value;
    }

    public DIMDimensions withE6145(String value) {
        setE6145(value);
        return this;
    }

    public DIMDimensions withC211(C211Dimensions value) {
        setC211(value);
        return this;
    }

}
