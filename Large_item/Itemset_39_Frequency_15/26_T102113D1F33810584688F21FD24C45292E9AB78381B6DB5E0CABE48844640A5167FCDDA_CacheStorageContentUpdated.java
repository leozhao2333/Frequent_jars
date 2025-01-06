package org.openqa.selenium.devtools.v104.storage.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

/**
 * A cache's contents have been modified.
 */
public class CacheStorageContentUpdated {

    private final java.lang.String origin;

    private final java.lang.String cacheName;

    public CacheStorageContentUpdated(java.lang.String origin, java.lang.String cacheName) {
        this.origin = java.util.Objects.requireNonNull(origin, "origin is required");
        this.cacheName = java.util.Objects.requireNonNull(cacheName, "cacheName is required");
    }

    /**
     * Origin to update.
     */
    public java.lang.String getOrigin() {
        return origin;
    }

    /**
     * Name of cache in origin.
     */
    public java.lang.String getCacheName() {
        return cacheName;
    }

    private static CacheStorageContentUpdated fromJson(JsonInput input) {
        java.lang.String origin = null;
        java.lang.String cacheName = null;
        input.beginObject();
        while (input.hasNext()) {
            switch(input.nextName()) {
                case "origin":
                    origin = input.nextString();
                    break;
                case "cacheName":
                    cacheName = input.nextString();
                    break;
                default:
                    input.skipValue();
                    break;
            }
        }
        input.endObject();
        return new CacheStorageContentUpdated(origin, cacheName);
    }
}
