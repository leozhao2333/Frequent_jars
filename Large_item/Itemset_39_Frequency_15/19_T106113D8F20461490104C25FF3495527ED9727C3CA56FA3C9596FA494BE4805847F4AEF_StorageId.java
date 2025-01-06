package org.openqa.selenium.devtools.v101.domstorage.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

/**
 * DOM Storage identifier.
 */
public class StorageId {

    private final java.lang.String securityOrigin;

    private final java.lang.Boolean isLocalStorage;

    public StorageId(java.lang.String securityOrigin, java.lang.Boolean isLocalStorage) {
        this.securityOrigin = java.util.Objects.requireNonNull(securityOrigin, "securityOrigin is required");
        this.isLocalStorage = java.util.Objects.requireNonNull(isLocalStorage, "isLocalStorage is required");
    }

    /**
     * Security origin for the storage.
     */
    public java.lang.String getSecurityOrigin() {
        return securityOrigin;
    }

    /**
     * Whether the storage is local storage (not session storage).
     */
    public java.lang.Boolean getIsLocalStorage() {
        return isLocalStorage;
    }

    private static StorageId fromJson(JsonInput input) {
        java.lang.String securityOrigin = null;
        java.lang.Boolean isLocalStorage = false;
        input.beginObject();
        while (input.hasNext()) {
            switch(input.nextName()) {
                case "securityOrigin":
                    securityOrigin = input.nextString();
                    break;
                case "isLocalStorage":
                    isLocalStorage = input.nextBoolean();
                    break;
                default:
                    input.skipValue();
                    break;
            }
        }
        input.endObject();
        return new StorageId(securityOrigin, isLocalStorage);
    }
}
