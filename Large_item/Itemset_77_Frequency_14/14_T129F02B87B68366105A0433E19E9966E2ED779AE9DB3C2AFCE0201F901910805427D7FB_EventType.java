/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 * 
 * http://aws.amazon.com/apache2.0
 * 
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package software.amazon.awssdk.services.pinpointsmsvoice.model;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.utils.internal.EnumUtils;

/**
 * The types of events that are sent to the event destination.
 */
@Generated("software.amazon.awssdk:codegen")
public enum EventType {
    INITIATED_CALL("INITIATED_CALL"),

    RINGING("RINGING"),

    ANSWERED("ANSWERED"),

    COMPLETED_CALL("COMPLETED_CALL"),

    BUSY("BUSY"),

    FAILED("FAILED"),

    NO_ANSWER("NO_ANSWER"),

    UNKNOWN_TO_SDK_VERSION(null);

    private static final Map<String, EventType> VALUE_MAP = EnumUtils.uniqueIndex(EventType.class, EventType::toString);

    private final String value;

    private EventType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    /**
     * Use this in place of valueOf to convert the raw string returned by the service into the enum value.
     *
     * @param value
     *        real value
     * @return EventType corresponding to the value
     */
    public static EventType fromValue(String value) {
        if (value == null) {
            return null;
        }
        return VALUE_MAP.getOrDefault(value, UNKNOWN_TO_SDK_VERSION);
    }

    /**
     * Use this in place of {@link #values()} to return a {@link Set} of all values known to the SDK. This will return
     * all known enum values except {@link #UNKNOWN_TO_SDK_VERSION}.
     *
     * @return a {@link Set} of known {@link EventType}s
     */
    public static Set<EventType> knownValues() {
        Set<EventType> knownValues = EnumSet.allOf(EventType.class);
        knownValues.remove(UNKNOWN_TO_SDK_VERSION);
        return knownValues;
    }
}
