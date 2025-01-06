package org.openqa.selenium.devtools.v104.profiler.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

/**
 * Describes a type collected during runtime.
 */
@org.openqa.selenium.Beta()
public class TypeObject {

    private final java.lang.String name;

    public TypeObject(java.lang.String name) {
        this.name = java.util.Objects.requireNonNull(name, "name is required");
    }

    /**
     * Name of a type collected with type profiling.
     */
    public java.lang.String getName() {
        return name;
    }

    private static TypeObject fromJson(JsonInput input) {
        java.lang.String name = null;
        input.beginObject();
        while (input.hasNext()) {
            switch(input.nextName()) {
                case "name":
                    name = input.nextString();
                    break;
                default:
                    input.skipValue();
                    break;
            }
        }
        input.endObject();
        return new TypeObject(name);
    }
}
