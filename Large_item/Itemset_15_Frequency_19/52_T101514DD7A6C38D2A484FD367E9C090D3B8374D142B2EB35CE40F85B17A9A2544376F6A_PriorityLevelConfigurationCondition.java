/*
 * Copyright (c) 2022 - Yupiik SAS - https://www.yupiik.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package io.yupiik.kubernetes.bindings.v1_22_5.v1beta1;

import io.yupiik.kubernetes.bindings.v1_22_5.Exportable;
import io.yupiik.kubernetes.bindings.v1_22_5.JsonStrings;
import io.yupiik.kubernetes.bindings.v1_22_5.Validable;
import java.util.Objects;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class PriorityLevelConfigurationCondition implements Validable<PriorityLevelConfigurationCondition>, Exportable {
    private String lastTransitionTime;
    private String message;
    private String reason;
    private String status;
    private String type;

    public PriorityLevelConfigurationCondition() {
        // no-op
    }

    public PriorityLevelConfigurationCondition(final String lastTransitionTime,
                                               final String message,
                                               final String reason,
                                               final String status,
                                               final String type) {
        this.lastTransitionTime = lastTransitionTime;
        this.message = message;
        this.reason = reason;
        this.status = status;
        this.type = type;
    }

    public String getLastTransitionTime() {
        return lastTransitionTime;
    }

    public void setLastTransitionTime(final String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(final String reason) {
        this.reason = reason;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                lastTransitionTime,
                message,
                reason,
                status,
                type);
    }

    @Override
    public boolean equals(final Object __other) {
        if (!(__other instanceof PriorityLevelConfigurationCondition)) {
            return false;
        }
        final PriorityLevelConfigurationCondition __otherCasted = (PriorityLevelConfigurationCondition) __other;
        return Objects.equals(lastTransitionTime, __otherCasted.lastTransitionTime) &&
            Objects.equals(message, __otherCasted.message) &&
            Objects.equals(reason, __otherCasted.reason) &&
            Objects.equals(status, __otherCasted.status) &&
            Objects.equals(type, __otherCasted.type);
    }

    public PriorityLevelConfigurationCondition lastTransitionTime(final String lastTransitionTime) {
        this.lastTransitionTime = lastTransitionTime;
        return this;
    }

    public PriorityLevelConfigurationCondition message(final String message) {
        this.message = message;
        return this;
    }

    public PriorityLevelConfigurationCondition reason(final String reason) {
        this.reason = reason;
        return this;
    }

    public PriorityLevelConfigurationCondition status(final String status) {
        this.status = status;
        return this;
    }

    public PriorityLevelConfigurationCondition type(final String type) {
        this.type = type;
        return this;
    }

    @Override
    public PriorityLevelConfigurationCondition validate() {
        return this;
    }

    @Override
    public String asJson() {
        return Stream.of(
                    (lastTransitionTime != null ? "\"lastTransitionTime\":\"" +  JsonStrings.escapeJson(lastTransitionTime) + "\"" : ""),
                    (message != null ? "\"message\":\"" +  JsonStrings.escapeJson(message) + "\"" : ""),
                    (reason != null ? "\"reason\":\"" +  JsonStrings.escapeJson(reason) + "\"" : ""),
                    (status != null ? "\"status\":\"" +  JsonStrings.escapeJson(status) + "\"" : ""),
                    (type != null ? "\"type\":\"" +  JsonStrings.escapeJson(type) + "\"" : ""))
                .filter(__it -> !__it.isBlank())
                .collect(joining(",", "{", "}"));
    }
}
