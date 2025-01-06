package org.openqa.selenium.devtools.v104.domstorage.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

public class SerializedStorageKey {

    private final java.lang.String serializedStorageKey;

    public SerializedStorageKey(java.lang.String serializedStorageKey) {
        this.serializedStorageKey = java.util.Objects.requireNonNull(serializedStorageKey, "Missing value for SerializedStorageKey");
    }

    private static SerializedStorageKey fromJson(JsonInput input) {
        return new SerializedStorageKey(input.nextString());
    }

    public String toJson() {
        return serializedStorageKey.toString();
    }

    public String toString() {
        return serializedStorageKey.toString();
    }
}
