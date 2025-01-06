package org.openqa.selenium.devtools.v104.database.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

/**
 * Unique identifier of Database object.
 */
public class DatabaseId {

    private final java.lang.String databaseId;

    public DatabaseId(java.lang.String databaseId) {
        this.databaseId = java.util.Objects.requireNonNull(databaseId, "Missing value for DatabaseId");
    }

    private static DatabaseId fromJson(JsonInput input) {
        return new DatabaseId(input.nextString());
    }

    public String toJson() {
        return databaseId.toString();
    }

    public String toString() {
        return databaseId.toString();
    }
}
