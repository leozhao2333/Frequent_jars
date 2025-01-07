package org.openqa.selenium.devtools.v104.page.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

/**
 * Status for an Origin Trial.
 */
@org.openqa.selenium.Beta()
public enum OriginTrialStatus {

    ENABLED("Enabled"), VALIDTOKENNOTPROVIDED("ValidTokenNotProvided"), OSNOTSUPPORTED("OSNotSupported"), TRIALNOTALLOWED("TrialNotAllowed");

    private String value;

    OriginTrialStatus(String value) {
        this.value = value;
    }

    public static OriginTrialStatus fromString(String s) {
        return java.util.Arrays.stream(OriginTrialStatus.values()).filter(rs -> rs.value.equalsIgnoreCase(s)).findFirst().orElseThrow(() -> new org.openqa.selenium.devtools.DevToolsException("Given value " + s + " is not found within OriginTrialStatus "));
    }

    public String toString() {
        return value;
    }

    public String toJson() {
        return value;
    }

    private static OriginTrialStatus fromJson(JsonInput input) {
        return fromString(input.nextString());
    }
}
