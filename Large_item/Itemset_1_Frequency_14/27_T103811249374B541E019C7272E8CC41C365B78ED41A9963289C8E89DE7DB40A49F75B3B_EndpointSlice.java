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
package io.yupiik.kubernetes.bindings.v1_22_5.v1;

import io.yupiik.kubernetes.bindings.v1_22_5.Exportable;
import io.yupiik.kubernetes.bindings.v1_22_5.JsonStrings;
import io.yupiik.kubernetes.bindings.v1_22_5.Validable;
import io.yupiik.kubernetes.bindings.v1_22_5.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class EndpointSlice implements Validable<EndpointSlice>, Exportable {
    private String addressType;
    private String apiVersion;
    private List<Endpoint> endpoints;
    private String kind;
    private ObjectMeta metadata;
    private List<EndpointPort> ports;

    public EndpointSlice() {
        // no-op
    }

    public EndpointSlice(final String addressType,
                         final String apiVersion,
                         final List<Endpoint> endpoints,
                         final String kind,
                         final ObjectMeta metadata,
                         final List<EndpointPort> ports) {
        this.addressType = addressType;
        this.apiVersion = apiVersion;
        this.endpoints = endpoints;
        this.kind = kind;
        this.metadata = metadata;
        this.ports = ports;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(final String addressType) {
        this.addressType = addressType;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public List<Endpoint> getEndpoints() {
        return endpoints;
    }

    public void setEndpoints(final List<Endpoint> endpoints) {
        this.endpoints = endpoints;
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

    public List<EndpointPort> getPorts() {
        return ports;
    }

    public void setPorts(final List<EndpointPort> ports) {
        this.ports = ports;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                addressType,
                apiVersion,
                endpoints,
                kind,
                metadata,
                ports);
    }

    @Override
    public boolean equals(final Object __other) {
        if (!(__other instanceof EndpointSlice)) {
            return false;
        }
        final EndpointSlice __otherCasted = (EndpointSlice) __other;
        return Objects.equals(addressType, __otherCasted.addressType) &&
            Objects.equals(apiVersion, __otherCasted.apiVersion) &&
            Objects.equals(endpoints, __otherCasted.endpoints) &&
            Objects.equals(kind, __otherCasted.kind) &&
            Objects.equals(metadata, __otherCasted.metadata) &&
            Objects.equals(ports, __otherCasted.ports);
    }

    public EndpointSlice addressType(final String addressType) {
        this.addressType = addressType;
        return this;
    }

    public EndpointSlice apiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public EndpointSlice endpoints(final List<Endpoint> endpoints) {
        this.endpoints = endpoints;
        return this;
    }

    public EndpointSlice kind(final String kind) {
        this.kind = kind;
        return this;
    }

    public EndpointSlice metadata(final ObjectMeta metadata) {
        this.metadata = metadata;
        return this;
    }

    public EndpointSlice ports(final List<EndpointPort> ports) {
        this.ports = ports;
        return this;
    }

    @Override
    public EndpointSlice validate() {
        if (kind == null) {
            kind = "EndpointSlice";
        }
        if (apiVersion == null) {
            apiVersion = "discovery.k8s.io/v1";
        }
        List<ValidationException.ValidationError> __errors_jsonSchema = null;
        if (addressType == null) {
            if (__errors_jsonSchema == null) {
                __errors_jsonSchema = new ArrayList<>();
            }
            __errors_jsonSchema.add(new ValidationException.ValidationError(
                "addressType", "addressType",
                "Missing 'addressType' attribute.", true));
        }
        if (endpoints == null) {
            if (__errors_jsonSchema == null) {
                __errors_jsonSchema = new ArrayList<>();
            }
            __errors_jsonSchema.add(new ValidationException.ValidationError(
                "endpoints", "endpoints",
                "Missing 'endpoints' attribute.", true));
        }
        if (__errors_jsonSchema != null) {
            throw new ValidationException(__errors_jsonSchema);
        }
        return this;
    }

    @Override
    public String asJson() {
        return Stream.of(
                    (addressType != null ? "\"addressType\":\"" +  JsonStrings.escapeJson(addressType) + "\"" : ""),
                    (apiVersion != null ? "\"apiVersion\":\"" +  JsonStrings.escapeJson(apiVersion) + "\"" : ""),
                    (endpoints != null ? "\"endpoints\":" + endpoints.stream().map(__it -> __it == null ? "null" : __it.asJson()).collect(joining(",", "[", "]")) : ""),
                    (kind != null ? "\"kind\":\"" +  JsonStrings.escapeJson(kind) + "\"" : ""),
                    (metadata != null ? "\"metadata\":" + metadata.asJson() : ""),
                    (ports != null ? "\"ports\":" + ports.stream().map(__it -> __it == null ? "null" : __it.asJson()).collect(joining(",", "[", "]")) : ""))
                .filter(__it -> !__it.isBlank())
                .collect(joining(",", "{", "}"));
    }
}
