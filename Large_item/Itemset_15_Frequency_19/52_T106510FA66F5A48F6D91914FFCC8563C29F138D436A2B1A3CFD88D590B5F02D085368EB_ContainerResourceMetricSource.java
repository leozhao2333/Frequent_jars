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
package io.yupiik.kubernetes.bindings.v1_22_5.v2beta2;

import io.yupiik.kubernetes.bindings.v1_22_5.Exportable;
import io.yupiik.kubernetes.bindings.v1_22_5.JsonStrings;
import io.yupiik.kubernetes.bindings.v1_22_5.Validable;
import io.yupiik.kubernetes.bindings.v1_22_5.ValidationException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class ContainerResourceMetricSource implements Validable<ContainerResourceMetricSource>, Exportable {
    private String container;
    private String name;
    private MetricTarget target;

    public ContainerResourceMetricSource() {
        // no-op
    }

    public ContainerResourceMetricSource(final String container,
                                         final String name,
                                         final MetricTarget target) {
        this.container = container;
        this.name = name;
        this.target = target;
    }

    public String getContainer() {
        return container;
    }

    public void setContainer(final String container) {
        this.container = container;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public MetricTarget getTarget() {
        return target;
    }

    public void setTarget(final MetricTarget target) {
        this.target = target;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                container,
                name,
                target);
    }

    @Override
    public boolean equals(final Object __other) {
        if (!(__other instanceof ContainerResourceMetricSource)) {
            return false;
        }
        final ContainerResourceMetricSource __otherCasted = (ContainerResourceMetricSource) __other;
        return Objects.equals(container, __otherCasted.container) &&
            Objects.equals(name, __otherCasted.name) &&
            Objects.equals(target, __otherCasted.target);
    }

    public ContainerResourceMetricSource container(final String container) {
        this.container = container;
        return this;
    }

    public ContainerResourceMetricSource name(final String name) {
        this.name = name;
        return this;
    }

    public ContainerResourceMetricSource target(final MetricTarget target) {
        this.target = target;
        return this;
    }

    @Override
    public ContainerResourceMetricSource validate() {
        List<ValidationException.ValidationError> __errors_jsonSchema = null;
        if (container == null) {
            if (__errors_jsonSchema == null) {
                __errors_jsonSchema = new ArrayList<>();
            }
            __errors_jsonSchema.add(new ValidationException.ValidationError(
                "container", "container",
                "Missing 'container' attribute.", true));
        }
        if (name == null) {
            if (__errors_jsonSchema == null) {
                __errors_jsonSchema = new ArrayList<>();
            }
            __errors_jsonSchema.add(new ValidationException.ValidationError(
                "name", "name",
                "Missing 'name' attribute.", true));
        }
        if (target == null) {
            if (__errors_jsonSchema == null) {
                __errors_jsonSchema = new ArrayList<>();
            }
            __errors_jsonSchema.add(new ValidationException.ValidationError(
                "target", "target",
                "Missing 'target' attribute.", true));
        }
        if (__errors_jsonSchema != null) {
            throw new ValidationException(__errors_jsonSchema);
        }
        return this;
    }

    @Override
    public String asJson() {
        return Stream.of(
                    (container != null ? "\"container\":\"" +  JsonStrings.escapeJson(container) + "\"" : ""),
                    (name != null ? "\"name\":\"" +  JsonStrings.escapeJson(name) + "\"" : ""),
                    (target != null ? "\"target\":" + target.asJson() : ""))
                .filter(__it -> !__it.isBlank())
                .collect(joining(",", "{", "}"));
    }
}
