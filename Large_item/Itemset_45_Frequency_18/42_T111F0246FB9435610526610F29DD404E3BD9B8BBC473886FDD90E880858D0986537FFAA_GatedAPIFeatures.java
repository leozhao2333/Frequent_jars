package org.openqa.selenium.devtools.v104.page.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

@org.openqa.selenium.Beta()
public enum GatedAPIFeatures {

    SHAREDARRAYBUFFERS("SharedArrayBuffers"), SHAREDARRAYBUFFERSTRANSFERALLOWED("SharedArrayBuffersTransferAllowed"), PERFORMANCEMEASUREMEMORY("PerformanceMeasureMemory"), PERFORMANCEPROFILE("PerformanceProfile");

    private String value;

    GatedAPIFeatures(String value) {
        this.value = value;
    }

    public static GatedAPIFeatures fromString(String s) {
        return java.util.Arrays.stream(GatedAPIFeatures.values()).filter(rs -> rs.value.equalsIgnoreCase(s)).findFirst().orElseThrow(() -> new org.openqa.selenium.devtools.DevToolsException("Given value " + s + " is not found within GatedAPIFeatures "));
    }

    public String toString() {
        return value;
    }

    public String toJson() {
        return value;
    }

    private static GatedAPIFeatures fromJson(JsonInput input) {
        return fromString(input.nextString());
    }
}
