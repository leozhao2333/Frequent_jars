package org.openqa.selenium.devtools.v104.page.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

@org.openqa.selenium.Beta()
public enum OriginTrialUsageRestriction {

    NONE("None"), SUBSET("Subset");

    private String value;

    OriginTrialUsageRestriction(String value) {
        this.value = value;
    }

    public static OriginTrialUsageRestriction fromString(String s) {
        return java.util.Arrays.stream(OriginTrialUsageRestriction.values()).filter(rs -> rs.value.equalsIgnoreCase(s)).findFirst().orElseThrow(() -> new org.openqa.selenium.devtools.DevToolsException("Given value " + s + " is not found within OriginTrialUsageRestriction "));
    }

    public String toString() {
        return value;
    }

    public String toJson() {
        return value;
    }

    private static OriginTrialUsageRestriction fromJson(JsonInput input) {
        return fromString(input.nextString());
    }
}
