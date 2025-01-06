package org.openqa.selenium.devtools.v104.domsnapshot.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

/**
 * A name/value pair.
 */
public class NameValue {

    private final java.lang.String name;

    private final java.lang.String value;

    public NameValue(java.lang.String name, java.lang.String value) {
        this.name = java.util.Objects.requireNonNull(name, "name is required");
        this.value = java.util.Objects.requireNonNull(value, "value is required");
    }

    /**
     * Attribute/property name.
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * Attribute/property value.
     */
    public java.lang.String getValue() {
        return value;
    }

    private static NameValue fromJson(JsonInput input) {
        java.lang.String name = null;
        java.lang.String value = null;
        input.beginObject();
        while (input.hasNext()) {
            switch(input.nextName()) {
                case "name":
                    name = input.nextString();
                    break;
                case "value":
                    value = input.nextString();
                    break;
                default:
                    input.skipValue();
                    break;
            }
        }
        input.endObject();
        return new NameValue(name, value);
    }
}
