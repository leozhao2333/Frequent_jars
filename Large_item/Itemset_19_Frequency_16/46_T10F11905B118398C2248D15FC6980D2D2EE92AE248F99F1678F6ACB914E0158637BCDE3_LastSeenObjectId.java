package org.openqa.selenium.devtools.v104.heapprofiler.model;

import org.openqa.selenium.Beta;
import org.openqa.selenium.json.JsonInput;

/**
 * If heap objects tracking has been started then backend regularly sends a current value for last
 * seen object id and corresponding timestamp. If the were changes in the heap since last event
 * then one or more heapStatsUpdate events will be sent before a new lastSeenObjectId event.
 */
public class LastSeenObjectId {

    private final java.lang.Integer lastSeenObjectId;

    private final java.lang.Number timestamp;

    public LastSeenObjectId(java.lang.Integer lastSeenObjectId, java.lang.Number timestamp) {
        this.lastSeenObjectId = java.util.Objects.requireNonNull(lastSeenObjectId, "lastSeenObjectId is required");
        this.timestamp = java.util.Objects.requireNonNull(timestamp, "timestamp is required");
    }

    public java.lang.Integer getLastSeenObjectId() {
        return lastSeenObjectId;
    }

    public java.lang.Number getTimestamp() {
        return timestamp;
    }

    private static LastSeenObjectId fromJson(JsonInput input) {
        java.lang.Integer lastSeenObjectId = 0;
        java.lang.Number timestamp = 0;
        input.beginObject();
        while (input.hasNext()) {
            switch(input.nextName()) {
                case "lastSeenObjectId":
                    lastSeenObjectId = input.nextNumber().intValue();
                    break;
                case "timestamp":
                    timestamp = input.nextNumber();
                    break;
                default:
                    input.skipValue();
                    break;
            }
        }
        input.endObject();
        return new LastSeenObjectId(lastSeenObjectId, timestamp);
    }
}
