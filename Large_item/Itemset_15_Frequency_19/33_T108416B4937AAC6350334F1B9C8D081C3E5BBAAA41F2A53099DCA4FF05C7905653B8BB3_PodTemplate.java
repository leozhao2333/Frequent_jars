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
import java.util.Objects;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class PodTemplate implements Validable<PodTemplate>, Exportable {
    private String apiVersion;
    private String kind;
    private ObjectMeta metadata;
    private PodTemplateSpec template;

    public PodTemplate() {
        // no-op
    }

    public PodTemplate(final String apiVersion,
                       final String kind,
                       final ObjectMeta metadata,
                       final PodTemplateSpec template) {
        this.apiVersion = apiVersion;
        this.kind = kind;
        this.metadata = metadata;
        this.template = template;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
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

    public PodTemplateSpec getTemplate() {
        return template;
    }

    public void setTemplate(final PodTemplateSpec template) {
        this.template = template;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                apiVersion,
                kind,
                metadata,
                template);
    }

    @Override
    public boolean equals(final Object __other) {
        if (!(__other instanceof PodTemplate)) {
            return false;
        }
        final PodTemplate __otherCasted = (PodTemplate) __other;
        return Objects.equals(apiVersion, __otherCasted.apiVersion) &&
            Objects.equals(kind, __otherCasted.kind) &&
            Objects.equals(metadata, __otherCasted.metadata) &&
            Objects.equals(template, __otherCasted.template);
    }

    public PodTemplate apiVersion(final String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public PodTemplate kind(final String kind) {
        this.kind = kind;
        return this;
    }

    public PodTemplate metadata(final ObjectMeta metadata) {
        this.metadata = metadata;
        return this;
    }

    public PodTemplate template(final PodTemplateSpec template) {
        this.template = template;
        return this;
    }

    @Override
    public PodTemplate validate() {
        if (kind == null) {
            kind = "PodTemplate";
        }
        if (apiVersion == null) {
            apiVersion = "v1";
        }
        return this;
    }

    @Override
    public String asJson() {
        return Stream.of(
                    (apiVersion != null ? "\"apiVersion\":\"" +  JsonStrings.escapeJson(apiVersion) + "\"" : ""),
                    (kind != null ? "\"kind\":\"" +  JsonStrings.escapeJson(kind) + "\"" : ""),
                    (metadata != null ? "\"metadata\":" + metadata.asJson() : ""),
                    (template != null ? "\"template\":" + template.asJson() : ""))
                .filter(__it -> !__it.isBlank())
                .collect(joining(",", "{", "}"));
    }
}
