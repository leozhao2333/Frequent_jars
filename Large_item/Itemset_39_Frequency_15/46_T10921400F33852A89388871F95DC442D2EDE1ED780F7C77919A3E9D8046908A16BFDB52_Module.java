package org.openqa.selenium.devtools.v104.memory.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

/**
 * Executable module information
 */
public class Module {

    private final java.lang.String name;

    private final java.lang.String uuid;

    private final java.lang.String baseAddress;

    private final java.lang.Number size;

    public Module(java.lang.String name, java.lang.String uuid, java.lang.String baseAddress, java.lang.Number size) {
        this.name = java.util.Objects.requireNonNull(name, "name is required");
        this.uuid = java.util.Objects.requireNonNull(uuid, "uuid is required");
        this.baseAddress = java.util.Objects.requireNonNull(baseAddress, "baseAddress is required");
        this.size = java.util.Objects.requireNonNull(size, "size is required");
    }

    /**
     * Name of the module.
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * UUID of the module.
     */
    public java.lang.String getUuid() {
        return uuid;
    }

    /**
     * Base address where the module is loaded into memory. Encoded as a decimal
     * or hexadecimal (0x prefixed) string.
     */
    public java.lang.String getBaseAddress() {
        return baseAddress;
    }

    /**
     * Size of the module in bytes.
     */
    public java.lang.Number getSize() {
        return size;
    }

    private static Module fromJson(JsonInput input) {
        java.lang.String name = null;
        java.lang.String uuid = null;
        java.lang.String baseAddress = null;
        java.lang.Number size = 0;
        input.beginObject();
        while (input.hasNext()) {
            switch(input.nextName()) {
                case "name":
                    name = input.nextString();
                    break;
                case "uuid":
                    uuid = input.nextString();
                    break;
                case "baseAddress":
                    baseAddress = input.nextString();
                    break;
                case "size":
                    size = input.nextNumber();
                    break;
                default:
                    input.skipValue();
                    break;
            }
        }
        input.endObject();
        return new Module(name, uuid, baseAddress, size);
    }
}
