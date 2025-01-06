package org.openqa.selenium.devtools.v104.audits.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

public enum ContentSecurityPolicyViolationType {

    KINLINEVIOLATION("kInlineViolation"),
    KEVALVIOLATION("kEvalViolation"),
    KURLVIOLATION("kURLViolation"),
    KTRUSTEDTYPESSINKVIOLATION("kTrustedTypesSinkViolation"),
    KTRUSTEDTYPESPOLICYVIOLATION("kTrustedTypesPolicyViolation"),
    KWASMEVALVIOLATION("kWasmEvalViolation");

    private String value;

    ContentSecurityPolicyViolationType(String value) {
        this.value = value;
    }

    public static ContentSecurityPolicyViolationType fromString(String s) {
        return java.util.Arrays.stream(ContentSecurityPolicyViolationType.values()).filter(rs -> rs.value.equalsIgnoreCase(s)).findFirst().orElseThrow(() -> new org.openqa.selenium.devtools.DevToolsException("Given value " + s + " is not found within ContentSecurityPolicyViolationType "));
    }

    public String toString() {
        return value;
    }

    public String toJson() {
        return value;
    }

    private static ContentSecurityPolicyViolationType fromJson(JsonInput input) {
        return fromString(input.nextString());
    }
}
