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
import io.yupiik.kubernetes.bindings.v1_22_5.Validable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;
import static java.util.stream.Collectors.joining;

public class PriorityLevelConfigurationStatus implements Validable<PriorityLevelConfigurationStatus>, Exportable {
    private List<PriorityLevelConfigurationCondition> conditions;

    public PriorityLevelConfigurationStatus() {
        // no-op
    }

    public PriorityLevelConfigurationStatus(final List<PriorityLevelConfigurationCondition> conditions) {
        this.conditions = conditions;
    }

    public List<PriorityLevelConfigurationCondition> getConditions() {
        return conditions;
    }

    public void setConditions(final List<PriorityLevelConfigurationCondition> conditions) {
        this.conditions = conditions;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                conditions);
    }

    @Override
    public boolean equals(final Object __other) {
        if (!(__other instanceof PriorityLevelConfigurationStatus)) {
            return false;
        }
        final PriorityLevelConfigurationStatus __otherCasted = (PriorityLevelConfigurationStatus) __other;
        return Objects.equals(conditions, __otherCasted.conditions);
    }

    public PriorityLevelConfigurationStatus conditions(final List<PriorityLevelConfigurationCondition> conditions) {
        this.conditions = conditions;
        return this;
    }

    @Override
    public PriorityLevelConfigurationStatus validate() {
        return this;
    }

    @Override
    public String asJson() {
        return Stream.of(
                    (conditions != null ? "\"conditions\":" + conditions.stream().map(__it -> __it == null ? "null" : __it.asJson()).collect(joining(",", "[", "]")) : ""))
                .filter(__it -> !__it.isBlank())
                .collect(joining(",", "{", "}"));
    }
}
