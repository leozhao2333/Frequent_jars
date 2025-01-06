package org.openqa.selenium.devtools.v104.webaudio.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

/**
 * An unique ID for a graph object (AudioContext, AudioNode, AudioParam) in Web Audio API
 */
public class GraphObjectId {

    private final java.lang.String graphObjectId;

    public GraphObjectId(java.lang.String graphObjectId) {
        this.graphObjectId = java.util.Objects.requireNonNull(graphObjectId, "Missing value for GraphObjectId");
    }

    private static GraphObjectId fromJson(JsonInput input) {
        return new GraphObjectId(input.nextString());
    }

    public String toJson() {
        return graphObjectId.toString();
    }

    public String toString() {
        return graphObjectId.toString();
    }
}
