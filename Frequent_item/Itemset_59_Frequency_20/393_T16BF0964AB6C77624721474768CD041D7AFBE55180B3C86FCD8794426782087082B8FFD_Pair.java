/*
 * Aeternity node
 * This is the [Aeternity](https://www.aeternity.com/) node API.
 *
 * The version of the OpenAPI document: x.y.z
 * Contact: apiteam@aeternity.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.kryptokrauts.aeternity.generated;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2022-01-10T23:40:09.108255703Z[Etc/UTC]")
public class Pair {
    private String name = "";
    private String value = "";

    public Pair (String name, String value) {
        setName(name);
        setValue(value);
    }

    private void setName(String name) {
        if (!isValidString(name)) {
            return;
        }

        this.name = name;
    }

    private void setValue(String value) {
        if (!isValidString(value)) {
            return;
        }

        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    private boolean isValidString(String arg) {
        if (arg == null) {
            return false;
        }

        if (arg.trim().isEmpty()) {
            return false;
        }

        return true;
    }
}
