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
package io.yupiik.kubernetes.bindings.v1_22_5.v1alpha1;

import io.yupiik.kubernetes.bindings.v1_22_5.Exportable;
import io.yupiik.kubernetes.bindings.v1_22_5.JsonStrings;
import io.yupiik.kubernetes.bindings.v1_22_5.Validable;
import java.util.Objects;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class PriorityClass implements Validable<PriorityClass>, Exportable {
    private String apiVersion;
    private String description;
    private Boolean globalDefault;
    private String kind;
    private ObjectMeta metadata;
    private String preemptionPolicy;
    private int value;

    public PriorityClass() {
        // no-op
    }

    public PriorityClass(final String apiVersion,
                         final String description,
                         final Boolean globalDefault,
                         final String kind,
                         final ObjectMeta metadata,
                         final String preemptionPolicy,
                         final int value) {
        this.apiVersion = apiVersion;
        this.description = description;
        this.globalDefault = globalDefault;
        this.kind = kind;
        this.metadata = metadata;
        this.preemptionPolicy = preemptionPolicy;
        this.value = value;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Boolean getGlobalDefault() {
        return globalDefault;
    }

    public void setGlobalDefault(final Boolean globalDefault) {
        this.globalDefault = globalDefault;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(final String kind) {
        this.kind = kind;
    }

    public ObjectMeta getMetadata() {
        return metadata;
    }

    public void setMetadata(final ObjectMeta metadata) {
        this.metadata = metadata;
    }

    public String getPreemptionPolicy() {
        return preemptionPolicy;
    }

    public void setPreemptionPolicy(final String preemptionPolicy) {
        this.preemptionPolicy = preemptionPolicy;
    }

    public int getValue() {
        return value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                apiVersion,
                description,
                globalDefault,
                kind,
                metadata,
                preemptionPolicy,
                value);
    }

    @Override
    public boolean equals(final Object __other) {
        if (!(__other instanceof PriorityClass)) {
            return false;
        }
        final PriorityClass __otherCasted = (PriorityClass) __other;
        return Objects.equals(apiVersion, __otherCasted.apiVersion) &&
            Objects.equals(description, __otherCasted.description) &&
            Objects.equals(globalDefault, __otherCasted.globalDefault) &&
            Objects.equals(kind, __otherCasted.kind) &&
            Objects.equals(metadata, __otherCasted.metadata) &&
            Objects.equals(preemptionPolicy, __otherCasted.preemptionPolicy) &&
            Objects.equals(value, __otherCasted.value);
    }

    public PriorityClass apiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public PriorityClass description(final String description) {
        this.description = description;
        return this;
    }

    public PriorityClass globalDefault(final Boolean globalDefault) {
        this.globalDefault = globalDefault;
        return this;
    }

    public PriorityClass kind(final String kind) {
        this.kind = kind;
        return this;
    }

    public PriorityClass metadata(final ObjectMeta metadata) {
        this.metadata = metadata;
        return this;
    }

    public PriorityClass preemptionPolicy(final String preemptionPolicy) {
        this.preemptionPolicy = preemptionPolicy;
        return this;
    }

    public PriorityClass value(final int value) {
        this.value = value;
        return this;
    }

    @Override
    public PriorityClass validate() {
        if (kind == null) {
            kind = "PriorityClass";
        }
        if (apiVersion == null) {
            apiVersion = "scheduling.k8s.io/v1alpha1";
        }
        return this;
    }

    @Override
    public String asJson() {
        return Stream.of(
                    (apiVersion != null ? "\"apiVersion\":\"" +  JsonStrings.escapeJson(apiVersion) + "\"" : ""),
                    (description != null ? "\"description\":\"" +  JsonStrings.escapeJson(description) + "\"" : ""),
                    (globalDefault != null ? "\"globalDefault\":" + globalDefault : ""),
                    (kind != null ? "\"kind\":\"" +  JsonStrings.escapeJson(kind) + "\"" : ""),
                    (metadata != null ? "\"metadata\":" + metadata.asJson() : ""),
                    (preemptionPolicy != null ? "\"preemptionPolicy\":\"" +  JsonStrings.escapeJson(preemptionPolicy) + "\"" : ""),
                    "\"value\":" + value)
                .filter(__it -> !__it.isBlank())
                .collect(joining(",", "{", "}"));
    }
}
