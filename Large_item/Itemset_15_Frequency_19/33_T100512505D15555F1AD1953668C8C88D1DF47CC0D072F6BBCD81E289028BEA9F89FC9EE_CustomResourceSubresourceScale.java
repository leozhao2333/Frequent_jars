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

public class CustomResourceSubresourceScale implements Validable<CustomResourceSubresourceScale>, Exportable {
    private String labelSelectorPath;
    private String specReplicasPath;
    private String statusReplicasPath;

    public CustomResourceSubresourceScale() {
        // no-op
    }

    public CustomResourceSubresourceScale(final String labelSelectorPath,
                                          final String specReplicasPath,
                                          final String statusReplicasPath) {
        this.labelSelectorPath = labelSelectorPath;
        this.specReplicasPath = specReplicasPath;
        this.statusReplicasPath = statusReplicasPath;
    }

    public String getLabelSelectorPath() {
        return labelSelectorPath;
    }

    public void setLabelSelectorPath(final String labelSelectorPath) {
        this.labelSelectorPath = labelSelectorPath;
    }

    public String getSpecReplicasPath() {
        return specReplicasPath;
    }

    public void setSpecReplicasPath(final String specReplicasPath) {
        this.specReplicasPath = specReplicasPath;
    }

    public String getStatusReplicasPath() {
        return statusReplicasPath;
    }

    public void setStatusReplicasPath(final String statusReplicasPath) {
        this.statusReplicasPath = statusReplicasPath;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                labelSelectorPath,
                specReplicasPath,
                statusReplicasPath);
    }

    @Override
    public boolean equals(final Object __other) {
        if (!(__other instanceof CustomResourceSubresourceScale)) {
            return false;
        }
        final CustomResourceSubresourceScale __otherCasted = (CustomResourceSubresourceScale) __other;
        return Objects.equals(labelSelectorPath, __otherCasted.labelSelectorPath) &&
            Objects.equals(specReplicasPath, __otherCasted.specReplicasPath) &&
            Objects.equals(statusReplicasPath, __otherCasted.statusReplicasPath);
    }

    public CustomResourceSubresourceScale labelSelectorPath(final String labelSelectorPath) {
        this.labelSelectorPath = labelSelectorPath;
        return this;
    }

    public CustomResourceSubresourceScale specReplicasPath(final String specReplicasPath) {
        this.specReplicasPath = specReplicasPath;
        return this;
    }

    public CustomResourceSubresourceScale statusReplicasPath(final String statusReplicasPath) {
        this.statusReplicasPath = statusReplicasPath;
        return this;
    }

    @Override
    public CustomResourceSubresourceScale validate() {
        List<ValidationException.ValidationError> __errors_jsonSchema = null;
        if (specReplicasPath == null) {
            if (__errors_jsonSchema == null) {
                __errors_jsonSchema = new ArrayList<>();
            }
            __errors_jsonSchema.add(new ValidationException.ValidationError(
                "specReplicasPath", "specReplicasPath",
                "Missing 'specReplicasPath' attribute.", true));
        }
        if (statusReplicasPath == null) {
            if (__errors_jsonSchema == null) {
                __errors_jsonSchema = new ArrayList<>();
            }
            __errors_jsonSchema.add(new ValidationException.ValidationError(
                "statusReplicasPath", "statusReplicasPath",
                "Missing 'statusReplicasPath' attribute.", true));
        }
        if (__errors_jsonSchema != null) {
            throw new ValidationException(__errors_jsonSchema);
        }
        return this;
    }

    @Override
    public String asJson() {
        return Stream.of(
                    (labelSelectorPath != null ? "\"labelSelectorPath\":\"" +  JsonStrings.escapeJson(labelSelectorPath) + "\"" : ""),
                    (specReplicasPath != null ? "\"specReplicasPath\":\"" +  JsonStrings.escapeJson(specReplicasPath) + "\"" : ""),
                    (statusReplicasPath != null ? "\"statusReplicasPath\":\"" +  JsonStrings.escapeJson(statusReplicasPath) + "\"" : ""))
                .filter(__it -> !__it.isBlank())
                .collect(joining(",", "{", "}"));
    }
}
